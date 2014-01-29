<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="bbdn.lti2.dao.Lti2ProviderDomain,
				 bbdn.lti2.dao.Lti2ProviderDomainDAO,
				 java.util.List"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:genericPage title="LTI 2.0 Tool Providers" ctxId="ctx"
	entitlement="system.admin.VIEW" navItem="bbdn-lti2-app-nav-1">

	<%
        	Lti2ProviderDomainDAO toolDao = new Lti2ProviderDomainDAO();
        	List<Lti2ProviderDomain> providers = toolDao.loadAll();
		%>

	<bbNG:pageHeader
		instructions="This report is available to show all LTI 2.0 provider domains in use in the system, 
        	including the status. Domains can be approved, excluded, and deleted. Use the Register Provider Domain 
        	option to create additional LTI 2.0 Tool Providers.">

		<bbNG:breadcrumbBar environment="SYS_ADMIN" navItem="bbdn-lti2-app-nav-1">
			<bbNG:breadcrumb>LTI 2.0 Tool Providers</bbNG:breadcrumb>
		</bbNG:breadcrumbBar>

		<bbNG:pageTitleBar>
                    LTI 2.0 Tool Providers
            </bbNG:pageTitleBar>

		<bbNG:actionControlBar>
			<bbNG:actionButton url="settings.jsp"
				title="Manage Global Properties" primary="false" />
			<bbNG:actionButton url="register.jsp"
				title="Register Provider Domain" primary="true" />
		</bbNG:actionControlBar>
	</bbNG:pageHeader>
	
	<% /* Removed this code for testing:
		<bbNG:inventoryList className="bbdn.lti2.dao.Lti2ProviderDomain"
                        collection="${providers}" objectVar="provider"
                        description="LTI 2.0 Tool Providers" initialSortCol="domain"
                        url="" emptyMsg="No LTI 2.0 Tools registered at this time.">

      		<bbNG:listOptions allowRefresh="true" refreshUrl="/webapps/blackboard/execute/blti/manageToolProviders"/>
      		
      		<bbNG:beanComparator property="primaryDomainName"/>
      		
      		<bbNG:beanComparator property="status"/>
      		
      		<bbNG:beanComparator property="sendUserData"/>
      		
      		<bbNG:beanComparator property="useSplash"/>
      		
      		orderKey="webapps.blackboard.blti.provider_list.menu"
      		*/
    %>

	<bbNG:inventoryList collection="<%=providers%>" objectVar="provider"
		className="bbdn.lti2.dao.Lti2ProviderDomain">

		<bbNG:listActionBar>
			<bbNG:listActionItem url="register.jsp" title="Approve"
				contextMenuItemId="approveItem" />
			<bbNG:listActionItem url="register.jsp" title="Exclude"
				contextMenuItemId="excludeItem" />
			<bbNG:listActionItem url="register.jsp" title="Delete"
				contextMenuItemId="deleteItem" />
		</bbNG:listActionBar>

		<bbNG:listCheckboxElement name="configIds"
			value="<%=Integer.toString(provider.getTool_id())%>" />

		<bbNG:listElement name="domain" label="Domain" isRowHeader="true">
			
			<a href="http://<%=provider.getTool_domain()%>" target="_blank"><%=provider.getTool_domain()%></a>

			<bbNG:listContextMenu menuLinkTitle="Edit">
				<bbNG:contextMenuItem url="register.jsp" title="Edit" id="editItem" />
			</bbNG:listContextMenu>
		</bbNG:listElement>

		<bbNG:listElement name="status" label="Status">
			
			<%=provider.getTool_status_ind()%>
		</bbNG:listElement>

		<bbNG:listElement name="sendUserData" label="Sends User Data">
			
			<%=provider.getTool_senddata()%>
		</bbNG:listElement>

		<bbNG:listElement name="splashMessage"
			label="User Acknowledgement Page">
			
			<%=provider.getTool_userack_ind()%>
		</bbNG:listElement>

	</bbNG:inventoryList>

</bbNG:genericPage>
