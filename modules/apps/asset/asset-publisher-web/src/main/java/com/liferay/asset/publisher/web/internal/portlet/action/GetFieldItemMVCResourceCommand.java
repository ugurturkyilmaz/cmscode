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

package com.liferay.asset.publisher.web.internal.portlet.action;

import com.liferay.asset.publisher.constants.AssetPublisherPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = {
		"javax.portlet.name=" + AssetPublisherPortletKeys.ASSET_PUBLISHER,
		"javax.portlet.name=" + AssetPublisherPortletKeys.HIGHEST_RATED_ASSETS,
		"javax.portlet.name=" + AssetPublisherPortletKeys.MOST_VIEWED_ASSETS,
		"javax.portlet.name=" + AssetPublisherPortletKeys.RECENT_CONTENT,
		"javax.portlet.name=" + AssetPublisherPortletKeys.RELATED_ASSETS,
		"mvc.command.name=/asset_publisher/get_field_item"
	},
	service = MVCResourceCommand.class
)
public class GetFieldItemMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		include(
			resourceRequest, resourceResponse,
			"/select_structure_field_item.jsp");
	}

}