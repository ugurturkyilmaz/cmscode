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

package com.liferay.portal.kernel.test.rule;

import com.liferay.portal.test.rule.InitializeKernelUtilTestRule;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Shuyang Zhou
 */
public class AggregateTestRule implements TestRule {

	public AggregateTestRule(boolean sort, TestRule... testRules) {
		if (testRules == null) {
			throw new NullPointerException("Test rules is null");
		}

		if (testRules.length < 2) {
			throw new IllegalArgumentException(
				"Rule number " + testRules.length + " is less than 2");
		}

		_testRules = testRules;

		if (sort) {
			Arrays.sort(_testRules, _testRuleComparator);
		}
	}

	public AggregateTestRule(TestRule... testRules) {
		this(true, testRules);
	}

	@Override
	public Statement apply(Statement statement, Description description) {
		for (int i = _testRules.length - 1; i >= 0; i--) {
			statement = _testRules[i].apply(statement, description);
		}

		return statement;
	}

	private static final String[] _ORDERED_RULE_CLASS_NAMES = {
		TimeoutTestRule.class.getName(), HeapDumpTestRule.class.getName(),
		CodeCoverageAssertor.class.getName(), NewEnvTestRule.class.getName(),
		AssumeTestRule.class.getName(),
		"com.liferay.portal.test.rule.LiferayIntegrationTestRule",
		LiferayUnitTestRule.class.getName(),
		"com.liferay.portal.test.rule.PersistenceTestRule",
		"com.liferay.portal.test.rule.TransactionalTestRule",
		SynchronousDestinationTestRule.class.getName(),
		"com.liferay.portal.test.rule.SynchronousMailTestRule",
		"com.liferay.document.library.webdav.test." +
			"WebDAVEnvironmentConfigClassTestRule",
		"com.liferay.portal.test.rule.PermissionCheckerMethodTestRule",
		InitializeKernelUtilTestRule.class.getName(),
		"com.liferay.portal.search.test.util.logging.ExpectedLogMethodTestRule"
	};

	private static final Comparator<TestRule> _testRuleComparator =
		new Comparator<TestRule>() {

			@Override
			public int compare(TestRule testRule1, TestRule testRule2) {
				return _getIndex(testRule1.getClass()) -
					_getIndex(testRule2.getClass());
			}

			private int _getIndex(Class<?> testRuleClass) {
				Set<String> testRuleClassNames = new HashSet<>();

				while (TestRule.class.isAssignableFrom(testRuleClass)) {
					testRuleClassNames.add(testRuleClass.getName());

					testRuleClass = testRuleClass.getSuperclass();
				}

				for (int i = 0; i < _ORDERED_RULE_CLASS_NAMES.length; i++) {
					if (testRuleClassNames.contains(
							_ORDERED_RULE_CLASS_NAMES[i])) {

						return i;
					}
				}

				throw new IllegalArgumentException(
					"Unknown test rule class : " + testRuleClass);
			}

		};

	private final TestRule[] _testRules;

}