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

package com.liferay.portal.settings.web.internal.portal.settings.configuration.admin.display;

import com.liferay.portal.settings.configuration.admin.display.PortalSettingsConfigurationScreenContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Balázs Mátyássy
 */
@Component(service = PortalSettingsConfigurationScreenContributor.class)
public class
	PasswordReminderQueriesEditCompanyPortalSettingsConfigurationScreenContributor
		extends BaseEditCompanyPortalSettingsConfigurationScreenContributor {

	@Override
	public String getCategoryKey() {
		return "user-authentication";
	}

	@Override
	public String getJspPath() {
		return "/authentication/reminder_queries.jsp";
	}

	@Override
	public String getKey() {
		return "reminder-queries";
	}

}