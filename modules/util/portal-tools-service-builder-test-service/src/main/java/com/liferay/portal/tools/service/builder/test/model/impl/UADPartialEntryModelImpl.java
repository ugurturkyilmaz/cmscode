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

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.service.builder.test.model.UADPartialEntry;
import com.liferay.portal.tools.service.builder.test.model.UADPartialEntryModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the UADPartialEntry service. Represents a row in the &quot;UADPartialEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UADPartialEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UADPartialEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UADPartialEntryImpl
 * @generated
 */
public class UADPartialEntryModelImpl
	extends BaseModelImpl<UADPartialEntry> implements UADPartialEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a uad partial entry model instance should use the <code>UADPartialEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "UADPartialEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uadPartialEntryId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"message", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uadPartialEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table UADPartialEntry (uadPartialEntryId LONG not null primary key,userId LONG,userName VARCHAR(75) null,message VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table UADPartialEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY uadPartialEntry.uadPartialEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY UADPartialEntry.uadPartialEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UADPARTIALENTRYID_COLUMN_BITMASK = 1L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.UADPartialEntry"));

	public UADPartialEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _uadPartialEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUadPartialEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uadPartialEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UADPartialEntry.class;
	}

	@Override
	public String getModelClassName() {
		return UADPartialEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UADPartialEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UADPartialEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UADPartialEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((UADPartialEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UADPartialEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UADPartialEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UADPartialEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UADPartialEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UADPartialEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UADPartialEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UADPartialEntry.class.getClassLoader(), UADPartialEntry.class,
			ModelWrapper.class);

		try {
			Constructor<UADPartialEntry> constructor =
				(Constructor<UADPartialEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<UADPartialEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UADPartialEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UADPartialEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<UADPartialEntry, Object>>();
		Map<String, BiConsumer<UADPartialEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UADPartialEntry, ?>>();

		attributeGetterFunctions.put(
			"uadPartialEntryId", UADPartialEntry::getUadPartialEntryId);
		attributeSetterBiConsumers.put(
			"uadPartialEntryId",
			(BiConsumer<UADPartialEntry, Long>)
				UADPartialEntry::setUadPartialEntryId);
		attributeGetterFunctions.put("userId", UADPartialEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<UADPartialEntry, Long>)UADPartialEntry::setUserId);
		attributeGetterFunctions.put("userName", UADPartialEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<UADPartialEntry, String>)UADPartialEntry::setUserName);
		attributeGetterFunctions.put("message", UADPartialEntry::getMessage);
		attributeSetterBiConsumers.put(
			"message",
			(BiConsumer<UADPartialEntry, String>)UADPartialEntry::setMessage);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getUadPartialEntryId() {
		return _uadPartialEntryId;
	}

	@Override
	public void setUadPartialEntryId(long uadPartialEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uadPartialEntryId = uadPartialEntryId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public String getMessage() {
		if (_message == null) {
			return "";
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_message = message;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, UADPartialEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UADPartialEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UADPartialEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UADPartialEntryImpl uadPartialEntryImpl = new UADPartialEntryImpl();

		uadPartialEntryImpl.setUadPartialEntryId(getUadPartialEntryId());
		uadPartialEntryImpl.setUserId(getUserId());
		uadPartialEntryImpl.setUserName(getUserName());
		uadPartialEntryImpl.setMessage(getMessage());

		uadPartialEntryImpl.resetOriginalValues();

		return uadPartialEntryImpl;
	}

	@Override
	public UADPartialEntry cloneWithOriginalValues() {
		UADPartialEntryImpl uadPartialEntryImpl = new UADPartialEntryImpl();

		uadPartialEntryImpl.setUadPartialEntryId(
			this.<Long>getColumnOriginalValue("uadPartialEntryId"));
		uadPartialEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		uadPartialEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		uadPartialEntryImpl.setMessage(
			this.<String>getColumnOriginalValue("message"));

		return uadPartialEntryImpl;
	}

	@Override
	public int compareTo(UADPartialEntry uadPartialEntry) {
		long primaryKey = uadPartialEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UADPartialEntry)) {
			return false;
		}

		UADPartialEntry uadPartialEntry = (UADPartialEntry)object;

		long primaryKey = uadPartialEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<UADPartialEntry> toCacheModel() {
		UADPartialEntryCacheModel uadPartialEntryCacheModel =
			new UADPartialEntryCacheModel();

		uadPartialEntryCacheModel.uadPartialEntryId = getUadPartialEntryId();

		uadPartialEntryCacheModel.userId = getUserId();

		uadPartialEntryCacheModel.userName = getUserName();

		String userName = uadPartialEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			uadPartialEntryCacheModel.userName = null;
		}

		uadPartialEntryCacheModel.message = getMessage();

		String message = uadPartialEntryCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			uadPartialEntryCacheModel.message = null;
		}

		return uadPartialEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UADPartialEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UADPartialEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UADPartialEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((UADPartialEntry)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<UADPartialEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UADPartialEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UADPartialEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((UADPartialEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UADPartialEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _uadPartialEntryId;
	private long _userId;
	private String _userName;
	private String _message;

	public <T> T getColumnValue(String columnName) {
		Function<UADPartialEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((UADPartialEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uadPartialEntryId", _uadPartialEntryId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("message", _message);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uadPartialEntryId", 1L);

		columnBitmasks.put("userId", 2L);

		columnBitmasks.put("userName", 4L);

		columnBitmasks.put("message", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private UADPartialEntry _escapedModel;

}