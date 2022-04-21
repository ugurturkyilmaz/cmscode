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

package com.liferay.document.library.internal.configuration.admin.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.configuration.test.util.ConfigurationTemporarySwapper;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapDictionaryBuilder;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.service.cm.ManagedServiceFactory;

/**
 * @author Adolfo Pérez
 */
@RunWith(Arquillian.class)
public class DLSizeLimitManagedServiceFactoryTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testGetCompanyMimeTypeSizeLimitSpecificValue()
		throws Exception {

		try (ConfigurationTemporarySwapper configurationTemporarySwapper =
				new ConfigurationTemporarySwapper(
					"com.liferay.document.library.internal.configuration." +
						"DLSizeLimitConfiguration",
					HashMapDictionaryBuilder.<String, Object>put(
						"mimeTypeSizeLimit", new String[] {"image/png:1234"}
					).build())) {

			Assert.assertEquals(
				1234, _getCompanyMimeTypeSizeLimit("image/png"));
		}
	}

	@Test
	public void testGetCompanyMimeTypeSizeLimitSystemDefaultValue()
		throws Exception {

		try (ConfigurationTemporarySwapper configurationTemporarySwapper =
				new ConfigurationTemporarySwapper(
					"com.liferay.document.library.internal.configuration." +
						"DLSizeLimitConfiguration",
					HashMapDictionaryBuilder.<String, Object>put(
						"mimeTypeSizeLimit", new String[0]
					).build())) {

			Assert.assertEquals(0, _getCompanyMimeTypeSizeLimit("image/png"));
		}
	}

	@Test
	public void testGetCompanyMimeTypeSizeLimitWildcard() throws Exception {
		try (ConfigurationTemporarySwapper configurationTemporarySwapper =
				new ConfigurationTemporarySwapper(
					"com.liferay.document.library.internal.configuration." +
						"DLSizeLimitConfiguration",
					HashMapDictionaryBuilder.<String, Object>put(
						"mimeTypeSizeLimit", new String[] {"image/*:1234"}
					).build())) {

			Assert.assertEquals(
				1234, _getCompanyMimeTypeSizeLimit("image/png"));
		}
	}

	@Test
	public void testGetCompanyMimeTypeSizeLimitWildcardAndSpecificValue()
		throws Exception {

		try (ConfigurationTemporarySwapper configurationTemporarySwapper =
				new ConfigurationTemporarySwapper(
					"com.liferay.document.library.internal.configuration." +
						"DLSizeLimitConfiguration",
					HashMapDictionaryBuilder.<String, Object>put(
						"mimeTypeSizeLimit",
						new String[] {"image/*:1234", "image/png:5678"}
					).build())) {

			Assert.assertEquals(
				5678, _getCompanyMimeTypeSizeLimit("image/png"));
		}
	}

	private long _getCompanyMimeTypeSizeLimit(String mimeType)
		throws Exception {

		Method method = ReflectionUtil.getDeclaredMethod(
			_managedServiceFactory.getClass(), "getCompanyMimeTypeSizeLimit",
			long.class, String.class);

		return (long)method.invoke(
			_managedServiceFactory, TestPropsValues.getCompanyId(), mimeType);
	}

	@Inject(filter = "component.name=*.DLSizeLimitManagedServiceFactory")
	private ManagedServiceFactory _managedServiceFactory;

}