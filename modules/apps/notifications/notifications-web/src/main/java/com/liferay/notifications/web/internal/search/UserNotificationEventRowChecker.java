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

package com.liferay.notifications.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

import javax.portlet.PortletResponse;

/**
 * @author István András Dézsi
 */
public class UserNotificationEventRowChecker extends EmptyOnClickRowChecker {

	public UserNotificationEventRowChecker(PortletResponse portletResponse) {
		super(portletResponse);
	}

	@Override
	public boolean isDisabled(Object object) {
		UserNotificationEvent userNotificationEvent =
			(UserNotificationEvent)object;

		if (userNotificationEvent.isActionRequired()) {
			return true;
		}

		userNotificationEvent =
			UserNotificationEventLocalServiceUtil.fetchUserNotificationEvent(
				userNotificationEvent.getUserNotificationEventId());

		if (userNotificationEvent == null) {
			return true;
		}

		return super.isDisabled(object);
	}

}