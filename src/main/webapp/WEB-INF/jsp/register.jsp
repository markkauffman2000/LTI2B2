<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Map,
				 blackboard.base.FormattedText,
				 blackboard.data.ReceiptOptions,
				 blackboard.persist.KeyNotFoundException,
				 blackboard.platform.plugin.PlugInUtil,
				 blackboard.platform.servlet.InlineReceiptUtil,
				 blackboard.servlet.tags.ngui.datacollection.DataElementTag,bbdn.lti2.util.BBDNConstants,bbdn.lti2.beans.Lti2Properties,
				 bbdn.lti2.dao.Lti2PropertiesDAO,bbdn.lti2.beans.Lti2ProviderDomain,
				 bbdn.lti2.dao.Lti2ProviderDomainDAO" %>

<%@ taglib uri="/bbNG" prefix="bbNG"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<bbNG:genericPage
        title="Register LTI 2.0 Domain"
        ctxId="ctx"
        entitlement='system.admin.VIEW'
        navItem="bbdn-lti2-app-nav-1">

        <bbNG:pageHeader 
        	instructions="Create a new registered provider domain, configure, and set policies. The provider domain, and secondary hostnames must be unique.">
        	
        	<bbNG:breadcrumbBar environment="SYS_ADMIN" />
            
            <bbNG:pageTitleBar>
                    Register LTI 2.0 Provider Domain
            </bbNG:pageTitleBar>
            
        </bbNG:pageHeader>
		
        <bbNG:form action="saveDomain" method="POST" isSecure="${ true }" nonceId="/saveDomain">
        
        <bbNG:hiddenElement name="actionType" value="save" />
        <bbNG:hiddenElement name="toolIds" value="${toolIds}" />
        
        	<bbNG:dataCollection>
        		<bbNG:step title="Provider Domain Status" instructions="Set the status of the provider domain. You can also provide a list of additional hostnames to share this configuration if needed.">
        			<c:choose> 
        				<c:when test="${actionType == 'register'}">
        					<bbNG:hiddenElement name="domainStatus" value="${domainStatus}" />
        					<bbNG:hiddenElement name="toolKey" value="${key}" />
        					<bbNG:hiddenElement name="toolSecret" value="${secret}" />
        					<bbNG:hiddenElement name="secondaryHostnames" value="${sechostnames}" />
        					
        					<bbNG:dataElement label="Registration URL" renderLegendAndFieldset="true" isRequired="true">
        						<bbNG:textElement name="domain" id="domain" title="LTI 2.0 Tool Provider Registration URL" maxLength="255" minLength="1" value="" />
        					</bbNG:dataElement>
        			
        				</c:when>
        				<c:otherwise>
        					<bbNG:dataElement label="Provider Domain" renderLegendAndFieldset="true" isRequired="true">
        						<bbNG:textElement name="domain" id="domain" title="Provider Domain" maxLength="255" minLength="1" value="${domain}" />
        					</bbNG:dataElement>
        			
        					<bbNG:dataElement label="Provider Domain Status" renderLegendAndFieldset="true">
        						<bbNG:radioElement name="domainStatus" id="domainStatusEnabled" optionLabel="Approved" value="true" isSelected="${domain_status}" />
        						<bbNG:radioElement name="domainStatus" id="domainStatusExcluded" optionLabel="Excluded" value="false" isSelected="${!domain_status}" />
        					</bbNG:dataElement>
        			
        					<bbNG:dataElement label="Consumer Key" renderLegendAndFieldset="true" isRequired="true">
        						<bbNG:textElement name="toolKey" id="toolKey" title="Consumer Key" maxLength="255" minLength="1" value="${key}" />
        					</bbNG:dataElement>
        			
        					<bbNG:dataElement label="Shared Secret" renderLegendAndFieldset="true" isRequired="true">
        						<bbNG:textElement name="toolSecret" id="toolSecret" title="Shared Secret" maxLength="255" minLength="1" value="${secret}" />
        					</bbNG:dataElement>
        					
        					<bbNG:dataElement label="Secondary Hostnames" renderLegendAndFieldset="true">
        						<textarea name="secondaryHostnames" id="secondaryHostnames" rows="6" cols="55">${sechostnames}</textarea>
          						<bbNG:elementInstructions text="Enter one hostname per line."/>
        					</bbNG:dataElement>
        				</c:otherwise>
        			</c:choose>
        					
        		</bbNG:step>
        		
        		
        		<c:choose> 
        			<c:when test="${actionType == 'register'}">
        				<bbNG:hiddenElement name="defaultConfig" value="${globalLinks}" />
       					<bbNG:hiddenElement name="customParameters" value="${customParameters}" />
       				</c:when>
        			<c:otherwise>
		        		<bbNG:step title="Default Configuration" instructions="LTI Tool Providers can request configuration per link, or can provide key and shared secret information for site-wide configuration." >
		        			
		        			<bbNG:dataElement label="Default Configuration" renderLegendAndFieldset="true">
		        				<bbNG:radioElement name="defaultConfig" id="defaultConfigSeparate" optionLabel="Set separately for each link" value="true" isSelected="${globalLinks}" />
		        				<bbNG:radioElement name="defaultConfig" id="defaultConfigGlobally" optionLabel="Set globally." value="false" isSelected="${!globalLinks}" />
		        			</bbNG:dataElement>
		        			
		        			<bbNG:dataElement label="Tool Provider Custom Parameters" labelFor="customParameters">
		          				<textarea name="customParameters" id="customParameters" rows="6" cols="55">${customParameters}</textarea>
		          				<bbNG:elementInstructions text="Enter any custom parameters required by the tool provider. Parameters must each be on their own line and be entered in \"name=value\" format."/>
		        			</bbNG:dataElement>
		        			
		        		</bbNG:step>
		        	</c:otherwise>
        		</c:choose>

        		<bbNG:step title="LTI 2.0 Tool Service Contract" instructions="LTI 2.0 allows the Tool Provider and Tool Consumer to negotiate the contract of allowable services. This section allows the admin to specifiy the allowed services for this tool provider.">
  
        			<bbNG:dataElement label="Allow configured tool providers to post grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="postGrades" id="postGradesYes" optionLabel="Yes" value="true" isSelected="${postGrades}" />
        				<bbNG:radioElement name="postGrades" id="postGradesNo" optionLabel="No" value="false" isSelected="${!postGrades}" />
        			</bbNG:dataElement>
        			
        			<bbNG:dataElement label="Allow configured tool providers to request grades" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="getGrades" id="getGradesYes" optionLabel="Yes" value="true" isSelected="${getGrades}" />
        				<bbNG:radioElement name="getGrades" id="getGradesNo" optionLabel="No" value="false" isSelected="${!getGrades}" />
        			</bbNG:dataElement>
        			    			
        			<bbNG:dataElement label="Allow Tool Provider to store settings data" renderLegendAndFieldset="true">
        				<bbNG:radioElement name="toolConfig" id="putToolSettingsContainerYes" optionLabel="Yes" value="true" isSelected="${toolConfig}" />
        				<bbNG:radioElement name="toolConfig" id="putToolSettingsContainerNo" optionLabel="No" value="false" isSelected="${!toolConfig}" />
        			</bbNG:dataElement>
        			
        		</bbNG:step>
        		
        		<bbNG:step title="Institution Policies" instructions="LTI Tool Providers can request certain information from Learn with each click-through. Set the default information that will be sent from your institution. These settings can be overridden for each tool provider.">
        		
        			<bbNG:dataElement label="Send User Data" renderLegendAndFieldset="true">
        				<p><bbNG:radioElement name="sendData" id="sendDataNever" optionLabel="Never" value="<%=BBDNConstants.BBDN_USER_DATA_NEVER%>" isSelected="${sendDataConfig[0]}" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataSSL" optionLabel="Send user data only over SSL" value="<%=BBDNConstants.BBDN_USER_DATA_SSL%>" isSelected="${sendDataConfig[1]}" /></p>
        				<p><bbNG:radioElement name="sendData" id="sendDataAny" optionLabel="Send user data over any connection" value="<%=BBDNConstants.BBDN_USER_DATA_ANY%>" isSelected="${sendDataConfig[2]}" /></p>
        			</bbNG:dataElement>
        			
        			
        			<bbNG:dataElement label="Provide the roster to external tools" renderLegendAndFieldset="true">
        				<p><bbNG:checkboxElement name="sendRole" id="sendRole" optionLabel="Role in Course" value="true" isSelected="${sendRole}" /></p>
        				<p><bbNG:checkboxElement name="sendUserName" id="sendUserName" optionLabel="Name" value="true" isSelected="${sendName}" /></p>
        				<p><bbNG:checkboxElement name="sendEmail" id="sendEmail" optionLabel="Email Address" value="true" isSelected="${sendEmail}" /></p>
        			</bbNG:dataElement>
        			
        			<c:choose> 
        				<c:when test="${actionType == 'register'}">
        					<bbNG:hiddenElement name="userAck" value="${displaySplash}" />
        					<bbNG:hiddenElement name="userAckMsgtext" value="${splashMessage}" />
        				</c:when>
        				<c:otherwise>	
        					<bbNG:dataElement label="Show user acknowledgement message" renderLegendAndFieldset="true">
        						<bbNG:radioElement name="userAck" id="userAckYes" optionLabel="Yes" value="true" isSelected="${displaySplash}" />
        						<bbNG:radioElement name="userAck" id="userAckNo" optionLabel="No" value="false" isSelected="${!displaySplash}" />
        					</bbNG:dataElement>
        			
        					<bbNG:dataElement label="Message Text" renderLegendAndFieldset="true">
        						<bbNG:textbox name="userAckMsg" ftext="${splashMessage}" />
        					</bbNG:dataElement>
        				</c:otherwise>
        			</c:choose>
        			
        		</bbNG:step>
        		
        		<bbNG:stepSubmit />
        	
        	</bbNG:dataCollection>
        </bbNG:form>        
</bbNG:genericPage>