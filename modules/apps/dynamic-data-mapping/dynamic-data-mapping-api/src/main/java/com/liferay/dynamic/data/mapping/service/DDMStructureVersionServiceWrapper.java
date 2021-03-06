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

package com.liferay.dynamic.data.mapping.service;

import com.liferay.dynamic.data.mapping.model.DDMStructureVersion;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DDMStructureVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see DDMStructureVersionService
 * @generated
 */
public class DDMStructureVersionServiceWrapper
	implements DDMStructureVersionService,
			   ServiceWrapper<DDMStructureVersionService> {

	public DDMStructureVersionServiceWrapper() {
		this(null);
	}

	public DDMStructureVersionServiceWrapper(
		DDMStructureVersionService ddmStructureVersionService) {

		_ddmStructureVersionService = ddmStructureVersionService;
	}

	@Override
	public DDMStructureVersion getLatestStructureVersion(long structureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmStructureVersionService.getLatestStructureVersion(
			structureId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ddmStructureVersionService.getOSGiServiceIdentifier();
	}

	@Override
	public DDMStructureVersion getStructureVersion(long structureVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmStructureVersionService.getStructureVersion(
			structureVersionId);
	}

	@Override
	public java.util.List<DDMStructureVersion> getStructureVersions(
			long structureId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DDMStructureVersion> orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmStructureVersionService.getStructureVersions(
			structureId, start, end, orderByComparator);
	}

	@Override
	public int getStructureVersionsCount(long structureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmStructureVersionService.getStructureVersionsCount(
			structureId);
	}

	@Override
	public DDMStructureVersionService getWrappedService() {
		return _ddmStructureVersionService;
	}

	@Override
	public void setWrappedService(
		DDMStructureVersionService ddmStructureVersionService) {

		_ddmStructureVersionService = ddmStructureVersionService;
	}

	private DDMStructureVersionService _ddmStructureVersionService;

}