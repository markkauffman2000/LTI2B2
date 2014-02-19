package bbdn.lti2.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbdn.lti2.dao.Lti2Properties;
import bbdn.lti2.dao.Lti2PropertiesDAO;
import blackboard.base.FormattedText;
import blackboard.platform.plugin.PlugInUtil;

@Controller
public class Lti2SettingsController {

	@Autowired
	private Lti2PropertiesDAO _dao;
	
	@RequestMapping("/properties")
	public ModelAndView create( HttpServletRequest request, HttpServletResponse response )
	{
		ModelAndView mv = new ModelAndView("settings");

		Lti2Properties props = _dao.load();
		
		boolean courseEnabled = props.isCourseEnabled();		
		boolean orgsEnabled = props.isOrgsEnabled();
		boolean[] linkCreation = {false,false,false};
		linkCreation[props.getPropertyLinkType()] = true;				
		boolean postGrades = props.isPostGradesEnabled();
		boolean getGrades = props.isGetGradesEnabled();
		boolean toolConfig = props.isToolSettingsEnabled();
		boolean[] sendDataConfig = {false,false,false};
		sendDataConfig[props.getSendDataConfig()] = true;
		boolean sendName = props.isSendNameEnabled();
		boolean sendRole = props.isSendRoleEnabled();
		boolean sendEmail = props.isSendEMailEnabled();
		boolean displaySplash = props.isSplashScreenEnabled();
		FormattedText splashMessage = FormattedText.toFormattedText(props.getSplashScreenMessage());
		
		mv.addObject("courseEnabled", courseEnabled);
		mv.addObject("orgsEnabled", orgsEnabled);
		mv.addObject("linkCreation", linkCreation);
		mv.addObject("postGrades", postGrades);
		mv.addObject("getGrades", getGrades);
		mv.addObject("toolConfig", toolConfig);
		mv.addObject("sendDataConfig", sendDataConfig);
		mv.addObject("sendName", sendName);
		mv.addObject("sendRole", sendRole);
		mv.addObject("sendEmail", sendEmail);
		mv.addObject("displaySplash", displaySplash);
		mv.addObject("splashMessage", splashMessage);
		mv.addObject("props", props);
    	
    	return mv;   
	}

	@RequestMapping("/saveProperties")
	private void saveProps(HttpServletRequest request, HttpServletResponse response) {

		Lti2Properties props = _dao.load();
		
		String indexPage = PlugInUtil.getUri("bbdn", "lti2", "index.jsp");
        
        //set all prefs to incoming request parameter values
		props.enableCourses(Boolean.valueOf(request.getParameter("enabledCourse")));
        props.enableOrgs(Boolean.valueOf(request.getParameter("enabledOrgs")));
        props.setPropertyLinkType(Integer.parseInt(request.getParameter("linkCreation")));
        props.enablePostGrades(Boolean.valueOf(request.getParameter("postGrades")));
        props.enableGetGrades(Boolean.valueOf(request.getParameter("getGrades")));
        props.enableToolSettings(Boolean.valueOf(request.getParameter("putToolSettingsContainer")));
        props.setSendDataConfig(Integer.parseInt(request.getParameter("sendData")));
        props.enableSendName(Boolean.valueOf(request.getParameter("sendUserName")));
        props.enableSendRole(Boolean.valueOf(request.getParameter("sendUserRole")));
        props.enableSendEMail(Boolean.valueOf(request.getParameter("sendUserEmail")));
        props.enableSplashScreen(Boolean.valueOf(request.getParameter("userAck")));
        props.setSplashScreenMessage(request.getParameter("userAckMsgtext"));
        
        //save the prefs
        _dao.save(props);
        
        try {
			response.sendRedirect(indexPage);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
