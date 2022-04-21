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

package com.liferay.portal.search.web.internal.search.bar.portlet.display.context.builder;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.search.web.internal.display.context.SearchScope;
import com.liferay.portal.search.web.internal.display.context.SearchScopePreference;
import com.liferay.portal.search.web.internal.search.bar.portlet.configuration.SearchBarPortletInstanceConfiguration;
import com.liferay.portal.search.web.internal.search.bar.portlet.display.context.SearchBarPortletDisplayContext;

import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author André de Oliveira
 */
public class SearchBarPortletDisplayContextBuilder {

	public SearchBarPortletDisplayContextBuilder(
		Http http, LayoutLocalService layoutLocalService, Portal portal,
		RenderRequest renderRequest) {

		_http = http;
		_layoutLocalService = layoutLocalService;
		_portal = portal;
		_renderRequest = renderRequest;
	}

	public SearchBarPortletDisplayContext build() throws PortletException {
		SearchBarPortletDisplayContext searchBarPortletDisplayContext =
			new SearchBarPortletDisplayContext();

		HttpServletRequest httpServletRequest = getHttpServletRequest(
			_renderRequest);

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		SearchBarPortletInstanceConfiguration
			searchBarPortletInstanceConfiguration =
				getSearchBarPortletInstanceConfiguration(
					themeDisplay.getPortletDisplay());

		searchBarPortletDisplayContext.setAvailableEverythingSearchScope(
			isAvailableEverythingSearchScope());
		searchBarPortletDisplayContext.setCurrentSiteSearchScopeParameterString(
			SearchScope.THIS_SITE.getParameterString());
		searchBarPortletDisplayContext.setDisplayStyleGroupId(
			getDisplayStyleGroupId(
				searchBarPortletInstanceConfiguration, themeDisplay));
		searchBarPortletDisplayContext.setEmptySearchEnabled(
			_emptySearchEnabled);
		searchBarPortletDisplayContext.setEverythingSearchScopeParameterString(
			SearchScope.EVERYTHING.getParameterString());
		searchBarPortletDisplayContext.setInputPlaceholder(
			LanguageUtil.get(httpServletRequest, "search-..."));
		searchBarPortletDisplayContext.setKeywords(getKeywords());
		searchBarPortletDisplayContext.setKeywordsParameterName(
			_keywordsParameterName);

		if (_searchScopePreference ==
				SearchScopePreference.LET_THE_USER_CHOOSE) {

			searchBarPortletDisplayContext.setLetTheUserChooseTheSearchScope(
				true);
		}

		searchBarPortletDisplayContext.setPaginationStartParameterName(
			getPaginationStartParameterName());
		searchBarPortletDisplayContext.setScopeParameterName(
			_scopeParameterName);
		searchBarPortletDisplayContext.setScopeParameterValue(
			getScopeParameterValue());
		searchBarPortletDisplayContext.setSearchBarPortletInstanceConfiguration(
			searchBarPortletInstanceConfiguration);

		_setSelectedSearchScope(searchBarPortletDisplayContext);

		if (Validator.isBlank(_destination)) {
			searchBarPortletDisplayContext.setSearchURL(_getURLCurrentPath());
		}
		else {
			String destinationURL = _getDestinationURL(_destination);

			if (destinationURL == null) {
				searchBarPortletDisplayContext.setDestinationUnreachable(true);
				searchBarPortletDisplayContext.setRenderNothing(true);
			}
			else {
				searchBarPortletDisplayContext.setSearchURL(destinationURL);
			}
		}

		if (_invisible) {
			searchBarPortletDisplayContext.setRenderNothing(true);
		}

		return searchBarPortletDisplayContext;
	}

