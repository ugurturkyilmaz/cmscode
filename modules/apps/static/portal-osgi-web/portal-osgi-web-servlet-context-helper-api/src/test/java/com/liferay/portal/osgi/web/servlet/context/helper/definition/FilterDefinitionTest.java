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

package com.liferay.portal.osgi.web.servlet.context.helper.definition;

import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Miguel Pastor
 */
public class FilterDefinitionTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testAddMultipleURLPatterns() {
		String urlPattern = "/o/module";

		List<String> urlPatterns = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			urlPatterns.add(urlPattern + "/" + i);
		}

		_filterDefinition.setURLPatterns(urlPatterns);

		urlPatterns = _filterDefinition.getURLPatterns();

		Assert.assertEquals(urlPatterns.toString(), 10, urlPatterns.size());

		for (int i = 0; i < 10; i++) {
			Assert.assertEquals(urlPattern + "/" + i, urlPatterns.get(i));
		}
	}

	@Test
	public void testAddSingleURLPattern() {
		String urlPattern = "/o/module";

		_filterDefinition.addURLPattern(urlPattern);

		List<String> urlPatterns = _filterDefinition.getURLPatterns();

		Assert.assertEquals(urlPatterns.toString(), 1, urlPatterns.size());
		Assert.assertEquals(urlPattern, urlPatterns.get(0));
	}

	@Test
	public void testSetFilter() {
		Filter filter = ProxyFactory.newDummyInstance(Filter.class);

		_filterDefinition.setFilter(filter);

		Assert.assertSame(filter, _filterDefinition.getFilter());
	}

	@Test
	public void testSetFilterName() {
		String filterName = "Module Filter";

		_filterDefinition.setName(filterName);

		Assert.assertEquals(filterName, _filterDefinition.getName());
	}

	@Test
	public void testSetMultipleInitParameters() {
		Map<String, String> initParameters = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			initParameters.put("parameter-" + i, String.valueOf(i));
		}

		_filterDefinition.setInitParameters(initParameters);

		initParameters = _filterDefinition.getInitParameters();

		Assert.assertEquals(
			initParameters.toString(), 10, initParameters.size());

		for (int i = 0; i < 10; i++) {
			String expectedValue = String.valueOf(i);
			String value = initParameters.get("parameter-" + i);

			Assert.assertEquals(expectedValue, value);
		}
	}

	@Test
	public void testSetSingleInitParameter() {
		String key = "parameter";
		String value = "1";

		_filterDefinition.setInitParameter(key, value);

		Map<String, String> initParameters =
			_filterDefinition.getInitParameters();

		Assert.assertEquals(
			initParameters.toString(), 1, initParameters.size());
		Assert.assertEquals(value, initParameters.get(key));
	}

	private final FilterDefinition _filterDefinition = new FilterDefinition();

}