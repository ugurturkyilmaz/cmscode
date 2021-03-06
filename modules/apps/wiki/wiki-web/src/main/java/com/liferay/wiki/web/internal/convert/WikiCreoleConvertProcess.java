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

package com.liferay.wiki.web.internal.convert;

import com.liferay.portal.convert.BaseConvertProcess;
import com.liferay.portal.convert.ConvertProcess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.MaintenanceUtil;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalService;
import com.liferay.wiki.web.internal.translator.ClassicToCreoleTranslator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 */
@Component(service = ConvertProcess.class)
public class WikiCreoleConvertProcess extends BaseConvertProcess {

	@Override
	public String getDescription() {
		return "convert-wiki-pages-from-classic-wiki-to-creole-format";
	}

	@Override
	public boolean isEnabled() {
		try {
			int pagesCount = _wikiPageLocalService.getPagesCount(
				"classic_wiki");

			if (pagesCount > 0) {
				return true;
			}

			return false;
		}
		catch (Exception exception) {
			_log.error(exception);

			return false;
		}
	}

	@Override
	protected void doConvert() {
		List<WikiPage> pages = _wikiPageLocalService.getPages("classic_wiki");

		ClassicToCreoleTranslator translator = new ClassicToCreoleTranslator();

		MaintenanceUtil.appendStatus(
			"Converting " + pages.size() +
				" Wiki pages from Classic Wiki to Creole format");

		for (int i = 0; i < pages.size(); i++) {
			if ((i > 0) && ((i % (pages.size() / 4)) == 0)) {
				MaintenanceUtil.appendStatus((i * 100. / pages.size()) + "%");
			}

			WikiPage page = pages.get(i);

			page.setFormat("creole");

			page.setContent(translator.translate(page.getContent()));

			_wikiPageLocalService.updateWikiPage(page);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		WikiCreoleConvertProcess.class);

	@Reference
	private WikiPageLocalService _wikiPageLocalService;

}