	public SearchBarPortletDisplayContextBuilder setDestination(
		String destination) {

		_destination = destination;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setEmptySearchEnabled(
		boolean emptySearchEnabled) {

		_emptySearchEnabled = emptySearchEnabled;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setInvisible(
		boolean invisible) {

		_invisible = invisible;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setKeywords(
		Optional<String> keywordsOptional) {

		keywordsOptional.ifPresent(keywords -> _keywords = keywords);

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setKeywordsParameterName(
		String keywordsParameterName) {

		_keywordsParameterName = keywordsParameterName;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder
		setPaginationStartParameterName(String paginationStartParameterName) {

		_paginationStartParameterName = paginationStartParameterName;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setScopeParameterName(
		String scopeParameterName) {

		_scopeParameterName = scopeParameterName;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setScopeParameterValue(
		Optional<String> scopeParameterValueOptional) {

		scopeParameterValueOptional.ifPresent(
			scopeParameterValue -> _scopeParameterValue = scopeParameterValue);

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setSearchScopePreference(
		SearchScopePreference searchScopePreference) {

		_searchScopePreference = searchScopePreference;

		return this;
	}

	public SearchBarPortletDisplayContextBuilder setThemeDisplay(
		ThemeDisplay themeDisplay) {

		_themeDisplay = themeDisplay;

		return this;
	}

	protected Layout fetchLayoutByFriendlyURL(
		long groupId, String friendlyURL) {

		Layout layout = _layoutLocalService.fetchLayoutByFriendlyURL(
			groupId, false, friendlyURL);

		if (layout != null) {
			return layout;
		}

		return _layoutLocalService.fetchLayoutByFriendlyURL(
			groupId, true, friendlyURL);
	}

	protected long getDisplayStyleGroupId(
		SearchBarPortletInstanceConfiguration
			searchBarPortletInstanceConfiguration,
		ThemeDisplay themeDisplay) {

		long displayStyleGroupId =
			searchBarPortletInstanceConfiguration.displayStyleGroupId();

		if (displayStyleGroupId <= 0) {
			displayStyleGroupId = themeDisplay.getScopeGroupId();
		}

		return displayStyleGroupId;
	}

	protected HttpServletRequest getHttpServletRequest(
		RenderRequest renderRequest) {

		LiferayPortletRequest liferayPortletRequest =
			_portal.getLiferayPortletRequest(renderRequest);

		return liferayPortletRequest.getHttpServletRequest();
	}

	protected String getKeywords() {
		if (_keywords != null) {
			return _keywords;
		}

		return StringPool.BLANK;
	}

	protected String getLayoutFriendlyURL(Layout layout) {
		try {
			return _portal.getLayoutFriendlyURL(layout, _themeDisplay);
		}
		catch (PortalException portalException) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get friendly URL for layout " +
						layout.getLinkedToLayout(),
					portalException);
			}

			return null;
		}
	}

	protected String getPaginationStartParameterName() {
		if (_paginationStartParameterName != null) {
			return _paginationStartParameterName;
		}

		return StringPool.BLANK;
	}

	protected String getScopeParameterValue() {
		if (_scopeParameterValue != null) {
			return _scopeParameterValue;
		}

		return StringPool.BLANK;
	}

	protected SearchBarPortletInstanceConfiguration
		getSearchBarPortletInstanceConfiguration(
			PortletDisplay portletDisplay) {

		try {
			return portletDisplay.getPortletInstanceConfiguration(
				SearchBarPortletInstanceConfiguration.class);
		}
		catch (ConfigurationException configurationException) {
			throw new RuntimeException(configurationException);
		}
	}

	protected SearchScope getSearchScope() {
		if (_scopeParameterValue != null) {
			return SearchScope.getSearchScope(_scopeParameterValue);
		}

		SearchScope searchScope = _searchScopePreference.getSearchScope();

		if (searchScope != null) {
			return searchScope;
		}

		return SearchScope.THIS_SITE;
	}

	protected boolean isAvailableEverythingSearchScope() {
		return true;
	}

	private String _getDestinationURL(String friendlyURL) {
		Layout layout = fetchLayoutByFriendlyURL(
			_themeDisplay.getScopeGroupId(), _slashify(friendlyURL));

		if (layout == null) {
			return null;
		}

		return getLayoutFriendlyURL(layout);
	}

	private String _getURLCurrentPath() {
		return _http.getPath(_themeDisplay.getURLCurrent());
	}

	private void _setSelectedSearchScope(
		SearchBarPortletDisplayContext searchBarPortletDisplayContext) {

		SearchScope searchScope = getSearchScope();

		if (searchScope == SearchScope.EVERYTHING) {
			searchBarPortletDisplayContext.setSelectedEverythingSearchScope(
				true);
		}

		if (searchScope == SearchScope.THIS_SITE) {
			searchBarPortletDisplayContext.setSelectedCurrentSiteSearchScope(
				true);
		}
	}

	private String _slashify(String s) {
		if (s.charAt(0) == CharPool.SLASH) {
			return s;
		}

		return StringPool.SLASH.concat(s);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SearchBarPortletDisplayContextBuilder.class);

	private String _destination;
	private boolean _emptySearchEnabled;
	private final Http _http;
	private boolean _invisible;
	private String _keywords;
	private String _keywordsParameterName;
	private final LayoutLocalService _layoutLocalService;
	private String _paginationStartParameterName;
	private final Portal _portal;
	private final RenderRequest _renderRequest;
	private String _scopeParameterName;
	private String _scopeParameterValue;
	private SearchScopePreference _searchScopePreference;
	private ThemeDisplay _themeDisplay;

}