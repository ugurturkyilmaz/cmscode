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

package com.liferay.commerce.product.content.web.internal.layout.display.page;

import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CProductLocalService;
import com.liferay.commerce.product.url.CPFriendlyURL;
import com.liferay.friendly.url.model.FriendlyURLEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.info.item.InfoItemReference;
import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.layout.display.page.LayoutDisplayPageProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	enabled = false, immediate = true, service = LayoutDisplayPageProvider.class
)
public class CProductLayoutDisplayPageProvider
	implements LayoutDisplayPageProvider<CProduct> {

	@Override
	public String getClassName() {
		return CProduct.class.getName();
	}

	@Override
	public LayoutDisplayPageObjectProvider<CProduct>
		getLayoutDisplayPageObjectProvider(
			InfoItemReference infoItemReference) {

		try {
			CProduct cProduct = _cProductLocalService.getCProduct(
				infoItemReference.getClassPK());

			long groupId = cProduct.getGroupId();

			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			if (serviceContext != null) {
				groupId = serviceContext.getScopeGroupId();
			}

			return new CProductLayoutDisplayPageObjectProvider(
				cProduct, groupId);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}
	}

	@Override
	public LayoutDisplayPageObjectProvider<CProduct>
		getLayoutDisplayPageObjectProvider(long groupId, String urlTitle) {

		try {
			Group group = _groupLocalService.getGroup(groupId);

			Group companyGroup = _groupLocalService.getCompanyGroup(
				group.getCompanyId());

			FriendlyURLEntry friendlyURLEntry =
				_friendlyURLEntryLocalService.fetchFriendlyURLEntry(
					companyGroup.getGroupId(),
					_portal.getClassNameId(CProduct.class), urlTitle);

			if (friendlyURLEntry == null) {
				return null;
			}

			CProduct cProduct = _cProductLocalService.getCProduct(
				friendlyURLEntry.getClassPK());

			return new CProductLayoutDisplayPageObjectProvider(
				cProduct, groupId);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}
	}

	@Override
	public String getURLSeparator() {
		return _cpFriendlyURL.getProductURLSeparator(
			CompanyThreadLocal.getCompanyId());
	}

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private CPFriendlyURL _cpFriendlyURL;

	@Reference
	private CProductLocalService _cProductLocalService;

	@Reference
	private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private Portal _portal;

}