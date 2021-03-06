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

package com.liferay.portal.kernel.dao.jdbc;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public class DataSourceFactoryUtil {

	public static void destroyDataSource(DataSource dataSource)
		throws Exception {

		_dataSourceFactory.destroyDataSource(dataSource);
	}

	public static DataSourceFactory getDataSourceFactory() {
		return _dataSourceFactory;
	}

	public static DataSource initDataSource(Properties properties)
		throws Exception {

		return _dataSourceFactory.initDataSource(properties);
	}

	public static DataSource initDataSource(
			String driverClassName, String url, String userName,
			String password, String jndiName)
		throws Exception {

		return _dataSourceFactory.initDataSource(
			driverClassName, url, userName, password, jndiName);
	}

	public static void setDataSourceFactory(
		DataSourceFactory dataSourceFactory) {

		_dataSourceFactory = dataSourceFactory;
	}

	private static DataSourceFactory _dataSourceFactory;

}