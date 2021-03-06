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

/**
 * Accepts a url and adds the cookie generated by Servlet
 * containers in the form of a jsessionid to the url.
 */
export default function getURLWithSessionId(url) {
	if (!themeDisplay.isAddSessionIdToURL()) {
		return url;
	}

	// LEP-4787

	let separatorIndex = url.indexOf(';');

	if (separatorIndex > -1) {
		return url;
	}

	const sessionId = `;jsessionid=${themeDisplay.getSessionId()}`;

	separatorIndex = url.indexOf('?');

	if (separatorIndex > -1) {
		return `${url.substring(0, separatorIndex)}${sessionId}${url.substring(
			separatorIndex
		)}`;
	}

	// In IE6, http://www.abc.com;jsessionid=XYZ does not work, but
	// http://www.abc.com/;jsessionid=XYZ does work.

	separatorIndex = url.indexOf('//');

	if (separatorIndex > -1) {
		const lastSeparatorIndex = url.lastIndexOf('/');

		if (separatorIndex + 1 === lastSeparatorIndex) {
			return `${url}/${sessionId}`;
		}
	}

	return `${url}${sessionId}`;
}
