package bbdn.lti2.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private void saveProps(HttpServletRequest request, HttpServletResponse response,
							@RequestParam("enabledCourse") String enabledCourse,
							@RequestParam("enabledOrgs") String enabledOrgs,
							@RequestParam("linkCreation") String linkCreation,
							@RequestParam("postGrades") String postGrades,
							@RequestParam("getGrades") String getGrades,
							@RequestParam("putToolSettingsContainer") String putToolSettingsContainer,
							@RequestParam("sendData") String sendData,
							@RequestParam("sendUserName") String sendUserName,
							@RequestParam("sendUserRole") String sendUserRole,
							@RequestParam("sendUserEmail") String sendUserEmail,
							@RequestParam("userAck") String userAck,
							@RequestParam("userAckMsgtext") String userAckMsgtext
							) {

		Lti2Properties props = _dao.load();
        
        //set all prefs to incoming request parameter values
		props.enableCourses(Boolean.valueOf(enabledCourse));
        props.enableOrgs(Boolean.valueOf(enabledOrgs));
        props.setPropertyLinkType(Integer.parseInt(linkCreation));
        props.enablePostGrades(Boolean.valueOf(postGrades));
        props.enableGetGrades(Boolean.valueOf(getGrades));
        props.enableToolSettings(Boolean.valueOf(putToolSettingsContainer));
        props.setSendDataConfig(Integer.parseInt(sendData));
        props.enableSendName(Boolean.valueOf(sendUserName));
        props.enableSendRole(Boolean.valueOf(sendUserRole));
        props.enableSendEMail(Boolean.valueOf(sendUserEmail));
        props.enableSplashScreen(Boolean.valueOf(userAck));
        props.setSplashScreenMessage(userAckMsgtext);
        
        //save the prefs
        _dao.save(props);
        
        try {
			response.sendRedirect("index");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
