<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="bbdn.lti2.beans.Lti2ProviderDomain,bbdn.lti2.dao.Lti2ProviderDomainDAO,java.util.List,blackboard.platform.plugin.PlugInUtil,blackboard.persist.Id,blackboard.util.UrlUtil"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

blackboard.platform.context.Context ctx = (blackboard.platform.context.Context) pageContext.getAttribute("ctx");
	
	<bbNG:jsBlock>
		<script type="text/javascript">
			var register =
			{
				onEdit : function ()
				{
					var form = $( 'domainManager');
					form.action = 'editDomain';
					form.actionType.value = 'edit';
					form.submit();
				},
			    onApprove : function()
			    {
			      var form = $( 'domainManager' );
			      form.action = 'approveDomain';
			      form.actionType.value = 'approve';
			      form.submit();
			    },
			    onExclude : function()
			    {
			      var form = $( 'domainManager' );
			      form.action = 'excludeDomain';
			      form.actionType.value = 'exclude';
			      form.submit();
			    },
			    onDelete : function()
			    {
			      var form = $( 'domainManager' );
			      form.action = 'deleteDomain';
			      var ids = form.getInputs( 'checkbox', 'toolIds' ).filter( function( box )
			      {
			        return box.checked;
			      } ).map( function( box )
			      {
			        return box.value;
			      } );
			
			      var confirmMsg = 'Are you sure you want to delete this domain?'
			      if ( confirm( confirmMsg ) )
			      {
			        form.actionType.value = 'delete';
			        form.submit();
			      }
			    }
			};
		</script>
	</bbNG:jsBlock>
	<bbNG:pageHeader
		instructions="This report is available to show all LTI 2.0 provider domains in use in the system, 
        	including the status. Domains can be approved, excluded, and deleted. Use the Register Provider Domain 
        	option to create additional LTI 2.0 Tool Providers.">

		<bbNG:breadcrumbBar environment="SYS_ADMIN" />

		<bbNG:pageTitleBar>
                    LTI 2.0 Tool Providers
            </bbNG:pageTitleBar>

		<bbNG:actionControlBar>
			<bbNG:actionButton url="properties"
				title="Manage Global Properties" primary="true" />
			<bbNG:actionButton url="register"
				title="Register Provider Domain" primary="true" />
			<bbNG:actionButton url="${sampleRegisterPath}"
				title="Sample LTI 2.0" primary="false" />
		</bbNG:actionControlBar>
	</bbNG:pageHeader>
	
	<bbNG:form id="domainManager" action="register" isSecure="${ true }" nonceId="/registerDomain">
	<bbNG:hiddenElement name="actionType" value="register"/> 
		n provider = Lti2ProviderDomainn) pageContext.getAttribute("provider");	      
			
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
