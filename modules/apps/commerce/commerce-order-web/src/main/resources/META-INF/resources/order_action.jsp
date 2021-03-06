<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

CommerceOrder commerceOrder = (CommerceOrder)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:choose>
		<c:when test="<%= CommerceOrderPermission.contains(permissionChecker, commerceOrder, ActionKeys.UPDATE) %>">
			<portlet:renderURL var="editURL">
				<portlet:param name="mvcRenderCommandName" value="/commerce_order/edit_commerce_order" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="commerceOrderId" value="<%= String.valueOf(commerceOrder.getCommerceOrderId()) %>" />
			</portlet:renderURL>

			<liferay-ui:icon
				message="edit"
				url="<%= editURL %>"
			/>
		</c:when>
		<c:otherwise>
			<portlet:renderURL var="viewCommerceOrderDetailURL">
				<portlet:param name="mvcRenderCommandName" value="/commerce_order_content/view_commerce_order_details" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="commerceOrderId" value="<%= String.valueOf(commerceOrder.getCommerceOrderId()) %>" />
			</portlet:renderURL>

			<liferay-ui:icon
				message="view"
				url="<%= viewCommerceOrderDetailURL %>"
			/>
		</c:otherwise>
	</c:choose>

	<c:if test="<%= CommerceOrderPermission.contains(permissionChecker, commerceOrder, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/commerce_order/edit_commerce_order" var="deleteURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="commerceOrderId" value="<%= String.valueOf(commerceOrder.getCommerceOrderId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>