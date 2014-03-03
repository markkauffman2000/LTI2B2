<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.HashMap,
				 javax.servlet.http.HttpServletRequest, 
				 blackboard.servlet.tags.ngui.datacollection.DataElementTag,
				 blackboard.base.FormattedText,
				 blackboard.platform.plugin.PlugInUtil,
				 bbdn.lti2.BBDNConstants,
				 bbdn.lti2.dao.Lti2Properties,
				 bbdn.lti2.dao.Lti2PropertiesDAO" 
%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:genericPage
        title="LTI 2.0 Global Settings"
        ctxId="ctx"
        entitlement='system.admin.VIEW'
        navItem="bbdn-lti2-app-nav-1">

        <bbNG:pageHeader 
        	instructions="Manage the Global Properties for all LTI 2.0 Tool Providers in use in the system. Determine the feature and service availability, and default configuration. Selecting the option to enable the feature will enable all approved LTI 2.0 Tool Providers.">
        	
        	<bbNG:breadcrumbBar environment="SYS_ADMIN" />
            
            <bbNG:pageTitleBar>
                    LTI 2.0 Global Settings
            </bbNG:pageTitleBar>
            
        </bbNG:pageHeader>
        
        <bbNG:form action="saveProperties" method="POST" isSecure="${ true }" nonceId="/saveProperties">
        
        	<bbNG:dataCollection>
        		
        		<bbNG:step title="Feature Availability" instructions="Tool links can be enabled in one of three modes. <b>Allow any links</b> enables users building courses to add links to any LTI tool providers they wish. <b>Allow any links with approval</b> allows users to add the links, but they will not function until the provider has been approved. <b>Require approval</b> will not let users add links unless the provider has already been approved. Enabling the grade option will allow tool providers which you have registered, and which have a gradable placement, to post a grade.">
        	
        			<bbNG:dataElement label="Enabled in Courses" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="enabledCourse" id="enabledCourseYes" optionLabel="Yes" value="true" isSelected="${courseEnabled}" />
        				<bbNG:radioElement name="enabledCourse" id="enabledCourseNo" optionLabel="No" value="false" isSelected="${!courseEnabled}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Enabled in Organizations" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="enabledOrgs" id="enabledOrgYes" optionLabel="Yes" value="true" isSelected="${orgsEnabled}" />
        				<bbNG:radioElement name="enabledOrgs" id="enabledOrgNo" optionLabel="No" value="false" isSelected="${!orgsEnabled}" />
        			</bbNG:dataElement>

					<bbNG:dataElement label="Creation of Tool Provider Links" renderLegendAndFieldset="true">
        				<p><bbNG:radioElement name="linkCreation" id="linkCreationAllow" optionLabel="Allow only links to approved tool providers." value="<%=BBDNConstants.BBDN_ONLY_APPROVED_LINKS%>" isSelected="${linkCreation[0]}" /></p>
        				<p><bbNG:radioElement name="linkCreation" id="linkCreationNeedApproval" optionLabel="Allow links to any tool provider, but require approval for each new provider." value="<%=BBDNConstants.BBDN_ANY_LINK_WITH_APPROVAL%>" isSelected="${linkCreation[1]}" /></p>
        				<p><bbNG:radioElement name="linkCreation" id="linkCreationExclude" optionLabel="Allow links to any tool provider that isn't explicitly excluded." value="<%=BBDNConstants.BBDN_ALLOW_NON_EXCLUDED%>" isSelected="${linkCreation[2]}" /></p>
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="LTI 2.0 Default Service Contract" instructions="LTI 2.0 allows the Tool Provider and Tool Consumer to negotiate the contract of allowable services. This section allows the admin to specifiy the default values for the allowed services.">
  
        			<bbNG:dataElement label="Allow configured tool providers to post grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="postGrades" id="postGradesYes" optionLabel="Yes" value="true" isSelected="${postGrades}" />
        				<bbNG:radioElement name="postGrades" id="postGradesNo" optionLabel="No" value="false" isSelected="${!postGrades}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Allow configured tool providers to request grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="getGrades" id="getGradesYes" optionLabel="Yes" value="true" isSelected="${getGrades}" />
        				<bbNG:radioElement name="getGrades" id="getGradesNo" optionLabel="No" value="false" isSelected="${!getGrades}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Allow Tool Provider to store settings data" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="putToolSettingsContainer" id="putToolSettingsContainerYes" optionLabel="Yes" value="true" isSelected="${toolConfig}" />
        				<bbNG:radioElement name="putToolSettingsContainer" id="putToolSettingsContainerNo" optionLabel="No" value="false" isSelected="${!toolConfig}" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="Default Configuration" instructions="LTI Tool Providers can request certain information from Learn with each click-through. Set the default information that will be sent from your institution. These settings can be overridden for each tool provider.">

        			<bbNG:dataElement label="Send user data" renderLegendAndFieldset="true">
        				<p><bbNG:radioElement name="sendData" id="sendDataNever" optionLabel="Never" value="<%=BBDNConstants.BBDN_USER_DATA_NEVER%>" isSelected="${sendDataConfig[0]}" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataSSL" optionLabel="Send user data only over SSL" value="<%=BBDNConstants.BBDN_USER_DATA_SSL%>" isSelected="${sendDataConfig[1]}" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataAny" optionLabel="Send user data over any connection" value="<%=BBDNConstants.BBDN_USER_DATA_ANY%>" isSelected="${sendDataConfig[2]}" /></p>
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Send user name" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="sendUserName" id="sendUserNameYes" optionLabel="Yes" value="true" isSelected="${sendName}" />
        				<bbNG:radioElement name="sendUserName" id="sendUserNameNo" optionLabel="No" value="false" isSelected="${!sendName}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Send user role" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="sendUserRole" id="sendUserRoleYes" optionLabel="Yes" value="true" isSelected="${sendRole}" />
        				<bbNG:radioElement name="sendUserRole" id="sendUserRoleNo" optionLabel="No" value="false" isSelected="${!sendRole}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Send user email" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="sendUserEmail" id="sendUserEmailYes" optionLabel="Yes" value="true" isSelected="${sendEmail}" />
        				<bbNG:radioElement name="sendUserEmail" id="sendUserEmailNo" optionLabel="No" value="false" isSelected="${!sendEmail}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Show user acknowledgement message" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="userAck" id="userAckYes" optionLabel="Yes" value="true" isSelected="${displaySplash}" />
        				<bbNG:radioElement name="userAck" id="userAckNo" optionLabel="No" value="false" isSelected="${!displaySplash}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Message Text" renderLegendAndFieldset="true">
        				<bbNG:textbox name="userAckMsg" ftext="${splashMessage}" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:stepSubmit />
        	
        	</bbNG:dataCollection>
        </bbNG:form>
        
</bbNG:genericPage>