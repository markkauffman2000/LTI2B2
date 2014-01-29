<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.HashMap,
				 blackboard.servlet.tags.ngui.datacollection.DataElementTag,
				 blackboard.base.FormattedText,
				 bbdn.lti2.BBDNConstants,
				 bbdn.lti2.dao.Lti2Properties,
				 bbdn.lti2.dao.Lti2PropertiesDAO,
				 bbdn.lti2.util.SettingsUtil" 
%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<%
	FormattedText defaultText = null; 
	
	/* BEGIN - Code from GST used as example 
	
		OsceGSTSysConfigDAO dao = new OsceGSTSysConfigDAO();
		OsceGSTSysConfig gstsysprefs = null;
		gstsysprefs = dao.load();
	
	END - Code from GST used as an example */
	
	Lti2PropertiesDAO gsDAO = new Lti2PropertiesDAO();
	Lti2Properties globalSettings = null;
	globalSettings = gsDAO.load();
	
	HashMap<String,String> gsMap = SettingsUtil.convertGlobalSettings(globalSettings);
%>

<bbNG:genericPage
        title="LTI 2.0 Global Settings"
        ctxId="ctx"
        entitlement='system.admin.VIEW'
        navItem="bbdn_lti2_props">

        <bbNG:pageHeader 
        	instructions="Manage the Global Properties for all LTI 2.0 Tool Providers in use in the system. Determine the feature and service availability, and default configuration. Selecting the option to enable the feature will enable all approved LTI 2.0 Tool Providers.">
        	
        	<bbNG:breadcrumbBar environment="SYS_ADMIN">
        		<bbNG:breadcrumb>LTI 2.0 Global Settings</bbNG:breadcrumb>
        	</bbNG:breadcrumbBar>
            
            <bbNG:pageTitleBar>
                    LTI 2.0 Global Settings
            </bbNG:pageTitleBar>
            
        </bbNG:pageHeader>
        
        <bbNG:form>
        
        	<bbNG:dataCollection>
        		
        		<bbNG:step title="Feature Availability" instructions="Tool links can be enabled in one of three modes. <b>Allow any links</b> enables users building courses to add links to any LTI tool providers they wish. <b>Allow any links with approval</b> allows users to add the links, but they will not function until the provider has been approved. <b>Require approval</b> will not let users add links unless the provider has already been approved. Enabling the grade option will allow tool providers which you have registered, and which have a gradable placement, to post a grade.">
        	
        			<bbNG:dataElement label="Enabled in Courses" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="enabledCourse" id="enabledCourseYes" optionLabel="Yes" value="true" isSelected="<%=Boolean.getBoolean(gsMap.get(\"CourseEnabled\"))%>" />
        				<bbNG:radioElement name="enabledCourse" id="enabledCourseNo" optionLabel="No" value="false" isSelected="<%=Boolean.getBoolean(gsMap.get(\"CourseDisabled\"))%>" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Enabled in Organizations" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="enabledOrgs" id="enabledOrgYes" optionLabel="Yes" value="true" isSelected="<%=Boolean.getBoolean(gsMap.get(\"OrgEnabled\"))%>" />
        				<bbNG:radioElement name="enabledOrgs" id="enabledOrgNo" optionLabel="No" value="false" isSelected="<%=Boolean.getBoolean(gsMap.get(\"OrgDisabled\"))%>" />
        			</bbNG:dataElement>

					<bbNG:dataElement label="Creation of Tool Provider Links" renderLegendAndFieldset="true">
        				<p><bbNG:radioElement name="linkCreation" id="linkCreationAllow" optionLabel="Allow only links to approved tool providers." value="<%=BBDNConstants.BBDN_ONLY_APPROVED_LINKS%>" isSelected="<%=Boolean.getBoolean(gsMap.get(\"LinkCreationAllow\"))%>" /></p>
        				<p><bbNG:radioElement name="linkCreation" id="linkCreationNeedApproval" optionLabel="Allow links to any tool provider, but require approval for each new provider." value="<%=BBDNConstants.BBDN_ANY_LINK_WITH_APPROVAL%>" isSelected="<%=Boolean.getBoolean(gsMap.get(\"LinkCreationNeedApproval\"))%>" /></p>
        				<p><bbNG:radioElement name="linkCreation" id="linkCreationExclude" optionLabel="Allow links to any tool provider that isn't explicitly excluded." value="<%=BBDNConstants.BBDN_ALLOW_NON_EXCLUDED%>" isSelected="<%=Boolean.getBoolean(gsMap.get(\"LinkCreationExclude\"))%>" /></p>
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="LTI 2.0 Default Service Contract" instructions="LTI 2.0 allows the Tool Provider and Tool Consumer to negotiate the contract of allowable services. This section allows the admin to specifiy the default values for the allowed services.">
  
        			<bbNG:dataElement label="Allow configured tool providers to post grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="postGrades" id="postGradesYes" optionLabel="Yes" value="true" isSelected="<%=Boolean.getBoolean(gsMap.get(\"PostGradesEnabled\"))%>" />
        				<bbNG:radioElement name="postGrades" id="postGradesNo" optionLabel="No" value="false" isSelected="<%=Boolean.getBoolean(gsMap.get(\"PostGradesDisabled\"))%>" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Allow configured tool providers to request grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="getGrades" id="getGradesYes" optionLabel="Yes" value="true" isSelected="<%=Boolean.getBoolean(gsMap.get(\"GetGradesEnabled\"))%>" />
        				<bbNG:radioElement name="getGrades" id="getGradesNo" optionLabel="No" value="false" isSelected="<%=Boolean.getBoolean(gsMap.get(\"GetGradesDisabled\"))%>" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Allow Tool Provider to store settings data" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="putToolSettingsContainer" id="putToolSettingsContainerYes" optionLabel="Yes" value="true" isSelected="<%=Boolean.getBoolean(gsMap.get(\"PutToolSettingsEnabled\"))%>" />
        				<bbNG:radioElement name="putToolSettingsContainer" id="putToolSettingsContainerNo" optionLabel="No" value="false" isSelected="<%=Boolean.getBoolean(gsMap.get(\"PutToolSettingsDisabled\"))%>" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="Default Configuration" instructions="LTI Tool Providers can request certain information from Learn with each click-through. Set the default information that will be sent from your institution. These settings can be overridden for each tool provider.">

        			<bbNG:dataElement label="Send User Data" renderLegendAndFieldset="true">
        				<p><bbNG:radioElement name="sendData" id="sendDataNever" optionLabel="Never" value="<%=BBDNConstants.BBDN_USER_DATA_NEVER%>" isSelected="<%=Boolean.getBoolean(gsMap.get(\"SendDataNever\"))%>" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataSSL" optionLabel="Send user data only over SSL" value="<%=BBDNConstants.BBDN_USER_DATA_SSL%>" isSelected="<%=Boolean.getBoolean(gsMap.get(\"SendDataSSL\"))%>" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataAny" optionLabel="Send user data over any connection" value="<%=BBDNConstants.BBDN_USER_DATA_ANY%>" isSelected="<%=Boolean.getBoolean(gsMap.get(\"SendDataAny\"))%>" /></p>
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Show user acknowledgement message" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="userAck" id="userAckYes" optionLabel="Yes" value="true" isSelected="<%=Boolean.getBoolean(gsMap.get(\"UserAckEnabled\"))%>" />
        				<bbNG:radioElement name="userAck" id="userAckNo" optionLabel="No" value="false" isSelected="<%=Boolean.getBoolean(gsMap.get(\"UserAckDisabled\"))%>" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Message Text" renderLegendAndFieldset="true">
        				<bbNG:textbox name="userAckMsg" ftext="<%=FormattedText.toFormattedText(gsMap.get(\"UserAckMessage\"))%>" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:stepSubmit />
        	
        	</bbNG:dataCollection>
        </bbNG:form>
        
</bbNG:genericPage>