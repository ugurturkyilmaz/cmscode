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

package com.liferay.html.preview.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.html.preview.model.HtmlPreviewEntry;
import com.liferay.html.preview.model.HtmlPreviewEntryModel;
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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the HtmlPreviewEntry service. Represents a row in the &quot;HtmlPreviewEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>HtmlPreviewEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HtmlPreviewEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HtmlPreviewEntryImpl
 * @generated
 */
public class HtmlPreviewEntryModelImpl
	extends BaseModelImpl<HtmlPreviewEntry> implements HtmlPreviewEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a html preview entry model instance should use the <code>HtmlPreviewEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "HtmlPreviewEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"htmlPreviewEntryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"classNameId", Types.BIGINT},
		{"classPK", Types.BIGINT}, {"fileEntryId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("htmlPreviewEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table HtmlPreviewEntry (htmlPreviewEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,fileEntryId LONG)";

	public static final String TABLE_SQL_DROP = "drop table HtmlPreviewEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY htmlPreviewEntry.htmlPreviewEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY HtmlPreviewEntry.htmlPreviewEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long HTMLPREVIEWENTRYID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public HtmlPreviewEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _htmlPreviewEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHtmlPreviewEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _htmlPreviewEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return HtmlPreviewEntry.class;
	}

	@Override
	public String getModelClassName() {
		return HtmlPreviewEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<HtmlPreviewEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<HtmlPreviewEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<HtmlPreviewEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((HtmlPreviewEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<HtmlPreviewEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<HtmlPreviewEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(HtmlPreviewEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<HtmlPreviewEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<HtmlPreviewEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, HtmlPreviewEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			HtmlPreviewEntry.class.getClassLoader(), HtmlPreviewEntry.class,
			ModelWrapper.class);

		try {
			Constructor<HtmlPreviewEntry> constructor =
				(Constructor<HtmlPreviewEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<HtmlPreviewEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<HtmlPreviewEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<HtmlPreviewEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<HtmlPreviewEntry, Object>>();
		Map<String, BiConsumer<HtmlPreviewEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<HtmlPreviewEntry, ?>>();

		attributeGetterFunctions.put(
			"htmlPreviewEntryId", HtmlPreviewEntry::getHtmlPreviewEntryId);
		attributeSetterBiConsumers.put(
			"htmlPreviewEntryId",
			(BiConsumer<HtmlPreviewEntry, Long>)
				HtmlPreviewEntry::setHtmlPreviewEntryId);
		attributeGetterFunctions.put("groupId", HtmlPreviewEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<HtmlPreviewEntry, Long>)HtmlPreviewEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", HtmlPreviewEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<HtmlPreviewEntry, Long>)HtmlPreviewEntry::setCompanyId);
		attributeGetterFunctions.put("userId", HtmlPreviewEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<HtmlPreviewEntry, Long>)HtmlPreviewEntry::setUserId);
		attributeGetterFunctions.put("userName", HtmlPreviewEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<HtmlPreviewEntry, String>)
				HtmlPreviewEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", HtmlPreviewEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<HtmlPreviewEntry, Date>)
				HtmlPreviewEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", HtmlPreviewEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<HtmlPreviewEntry, Date>)
				HtmlPreviewEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"classNameId", HtmlPreviewEntry::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<HtmlPreviewEntry, Long>)
				HtmlPreviewEntry::setClassNameId);
		attributeGetterFunctions.put("classPK", HtmlPreviewEntry::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<HtmlPreviewEntry, Long>)HtmlPreviewEntry::setClassPK);
		attributeGetterFunctions.put(
			"fileEntryId", HtmlPreviewEntry::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<HtmlPreviewEntry, Long>)
				HtmlPreviewEntry::setFileEntryId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getHtmlPreviewEntryId() {
		return _htmlPreviewEntryId;
	}

	@Override
	public void setHtmlPreviewEntryId(long htmlPreviewEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_htmlPreviewEntryId = htmlPreviewEntryId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classNameId = classNameId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassNameId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("classNameId"));
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("classPK"));
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileEntryId = fileEntryId;
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
			getCompanyId(), HtmlPreviewEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public HtmlPreviewEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, HtmlPreviewEntry>
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
		HtmlPreviewEntryImpl htmlPreviewEntryImpl = new HtmlPreviewEntryImpl();

		htmlPreviewEntryImpl.setHtmlPreviewEntryId(getHtmlPreviewEntryId());
		htmlPreviewEntryImpl.setGroupId(getGroupId());
		htmlPreviewEntryImpl.setCompanyId(getCompanyId());
		htmlPreviewEntryImpl.setUserId(getUserId());
		htmlPreviewEntryImpl.setUserName(getUserName());
		htmlPreviewEntryImpl.setCreateDate(getCreateDate());
		htmlPreviewEntryImpl.setModifiedDate(getModifiedDate());
		htmlPreviewEntryImpl.setClassNameId(getClassNameId());
		htmlPreviewEntryImpl.setClassPK(getClassPK());
		htmlPreviewEntryImpl.setFileEntryId(getFileEntryId());

		htmlPreviewEntryImpl.resetOriginalValues();

		return htmlPreviewEntryImpl;
	}

	@Override
	public HtmlPreviewEntry cloneWithOriginalValues() {
		HtmlPreviewEntryImpl htmlPreviewEntryImpl = new HtmlPreviewEntryImpl();

		htmlPreviewEntryImpl.setHtmlPreviewEntryId(
			this.<Long>getColumnOriginalValue("htmlPreviewEntryId"));
		htmlPreviewEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		htmlPreviewEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		htmlPreviewEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		htmlPreviewEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		htmlPreviewEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		htmlPreviewEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		htmlPreviewEntryImpl.setClassNameId(
			this.<Long>getColumnOriginalValue("classNameId"));
		htmlPreviewEntryImpl.setClassPK(
			this.<Long>getColumnOriginalValue("classPK"));
		htmlPreviewEntryImpl.setFileEntryId(
			this.<Long>getColumnOriginalValue("fileEntryId"));

		return htmlPreviewEntryImpl;
	}

	@Override
	public int compareTo(HtmlPreviewEntry htmlPreviewEntry) {
		long primaryKey = htmlPreviewEntry.getPrimaryKey();

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

		if (!(object instanceof HtmlPreviewEntry)) {
			return false;
		}

		HtmlPreviewEntry htmlPreviewEntry = (HtmlPreviewEntry)object;

		long primaryKey = htmlPreviewEntry.getPrimaryKey();

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
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<HtmlPreviewEntry> toCacheModel() {
		HtmlPreviewEntryCacheModel htmlPreviewEntryCacheModel =
			new HtmlPreviewEntryCacheModel();

		htmlPreviewEntryCacheModel.htmlPreviewEntryId = getHtmlPreviewEntryId();

		htmlPreviewEntryCacheModel.groupId = getGroupId();

		htmlPreviewEntryCacheModel.companyId = getCompanyId();

		htmlPreviewEntryCacheModel.userId = getUserId();

		htmlPreviewEntryCacheModel.userName = getUserName();

		String userName = htmlPreviewEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			htmlPreviewEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			htmlPreviewEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			htmlPreviewEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			htmlPreviewEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			htmlPreviewEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		htmlPreviewEntryCacheModel.classNameId = getClassNameId();

		htmlPreviewEntryCacheModel.classPK = getClassPK();

		htmlPreviewEntryCacheModel.fileEntryId = getFileEntryId();

		return htmlPreviewEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<HtmlPreviewEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<HtmlPreviewEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<HtmlPreviewEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(HtmlPreviewEntry)this);

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
		Map<String, Function<HtmlPreviewEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<HtmlPreviewEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<HtmlPreviewEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((HtmlPreviewEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, HtmlPreviewEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _htmlPreviewEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _fileEntryId;

	public <T> T getColumnValue(String columnName) {
		Function<HtmlPreviewEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((HtmlPreviewEntry)this);
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

		_columnOriginalValues.put("htmlPreviewEntryId", _htmlPreviewEntryId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("classNameId", _classNameId);
		_columnOriginalValues.put("classPK", _classPK);
		_columnOriginalValues.put("fileEntryId", _fileEntryId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("htmlPreviewEntryId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("classNameId", 128L);

		columnBitmasks.put("classPK", 256L);

		columnBitmasks.put("fileEntryId", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private HtmlPreviewEntry _escapedModel;

}