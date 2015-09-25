<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.HashMap,
				 javax.servlet.http.HttpServletRequest, 
				 blackboard.servlet.tags.ngui.datacollection.DataElementTag,
				 blackboard.base.FormattedText,
				 blackboard.platform.plugin.PlugInUtil,bbdn.lti2.util.BBDNConstants,bbdn.lti2.beans.Lti2Properties,
				 bbdn.lti2.dao.Lti2PropertiesDAO" 
%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:genericPage
        title="LTI 2.0 Test Result"
        ctxId="ctx"
        entitlement='system.admin.VIEW'
        navItem="bbdn-lti2-app-nav-1">

        <bbNG:pageHeader 
        	instructions="This page shows your test result.">
        	
        	<bbNG:breadcrumbBar environment="SYS_ADMIN" />
            
            <bbNG:pageTitleBar>
                    LTI 2.0 Test Results
            </bbNG:pageTitleBar>
            
        </bbNG:pageHeader>
                Result: ${result}
</bbNG:genericPage>