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

package com.liferay.message.boards.permission.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.constants.MBConstants;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.service.MBCategoryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.security.permission.test.util.BasePermissionTestCase;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eric Chin
 * @author Shinn Lok
 */
@RunWith(Arquillian.class)
public class MBCategoryPermissionCheckerTest extends BasePermissionTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testContains() throws Exception {
		Assert.assertTrue(
			_categoryModelResourcePermission.contains(
				permissionChecker, _category, ActionKeys.VIEW));
		Assert.assertTrue(
			_categoryModelResourcePermission.contains(
				permissionChecker, _subcategory, ActionKeys.VIEW));

		removePortletModelViewPermission();

		Assert.assertFalse(
			_categoryModelResourcePermission.contains(
				permissionChecker, _category, ActionKeys.VIEW));
		Assert.assertFalse(
			_categoryModelResourcePermission.contains(
				permissionChecker, _subcategory, ActionKeys.VIEW));
	}

	@Override
	protected void doSetUp() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				group.getGroupId(), TestPropsValues.getUserId());

		_category = MBCategoryLocalServiceUtil.addCategory(
			TestPropsValues.getUserId(),
			MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
			RandomTestUtil.randomString(), StringPool.BLANK, serviceContext);

		_subcategory = MBCategoryLocalServiceUtil.addCategory(
			TestPropsValues.getUserId(), _category.getCategoryId(),
			RandomTestUtil.randomString(), StringPool.BLANK, serviceContext);
	}

	@Override
	protected String getResourceName() {
		return MBConstants.RESOURCE_NAME;
	}

	@Inject(
		filter = "model.class.name=com.liferay.message.boards.model.MBCategory"
	)
	private static ModelResourcePermission<MBCategory>
		_categoryModelResourcePermission;

	private MBCategory _category;
	private MBCategory _subcategory;

}