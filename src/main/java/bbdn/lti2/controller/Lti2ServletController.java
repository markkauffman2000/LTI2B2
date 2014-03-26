package bbdn.lti2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.imsglobal.basiclti.BasicLTIConstants;
import org.imsglobal.basiclti.BasicLTIUtil;
import org.imsglobal.json.IMSJSONRequest;
import org.imsglobal.lti2.LTI2Constants;
import org.imsglobal.lti2.LTI2Servlet;
import org.imsglobal.lti2.LTI2Util;
import org.imsglobal.lti2.objects.Service_offered;
import org.imsglobal.lti2.objects.StandardServices;
import org.imsglobal.lti2.objects.ToolConsumer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbdn.lti2.beans.Lti2Config;
import bbdn.lti2.beans.Lti2ProviderDomain;
import bbdn.lti2.dao.Lti2ProviderDomainDAO;
import blackboard.persist.KeyNotFoundException;

@Controller
public class Lti2ServletController {
	
	@Autowired
	private Lti2ProviderDomainDAO _dao;
	
	//private static final long serialVersionUID = 1L;
	private static Log M_log = LogFactory.getLog(LTI2Servlet.class);

	protected Service_offered LTI2ResultItem = null;
	protected Service_offered LTI2LtiLinkSettings = null;
	protected Service_offered LTI2ToolProxyBindingSettings = null;
	protected Service_offered LTI2ToolProxySettings = null;

	private static final String SVC_tc_profile = "tc_profile";
	private static final String SVC_tc_registration = "tc_registration";
	private static final String SVC_Settings = "Settings";
	private static final String SVC_Result = "Result";

	@SuppressWarnings("unused")
	private static final String EMPTY_JSON_OBJECT = "{\n}\n";

	private static final String APPLICATION_JSON = "application/json";

