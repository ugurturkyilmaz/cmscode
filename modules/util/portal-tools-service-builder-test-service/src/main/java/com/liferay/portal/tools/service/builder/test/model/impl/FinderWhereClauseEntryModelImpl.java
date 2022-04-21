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
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.service.builder.test.model.FinderWhereClauseEntry;
import com.liferay.portal.tools.service.builder.test.model.FinderWhereClauseEntryModel;

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
 * The base model implementation for the FinderWhereClauseEntry service. Represents a row in the &quot;FinderWhereClauseEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FinderWhereClauseEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FinderWhereClauseEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FinderWhereClauseEntryImpl
 * @generated
 */
public class FinderWhereClauseEntryModelImpl
	extends BaseModelImpl<FinderWhereClauseEntry>
	implements FinderWhereClauseEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a finder where clause entry model instance should use the <code>FinderWhereClauseEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "FinderWhereClauseEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"finderWhereClauseEntryId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"nickname", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("finderWhereClauseEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nickname", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FinderWhereClauseEntry (finderWhereClauseEntryId LONG not null primary key,name VARCHAR(75) null,nickname VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table FinderWhereClauseEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY finderWhereClauseEntry.finderWhereClauseEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FinderWhereClauseEntry.finderWhereClauseEntryId ASC";

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
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FINDERWHERECLAUSEENTRYID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.FinderWhereClauseEntry"));

	public FinderWhereClauseEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _finderWhereClauseEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFinderWhereClauseEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _finderWhereClauseEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FinderWhereClauseEntry.class;
	}

	@Override
	public String getModelClassName() {
		return FinderWhereClauseEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FinderWhereClauseEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FinderWhereClauseEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FinderWhereClauseEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FinderWhereClauseEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FinderWhereClauseEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FinderWhereClauseEntry, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FinderWhereClauseEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FinderWhereClauseEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FinderWhereClauseEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, FinderWhereClauseEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FinderWhereClauseEntry.class.getClassLoader(),
			FinderWhereClauseEntry.class, ModelWrapper.class);

		try {
			Constructor<FinderWhereClauseEntry> constructor =
				(Constructor<FinderWhereClauseEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<FinderWhereClauseEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FinderWhereClauseEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FinderWhereClauseEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<FinderWhereClauseEntry, Object>>();
		Map<String, BiConsumer<FinderWhereClauseEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<FinderWhereClauseEntry, ?>>();

		attributeGetterFunctions.put(
			"finderWhereClauseEntryId",
			FinderWhereClauseEntry::getFinderWhereClauseEntryId);
		attributeSetterBiConsumers.put(
			"finderWhereClauseEntryId",
			(BiConsumer<FinderWhereClauseEntry, Long>)
				FinderWhereClauseEntry::setFinderWhereClauseEntryId);
		attributeGetterFunctions.put("name", FinderWhereClauseEntry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<FinderWhereClauseEntry, String>)
				FinderWhereClauseEntry::setName);
		attributeGetterFunctions.put(
			"nickname", FinderWhereClauseEntry::getNickname);
		attributeSetterBiConsumers.put(
			"nickname",
			(BiConsumer<FinderWhereClauseEntry, String>)
				FinderWhereClauseEntry::setNickname);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getFinderWhereClauseEntryId() {
		return _finderWhereClauseEntryId;
	}

	@Override
	public void setFinderWhereClauseEntryId(long finderWhereClauseEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_finderWhereClauseEntryId = finderWhereClauseEntryId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@Override
	public String getNickname() {
		if (_nickname == null) {
			return "";
		}
		else {
			return _nickname;
		}
	}

	@Override
	public void setNickname(String nickname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nickname = nickname;
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
			0, FinderWhereClauseEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FinderWhereClauseEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FinderWhereClauseEntry>
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
		FinderWhereClauseEntryImpl finderWhereClauseEntryImpl =
			new FinderWhereClauseEntryImpl();

		finderWhereClauseEntryImpl.setFinderWhereClauseEntryId(
			getFinderWhereClauseEntryId());
		finderWhereClauseEntryImpl.setName(getName());
		finderWhereClauseEntryImpl.setNickname(getNickname());

		finderWhereClauseEntryImpl.resetOriginalValues();

		return finderWhereClauseEntryImpl;
	}

	@Override
	public FinderWhereClauseEntry cloneWithOriginalValues() {
		FinderWhereClauseEntryImpl finderWhereClauseEntryImpl =
			new FinderWhereClauseEntryImpl();

		finderWhereClauseEntryImpl.setFinderWhereClauseEntryId(
			this.<Long>getColumnOriginalValue("finderWhereClauseEntryId"));
		finderWhereClauseEntryImpl.setName(
			this.<String>getColumnOriginalValue("name"));
		finderWhereClauseEntryImpl.setNickname(
			this.<String>getColumnOriginalValue("nickname"));

		return finderWhereClauseEntryImpl;
	}

	@Override
	public int compareTo(FinderWhereClauseEntry finderWhereClauseEntry) {
		long primaryKey = finderWhereClauseEntry.getPrimaryKey();

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

		if (!(object instanceof FinderWhereClauseEntry)) {
			return false;
		}

		FinderWhereClauseEntry finderWhereClauseEntry =
			(FinderWhereClauseEntry)object;

		long primaryKey = finderWhereClauseEntry.getPrimaryKey();

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
	public CacheModel<FinderWhereClauseEntry> toCacheModel() {
		FinderWhereClauseEntryCacheModel finderWhereClauseEntryCacheModel =
			new FinderWhereClauseEntryCacheModel();

		finderWhereClauseEntryCacheModel.finderWhereClauseEntryId =
			getFinderWhereClauseEntryId();

		finderWhereClauseEntryCacheModel.name = getName();

		String name = finderWhereClauseEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			finderWhereClauseEntryCacheModel.name = null;
		}

		finderWhereClauseEntryCacheModel.nickname = getNickname();

		String nickname = finderWhereClauseEntryCacheModel.nickname;

		if ((nickname != null) && (nickname.length() == 0)) {
			finderWhereClauseEntryCacheModel.nickname = null;
		}

		return finderWhereClauseEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FinderWhereClauseEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FinderWhereClauseEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FinderWhereClauseEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(FinderWhereClauseEntry)this);

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
		Map<String, Function<FinderWhereClauseEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FinderWhereClauseEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FinderWhereClauseEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((FinderWhereClauseEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FinderWhereClauseEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _finderWhereClauseEntryId;
	private String _name;
	private String _nickname;

	public <T> T getColumnValue(String columnName) {
		Function<FinderWhereClauseEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FinderWhereClauseEntry)this);
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

		_columnOriginalValues.put(
			"finderWhereClauseEntryId", _finderWhereClauseEntryId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("nickname", _nickname);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("finderWhereClauseEntryId", 1L);

		columnBitmasks.put("name", 2L);

		columnBitmasks.put("nickname", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FinderWhereClauseEntry _escapedModel;

}