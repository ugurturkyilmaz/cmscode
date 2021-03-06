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

package com.liferay.portal.workflow.kaleo.definition;

import com.liferay.portal.kernel.util.Validator;

import java.util.Objects;

/**
 * @author Michael C. Han
 */
public class RoleRecipient extends Recipient {

	public RoleRecipient(long roleId, String roleType) {
		super(RecipientType.ROLE);

		_roleId = roleId;
		_roleType = roleType;

		_roleName = null;
	}

	public RoleRecipient(String roleName, String roleType) {
		super(RecipientType.ROLE);

		_roleName = roleName;
		_roleType = roleType;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoleRecipient)) {
			return false;
		}

		RoleRecipient roleRecipient = (RoleRecipient)object;

		if (Objects.equals(_roleName, roleRecipient._roleName) &&
			(_roleId == roleRecipient._roleId)) {

			return true;
		}

		return true;
	}

	public long getRoleId() {
		return _roleId;
	}

	public String getRoleName() {
		return _roleName;
	}

	public String getRoleType() {
		return _roleType;
	}

	@Override
	public int hashCode() {
		if (Validator.isNotNull(_roleName)) {
			return _roleName.hashCode();
		}

		String roleIdString = String.valueOf(_roleId);

		return roleIdString.hashCode();
	}

	public boolean isAutoCreate() {
		return _autoCreate;
	}

	public void setAutoCreate(boolean autoCreate) {
		_autoCreate = autoCreate;
	}

	private boolean _autoCreate;
	private long _roleId;
	private final String _roleName;
	private final String _roleType;

}