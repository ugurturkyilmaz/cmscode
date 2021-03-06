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

package com.liferay.product.navigation.control.menu.util;

import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuEntry;

import org.osgi.framework.ServiceReference;

/**
 * @author     Julio Camarero
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public class ProductNavigationControlMenuEntryServiceReferenceMapper
	implements ServiceReferenceMapper
		<String, ProductNavigationControlMenuEntry> {

	@Override
	public void map(
		ServiceReference<ProductNavigationControlMenuEntry> serviceReference,
		Emitter<String> emitter) {

		String productNavigationControlMenuCategoryKey =
			(String)serviceReference.getProperty(
				"product.navigation.control.menu.category.key");

		if (Validator.isNull(productNavigationControlMenuCategoryKey)) {
			_log.error(
				"Unable to register product navigation control menu entry " +
					"because of missing service property " +
						"\"product.navigation.control.menu.category.key\"");
		}
		else {
			emitter.emit(productNavigationControlMenuCategoryKey);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ProductNavigationControlMenuEntryServiceReferenceMapper.class);

}