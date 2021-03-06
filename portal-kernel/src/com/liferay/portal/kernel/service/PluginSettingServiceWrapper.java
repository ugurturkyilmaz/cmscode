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

package com.liferay.portal.kernel.service;

/**
 * Provides a wrapper for {@link PluginSettingService}.
 *
 * @author Brian Wing Shun Chan
 * @see PluginSettingService
 * @generated
 */
public class PluginSettingServiceWrapper
	implements PluginSettingService, ServiceWrapper<PluginSettingService> {

	public PluginSettingServiceWrapper() {
		this(null);
	}

	public PluginSettingServiceWrapper(
		PluginSettingService pluginSettingService) {

		_pluginSettingService = pluginSettingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _pluginSettingService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PluginSetting updatePluginSetting(
			long companyId, java.lang.String pluginId,
			java.lang.String pluginType, java.lang.String roles, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pluginSettingService.updatePluginSetting(
			companyId, pluginId, pluginType, roles, active);
	}

	@Override
	public PluginSettingService getWrappedService() {
		return _pluginSettingService;
	}

	@Override
	public void setWrappedService(PluginSettingService pluginSettingService) {
		_pluginSettingService = pluginSettingService;
	}

	private PluginSettingService _pluginSettingService;

}