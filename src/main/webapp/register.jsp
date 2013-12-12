<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="blackboard.servlet.tags.ngui.datacollection.DataElementTag,
				 blackboard.base.FormattedText,
				 bbdn.lti2.BBDNConstants" %>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<%
	FormattedText defaultText = new FormattedText("Place your message text here.", FormattedText.Type.PLAIN_TEXT );
	String navItem = request.getParameter("navItem");
%>

<bbNG:genericPage
        title="Register LTI 2.0 Provider Domain"
        ctxId="ctx"
        entitlement='system.admin.VIEW'
        navItem="<%=navItem%>">

        <bbNG:pageHeader 
        	instructions="Create a new registered provider domain, configure, and set policies. The provider domain, and secondary hostnames must be unique.">
        	
        	<bbNG:breadcrumbBar environment="SYS_ADMIN">
        		<bbNG:breadcrumb>LTI 2.0 Global Settings</bbNG:breadcrumb>
        	</bbNG:breadcrumbBar>
            
            <bbNG:pageTitleBar>
                    Register LTI 2.0 Provider Domain
            </bbNG:pageTitleBar>
            
        </bbNG:pageHeader>

        <bbNG:form>
        
        	<bbNG:dataCollection>
        		
        		<bbNG:step title="Provider Domain Status" instructions="Set the status of the provider domain. You can also provide a list of additional hostnames to share this configuration if needed.">
        			
        			<bbNG:dataElement label="Provider Domain" renderLegendAndFieldset="true" isRequired="true">
        				<bbNG:textElement name="domain" id="domain" title="Provider Domain" maxLength="255" minLength="1" value="domain" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Provider Domain Status" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="domainStatus" id="domainStatusEnabled" optionLabel="Approved" value="true" isSelected="true" />
        				<bbNG:radioElement name="domainStatus" id="domainStatusExcluded" optionLabel="Excluded" value="false" isSelected="false" />
        			</bbNG:dataElement>

					<bbNG:dataElement label="Secondary Hostnames" renderLegendAndFieldset="true">
        				<textarea name="secondaryHostnames" id="secondaryHostnames" rows="6" cols="55">Hostnames go here.</textarea>
          				<bbNG:elementInstructions text="Enter one hostname per line."/>
        			</bbNG:dataElement>
        		
        		</bbNG:step>
        		
        		<bbNG:step title="Default Configuration" instructions="LTI Tool Providers can request configuration per link, or can provide key and shared secret information for site-wide configuration." >
        			
        			<bbNG:dataElement label="Default Configuration" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="defaultConfig" id="defaultConfigSeparate" optionLabel="Set separately for each link" value="true" isSelected="true" />
        				<bbNG:radioElement name="defaultConfig" id="defaultConfigGlobally" optionLabel="Set globally." value="false" isSelected="false" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Tool Provider Custom Parameters" labelFor="customParameters">
          				<textarea name="customParameters" id="customParameters" rows="6" cols="55" disabled>Your custom parameters here.</textarea>
          				<bbNG:elementInstructions text="Enter any custom parameters required by the tool provider. Parameters must each be on their own line and be entered in \"name=value\" format."/>
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="LTI 2.0 Tool Service Contract" instructions="LTI 2.0 allows the Tool Provider and Tool Consumer to negotiate the contract of allowable services. This section allows the admin to specifiy the allowed services for this tool provider.">
  
        			<bbNG:dataElement label="Allow configured tool providers to post grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="postGrades" id="postGradesYes" optionLabel="Yes" value="true" isSelected="true" />
        				<bbNG:radioElement name="postGrades" id="postGradesNo" optionLabel="No" value="false" isSelected="false" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Allow configured tool providers to request grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="getGrades" id="getGradesYes" optionLabel="Yes" value="true" isSelected="true" />
        				<bbNG:radioElement name="getGrades" id="getGradesNo" optionLabel="No" value="false" isSelected="false" />
        			</bbNG:dataElement>
        			    			
        			<bbNG:dataElement label="Allow Tool Provider to store settings data" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="putToolSettingsContainer" id="putToolSettingsContainerYes" optionLabel="Yes" value="true" isSelected="true" />
        				<bbNG:radioElement name="putToolSettingsContainer" id="putToolSettingsContainerNo" optionLabel="No" value="false" isSelected="false" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="Institution Policies" instructions="LTI Tool Providers can request certain information from Learn with each click-through. Set the default information that will be sent from your institution. These settings can be overridden for each tool provider.">
        		
        			<bbNG:dataElement label="Send User Data" renderLegendAndFieldset="true">
        				<p><bbNG:radioElement name="sendData" id="sendDataNever" optionLabel="Never" value="<%=BBDNConstants.BBDN_USER_DATA_NEVER%>" isSelected="true" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataSSL" optionLabel="Send user data only over SSL" value="<%=BBDNConstants.BBDN_USER_DATA_SSL%>" isSelected="false" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataAny" optionLabel="Send user data over any connection" value="<%=BBDNConstants.BBDN_USER_DATA_ANY%>" isSelected="false" /></p>
        			</bbNG:dataElement>
        			
        			
        			<bbNG:dataElement label="Provide the roster to external tools" renderLegendAndFieldset="true">
        				<p><bbNG:checkboxElement name="sendRole" id="sendRole" optionLabel="Role in Course" value="true" isSelected="true" /></p>
        				<p><bbNG:checkboxElement name="sendUserName" id="sendUserName" optionLabel="Name" value="true" isSelected="true" /></p>
        				<p><bbNG:checkboxElement name="sendEmail" id="sendEmail" optionLabel="Email Address" value="true" isSelected="true" /></p>
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Show user acknowledgement message" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="userAck" id="userAckYes" optionLabel="Yes" value="true" isSelected="true" />
        				<bbNG:radioElement name="userAck" id="userAckNo" optionLabel="No" value="false" isSelected="false" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Message Text" renderLegendAndFieldset="true">
        				<bbNG:textbox name="userAckMsg" ftext="<%=defaultText%>" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:stepSubmit />
        	
        	</bbNG:dataCollection>
        </bbNG:form>
        
</bbNG:genericPage>