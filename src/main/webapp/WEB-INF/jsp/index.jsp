<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="bbdn.lti2.dao.Lti2ProviderDomain,
				 bbdn.lti2.dao.Lti2ProviderDomainDAO,
				 java.util.List,
				 blackboard.platform.plugin.PlugInUtil,
				 blackboard.persist.Id,
				 blackboard.util.UrlUtil"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:genericPage title="LTI 2.0 Tool Providers" ctxId="ctx"
	entitlement="system.admin.VIEW" navItem="bbdn-lti2-app-nav-1">
	
	<bbNG:jsFile href="${jsFilePath}"/>

	<bbNG:pageHeader
		instructions="This report is available to show all LTI 2.0 provider domains in use in the system, 
        	including the status. Domains can be approved, excluded, and deleted. Use the Register Provider Domain 
        	option to create additional LTI 2.0 Tool Providers.">

		<bbNG:breadcrumbBar environment="SYS_ADMIN" />

		<bbNG:pageTitleBar>
                    LTI 2.0 Tool Providers
            </bbNG:pageTitleBar>

		<bbNG:actionControlBar>
			<bbNG:actionButton url="settings"
				title="Manage Global Properties" primary="true" />
			<bbNG:actionButton url="registerDomain"
				title="Register Provider Domain" primary="true" />
			<bbNG:actionButton url="${sampleRegisterPath}"
				title="Sample LTI 2.0" primary="false" />
		</bbNG:actionControlBar>
	</bbNG:pageHeader>
	
	<bbNG:form id="domainManager" action="registerDomain">
	<bbNG:hiddenElement name="actionType" value="register"/> 
		<bbNG:inventoryList className="bbdn.lti2.dao.Lti2ProviderDomain"
	                        collection="${providers}" objectVar="provider"
	                        description="LTI 2.0 Tool Providers" initialSortCol="domain"
	                        url="" emptyMsg="No LTI 2.0 Tools registered at this time.">	      
			
			<bbNG:listActionBar>
				<bbNG:listActionItem url="javascript:register.onApprove();" title="Approve"
					contextMenuItemId="approveItem" />
				<bbNG:listActionItem url="javascript:register.onExclude();" title="Exclude"
					contextMenuItemId="excludeItem" />
				<bbNG:listActionItem url="javascript:register.onDelete();" title="Delete"
					contextMenuItemId="deleteItem" />
			</bbNG:listActionBar>
	
			<bbNG:listCheckboxElement name="toolIds"
				value="<%=Integer.toString(provider.getToolId())%>" />
	
			<bbNG:listElement name="domain" label="Domain" isRowHeader="true">
				
				<a href="http://<%=provider.getDomain()%>" target="_blank"><%=provider.getDomain()%></a>
	
				<bbNG:listContextMenu menuLinkTitle="Edit">
					<bbNG:contextMenuItem title="Edit" id="editItem" url="javascript:register.onEdit();"/>
				</bbNG:listContextMenu>
			</bbNG:listElement>
	
			<bbNG:listElement name="status" label="Status">
				
				<%=Boolean.toString(provider.isDomainEnabled())%>
			</bbNG:listElement>
	
			<bbNG:listElement name="sendUserData" label="Sends User Data">
				
				<%=provider.getSendDataConfig()%>
			</bbNG:listElement>
	
			<bbNG:listElement name="splashMessage"
				label="User Acknowledgement Page">
				
				<%=Boolean.toString(provider.isSplashScreenEnabled())%>
			</bbNG:listElement>
	
		</bbNG:inventoryList>
	</bbNG:form>
</bbNG:genericPage>
