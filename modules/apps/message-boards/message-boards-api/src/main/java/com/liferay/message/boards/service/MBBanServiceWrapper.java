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

package com.liferay.message.boards.service;

import com.liferay.message.boards.model.MBBan;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MBBanService}.
 *
 * @author Brian Wing Shun Chan
 * @see MBBanService
 * @generated
 */
public class MBBanServiceWrapper
	implements MBBanService, ServiceWrapper<MBBanService> {

	public MBBanServiceWrapper() {
		this(null);
	}

	public MBBanServiceWrapper(MBBanService mbBanService) {
		_mbBanService = mbBanService;
	}

	@Override
	public MBBan addBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbBanService.addBan(banUserId, serviceContext);
	}

	@Override
	public void deleteBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_mbBanService.deleteBan(banUserId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mbBanService.getOSGiServiceIdentifier();
	}

	@Override
	public MBBanService getWrappedService() {
		return _mbBanService;
	}

	@Override
	public void setWrappedService(MBBanService mbBanService) {
		_mbBanService = mbBanService;
	}

	private MBBanService _mbBanService;

}