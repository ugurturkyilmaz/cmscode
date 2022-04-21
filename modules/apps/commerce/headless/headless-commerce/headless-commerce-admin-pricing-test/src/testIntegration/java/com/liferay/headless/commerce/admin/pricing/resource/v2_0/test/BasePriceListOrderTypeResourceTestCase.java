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

package com.liferay.headless.commerce.admin.pricing.resource.v2_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.headless.commerce.admin.pricing.client.dto.v2_0.PriceListOrderType;
import com.liferay.headless.commerce.admin.pricing.client.http.HttpInvoker;
import com.liferay.headless.commerce.admin.pricing.client.pagination.Page;
import com.liferay.headless.commerce.admin.pricing.client.pagination.Pagination;
import com.liferay.headless.commerce.admin.pricing.client.resource.v2_0.PriceListOrderTypeResource;
import com.liferay.headless.commerce.admin.pricing.client.serdes.v2_0.PriceListOrderTypeSerDes;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
public abstract class BasePriceListOrderTypeResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_priceListOrderTypeResource.setContextCompany(testCompany);

		PriceListOrderTypeResource.Builder builder =
			PriceListOrderTypeResource.builder();

		priceListOrderTypeResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		PriceListOrderType priceListOrderType1 = randomPriceListOrderType();

		String json = objectMapper.writeValueAsString(priceListOrderType1);

		PriceListOrderType priceListOrderType2 = PriceListOrderTypeSerDes.toDTO(
			json);

		Assert.assertTrue(equals(priceListOrderType1, priceListOrderType2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		PriceListOrderType priceListOrderType = randomPriceListOrderType();

		String json1 = objectMapper.writeValueAsString(priceListOrderType);
		String json2 = PriceListOrderTypeSerDes.toJSON(priceListOrderType);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		PriceListOrderType priceListOrderType = randomPriceListOrderType();

		priceListOrderType.setOrderTypeExternalReferenceCode(regex);
		priceListOrderType.setPriceListExternalReferenceCode(regex);

		String json = PriceListOrderTypeSerDes.toJSON(priceListOrderType);

		Assert.assertFalse(json.contains(regex));

		priceListOrderType = PriceListOrderTypeSerDes.toDTO(json);

		Assert.assertEquals(
			regex, priceListOrderType.getOrderTypeExternalReferenceCode());
		Assert.assertEquals(
			regex, priceListOrderType.getPriceListExternalReferenceCode());
	}

	@Test
	public void testDeletePriceListOrderType() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeletePriceListOrderType() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetPriceListByExternalReferenceCodePriceListOrderTypesPage()
		throws Exception {

		String externalReferenceCode =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_getExternalReferenceCode();
		String irrelevantExternalReferenceCode =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_getIrrelevantExternalReferenceCode();

		Page<PriceListOrderType> page =
			priceListOrderTypeResource.
				getPriceListByExternalReferenceCodePriceListOrderTypesPage(
					externalReferenceCode, Pagination.of(1, 10));

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantExternalReferenceCode != null) {
			PriceListOrderType irrelevantPriceListOrderType =
				testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
					irrelevantExternalReferenceCode,
					randomIrrelevantPriceListOrderType());

			page =
				priceListOrderTypeResource.
					getPriceListByExternalReferenceCodePriceListOrderTypesPage(
						irrelevantExternalReferenceCode, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantPriceListOrderType),
				(List<PriceListOrderType>)page.getItems());
			assertValid(page);
		}

		PriceListOrderType priceListOrderType1 =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
				externalReferenceCode, randomPriceListOrderType());

		PriceListOrderType priceListOrderType2 =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
				externalReferenceCode, randomPriceListOrderType());

		page =
			priceListOrderTypeResource.
				getPriceListByExternalReferenceCodePriceListOrderTypesPage(
					externalReferenceCode, Pagination.of(1, 10));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(priceListOrderType1, priceListOrderType2),
			(List<PriceListOrderType>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetPriceListByExternalReferenceCodePriceListOrderTypesPageWithPagination()
		throws Exception {

		String externalReferenceCode =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_getExternalReferenceCode();

		PriceListOrderType priceListOrderType1 =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
				externalReferenceCode, randomPriceListOrderType());

		PriceListOrderType priceListOrderType2 =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
				externalReferenceCode, randomPriceListOrderType());

		PriceListOrderType priceListOrderType3 =
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
				externalReferenceCode, randomPriceListOrderType());

		Page<PriceListOrderType> page1 =
			priceListOrderTypeResource.
				getPriceListByExternalReferenceCodePriceListOrderTypesPage(
					externalReferenceCode, Pagination.of(1, 2));

		List<PriceListOrderType> priceListOrderTypes1 =
			(List<PriceListOrderType>)page1.getItems();

		Assert.assertEquals(
			priceListOrderTypes1.toString(), 2, priceListOrderTypes1.size());

		Page<PriceListOrderType> page2 =
			priceListOrderTypeResource.
				getPriceListByExternalReferenceCodePriceListOrderTypesPage(
					externalReferenceCode, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<PriceListOrderType> priceListOrderTypes2 =
			(List<PriceListOrderType>)page2.getItems();

		Assert.assertEquals(
			priceListOrderTypes2.toString(), 1, priceListOrderTypes2.size());

		Page<PriceListOrderType> page3 =
			priceListOrderTypeResource.
				getPriceListByExternalReferenceCodePriceListOrderTypesPage(
					externalReferenceCode, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(
				priceListOrderType1, priceListOrderType2, priceListOrderType3),
			(List<PriceListOrderType>)page3.getItems());
	}

	protected PriceListOrderType
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_addPriceListOrderType(
				String externalReferenceCode,
				PriceListOrderType priceListOrderType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_getExternalReferenceCode()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String
			testGetPriceListByExternalReferenceCodePriceListOrderTypesPage_getIrrelevantExternalReferenceCode()
		throws Exception {

		return null;
	}

	@Test
	public void testPostPriceListByExternalReferenceCodePriceListOrderType()
		throws Exception {

		PriceListOrderType randomPriceListOrderType =
			randomPriceListOrderType();

		PriceListOrderType postPriceListOrderType =
			testPostPriceListByExternalReferenceCodePriceListOrderType_addPriceListOrderType(
				randomPriceListOrderType);

		assertEquals(randomPriceListOrderType, postPriceListOrderType);
		assertValid(postPriceListOrderType);
	}

	protected PriceListOrderType
			testPostPriceListByExternalReferenceCodePriceListOrderType_addPriceListOrderType(
				PriceListOrderType priceListOrderType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetPriceListIdPriceListOrderTypesPage() throws Exception {
		Long id = testGetPriceListIdPriceListOrderTypesPage_getId();
		Long irrelevantId =
			testGetPriceListIdPriceListOrderTypesPage_getIrrelevantId();

		Page<PriceListOrderType> page =
			priceListOrderTypeResource.getPriceListIdPriceListOrderTypesPage(
				id, null, Pagination.of(1, 10));

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantId != null) {
			PriceListOrderType irrelevantPriceListOrderType =
				testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
					irrelevantId, randomIrrelevantPriceListOrderType());

			page =
				priceListOrderTypeResource.
					getPriceListIdPriceListOrderTypesPage(
						irrelevantId, null, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantPriceListOrderType),
				(List<PriceListOrderType>)page.getItems());
			assertValid(page);
		}

		PriceListOrderType priceListOrderType1 =
			testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
				id, randomPriceListOrderType());

		PriceListOrderType priceListOrderType2 =
			testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
				id, randomPriceListOrderType());

		page = priceListOrderTypeResource.getPriceListIdPriceListOrderTypesPage(
			id, null, Pagination.of(1, 10));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(priceListOrderType1, priceListOrderType2),
			(List<PriceListOrderType>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetPriceListIdPriceListOrderTypesPageWithPagination()
		throws Exception {

		Long id = testGetPriceListIdPriceListOrderTypesPage_getId();

		PriceListOrderType priceListOrderType1 =
			testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
				id, randomPriceListOrderType());

		PriceListOrderType priceListOrderType2 =
			testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
				id, randomPriceListOrderType());

		PriceListOrderType priceListOrderType3 =
			testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
				id, randomPriceListOrderType());

		Page<PriceListOrderType> page1 =
			priceListOrderTypeResource.getPriceListIdPriceListOrderTypesPage(
				id, null, Pagination.of(1, 2));

		List<PriceListOrderType> priceListOrderTypes1 =
			(List<PriceListOrderType>)page1.getItems();

		Assert.assertEquals(
			priceListOrderTypes1.toString(), 2, priceListOrderTypes1.size());

		Page<PriceListOrderType> page2 =
			priceListOrderTypeResource.getPriceListIdPriceListOrderTypesPage(
				id, null, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<PriceListOrderType> priceListOrderTypes2 =
			(List<PriceListOrderType>)page2.getItems();

		Assert.assertEquals(
			priceListOrderTypes2.toString(), 1, priceListOrderTypes2.size());

		Page<PriceListOrderType> page3 =
			priceListOrderTypeResource.getPriceListIdPriceListOrderTypesPage(
				id, null, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(
				priceListOrderType1, priceListOrderType2, priceListOrderType3),
			(List<PriceListOrderType>)page3.getItems());
	}

	protected PriceListOrderType
			testGetPriceListIdPriceListOrderTypesPage_addPriceListOrderType(
				Long id, PriceListOrderType priceListOrderType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetPriceListIdPriceListOrderTypesPage_getId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetPriceListIdPriceListOrderTypesPage_getIrrelevantId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostPriceListIdPriceListOrderType() throws Exception {
		PriceListOrderType randomPriceListOrderType =
			randomPriceListOrderType();

		PriceListOrderType postPriceListOrderType =
			testPostPriceListIdPriceListOrderType_addPriceListOrderType(
				randomPriceListOrderType);

		assertEquals(randomPriceListOrderType, postPriceListOrderType);
		assertValid(postPriceListOrderType);
	}

	protected PriceListOrderType
			testPostPriceListIdPriceListOrderType_addPriceListOrderType(
				PriceListOrderType priceListOrderType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		PriceListOrderType priceListOrderType,
		List<PriceListOrderType> priceListOrderTypes) {

		boolean contains = false;

		for (PriceListOrderType item : priceListOrderTypes) {
			if (equals(priceListOrderType, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			priceListOrderTypes + " does not contain " + priceListOrderType,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		PriceListOrderType priceListOrderType1,
		PriceListOrderType priceListOrderType2) {

		Assert.assertTrue(
			priceListOrderType1 + " does not equal " + priceListOrderType2,
			equals(priceListOrderType1, priceListOrderType2));
	}

	protected void assertEquals(
		List<PriceListOrderType> priceListOrderTypes1,
		List<PriceListOrderType> priceListOrderTypes2) {

		Assert.assertEquals(
			priceListOrderTypes1.size(), priceListOrderTypes2.size());

		for (int i = 0; i < priceListOrderTypes1.size(); i++) {
			PriceListOrderType priceListOrderType1 = priceListOrderTypes1.get(
				i);
			PriceListOrderType priceListOrderType2 = priceListOrderTypes2.get(
				i);

			assertEquals(priceListOrderType1, priceListOrderType2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<PriceListOrderType> priceListOrderTypes1,
		List<PriceListOrderType> priceListOrderTypes2) {

		Assert.assertEquals(
			priceListOrderTypes1.size(), priceListOrderTypes2.size());

		for (PriceListOrderType priceListOrderType1 : priceListOrderTypes1) {
			boolean contains = false;

			for (PriceListOrderType priceListOrderType2 :
					priceListOrderTypes2) {

				if (equals(priceListOrderType1, priceListOrderType2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				priceListOrderTypes2 + " does not contain " +
					priceListOrderType1,
				contains);
		}
	}

	protected void assertValid(PriceListOrderType priceListOrderType)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (priceListOrderType.getActions() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("orderType", additionalAssertFieldName)) {
				if (priceListOrderType.getOrderType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"orderTypeExternalReferenceCode",
					additionalAssertFieldName)) {

				if (priceListOrderType.getOrderTypeExternalReferenceCode() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals("orderTypeId", additionalAssertFieldName)) {
				if (priceListOrderType.getOrderTypeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"priceListExternalReferenceCode",
					additionalAssertFieldName)) {

				if (priceListOrderType.getPriceListExternalReferenceCode() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals("priceListId", additionalAssertFieldName)) {
				if (priceListOrderType.getPriceListId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"priceListOrderTypeId", additionalAssertFieldName)) {

				if (priceListOrderType.getPriceListOrderTypeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("priority", additionalAssertFieldName)) {
				if (priceListOrderType.getPriority() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<PriceListOrderType> page) {
		boolean valid = false;

		java.util.Collection<PriceListOrderType> priceListOrderTypes =
			page.getItems();

		int size = priceListOrderTypes.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.headless.commerce.admin.pricing.dto.v2_0.
						PriceListOrderType.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		PriceListOrderType priceListOrderType1,
		PriceListOrderType priceListOrderType2) {

		if (priceListOrderType1 == priceListOrderType2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (!equals(
						(Map)priceListOrderType1.getActions(),
						(Map)priceListOrderType2.getActions())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("orderType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						priceListOrderType1.getOrderType(),
						priceListOrderType2.getOrderType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"orderTypeExternalReferenceCode",
					additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						priceListOrderType1.getOrderTypeExternalReferenceCode(),
						priceListOrderType2.
							getOrderTypeExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("orderTypeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						priceListOrderType1.getOrderTypeId(),
						priceListOrderType2.getOrderTypeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"priceListExternalReferenceCode",
					additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						priceListOrderType1.getPriceListExternalReferenceCode(),
						priceListOrderType2.
							getPriceListExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("priceListId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						priceListOrderType1.getPriceListId(),
						priceListOrderType2.getPriceListId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"priceListOrderTypeId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						priceListOrderType1.getPriceListOrderTypeId(),
						priceListOrderType2.getPriceListOrderTypeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("priority", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						priceListOrderType1.getPriority(),
						priceListOrderType2.getPriority())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_priceListOrderTypeResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_priceListOrderTypeResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		PriceListOrderType priceListOrderType) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("actions")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("orderType")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("orderTypeExternalReferenceCode")) {
			sb.append("'");
			sb.append(
				String.valueOf(
					priceListOrderType.getOrderTypeExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("orderTypeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("priceListExternalReferenceCode")) {
			sb.append("'");
			sb.append(
				String.valueOf(
					priceListOrderType.getPriceListExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("priceListId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("priceListOrderTypeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("priority")) {
			sb.append(String.valueOf(priceListOrderType.getPriority()));

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected PriceListOrderType randomPriceListOrderType() throws Exception {
		return new PriceListOrderType() {
			{
				orderTypeExternalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				orderTypeId = RandomTestUtil.randomLong();
				priceListExternalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				priceListId = RandomTestUtil.randomLong();
				priceListOrderTypeId = RandomTestUtil.randomLong();
				priority = RandomTestUtil.randomInt();
			}
		};
	}

	protected PriceListOrderType randomIrrelevantPriceListOrderType()
		throws Exception {

		PriceListOrderType randomIrrelevantPriceListOrderType =
			randomPriceListOrderType();

		return randomIrrelevantPriceListOrderType;
	}

	protected PriceListOrderType randomPatchPriceListOrderType()
		throws Exception {

		return randomPriceListOrderType();
	}

	protected PriceListOrderTypeResource priceListOrderTypeResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BasePriceListOrderTypeResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.headless.commerce.admin.pricing.resource.v2_0.
		PriceListOrderTypeResource _priceListOrderTypeResource;

}