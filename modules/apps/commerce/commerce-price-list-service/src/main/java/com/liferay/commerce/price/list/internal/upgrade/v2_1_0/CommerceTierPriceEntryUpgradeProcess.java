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

package com.liferay.commerce.price.list.internal.upgrade.v2_1_0;

import com.liferay.commerce.price.list.internal.upgrade.base.BaseCommercePriceListUpgradeProcess;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author Riccardo Alberti
 */
public class CommerceTierPriceEntryUpgradeProcess
	extends BaseCommercePriceListUpgradeProcess {

	@Override
	public void doUpgrade() throws Exception {
		addColumn("CommerceTierPriceEntry", "discountDiscovery", "BOOLEAN");
		addColumn("CommerceTierPriceEntry", "discountLevel1", "DECIMAL(30,16)");
		addColumn("CommerceTierPriceEntry", "discountLevel2", "DECIMAL(30,16)");
		addColumn("CommerceTierPriceEntry", "discountLevel3", "DECIMAL(30,16)");
		addColumn("CommerceTierPriceEntry", "discountLevel4", "DECIMAL(30,16)");
		addColumn("CommerceTierPriceEntry", "displayDate", "DATE");
		addColumn("CommerceTierPriceEntry", "expirationDate", "DATE");
		addColumn("CommerceTierPriceEntry", "status", "INTEGER");
		addColumn("CommerceTierPriceEntry", "statusByUserId", "LONG");
		addColumn("CommerceTierPriceEntry", "statusByUserName", "VARCHAR(75)");
		addColumn("CommerceTierPriceEntry", "statusDate", "DATE");

		runSQL(
			"update CommerceTierPriceEntry set displayDate = lastPublishDate");
		runSQL(
			"update CommerceTierPriceEntry set status = " +
				WorkflowConstants.STATUS_APPROVED);
		runSQL("update CommerceTierPriceEntry set statusByUserId = userId");
		runSQL("update CommerceTierPriceEntry set statusByUserName = userName");
		runSQL("update CommerceTierPriceEntry set statusDate = modifiedDate");
	}

}