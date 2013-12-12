<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:genericPage
        title="LTI 2.0 Tool Providers"
        ctxId="ctx"
        entitlement='system.admin.VIEW'>

        <bbNG:pageHeader 
        	instructions="This report is available to show all LTI 2.0 provider domains in use in the system, including the status. Domains can be approved, excluded, and deleted. Use the Register Provider Domain option to create additional LTI 2.0 Tool Providers.">
        	
        	<bbNG:breadcrumbBar environment="SYS_ADMIN">
        		<bbNG:breadcrumb>LTI 2.0 Tool Providers</bbNG:breadcrumb>
        	</bbNG:breadcrumbBar>
            <bbNG:pageTitleBar>
                    LTI 2.0 Tool Providers
            </bbNG:pageTitleBar>
            
        	<bbNG:actionControlBar>
        		<bbNG:actionButton url="settings.jsp" title="Manage Global Properties" primary="true"/>
        		<bbNG:actionButton url="register.jsp" title="Register Provider Domain" primary="true"/>
        	</bbNG:actionControlBar>
        </bbNG:pageHeader>

        <bbNG:inventoryList className="bbdn.lti2.dao.Lti2ProviderDomain "
                        collection="${providers}" objectVar="provider"
                        description="LTI 2.0 Tool Providers" initialSortCol="domain"
                        url="/webapps/blackboard/execute/blti/manageToolProviders">
      
      <bbNG:listOptions allowRefresh="true" refreshUrl="/webapps/blackboard/execute/blti/manageToolProviders"/>
      
      <bbNG:listActionBar>
        <bbNG:listActionItem url="javascript:manage_tool_providers.onApprove();" title="${approveStr}" contextMenuItemId="approveItem"/>
        <bbNG:listActionItem url="javascript:manage_tool_providers.onExclude();" title="${excludeStr}" contextMenuItemId="excludeItem"/>
        <bbNG:listActionItem url="javascript:manage_tool_providers.onDelete();" title="${deleteStr}" contextMenuItemId="deleteItem"/>
      </bbNG:listActionBar>
      
      <bbNG:listCheckboxElement name="configIds" value="provider.getBbdn_tool_id() "/>
      
      <bbNG:listElement name="domain" label="Domain" isRowHeader="true">
       	<bbNG:beanComparator property="primaryDomainName"/>
        <a href="http://${bbNG:HtmlEscape( provider.primaryDomainName ) }" target="_blank">${provider.primaryDomainName}</a>
        
        <bbNG:listContextMenu orderKey="webapps.blackboard.blti.provider_list.menu" menuLinkTitle="${menuLinkTitleStr}">
          <bbNG:contextMenuItem url="${provider.editUrl}" title="Edit" id="editItem"/>
        </bbNG:listContextMenu>
      </bbNG:listElement>
      
      <bbNG:listElement name="status" label="Status">
        <bbNG:beanComparator property="status"/>
        ${provider.status}
      </bbNG:listElement>
      
      <bbNG:listElement name="credentials" label="Credentials">
        <bbNG:beanComparator property="credentials"/>
        ${provider.credentials}
      </bbNG:listElement>      
      
      <bbNG:listElement name="sendUserData" label="Sends User Data">
        <bbNG:beanComparator property="sendUserData"/>
        ${provider.sendUserData}
      </bbNG:listElement>
      
      <bbNG:listElement name="splashMessage" label="User Acknowledgement Page">
        <bbNG:beanComparator property="useSplash"/>
        ${provider.useSplash}
      </bbNG:listElement>
    
    </bbNG:inventoryList>
        
</bbNG:genericPage>