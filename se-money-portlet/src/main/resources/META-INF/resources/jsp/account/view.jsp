<%@ page import="ru.serioussem.se.money.service.AccountLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<portlet:renderURL var="createAccountURL">
    <portlet:param name="jspPage" value="/META-INF/resources/jsp/account/create.jsp"/>
</portlet:renderURL>

<aui:fieldset>
    <aui:form name="createAccount" action="${createAccountURL}">
        <aui:button-row>
            <aui:button name="create" value="account.create" type="submit"/>
        </aui:button-row>
    </aui:form>

    <aui:fieldset-group markupView="lexicon">
        <liferay-ui:search-container
                emptyResultsMessage="empty.results.message"
                total="<%= AccountLocalServiceUtil.getAccountsCount()%>"
                cssClass="table table-autofit table-hover table-list"
                id="account">
            <liferay-ui:search-container-results
                    results="<%= AccountLocalServiceUtil.getAccounts(0, AccountLocalServiceUtil.getAccountsCount()) %>"/>
            <liferay-ui:search-container-row className="ru.serioussem.se.money.model.Account" rowVar="row"
                                             modelVar="entity" cssClass="text-center">
                <liferay-ui:search-container-column-text name="Номер" value="${row.rowId}"/>
<%--                <liferay-ui:search-container-column-image src="" />--%>
                <liferay-ui:search-container-column-text name="account.name" value="${entity.name}" orderable="true" orderableProperty="Name"/>
                <liferay-ui:search-container-column-text name="account.balance" value="${entity.balance}"/>
                <liferay-ui:search-container-column-text name="action.menu">
                    <liferay-ui:icon-menu direction="right-side" icon="bars" markupView="lexicon" showWhenSingleIcon="true">
                        <portlet:renderURL var="editAccountURL">
                            <portlet:param name="accountId" value="${entity.id}"/>
                            <portlet:param name="jspPage" value="/META-INF/resources/jsp/account/create.jsp"/>
                        </portlet:renderURL>
                        <liferay-ui:icon image="edit" message="common.edit" url="${editAccountURL}"/>
                    </liferay-ui:icon-menu>
                </liferay-ui:search-container-column-text>
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator markupView="lexicon"/>
        </liferay-ui:search-container>
    </aui:fieldset-group>
</aui:fieldset>

<style>
    .aui .table thead td, .table thead th {
        text-align: center;
        vertical-align: middle;
    }
</style>