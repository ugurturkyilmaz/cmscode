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

package com.liferay.users.admin.uad.exporter;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.service.UserTrackerLocalService;
import com.liferay.user.associated.data.exporter.DynamicQueryUADExporter;
import com.liferay.users.admin.uad.constants.UsersAdminUADConstants;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the user tracker UAD exporter.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link UserTrackerUADExporter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseUserTrackerUADExporter
	extends DynamicQueryUADExporter<UserTracker> {

	@Override
	public Class<UserTracker> getTypeClass() {
		return UserTracker.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return userTrackerLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return UsersAdminUADConstants.USER_ID_FIELD_NAMES_USER_TRACKER;
	}

	@Override
	protected String toXmlString(UserTracker userTracker) {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.kernel.model.UserTracker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userTrackerId</column-name><column-value><![CDATA[");
		sb.append(userTracker.getUserTrackerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(userTracker.getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	@Reference
	protected UserTrackerLocalService userTrackerLocalService;

}