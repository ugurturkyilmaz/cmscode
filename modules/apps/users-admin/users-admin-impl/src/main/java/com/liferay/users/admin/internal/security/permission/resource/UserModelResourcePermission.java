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

package com.liferay.users.admin.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.permission.UserPermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.User",
	service = ModelResourcePermission.class
)
public class UserModelResourcePermission
	implements ModelResourcePermission<User> {

	@Override
	public void check(
			PermissionChecker permissionChecker, long organizationId,
			String actionId)
		throws PortalException {

		userPermission.check(permissionChecker, organizationId, actionId);
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, User user, String actionId)
		throws PortalException {

		userPermission.check(
			permissionChecker, user.getUserId(), user.getOrganizationIds(),
			actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long organizationId,
			String actionId)
		throws PortalException {

		return userPermission.contains(
			permissionChecker, organizationId, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, User user, String actionId)
		throws PortalException {

		return userPermission.contains(
			permissionChecker, user.getUserId(), user.getOrganizationIds(),
			actionId);
	}

	@Override
	public String getModelName() {
		return User.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return null;
	}

	@Reference
	protected UserPermission userPermission;

}