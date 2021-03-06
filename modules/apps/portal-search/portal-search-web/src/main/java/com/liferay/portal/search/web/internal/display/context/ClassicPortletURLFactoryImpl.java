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

package com.liferay.portal.search.web.internal.display.context;

import com.liferay.portal.kernel.portlet.PortletURLUtil;

import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author André de Oliveira
 */
public class ClassicPortletURLFactoryImpl implements PortletURLFactory {

	public ClassicPortletURLFactoryImpl(
		PortletRequest portletRequest, MimeResponse mimeResponse) {

		_portletRequest = portletRequest;
		_mimeResponse = mimeResponse;
	}

	@Override
	public PortletURL getPortletURL() throws PortletException {
		PortletURL portletURL = PortletURLUtil.getCurrent(
			_portletRequest, _mimeResponse);

		return PortletURLUtil.clone(portletURL, _mimeResponse);
	}

	private final MimeResponse _mimeResponse;
	private final PortletRequest _portletRequest;

}