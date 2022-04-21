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
import com.liferay.portal.tools.service.builder.test.model.NestedSetsTreeEntry;
import com.liferay.portal.tools.service.builder.test.model.NestedSetsTreeEntryModel;

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
 * The base model implementation for the NestedSetsTreeEntry service. Represents a row in the &quot;NestedSetsTreeEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NestedSetsTreeEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NestedSetsTreeEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NestedSetsTreeEntryImpl
 * @generated
 */
public class NestedSetsTreeEntryModelImpl
	extends BaseModelImpl<NestedSetsTreeEntry>
	implements NestedSetsTreeEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a nested sets tree entry model instance should use the <code>NestedSetsTreeEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "NestedSetsTreeEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"nestedSetsTreeEntryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"parentNestedSetsTreeEntryId", Types.BIGINT},
		{"leftNestedSetsTreeEntryId", Types.BIGINT},
		{"rightNestedSetsTreeEntryId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("nestedSetsTreeEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("parentNestedSetsTreeEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("leftNestedSetsTreeEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rightNestedSetsTreeEntryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table NestedSetsTreeEntry (nestedSetsTreeEntryId LONG not null primary key,groupId LONG,parentNestedSetsTreeEntryId LONG,leftNestedSetsTreeEntryId LONG,rightNestedSetsTreeEntryId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table NestedSetsTreeEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY nestedSetsTreeEntry.nestedSetsTreeEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY NestedSetsTreeEntry.nestedSetsTreeEntryId ASC";

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
	public static final long NESTEDSETSTREEENTRYID_COLUMN_BITMASK = 1L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.NestedSetsTreeEntry"));

	public NestedSetsTreeEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _nestedSetsTreeEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNestedSetsTreeEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _nestedSetsTreeEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NestedSetsTreeEntry.class;
	}

	@Override
	public String getModelClassName() {
		return NestedSetsTreeEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<NestedSetsTreeEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<NestedSetsTreeEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NestedSetsTreeEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((NestedSetsTreeEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<NestedSetsTreeEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<NestedSetsTreeEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(NestedSetsTreeEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<NestedSetsTreeEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<NestedSetsTreeEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, NestedSetsTreeEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			NestedSetsTreeEntry.class.getClassLoader(),
			NestedSetsTreeEntry.class, ModelWrapper.class);

		try {
			Constructor<NestedSetsTreeEntry> constructor =
				(Constructor<NestedSetsTreeEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<NestedSetsTreeEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<NestedSetsTreeEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<NestedSetsTreeEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<NestedSetsTreeEntry, Object>>();
		Map<String, BiConsumer<NestedSetsTreeEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<NestedSetsTreeEntry, ?>>();

		attributeGetterFunctions.put(
			"nestedSetsTreeEntryId",
			NestedSetsTreeEntry::getNestedSetsTreeEntryId);
		attributeSetterBiConsumers.put(
			"nestedSetsTreeEntryId",
			(BiConsumer<NestedSetsTreeEntry, Long>)
				NestedSetsTreeEntry::setNestedSetsTreeEntryId);
		attributeGetterFunctions.put(
			"groupId", NestedSetsTreeEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<NestedSetsTreeEntry, Long>)
				NestedSetsTreeEntry::setGroupId);
		attributeGetterFunctions.put(
			"parentNestedSetsTreeEntryId",
			NestedSetsTreeEntry::getParentNestedSetsTreeEntryId);
		attributeSetterBiConsumers.put(
			"parentNestedSetsTreeEntryId",
			(BiConsumer<NestedSetsTreeEntry, Long>)
				NestedSetsTreeEntry::setParentNestedSetsTreeEntryId);
		attributeGetterFunctions.put(
			"leftNestedSetsTreeEntryId",
			NestedSetsTreeEntry::getLeftNestedSetsTreeEntryId);
		attributeSetterBiConsumers.put(
			"leftNestedSetsTreeEntryId",
			(BiConsumer<NestedSetsTreeEntry, Long>)
				NestedSetsTreeEntry::setLeftNestedSetsTreeEntryId);
		attributeGetterFunctions.put(
			"rightNestedSetsTreeEntryId",
			NestedSetsTreeEntry::getRightNestedSetsTreeEntryId);
		attributeSetterBiConsumers.put(
			"rightNestedSetsTreeEntryId",
			(BiConsumer<NestedSetsTreeEntry, Long>)
				NestedSetsTreeEntry::setRightNestedSetsTreeEntryId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getNestedSetsTreeEntryId() {
		return _nestedSetsTreeEntryId;
	}

	@Override
	public void setNestedSetsTreeEntryId(long nestedSetsTreeEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nestedSetsTreeEntryId = nestedSetsTreeEntryId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@Override
	public long getParentNestedSetsTreeEntryId() {
		return _parentNestedSetsTreeEntryId;
	}

	@Override
	public void setParentNestedSetsTreeEntryId(
		long parentNestedSetsTreeEntryId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parentNestedSetsTreeEntryId = parentNestedSetsTreeEntryId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalParentNestedSetsTreeEntryId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("parentNestedSetsTreeEntryId"));
	}

	@Override
	public long getLeftNestedSetsTreeEntryId() {
		return _leftNestedSetsTreeEntryId;
	}

	@Override
	public void setLeftNestedSetsTreeEntryId(long leftNestedSetsTreeEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_leftNestedSetsTreeEntryId = leftNestedSetsTreeEntryId;
	}

	@Override
	public long getRightNestedSetsTreeEntryId() {
		return _rightNestedSetsTreeEntryId;
	}

	@Override
	public void setRightNestedSetsTreeEntryId(long rightNestedSetsTreeEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rightNestedSetsTreeEntryId = rightNestedSetsTreeEntryId;
	}

	public long getNestedSetsTreeNodeLeft() {
		return _leftNestedSetsTreeEntryId;
	}

	public long getNestedSetsTreeNodeRight() {
		return _rightNestedSetsTreeEntryId;
	}

	public long getNestedSetsTreeNodeScopeId() {
		return _groupId;
	}

	public void setNestedSetsTreeNodeLeft(long nestedSetsTreeNodeLeft) {
		_leftNestedSetsTreeEntryId = nestedSetsTreeNodeLeft;
	}

	public void setNestedSetsTreeNodeRight(long nestedSetsTreeNodeRight) {
		_rightNestedSetsTreeEntryId = nestedSetsTreeNodeRight;
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
			0, NestedSetsTreeEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NestedSetsTreeEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, NestedSetsTreeEntry>
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
		NestedSetsTreeEntryImpl nestedSetsTreeEntryImpl =
			new NestedSetsTreeEntryImpl();

		nestedSetsTreeEntryImpl.setNestedSetsTreeEntryId(
			getNestedSetsTreeEntryId());
		nestedSetsTreeEntryImpl.setGroupId(getGroupId());
		nestedSetsTreeEntryImpl.setParentNestedSetsTreeEntryId(
			getParentNestedSetsTreeEntryId());
		nestedSetsTreeEntryImpl.setLeftNestedSetsTreeEntryId(
			getLeftNestedSetsTreeEntryId());
		nestedSetsTreeEntryImpl.setRightNestedSetsTreeEntryId(
			getRightNestedSetsTreeEntryId());

		nestedSetsTreeEntryImpl.resetOriginalValues();

		return nestedSetsTreeEntryImpl;
	}

	@Override
	public NestedSetsTreeEntry cloneWithOriginalValues() {
		NestedSetsTreeEntryImpl nestedSetsTreeEntryImpl =
			new NestedSetsTreeEntryImpl();

		nestedSetsTreeEntryImpl.setNestedSetsTreeEntryId(
			this.<Long>getColumnOriginalValue("nestedSetsTreeEntryId"));
		nestedSetsTreeEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		nestedSetsTreeEntryImpl.setParentNestedSetsTreeEntryId(
			this.<Long>getColumnOriginalValue("parentNestedSetsTreeEntryId"));
		nestedSetsTreeEntryImpl.setLeftNestedSetsTreeEntryId(
			this.<Long>getColumnOriginalValue("leftNestedSetsTreeEntryId"));
		nestedSetsTreeEntryImpl.setRightNestedSetsTreeEntryId(
			this.<Long>getColumnOriginalValue("rightNestedSetsTreeEntryId"));

		return nestedSetsTreeEntryImpl;
	}

	@Override
	public int compareTo(NestedSetsTreeEntry nestedSetsTreeEntry) {
		long primaryKey = nestedSetsTreeEntry.getPrimaryKey();

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

		if (!(object instanceof NestedSetsTreeEntry)) {
			return false;
		}

		NestedSetsTreeEntry nestedSetsTreeEntry = (NestedSetsTreeEntry)object;

		long primaryKey = nestedSetsTreeEntry.getPrimaryKey();

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
	public CacheModel<NestedSetsTreeEntry> toCacheModel() {
		NestedSetsTreeEntryCacheModel nestedSetsTreeEntryCacheModel =
			new NestedSetsTreeEntryCacheModel();

		nestedSetsTreeEntryCacheModel.nestedSetsTreeEntryId =
			getNestedSetsTreeEntryId();

		nestedSetsTreeEntryCacheModel.groupId = getGroupId();

		nestedSetsTreeEntryCacheModel.parentNestedSetsTreeEntryId =
			getParentNestedSetsTreeEntryId();

		nestedSetsTreeEntryCacheModel.leftNestedSetsTreeEntryId =
			getLeftNestedSetsTreeEntryId();

		nestedSetsTreeEntryCacheModel.rightNestedSetsTreeEntryId =
			getRightNestedSetsTreeEntryId();

		return nestedSetsTreeEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<NestedSetsTreeEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<NestedSetsTreeEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NestedSetsTreeEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(NestedSetsTreeEntry)this);

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
		Map<String, Function<NestedSetsTreeEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<NestedSetsTreeEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NestedSetsTreeEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((NestedSetsTreeEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, NestedSetsTreeEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _nestedSetsTreeEntryId;
	private long _groupId;
	private long _parentNestedSetsTreeEntryId;
	private long _leftNestedSetsTreeEntryId;
	private long _rightNestedSetsTreeEntryId;

	public <T> T getColumnValue(String columnName) {
		Function<NestedSetsTreeEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((NestedSetsTreeEntry)this);
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
			"nestedSetsTreeEntryId", _nestedSetsTreeEntryId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put(
			"parentNestedSetsTreeEntryId", _parentNestedSetsTreeEntryId);
		_columnOriginalValues.put(
			"leftNestedSetsTreeEntryId", _leftNestedSetsTreeEntryId);
		_columnOriginalValues.put(
			"rightNestedSetsTreeEntryId", _rightNestedSetsTreeEntryId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("nestedSetsTreeEntryId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("parentNestedSetsTreeEntryId", 4L);

		columnBitmasks.put("leftNestedSetsTreeEntryId", 8L);

		columnBitmasks.put("rightNestedSetsTreeEntryId", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private NestedSetsTreeEntry _escapedModel;

}