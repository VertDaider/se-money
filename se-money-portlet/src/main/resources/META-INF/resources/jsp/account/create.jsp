<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<h2>Добавить новый кошелек</h2>
<portlet:actionURL name="createAccount" var="addAccountURL">
    <portlet:param name="tab" value="tabAccount"/>
    <portlet:param name="mvcPath" value="/META-INF/resources/jsp/view.jsp"/>
</portlet:actionURL>
<portlet:renderURL var="backURL">
    <portlet:param name="tab" value="tabAccount"/>
    <portlet:param name="mvcPath" value="/META-INF/resources/jsp/view.jsp"/>
</portlet:renderURL>
<aui:form method="post" name="addAccount" action="${addAccountURL}">
    <clay:row>
        <clay:col md="3">
            <aui:input name="name" type="text" label="account.name">
                <aui:validator name="required" />
            </aui:input>
        </clay:col>
        <clay:col md="3">
            <aui:input name="balance" label="account.balance">
                <aui:validator name="number" />
            </aui:input>
        </clay:col>
        <clay:col md="3">
            <aui:input name="total" type="toggle-switch" label="account.total.label" checked="true"/>
        </clay:col>
    </clay:row>
    <aui:button-row>
        <aui:button type="submit" value="account.create"/>
        <aui:button href="${backURL}" value="common.back"/>
    </aui:button-row>
</aui:form>