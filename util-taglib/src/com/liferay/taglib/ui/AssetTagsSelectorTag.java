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

package com.liferay.taglib.ui;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 * @deprecated As of Athanasius (7.3.x), replaced by {@link
 *             com.liferay.asset.taglib.servlet.taglib.AssetTagsSelectorTag}
 */
@Deprecated
public class AssetTagsSelectorTag extends IncludeTag {

	public String getAddCallback() {
		return _addCallback;
	}

	public String getClassName() {
		return _className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public String getCurTags() {
		return _curTags;
	}

	public long[] getGroupIds() {
		return _groupIds;
	}

	public String getHiddenInput() {
		return _hiddenInput;
	}

	public String getId() {
		return _id;
	}

	public String getRemoveCallback() {
		return _removeCallback;
	}

	public boolean isAllowAddEntry() {
		return _allowAddEntry;
	}

	public boolean isAutoFocus() {
		return _autoFocus;
	}

	public boolean isIgnoreRequestValue() {
		return _ignoreRequestValue;
	}

	public void setAddCallback(String addCallback) {
		_addCallback = addCallback;
	}

	public void setAllowAddEntry(boolean allowAddEntry) {
		_allowAddEntry = allowAddEntry;
	}

	public void setAutoFocus(boolean autoFocus) {
		_autoFocus = autoFocus;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setCurTags(String curTags) {
		_curTags = curTags;
	}

	public void setGroupIds(long[] groupIds) {
		_groupIds = groupIds;
	}

	public void setHiddenInput(String hiddenInput) {
		_hiddenInput = hiddenInput;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setIgnoreRequestValue(boolean ignoreRequestValue) {
		_ignoreRequestValue = ignoreRequestValue;
	}

	public void setRemoveCallback(String removeCallback) {
		_removeCallback = removeCallback;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_addCallback = null;
		_allowAddEntry = true;
		_autoFocus = false;
		_className = null;
		_classPK = 0;
		_curTags = null;
		_groupIds = null;
		_hiddenInput = "assetTagNames";
		_id = null;
		_ignoreRequestValue = false;
		_removeCallback = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		String id = _id;

		if (Validator.isNull(id)) {
			String randomKey = PortalUtil.generateRandomKey(
				httpServletRequest, "taglib_ui_asset_tags_selector_page");

			id = randomKey + StringPool.UNDERLINE;
		}

		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:addCallback",
			String.valueOf(_addCallback));
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:allowAddEntry",
			String.valueOf(_allowAddEntry));
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:autoFocus",
			String.valueOf(_autoFocus));
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:className", _className);
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:classPK", String.valueOf(_classPK));
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:curTags", _curTags);
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:removeCallback",
			String.valueOf(_removeCallback));

		if (_groupIds == null) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			long[] groupIds = null;

			Group group = themeDisplay.getScopeGroup();

			if (group.isLayout()) {
				groupIds = new long[] {group.getParentGroupId()};
			}
			else {
				groupIds = new long[] {group.getGroupId()};
			}

			if (group.getParentGroupId() != themeDisplay.getCompanyGroupId()) {
				groupIds = ArrayUtil.append(
					groupIds, themeDisplay.getCompanyGroupId());
			}

			_groupIds = groupIds;
		}

		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:groupIds", _groupIds);

		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:hiddenInput", _hiddenInput);
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:id", id);
		httpServletRequest.setAttribute(
			"liferay-ui:asset-tags-selector:ignoreRequestValue",
			_ignoreRequestValue);
	}

	private static final String _PAGE =
		"/html/taglib/ui/asset_tags_selector/page.jsp";

	private String _addCallback;
	private boolean _allowAddEntry = true;
	private boolean _autoFocus;
	private String _className;
	private long _classPK;
	private String _curTags;
	private long[] _groupIds;
	private String _hiddenInput = "assetTagNames";
	private String _id;
	private boolean _ignoreRequestValue;
	private String _removeCallback;

}