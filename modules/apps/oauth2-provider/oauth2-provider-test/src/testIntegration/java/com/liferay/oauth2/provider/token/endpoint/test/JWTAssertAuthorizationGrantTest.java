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

package com.liferay.oauth2.provider.token.endpoint.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.oauth2.provider.client.test.BaseClientTestCase;
import com.liferay.oauth2.provider.client.test.BaseTestPreparatorBundleActivator;
import com.liferay.oauth2.provider.constants.GrantType;
import com.liferay.oauth2.provider.internal.test.TestAuthorizationGrant;
import com.liferay.oauth2.provider.internal.test.TestClientAuthentication;
import com.liferay.oauth2.provider.internal.test.TestClientPasswordClientAuthentication;
import com.liferay.oauth2.provider.internal.test.TestJWTAssertionAuthorizationGrant;
import com.liferay.oauth2.provider.internal.test.util.JWTAssertionUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.HashMapDictionaryBuilder;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.Arrays;
import java.util.function.Function;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.BundleActivator;

/**
 * @author Arthur Chan
 */
@RunWith(Arquillian.class)
public class JWTAssertAuthorizationGrantTest extends BaseClientTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testClientAuthentications() {
		Assert.assertTrue(
			Validator.isNotNull(
				_getToken(
					_getTestAuthorizationGrant(),
					_TEST_CLIENT_PASSWORD_CLIENT_AUTHENTICATION)));
	}

	@Test
	public void testGrantWithCorrectAudience() throws Exception {
		User user = UserTestUtil.getAdminUser(PortalUtil.getDefaultCompanyId());

		TestJWTAssertionAuthorizationGrant testJWTAssertionAuthorizationGrant =
			new TestJWTAssertionAuthorizationGrant(
				_TEST_CLIENT_ID_01, null, user.getUuid(), getTokenWebTarget());

		Assert.assertTrue(
			Validator.isNotNull(_getToken(testJWTAssertionAuthorizationGrant)));
	}

	@Test
	public void testGrantWithWrongAudience() throws Exception {
		User user = UserTestUtil.getAdminUser(PortalUtil.getDefaultCompanyId());

		TestJWTAssertionAuthorizationGrant testJWTAssertionAuthorizationGrant =
			new TestJWTAssertionAuthorizationGrant(
				_TEST_CLIENT_ID_01, null, user.getUuid(),
				getJsonWebTarget("wrongPath"));

		Assert.assertTrue(
			Validator.isNull(_getToken(testJWTAssertionAuthorizationGrant)));
	}

	@Override
	protected BundleActivator getBundleActivator() {
		return new JWTBearerGrantTestPreparatorBundleActivator();
	}

	private static Invocation.Builder _getInvocationBuilder() {
		return getInvocationBuilder(
			null, getTokenWebTarget(), Function.identity());
	}

	private TestAuthorizationGrant _getTestAuthorizationGrant() {
		User user = null;

		try {
			user = UserTestUtil.getAdminUser(PortalUtil.getDefaultCompanyId());

			return new TestJWTAssertionAuthorizationGrant(
				_TEST_CLIENT_ID_01, null, user.getUuid(), getTokenWebTarget());
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	private String _getToken(TestAuthorizationGrant testAuthorizationGrant) {
		return _getToken(
			testAuthorizationGrant,
			_TEST_CLIENT_PASSWORD_CLIENT_AUTHENTICATION);
	}

	private String _getToken(
		TestAuthorizationGrant testAuthorizationGrant,
		TestClientAuthentication testClientAuthentication) {

		return parseTokenString(
			_getTokenResponse(
				testAuthorizationGrant, testClientAuthentication));
	}

	private Response _getTokenResponse(
		TestAuthorizationGrant testAuthorizationGrant,
		TestClientAuthentication testClientAuthentication) {

		MultivaluedMap<String, String> multivaluedMap =
			new MultivaluedHashMap<>();

		multivaluedMap.putAll(
			testAuthorizationGrant.getAuthorizationGrantParameters());
		multivaluedMap.putAll(
			testClientAuthentication.getClientAuthenticationParameters());

		return _invocationBuilder.post(Entity.form(multivaluedMap));
	}

	private static final String _TEST_CLIENT_ID_01 = "test_client_id_01";

	private static final TestClientPasswordClientAuthentication
		_TEST_CLIENT_PASSWORD_CLIENT_AUTHENTICATION =
			new TestClientPasswordClientAuthentication(
				_TEST_CLIENT_ID_01,
				JWTAssertAuthorizationGrantTest._TEST_CLIENT_SECRET);

	private static final String _TEST_CLIENT_SECRET =
		"oauthTestApplicationSecret";

	private static final Invocation.Builder _invocationBuilder =
		_getInvocationBuilder();

	private static class JWTBearerGrantTestPreparatorBundleActivator
		extends BaseTestPreparatorBundleActivator {

		@Override
		protected void prepareTest() throws Exception {
			createFactoryConfiguration(
				"com.liferay.oauth2.provider.rest.internal.configuration." +
					"OAuth2InAssertionConfiguration",
				HashMapDictionaryBuilder.<String, Object>put(
					"oauth2.in.assertion.issuer", _TEST_CLIENT_ID_01
				).put(
					"oauth2.in.assertion.signature.json.web.key.set",
					JWTAssertionUtil.JWKS
				).put(
					"oauth2.in.assertion.user.auth.type", "UUID"
				).build());

			User user = UserTestUtil.getAdminUser(
				PortalUtil.getDefaultCompanyId());

			createOAuth2Application(
				user.getCompanyId(), user, _TEST_CLIENT_ID_01,
				Arrays.asList(GrantType.JWT_BEARER),
				Arrays.asList(
					"everything", "everything.read", "everything.write"));
		}

	}

}