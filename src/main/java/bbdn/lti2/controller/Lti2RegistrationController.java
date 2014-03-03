package bbdn.lti2.controller;

import java.io.IOException;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbdn.lti2.dao.Lti2Properties;
import bbdn.lti2.dao.Lti2PropertiesDAO;
import bbdn.lti2.dao.Lti2ProviderDomain;
import bbdn.lti2.dao.Lti2ProviderDomainDAO;
import blackboard.base.FormattedText;
//import blackboard.data.ReceiptOptions;
//import blackboard.persist.KeyNotFoundException;
//import blackboard.persist.PersistenceException;
//import blackboard.platform.plugin.PlugInException;
//import blackboard.platform.plugin.PlugInUtil;
//import blackboard.platform.servlet.InlineReceiptUtil;

@Controller
public class Lti2RegistrationController {
	
	@Autowired
	private Lti2PropertiesDAO _propDAO;
	
	@Autowired
	private Lti2ProviderDomainDAO _toolDAO;
	
	@RequestMapping( "/register" )
	public ModelAndView create( HttpServletRequest request, HttpServletResponse response )
	{
		ModelAndView mv = new ModelAndView("register");
		
		Lti2ProviderDomain provider = createNewTool();
    	mv.addObject("provider", provider);
    	mv.addObject("actionType", "register");
    	mv = buildModel(provider,mv);
    	
    	return mv;   
	}
	
