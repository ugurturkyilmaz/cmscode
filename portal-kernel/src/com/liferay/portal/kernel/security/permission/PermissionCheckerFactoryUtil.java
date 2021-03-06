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

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Charles May
 * @author Brian Wing Shun Chan
 */
public class PermissionCheckerFactoryUtil {

	public static PermissionChecker create(User user) {
		return _permissionCheckerFactory.create(user);
	}

	public static PermissionCheckerFactory getPermissionCheckerFactory() {
		return _permissionCheckerFactory;
	}

	private PermissionCheckerFactoryUtil() {
	}

	private static volatile PermissionCheckerFactory _permissionCheckerFactory =
		ServiceProxyFactory.newServiceTrackedInstance(
			PermissionCheckerFactory.class, PermissionCheckerFactoryUtil.class,
			"_permissionCheckerFactory", false, true);

}