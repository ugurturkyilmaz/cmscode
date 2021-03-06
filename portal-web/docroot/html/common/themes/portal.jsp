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

<%@ include file="/html/common/themes/init.jsp" %>

<%
StringBundler sb = (StringBundler)request.getAttribute(WebKeys.LAYOUT_CONTENT);

if ((sb != null) && themeDisplay.isStateExclusive()) {
	sb.writeTo(out);
}
else {
	Definition definition = (Definition)request.getAttribute(TilesUtil.DEFINITION);

	boolean tilesPopUp = false;

	if (definition != null) {
		Map<String, String> attributes = definition.getAttributes();

		tilesPopUp = GetterUtil.getBoolean(attributes.get("pop_up"));
	}
%>

	<c:choose>
		<c:when test="<%= tilesPopUp || themeDisplay.isStatePopUp() || themeDisplay.isWidget() %>">
			<liferay-theme:include
				page="portal_pop_up.jsp"
			/>
		</c:when>
		<c:otherwise>
			<liferay-theme:include
				page="portal_normal.jsp"
			/>
		</c:otherwise>
	</c:choose>

<%
}

request.removeAttribute(WebKeys.LAYOUT_CONTENT);

PortalMessages.clear(request);
SessionMessages.clear(request);
SessionErrors.clear(request);
%>