	/**
	 * doRegister()
	 * 
	 * @param request
	 * @param response
	 * 
	 * This method handles the request from the Tool Provider to retrieve the tool consumer profile
	 * @throws IOException 
	 */
	@RequestMapping("lti2operation/register")
	public void register(HttpServletRequest request, HttpServletResponse response,
							@RequestParam("domain") String launch_url) throws IOException {
		
		response.setContentType("text/html");

		String output = null;
		if ( launch_url != null ) {
			Map<String, String> ltiProps = new HashMap<String,String>();

			ltiProps.put(BasicLTIConstants.LTI_VERSION, LTI2Constants.LTI2_VERSION_STRING);
			ltiProps.put(LTI2Constants.REG_KEY,"42"); //TODO: Generate Random Key/Secret Pair only good for Tool Registration
			ltiProps.put(LTI2Constants.REG_PASSWORD,"zaphod"); //TODO: Generate Random Key/Secret Pair only good for Tool Registration
			ltiProps.put(BasicLTIUtil.BASICLTI_SUBMIT, "Press to Launch External Tool");
			ltiProps.put(BasicLTIConstants.LTI_MESSAGE_TYPE, BasicLTIConstants.LTI_MESSAGE_TYPE_TOOLPROXYREGISTRATIONREQUEST);

			String serverUrl = getServiceURL(request);
			ltiProps.put(LTI2Constants.TC_PROFILE_URL,serverUrl + SVC_tc_profile + "/42"); //TODO: Generate Random Key/Secret Pair only good for Tool Registration
			ltiProps.put(BasicLTIConstants.LAUNCH_PRESENTATION_RETURN_URL, serverUrl + "launch");
			System.out.println("ltiProps="+ltiProps);

			boolean dodebug = true;
			ltiProps = BasicLTIUtil.cleanupProperties(ltiProps);
			output = BasicLTIUtil.postLaunchHTML(ltiProps, launch_url, dodebug);
		} else {
			response.sendRedirect("register");
		}

		try {
			PrintWriter out = response.getWriter();
			out.println(output);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("lti2operation/SVC_tc_profile")
	private void getToolConsumerProfile(HttpServletRequest request, 
			HttpServletResponse response) throws KeyNotFoundException
	{
		Map<String,Object> deploy = null;
		String uri = request.getRequestURI();
		String [] parts = uri.split("/");
		if ( parts.length < 5 ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
			//doErrorJSON(request, response, null, "Incorrect url format", null);
			return;
		}
		String profile_id = parts[5];

		ToolConsumer consumer = buildToolConsumerProfile(request, deploy, profile_id);

		ObjectMapper mapper = new ObjectMapper();
		try {
			// http://stackoverflow.com/questions/6176881/how-do-i-make-jackson-pretty-print-the-json-content-it-generates
			ObjectWriter writer = mapper.defaultPrettyPrintingWriter();
			// ***IMPORTANT!!!*** for Jackson 2.x use the line below instead of the one above: 
			// ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
			// System.out.println(mapper.writeValueAsString(consumer));
			response.setContentType(APPLICATION_JSON);
			PrintWriter out = response.getWriter();
			out.println(writer.writeValueAsString(consumer));
			// System.out.println(writer.writeValueAsString(consumer));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Normally deploy would have the data about the deployment - for this test
	// it is always null and we allow everything
	private ToolConsumer buildToolConsumerProfile(HttpServletRequest request, Map<String, Object> deploy, String profile_id) throws KeyNotFoundException
	{
		// Load the configuration data
		Lti2Config cnf = new Lti2Config();
		Lti2ProviderDomain tool = _dao.loadByKey(profile_id);

		ToolConsumer consumer = new ToolConsumer(profile_id+"", getServiceURL(request), cnf);

		// Normally we would check permissions before we offer capabilities
		List<String> capabilities = consumer.getCapability_offered();
		if (tool.isSendEMailEnabled()) {
			LTI2Util.allowEmail(capabilities);
		}
		
		if (tool.isSendNameEnabled()) {
			LTI2Util.allowName(capabilities);
		}
		
		if (tool.isToolSettingsEnabled()) {	
			LTI2Util.allowSettings(capabilities);
		}
		
		if (tool.isPostGradesEnabled()) {
			LTI2Util.allowResult(capabilities);
		}
		
		// Normally we would check permissions before we offer services
		List<Service_offered> services = consumer.getService_offered();
		services.add(StandardServices.LTI2Registration(getServiceURL(request) + 
			SVC_tc_registration + "/" + profile_id));
		if (tool.isPostGradesEnabled()) {
			services.add(StandardServices.LTI2ResultItem(getServiceURL(request) + 
					SVC_Result + "/{" + BasicLTIConstants.LIS_RESULT_SOURCEDID + "}"));
		}
		
		if (tool.isToolSettingsEnabled()) {
			services.add(StandardServices.LTI2LtiLinkSettings(getServiceURL(request) + 
					SVC_Settings + "/" + LTI2Util.SCOPE_LtiLink + "/{" + BasicLTIConstants.RESOURCE_LINK_ID + "}"));
		}
		
		services.add(StandardServices.LTI2ToolProxySettings(getServiceURL(request) + 
			SVC_Settings + "/" + LTI2Util.SCOPE_ToolProxyBinding + "/{" + BasicLTIConstants.CONTEXT_ID + "}"));
		services.add(StandardServices.LTI2ToolProxySettings(getServiceURL(request) + 
			SVC_Settings + "/" + LTI2Util.SCOPE_ToolProxy + "/{" + LTI2Constants.TOOL_PROXY_GUID + "}"));
		return consumer;
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public void registerToolProviderProfile(HttpServletRequest request,HttpServletResponse response, 
			String profile_id) throws java.io.IOException, KeyNotFoundException
	{
		
		String TEST_KEY = "42";
		String TEST_SECRET = "zaphod";
		
		// Normally we would look up the deployment descriptor
		if ( ! TEST_KEY.equals(profile_id) ) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
			return;
		}

		String key = TEST_KEY;
		String secret = TEST_SECRET;

		IMSJSONRequest jsonRequest = new IMSJSONRequest(request);

		if ( ! jsonRequest.valid ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			doErrorJSON(request, response, jsonRequest, "Request is not in a valid format", null);
			return;
		}

		System.out.println(jsonRequest.getPostBody());

		// Lets check the signature
		if ( key == null || secret == null ) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			doErrorJSON(request, response, jsonRequest, "Deployment is missing credentials", null);
			return;
		}

		jsonRequest.validateRequest(key, secret, request);
		if ( !jsonRequest.valid ) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			doErrorJSON(request, response, jsonRequest, "OAuth signature failure", null);
			return;
		}

		JSONObject providerProfile = (JSONObject) JSONValue.parse(jsonRequest.getPostBody());
		// System.out.println("OBJ:"+providerProfile);
		if ( providerProfile == null  ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			doErrorJSON(request, response, jsonRequest, "JSON parse failed", null);
			return;
		}

		JSONObject default_custom = (JSONObject) providerProfile.get(LTI2Constants.CUSTOM);

		JSONObject security_contract = (JSONObject) providerProfile.get(LTI2Constants.SECURITY_CONTRACT);
		if ( security_contract == null  ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			doErrorJSON(request, response, jsonRequest, "JSON missing security_contract", null);
			return;
		}

		String shared_secret = (String) security_contract.get(LTI2Constants.SHARED_SECRET);
		System.out.println("shared_secret="+shared_secret);
		if ( shared_secret == null  ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			doErrorJSON(request, response, jsonRequest, "JSON missing shared_secret", null);
			return;
		}

		// Make sure that the requested services are a subset of the offered services
		ToolConsumer consumer = buildToolConsumerProfile(request, null, profile_id);

		JSONArray tool_services = (JSONArray) security_contract.get(LTI2Constants.TOOL_SERVICE);
		String retval = LTI2Util.validateServices(consumer, providerProfile);
		if ( retval != null ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			doErrorJSON(request, response, jsonRequest, retval, null);
			return;
		}

		// Parse the tool profile bit and extract the tools with error checking
		retval = LTI2Util.validateCapabilities(consumer, providerProfile);
		if ( retval != null ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			doErrorJSON(request, response, jsonRequest, retval, null);
			return;
		}

		// Pass the profile to the launch process
		//PERSIST.put("profile", providerProfile.toString());

		// Share our happiness with the Tool Provider
		Map jsonResponse = new TreeMap();
		jsonResponse.put(LTI2Constants.CONTEXT,StandardServices.TOOLPROXY_ID_CONTEXT);
		jsonResponse.put(LTI2Constants.TYPE, StandardServices.TOOLPROXY_ID_TYPE);
		jsonResponse.put(LTI2Constants.JSONLD_ID, getServiceURL(request) + SVC_tc_registration + "/" +profile_id);
		jsonResponse.put(LTI2Constants.TOOL_PROXY_GUID, profile_id);
		jsonResponse.put(LTI2Constants.CUSTOM_URL, getServiceURL(request) + SVC_Settings + "/" + LTI2Util.SCOPE_ToolProxy + "/" +profile_id);
		response.setContentType(StandardServices.TOOLPROXY_ID_FORMAT);
		response.setStatus(HttpServletResponse.SC_CREATED);
		String jsonText = JSONValue.toJSONString(jsonResponse);
		M_log.debug(jsonText);
		PrintWriter out = response.getWriter();
		out.println(jsonText);
	}
	
	private String getServiceURL(HttpServletRequest request) {
		String scheme = request.getScheme();             // http
		String serverName = request.getServerName();     // localhost
		int serverPort = request.getServerPort();        // 80
		String contextPath = request.getContextPath();   // /imsblis
		String servletPath = request.getServletPath();   // /ltitest
		String url = scheme+"://"+serverName+":"+serverPort+contextPath+servletPath+"/";
		return url;
	}
	
	/* IMS JSON version of Errors */
	private void doErrorJSON(HttpServletRequest request,HttpServletResponse response, 
			IMSJSONRequest json, String message, Exception e) 
			throws java.io.IOException 
	{
		if (e != null) {
			M_log.error(e.getLocalizedMessage(), e);
		}
        M_log.info(message);
		String output = IMSJSONRequest.doErrorJSON(request, response, json, message, e);
		System.out.println(output);
    }
}