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

package com.liferay.users.admin.uad.anonymizer;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.service.UserTrackerLocalService;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;
import com.liferay.users.admin.uad.constants.UsersAdminUADConstants;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the user tracker UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link UserTrackerUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseUserTrackerUADAnonymizer
	extends DynamicQueryUADAnonymizer<UserTracker> {

	@Override
	public void autoAnonymize(
			UserTracker userTracker, long userId, User anonymousUser)
		throws PortalException {

		if (userTracker.getUserId() == userId) {
			delete(userTracker);

			autoAnonymizeAssetEntry(userTracker, anonymousUser);
		}
	}

	@Override
	public void delete(UserTracker userTracker) throws PortalException {
		userTrackerLocalService.deleteUserTracker(userTracker);
	}

	@Override
	public Class<UserTracker> getTypeClass() {
		return UserTracker.class;
	}

	protected void autoAnonymizeAssetEntry(
		UserTracker userTracker, User anonymousUser) {

		AssetEntry assetEntry = fetchAssetEntry(userTracker);

		if (assetEntry != null) {
			assetEntry.setUserId(anonymousUser.getUserId());
			assetEntry.setUserName(anonymousUser.getFullName());

			assetEntryLocalService.updateAssetEntry(assetEntry);
		}
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return userTrackerLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return UsersAdminUADConstants.USER_ID_FIELD_NAMES_USER_TRACKER;
	}

	protected AssetEntry fetchAssetEntry(UserTracker userTracker) {
		return assetEntryLocalService.fetchEntry(
			UserTracker.class.getName(), userTracker.getUserTrackerId());
	}

	@Reference
	protected AssetEntryLocalService assetEntryLocalService;

	@Reference
	protected UserTrackerLocalService userTrackerLocalService;

}