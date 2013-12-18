package bbdn.lti2.util;

import java.util.HashMap;

import bbdn.lti2.dao.Lti2Properties;

/**
 * 
 */

/**
 * @author shurrey
 *
 */
public abstract class SettingsUtil {

	/**
	 * 
	 */
	public static String indToBool(char indVal) {
		if (indVal == 'Y')
			return "true";
		else
			return "false";	
	}
	
	public static HashMap<String,String> convertGlobalSettings(Lti2Properties globalSettings) {
		HashMap<String,String> gsMap = new HashMap<String,String>();
		
		// Map Global Settings Id
		gsMap.put("SettingsId",Integer.toString(globalSettings.getProps_id()));
		
		// Map LTI 2.0 Enabled in Courses
		String courseDisabled = "false";
		String courseEnabled = indToBool(globalSettings.getProps_courses_ind());
		
		if (courseEnabled.matches("false")) {
			courseDisabled = "true";
		}
		
		gsMap.put("CourseEnabled", courseEnabled);
		gsMap.put("CourseDisabled", courseDisabled);
		
		// Map LTI 2.0 Enabled in Courses
		String orgDisabled = "false";
		String orgEnabled = indToBool(globalSettings.getProps_orgs_ind());
		
		if (orgEnabled.matches("false")) {
			orgDisabled = "true";
		}
				
		gsMap.put("OrgEnabled", orgEnabled);
		gsMap.put("OrgDisabled", orgDisabled);
		
		// Map Link Creation Settings
		int linksAllowed = globalSettings.getProps_links();
		
		String linkCreationAllow = "false";
		String linkCreationNeedApproval = "false";
		String linkCreationExclude = "false";
		
		switch(linksAllowed) {
		case 0:	linkCreationAllow = "true";
		case 1: linkCreationNeedApproval = "true";
		case 2: linkCreationExclude = "true";
		}
		
		gsMap.put("LinkCreationAllow", linkCreationAllow);
		gsMap.put("LinkCreationNeedApproval", linkCreationNeedApproval);
		gsMap.put("LinkCreationExclude", linkCreationExclude);
				
		// Map LTI 2.0 Post Grades
		String postGradesDisabled = "false";
		String postGradesEnabled = indToBool(globalSettings.getProps_postgrades_ind());
				
		if (postGradesEnabled.matches("false")) {
			postGradesDisabled = "true";
		}
		
		gsMap.put("PostGradesEnabled", postGradesEnabled);
		gsMap.put("PostGradesDisabled", postGradesDisabled);
		
		// Map LTI 2.0 Get Grades
		String getGradesDisabled = "false";
		String getGradesEnabled = indToBool(globalSettings.getProps_getgrades_ind());
				
		if (getGradesEnabled.matches("false")) {
			getGradesDisabled = "true";
		}
		
		gsMap.put("GetGradesEnabled", getGradesEnabled);
		gsMap.put("GetGradesDisabled", getGradesDisabled);

		// Map LTI 2.0 Post Tool Settings
		String putToolSettingsDisabled = "false";
		String putToolSettingsEnabled = indToBool(globalSettings.getProps_toolsettings_ind());
				
		if (putToolSettingsEnabled.matches("false")) {
			putToolSettingsDisabled = "true";
		}
		
		gsMap.put("PutToolSettingsEnabled", putToolSettingsEnabled);
		gsMap.put("PutToolSettingsDisabled", putToolSettingsDisabled);
		
		// Map User Data Connection Setting
		int sendData = globalSettings.getProps_senddata();
		
		String sendDataNever = "false";
		String sendDataSSL = "false";
		String sendDataAny = "false";
		
		switch(sendData) {
		case 0:	sendDataNever = "true";
		case 1: sendDataSSL = "true";
		case 2: sendDataAny = "true";
		}
		
		gsMap.put("SendDataNever", sendDataNever);
		gsMap.put("SendDataSSL", sendDataSSL);
		gsMap.put("SendDataAny", sendDataAny);
				
		// Map Send Role Setting
		String sendRoleDisabled = "false";
		String sendRoleEnabled = indToBool(globalSettings.getProps_sendrole_ind());
				
		if (sendRoleEnabled.matches("false")) {
			sendRoleDisabled = "true";
		}
		
		gsMap.put("SendRoleEnabled", sendRoleEnabled);
		gsMap.put("SendRoleDisabled", sendRoleDisabled);
		
		// Map Send Name Setting
		String sendNameDisabled = "false";
		String sendNameEnabled = indToBool(globalSettings.getProps_sendname_ind());
		
		if (sendNameEnabled.matches("false")) {
			sendNameDisabled = "true";
		}

		gsMap.put("SendNameEnabled", sendNameEnabled);
		gsMap.put("SendNameDisabled", sendNameDisabled);

		// Map Send Email Setting
		String sendEmailDisabled = "false";
		String sendEmailEnabled = indToBool(globalSettings.getProps_sendemail_ind());
		
		if (sendEmailEnabled.matches("false")) {
			sendEmailDisabled = "true";
		}

		gsMap.put("SendEmailEnabled", sendEmailEnabled);
		gsMap.put("SendEmailDisabled", sendEmailDisabled);

		// Map User Acknowledgment Setting
		String userAckDisabled = "false";
		String userAckEnabled = indToBool(globalSettings.getProps_userack_ind());
		
		if (userAckEnabled.matches("false")) {
			userAckDisabled = "true";
		}

		gsMap.put("UserAckEnabled", userAckEnabled);
		gsMap.put("UserAckDisabled", userAckDisabled);

		// Map User Acknowledgment Message
		gsMap.put("UserAckMessage", globalSettings.getProps_ackmsg());
		
		return(gsMap);
	}

}