	@RequestMapping( "/saveDomain" )
	public void save( HttpServletRequest request, HttpServletResponse response, 
						@RequestParam( "actionType" ) String actionType,
						@RequestParam( "toolIds" ) String[] toolIds,
						@RequestParam( "domain" ) String domain,
						@RequestParam( "domainStatus" ) String domainStatus,
						@RequestParam( "secondaryHostnames" ) String secondaryHostnames,
						@RequestParam( "defaultConfig" ) String defaultConfig,
						@RequestParam( "toolKey" ) String toolKey,
						@RequestParam( "toolSecret" ) String toolSecret,
						@RequestParam( "customParameters" ) String customParameters,
						@RequestParam( "postGrades" ) String postGrades,
						@RequestParam( "getGrades" ) String getGrades,
						@RequestParam( "toolConfig" ) String toolConfig,
						@RequestParam( "sendData" ) String sendData,
						@RequestParam( "sendUserName" ) String sendName,
						@RequestParam( "sendRole" ) String sendRole,
						@RequestParam( "sendEmail" ) String sendEmail,
						@RequestParam( "userAck" ) String userAck,
						@RequestParam( "userAckMsgtext" ) String userAckMsgtext )
	{
		String toolId = "unknown";
		Lti2ProviderDomain tool = null;
		
		if(toolIds.length == 0) {
			tool = createNewTool();
			saveTool(tool, domain, domainStatus, secondaryHostnames, defaultConfig, 
						toolKey, toolSecret, customParameters, postGrades, getGrades, 
						toolConfig, sendData, sendName, sendRole, sendEmail, 
						userAck, userAckMsgtext);
			
		} else {
			for (int i = 0; i < toolIds.length; i++) {
				if(!toolIds[i].isEmpty() && !toolIds[i].equalsIgnoreCase("unknown")) {
					try {
						tool = _toolDAO.loadById(toolId);
					} catch (Exception knfe) {
						System.out.println("Error loading Domain record for " + toolId + ": " + knfe.getLocalizedMessage() + "<br />");
					}
				} else {
					tool = createNewTool();
				}
				
				//set all prefs to incoming request parameter values
				saveTool(tool, domain, domainStatus, secondaryHostnames, defaultConfig, 
						toolKey, toolSecret, customParameters, postGrades, getGrades, 
						toolConfig, sendData, sendName, sendRole, sendEmail, 
						userAck, userAckMsgtext);
			}
		}
		
		// Temp for testing. This should call the Lti2 Registration work flow and eventually serve the registration form back 
		// with the ability for the admin to approve the domain and add in the resulting key and secret from the registration.
		try {
			response.sendRedirect("index");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


//	
//	@RequestMapping( method = RequestMethod.POST, params = "actionType=edit" )
//	public ModelAndView edit( HttpServletRequest request, HttpServletResponse response, 
//			@RequestParam( "toolIds" ) String[] toolIds,
//			@RequestParam( "domain" ) String domain)
//	{
//		ModelAndView mv = new ModelAndView("register");
//		
//		Lti2ProviderDomain provider = null;
//		try {
//			provider = _toolDAO.loadById(toolIds[0]);
//		} catch (KeyNotFoundException e) {
//			e.printStackTrace();
//		}
//    	mv.addObject("provider", provider);
//    	mv.addObject("actionType", "edit");
//    	mv = buildModel(provider,mv);
//    	
//    	return mv; 
//	}
//	
//	@RequestMapping( method = RequestMethod.POST, params = "actionType=approve" )
//	public ModelAndView approve( HttpServletRequest request, HttpServletResponse response, 
//			@RequestParam( "toolIds" ) String[] toolIds,
//			@RequestParam( "domain" ) String domain )
//	{
//		ModelAndView mv = new ModelAndView("register");
//		
//		Lti2ProviderDomain provider = null;
//		try {
//			provider = _toolDAO.loadById(toolIds[0]);
//		} catch (KeyNotFoundException e) {
//			e.printStackTrace();
//		}
//    	mv.addObject("provider", provider);
//    	mv.addObject("actionType", "approve");
//    	mv = buildModel(provider,mv);
//    	
//    	return mv; 
//	}
//	
//	@RequestMapping( method = RequestMethod.POST, params = "actionType=exclude" )
//	public ModelAndView exclude( HttpServletRequest request, HttpServletResponse response, 
//			@RequestParam( "toolIds" ) String[] toolIds,
//			@RequestParam( "domain" ) String domain )
//	{
//		ModelAndView mv = new ModelAndView("register");
//		
//		Lti2ProviderDomain provider = null;
//		try {
//			provider = _toolDAO.loadById(toolIds[0]);
//		} catch (KeyNotFoundException e) {
//			e.printStackTrace();
//		}
//    	mv.addObject("provider", provider);
//    	mv.addObject("actionType", "exclude");
//    	mv = buildModel(provider,mv);
//    	
//    	return mv; 
//	    
//	}
//	
//	@RequestMapping( method = RequestMethod.POST, params = "actionType=delete" )
//	public ModelAndView delete( HttpServletRequest request, HttpServletResponse response, 
//			@RequestParam( "toolIds" ) String[] toolIds,
//			@RequestParam( "domain" ) String domain )
//	{
//		ModelAndView mv = new ModelAndView("register");
//		
//		Lti2ProviderDomain provider = null;
//		try {
//			provider = _toolDAO.loadById(toolIds[0]);
//		} catch (KeyNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	mv.addObject("provider", provider);
//    	mv.addObject("actionType", "delete");
//    	mv = buildModel(provider,mv);
//    	
//    	return mv; 
//	    
//	}
	
	
	/*
	Lti2PropertiesDAO propDAO = new Lti2PropertiesDAO();
	Lti2ProviderDomain lti2Tool = new Lti2ProviderDomain();

	String action = "register";
	String toolId = "unknown";
	String domainName = "unknown";
	String message = "====================================================================<br />";

	String indexPage = PlugInUtil.getUri("bbdn", "lti2", "index.jsp");

	ReceiptOptions rOptions = new ReceiptOptions();

	try {
		message += "Getting action.<br />";
		action = request.getParameter("action");
	} catch (Exception e) {
		message += "Exception in getParameter: " + e.getLocalizedMessage() + "<br />";
		action="register";
	}

	message += "action: " + action +"<br />";
	if (action.equals("register")) {
		message += "calling createNewTool.<br />";
		lti2Tool = createNewTool();
	} else if (action.equals("save")) {
		try{
			registerDomain(request);
			rOptions.addSuccessMessage("Domain Registered Successfully.");
		} catch (Exception ex) {
			rOptions.addErrorMessage("Error Registering Domain", ex);
		}
		
		response.sendRedirect(InlineReceiptUtil.addReceiptToUrl(indexPage, rOptions));
	}else{
		//TODO: place holder until all use cases are coded for. For now, default to edit mode if not a new registration
		message += "getting domain<br />";
		domainName = request.getParameter("domain");
		message += "domain: " + domainName + "<br />";
		message += "getting toolId<br />";
		toolId = request.getParameter("toolIds");
		message += "toolId: " + toolId + "<br />";
		Lti2ProviderDomainDAO toolDAO = new Lti2ProviderDomainDAO();
		message += "Got toolDAO. <br />";
		
		try {
			message += "load tool by domain";
			lti2Tool = toolDAO.loadByDomain(domainName);
		} catch (KeyNotFoundException knfe ) {
			message += "KeyNotFoundException loading by domain: " + knfe.getLocalizedMessage() + "<br />Call createNewTool<br />";
			lti2Tool = createNewTool();
		} catch (Exception e) {
			message += "Exception by knfe: " + e.getLocalizedMessage() + "<br />";
		}
	}

*/
	private Lti2ProviderDomain createNewTool() {

		Lti2Properties props = new Lti2Properties();
		
		try {
			props = _propDAO.load();
		} catch (Exception e) {
			System.out.println("Exception in createNewTool(): " + e.getLocalizedMessage());
		}
		
		Lti2ProviderDomain tool = new Lti2ProviderDomain();
		
		tool.setDomain("");
		tool.enableDomain(false);
		tool.setSecHostNames("");
		tool.setDomainConfigGlobally(true);
		tool.setConsumerKey("");
		tool.setSharedSecret("");
		tool.setCustomParams("");
		tool.enablePostGrades(props.isPostGradesEnabled());
		tool.enableGetGrades(props.isGetGradesEnabled());
		tool.enableToolSettings(props.isToolSettingsEnabled());
		tool.setSendDataConfig(props.getSendDataConfig());
		tool.enableSendName(props.isSendNameEnabled());
		tool.enableSendRole(props.isSendRoleEnabled());
		tool.enableSendEMail(props.isSendEMailEnabled());
		tool.enableSplashScreen(props.isSplashScreenEnabled());
		tool.setSplashScreenMessage(props.getSplashScreenMessage());
		System.out.println(tool.toString());
		
		return tool;
	}
	
	private ModelAndView buildModel(Lti2ProviderDomain tool, ModelAndView mv) {
		String[] toolIds = { "unknown" };
		mv.addObject(toolIds);
		mv.addObject("domain",tool.getDomain());
		mv.addObject("domain_status",tool.isDomainEnabled());
		mv.addObject("sechostnames",tool.getSecHostNames());
		mv.addObject("globalLinks", tool.isDomainConfiguredGlobally());
		mv.addObject("key", tool.getConsumerKey());
		mv.addObject("secret", tool.getSharedSecret());
		mv.addObject("customParameters", tool.getCustomParams());
		mv.addObject("postGrades", tool.isPostGradesEnabled());
		mv.addObject("getGrades", tool.isGetGradesEnabled());
		mv.addObject("toolConfig", tool.isToolSettingsEnabled());
		boolean[] sendDataConfig = {false,false,false};
		sendDataConfig[tool.getSendDataConfig()] = true;
		mv.addObject("sendDataConfig",sendDataConfig);
		mv.addObject("sendName", tool.isSendNameEnabled());
		mv.addObject("sendRole", tool.isSendRoleEnabled());
		mv.addObject("sendEmail", tool.isSendEMailEnabled());
		mv.addObject("displaySplash", tool.isSplashScreenEnabled());
		mv.addObject("splashMessage", FormattedText.toFormattedText(tool.getSplashScreenMessage()));
		
		return mv;
	}
	
private void saveTool(Lti2ProviderDomain tool, String domain, String domainStatus, String secondaryHostnames,
							String defaultConfig, String toolKey, String toolSecret, String customParameters,
							String postGrades, String getGrades, String toolConfig, String sendData, String sendName, 
							String sendRole, String sendEmail, String userAck, String userAckMsgtext ) {
		//set all prefs to incoming request parameter values
		tool.setDomain(domain);
		tool.enableDomain(Boolean.valueOf(domainStatus));
		tool.setSecHostNames(secondaryHostnames);
		tool.setDomainConfigGlobally(Boolean.valueOf(defaultConfig));
		tool.setConsumerKey(toolKey);
		tool.setSharedSecret(toolSecret);
		tool.setCustomParams(customParameters);
		tool.enablePostGrades(Boolean.valueOf(postGrades));
		tool.enableGetGrades(Boolean.valueOf(getGrades));
		tool.enableToolSettings(Boolean.valueOf(toolConfig));
		tool.setSendDataConfig(Integer.parseInt(sendData));
		tool.enableSendName(Boolean.valueOf(sendName));
		tool.enableSendRole(Boolean.valueOf(sendRole));
		tool.enableSendEMail(Boolean.valueOf(sendEmail));
		tool.enableSplashScreen(Boolean.valueOf(userAck));
		tool.setSplashScreenMessage(userAckMsgtext);
		
		//save the prefs
		try {
			_toolDAO.save(tool);
		} catch (Exception ex) {
			System.out.println("Error saving Tool");
		}
	}
}