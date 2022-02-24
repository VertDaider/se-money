<%@ include file="./init.jsp" %>
<%@ include file="/META-INF/resources/jsp/init.jsp" %>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/META-INF/resources/jsp/view.jsp"/>
</portlet:renderURL>

<c:set var="tabNames" value="tab.operation,tab.account,tab.report"/>
<c:set var="tabValues" value="tabOperation,tabAccount,tabReport"/>

<div class="container-fluid">
	<clay:row>
		<clay:col md="2">
			<nav class="sidebar-sticky navbar-expand-md">
				<div class="collapse navbar-collapse">
					<liferay-ui:tabs names="${tabNames}" cssClass="navbar-nav mr-auto flex-column" type="underline"
									 param="tab" tabsValues="${tabValues}" url="${viewURL.toString()}">
					</liferay-ui:tabs>
				</div>
			</nav>
		</clay:col>
		<clay:col md="10">
			<c:choose>
				<c:when test="${'tabAccount' eq renderRequest.getParameter('tab')}">
					<jsp:include page="/META-INF/resources/jsp/account/view.jsp"/>
				</c:when>
				<c:when test="${'tabReport' eq renderRequest.getParameter('tab')}">
					<jsp:include page="/META-INF/resources/jsp/report/view.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="/META-INF/resources/jsp/operation/view.jsp"/>
				</c:otherwise>
			</c:choose>
		</clay:col>
	</clay:row>
</div>