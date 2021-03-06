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

package com.liferay.sync.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.sync.model.SyncDevice;

/**
 * Provides the remote service utility for SyncDevice. This utility wraps
 * <code>com.liferay.sync.service.impl.SyncDeviceServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SyncDeviceService
 * @generated
 */
public class SyncDeviceServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sync.service.impl.SyncDeviceServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SyncDevice registerSyncDevice(
			String type, long buildNumber, int featureSet, String uuid)
		throws PortalException {

		return getService().registerSyncDevice(
			type, buildNumber, featureSet, uuid);
	}

	public static void unregisterSyncDevice(String uuid)
		throws PortalException {

		getService().unregisterSyncDevice(uuid);
	}

	public static SyncDeviceService getService() {
		return _service;
	}

	private static volatile SyncDeviceService _service;

}