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

package com.liferay.blogs.editor.configuration.internal;

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	property = {
		"editor.config.key=coverImageCaptionEditor", "editor.name=alloyeditor",
		"javax.portlet.name=" + BlogsPortletKeys.BLOGS,
		"javax.portlet.name=" + BlogsPortletKeys.BLOGS_ADMIN
	},
	service = EditorConfigContributor.class
)
public class BlogsCoverImageCaptionAlloyEditorConfigContributor
	extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		jsonObject.put(
			"extraPlugins", "ae_placeholder,ae_selectionregion,ae_uicore"
		).put(
			"toolbars", _getToolbarsJSONObject()
		);
	}

	private JSONObject _getToolbarsJSONObject() {
		return JSONUtil.put("styles", _getToolbarsStylesJSONObject());
	}

	private JSONObject _getToolbarsStylesJSONObject() {
		return JSONUtil.put(
			"selections", _getToolbarStylesSelectionsJSONArray()
		).put(
			"tabIndex", 1
		);
	}

	private JSONArray _getToolbarStylesSelectionsJSONArray() {
		return JSONUtil.putAll(
			_getToolbarStylesSelectionsLinkJSONObject(),
			_getToolbarStylesSelectionsTextJSONObject());
	}

	private JSONObject _getToolbarStylesSelectionsLinkJSONObject() {
		return JSONUtil.put(
			"buttons", toJSONArray("['linkEdit']")
		).put(
			"name", "link"
		).put(
			"test", "AlloyEditor.SelectionTest.link"
		);
	}

	private JSONObject _getToolbarStylesSelectionsTextJSONObject() {
		return JSONUtil.put(
			"buttons", toJSONArray("['link']")
		).put(
			"name", "text"
		).put(
			"test", "AlloyEditor.SelectionTest.text"
		);
	}

}