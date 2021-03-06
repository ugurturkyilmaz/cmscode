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

package com.liferay.portal.upgrade.release;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.model.dao.ReleaseDAO;
import com.liferay.portal.kernel.upgrade.UpgradeException;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Adolfo Pérez
 */
public abstract class BaseUpgradeServiceModuleRelease extends UpgradeProcess {

	@Override
	public void upgrade() throws UpgradeException {
		try (Connection connection = DataAccess.getConnection()) {
			if (_getBuildNumber(connection, getNewBundleSymbolicName()) ==
					null) {

				super.upgrade();
			}
		}
		catch (SQLException sqlException) {
			throw new UpgradeException(sqlException);
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		String buildNumber = _getBuildNumber(
			connection, getOldBundleSymbolicName());

		if (buildNumber != null) {
			_updateRelease(_toSchemaVersion(buildNumber));
		}
		else if (_hasServiceComponent()) {
			_createRelease();
		}
	}

	protected String getNamespace() {
		return StringPool.BLANK;
	}

	protected abstract String getNewBundleSymbolicName();

	protected abstract String getOldBundleSymbolicName();

	private void _createRelease() throws Exception {
		ReleaseDAO releaseDAO = new ReleaseDAO();

		releaseDAO.addRelease(connection, getNewBundleSymbolicName());
	}

	private String _getBuildNumber(
			Connection connection, String servletContextName)
		throws SQLException {

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				"select buildNumber from Release_ where servletContextName = " +
					"?")) {

			preparedStatement.setString(1, servletContextName);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString("buildNumber");
				}
			}
		}

		return null;
	}

	private boolean _hasServiceComponent() throws Exception {
		if (Validator.isNull(getNamespace())) {
			return false;
		}

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				"select serviceComponentId from ServiceComponent where " +
					"buildNamespace = ?")) {

			preparedStatement.setString(1, getNamespace());

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return true;
				}
			}
		}

		return false;
	}

	private String _toSchemaVersion(String buildNumber) {
		StringBuilder sb = new StringBuilder(2 * buildNumber.length());

		for (int i = 0; i < buildNumber.length(); i++) {
			sb.append(buildNumber.charAt(i));
			sb.append(CharPool.PERIOD);
		}

		if (buildNumber.length() > 0) {
			sb.setLength(sb.length() - 1);
		}

		return sb.toString();
	}

	private void _updateRelease(String schemaVersion) throws Exception {
		try (PreparedStatement preparedStatement = connection.prepareStatement(
				"update Release_ set servletContextName = ?, schemaVersion = " +
					"? where servletContextName = ?")) {

			preparedStatement.setString(1, getNewBundleSymbolicName());
			preparedStatement.setString(2, schemaVersion);
			preparedStatement.setString(3, getOldBundleSymbolicName());

			preparedStatement.execute();
		}
	}

}