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

package com.liferay.commerce.inventory.util.comparator;

import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Luca Pellizzon
 */
public class CommerceInventoryWarehouseItemWarehouseNameComparator
	extends OrderByComparator<CommerceInventoryWarehouseItem> {

	public static final String ORDER_BY_ASC =
		"CommerceInventoryWarehouse.name ASC";

	public static final String ORDER_BY_DESC =
		"CommerceInventoryWarehouse.name DESC";

	public static final String[] ORDER_BY_FIELDS = {
		"CommerceInventoryWarehouse.name"
	};

	public CommerceInventoryWarehouseItemWarehouseNameComparator() {
		this(false);
	}

	public CommerceInventoryWarehouseItemWarehouseNameComparator(
		boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(
		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem1,
		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem2) {

		try {
			CommerceInventoryWarehouse commerceInventoryWarehouse1 =
				commerceInventoryWarehouseItem1.getCommerceInventoryWarehouse();
			CommerceInventoryWarehouse commerceInventoryWarehouse2 =
				commerceInventoryWarehouseItem2.getCommerceInventoryWarehouse();

			String name1 = StringUtil.toLowerCase(
				commerceInventoryWarehouse1.getName());
			String name2 = StringUtil.toLowerCase(
				commerceInventoryWarehouse2.getName());

			int value = name1.compareTo(name2);

			if (_ascending) {
				return value;
			}

			return Math.negateExact(value);
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}