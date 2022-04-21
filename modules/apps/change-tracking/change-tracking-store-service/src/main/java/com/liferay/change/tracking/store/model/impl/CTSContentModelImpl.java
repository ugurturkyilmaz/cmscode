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

package com.liferay.change.tracking.store.model.impl;

import com.liferay.change.tracking.store.model.CTSContent;
import com.liferay.change.tracking.store.model.CTSContentDataBlobModel;
import com.liferay.change.tracking.store.model.CTSContentModel;
import com.liferay.change.tracking.store.service.CTSContentLocalServiceUtil;
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

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CTSContent service. Represents a row in the &quot;CTSContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CTSContentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CTSContentImpl}.
 * </p>
 *
 * @author Shuyang Zhou
 * @see CTSContentImpl
 * @generated
 */
public class CTSContentModelImpl
	extends BaseModelImpl<CTSContent> implements CTSContentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cts content model instance should use the <code>CTSContent</code> interface instead.
	 */
	public static final String TABLE_NAME = "CTSContent";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctCollectionId", Types.BIGINT},
		{"ctsContentId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"repositoryId", Types.BIGINT}, {"path_", Types.VARCHAR},
		{"version", Types.VARCHAR}, {"data_", Types.BLOB},
		{"size_", Types.BIGINT}, {"storeType", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctsContentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("repositoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("path_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("data_", Types.BLOB);
		TABLE_COLUMNS_MAP.put("size_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("storeType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CTSContent (mvccVersion LONG default 0 not null,ctCollectionId LONG default 0 not null,ctsContentId LONG not null,companyId LONG,repositoryId LONG,path_ VARCHAR(75) null,version VARCHAR(75) null,data_ BLOB,size_ LONG,storeType VARCHAR(75) null,primary key (ctsContentId, ctCollectionId))";

	public static final String TABLE_SQL_DROP = "drop table CTSContent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ctsContent.version DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CTSContent.version DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PATH_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long REPOSITORYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STORETYPE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VERSION_COLUMN_BITMASK = 16L;

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

	public CTSContentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ctsContentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCtsContentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ctsContentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CTSContent.class;
	}

	@Override
	public String getModelClassName() {
		return CTSContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CTSContent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CTSContent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTSContent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CTSContent)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CTSContent, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CTSContent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CTSContent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CTSContent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CTSContent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CTSContent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CTSContent.class.getClassLoader(), CTSContent.class,
			ModelWrapper.class);

		try {
			Constructor<CTSContent> constructor =
				(Constructor<CTSContent>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CTSContent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CTSContent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CTSContent, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CTSContent, Object>>();
		Map<String, BiConsumer<CTSContent, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CTSContent, ?>>();

		attributeGetterFunctions.put("mvccVersion", CTSContent::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CTSContent, Long>)CTSContent::setMvccVersion);
		attributeGetterFunctions.put(
			"ctCollectionId", CTSContent::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<CTSContent, Long>)CTSContent::setCtCollectionId);
		attributeGetterFunctions.put(
			"ctsContentId", CTSContent::getCtsContentId);
		attributeSetterBiConsumers.put(
			"ctsContentId",
			(BiConsumer<CTSContent, Long>)CTSContent::setCtsContentId);
		attributeGetterFunctions.put("companyId", CTSContent::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CTSContent, Long>)CTSContent::setCompanyId);
		attributeGetterFunctions.put(
			"repositoryId", CTSContent::getRepositoryId);
		attributeSetterBiConsumers.put(
			"repositoryId",
			(BiConsumer<CTSContent, Long>)CTSContent::setRepositoryId);
		attributeGetterFunctions.put("path", CTSContent::getPath);
		attributeSetterBiConsumers.put(
			"path", (BiConsumer<CTSContent, String>)CTSContent::setPath);
		attributeGetterFunctions.put("version", CTSContent::getVersion);
		attributeSetterBiConsumers.put(
			"version", (BiConsumer<CTSContent, String>)CTSContent::setVersion);
		attributeGetterFunctions.put("data", CTSContent::getData);
		attributeSetterBiConsumers.put(
			"data", (BiConsumer<CTSContent, Blob>)CTSContent::setData);
		attributeGetterFunctions.put("size", CTSContent::getSize);
		attributeSetterBiConsumers.put(
			"size", (BiConsumer<CTSContent, Long>)CTSContent::setSize);
		attributeGetterFunctions.put("storeType", CTSContent::getStoreType);
		attributeSetterBiConsumers.put(
			"storeType",
			(BiConsumer<CTSContent, String>)CTSContent::setStoreType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@Override
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ctCollectionId = ctCollectionId;
	}

	@Override
	public long getCtsContentId() {
		return _ctsContentId;
	}

	@Override
	public void setCtsContentId(long ctsContentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ctsContentId = ctsContentId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getRepositoryId() {
		return _repositoryId;
	}

	@Override
	public void setRepositoryId(long repositoryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_repositoryId = repositoryId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalRepositoryId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("repositoryId"));
	}

	@Override
	public String getPath() {
		if (_path == null) {
			return "";
		}
		else {
			return _path;
		}
	}

	@Override
	public void setPath(String path) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_path = path;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPath() {
		return getColumnOriginalValue("path_");
	}

	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_version = version;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalVersion() {
		return getColumnOriginalValue("version");
	}

	@Override
	public Blob getData() {
		if (_dataBlobModel == null) {
			try {
				_dataBlobModel = CTSContentLocalServiceUtil.getDataBlobModel(
					getPrimaryKey());
			}
			catch (Exception exception) {
			}
		}

		Blob blob = null;

		if (_dataBlobModel != null) {
			blob = _dataBlobModel.getDataBlob();
		}

		return blob;
	}

	@Override
	public void setData(Blob data) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		if (_dataBlobModel == null) {
			_dataBlobModel = new CTSContentDataBlobModel(getPrimaryKey(), data);
		}
		else {
			_dataBlobModel.setDataBlob(data);
		}
	}

	@Override
	public long getSize() {
		return _size;
	}

	@Override
	public void setSize(long size) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_size = size;
	}

	@Override
	public String getStoreType() {
		if (_storeType == null) {
			return "";
		}
		else {
			return _storeType;
		}
	}

	@Override
	public void setStoreType(String storeType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_storeType = storeType;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStoreType() {
		return getColumnOriginalValue("storeType");
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
			getCompanyId(), CTSContent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CTSContent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CTSContent>
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
		CTSContentImpl ctsContentImpl = new CTSContentImpl();

		ctsContentImpl.setMvccVersion(getMvccVersion());
		ctsContentImpl.setCtCollectionId(getCtCollectionId());
		ctsContentImpl.setCtsContentId(getCtsContentId());
		ctsContentImpl.setCompanyId(getCompanyId());
		ctsContentImpl.setRepositoryId(getRepositoryId());
		ctsContentImpl.setPath(getPath());
		ctsContentImpl.setVersion(getVersion());
		ctsContentImpl.setSize(getSize());
		ctsContentImpl.setStoreType(getStoreType());

		ctsContentImpl.resetOriginalValues();

		return ctsContentImpl;
	}

	@Override
	public CTSContent cloneWithOriginalValues() {
		CTSContentImpl ctsContentImpl = new CTSContentImpl();

		ctsContentImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		ctsContentImpl.setCtCollectionId(
			this.<Long>getColumnOriginalValue("ctCollectionId"));
		ctsContentImpl.setCtsContentId(
			this.<Long>getColumnOriginalValue("ctsContentId"));
		ctsContentImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		ctsContentImpl.setRepositoryId(
			this.<Long>getColumnOriginalValue("repositoryId"));
		ctsContentImpl.setPath(this.<String>getColumnOriginalValue("path_"));
		ctsContentImpl.setVersion(
			this.<String>getColumnOriginalValue("version"));
		ctsContentImpl.setSize(this.<Long>getColumnOriginalValue("size_"));
		ctsContentImpl.setStoreType(
			this.<String>getColumnOriginalValue("storeType"));

		return ctsContentImpl;
	}

	@Override
	public int compareTo(CTSContent ctsContent) {
		int value = 0;

		value = getVersion().compareTo(ctsContent.getVersion());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CTSContent)) {
			return false;
		}

		CTSContent ctsContent = (CTSContent)object;

		long primaryKey = ctsContent.getPrimaryKey();

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

		_dataBlobModel = null;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CTSContent> toCacheModel() {
		CTSContentCacheModel ctsContentCacheModel = new CTSContentCacheModel();

		ctsContentCacheModel.mvccVersion = getMvccVersion();

		ctsContentCacheModel.ctCollectionId = getCtCollectionId();

		ctsContentCacheModel.ctsContentId = getCtsContentId();

		ctsContentCacheModel.companyId = getCompanyId();

		ctsContentCacheModel.repositoryId = getRepositoryId();

		ctsContentCacheModel.path = getPath();

		String path = ctsContentCacheModel.path;

		if ((path != null) && (path.length() == 0)) {
			ctsContentCacheModel.path = null;
		}

		ctsContentCacheModel.version = getVersion();

		String version = ctsContentCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			ctsContentCacheModel.version = null;
		}

		ctsContentCacheModel.size = getSize();

		ctsContentCacheModel.storeType = getStoreType();

		String storeType = ctsContentCacheModel.storeType;

		if ((storeType != null) && (storeType.length() == 0)) {
			ctsContentCacheModel.storeType = null;
		}

		return ctsContentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{\"mvccVersion\": ");

		sb.append(getMvccVersion());

		sb.append(", \"ctCollectionId\": ");

		sb.append(getCtCollectionId());

		sb.append(", \"ctsContentId\": ");

		sb.append(getCtsContentId());

		sb.append(", \"companyId\": ");

		sb.append(getCompanyId());

		sb.append(", \"repositoryId\": ");

		sb.append(getRepositoryId());

		sb.append(", \"path\": ");

		sb.append("\"" + getPath() + "\"");

		sb.append(", \"version\": ");

		sb.append("\"" + getVersion() + "\"");

		sb.append(", \"size\": ");

		sb.append(getSize());

		sb.append(", \"storeType\": ");

		sb.append("\"" + getStoreType() + "\"");

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.change.tracking.store.model.CTSContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");

		sb.append(getMvccVersion());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ctCollectionId</column-name><column-value><![CDATA[");

		sb.append(getCtCollectionId());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ctsContentId</column-name><column-value><![CDATA[");

		sb.append(getCtsContentId());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");

		sb.append(getCompanyId());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");

		sb.append(getRepositoryId());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");

		sb.append(getPath());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");

		sb.append(getVersion());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");

		sb.append(getSize());

		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storeType</column-name><column-value><![CDATA[");

		sb.append(getStoreType());

		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CTSContent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _ctCollectionId;
	private long _ctsContentId;
	private long _companyId;
	private long _repositoryId;
	private String _path;
	private String _version;
	private CTSContentDataBlobModel _dataBlobModel;
	private long _size;
	private String _storeType;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CTSContent, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CTSContent)this);
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

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("ctCollectionId", _ctCollectionId);
		_columnOriginalValues.put("ctsContentId", _ctsContentId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("repositoryId", _repositoryId);
		_columnOriginalValues.put("path_", _path);
		_columnOriginalValues.put("version", _version);
		_columnOriginalValues.put("size_", _size);
		_columnOriginalValues.put("storeType", _storeType);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("path_", "path");
		attributeNames.put("data_", "data");
		attributeNames.put("size_", "size");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("ctCollectionId", 2L);

		columnBitmasks.put("ctsContentId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("repositoryId", 16L);

		columnBitmasks.put("path_", 32L);

		columnBitmasks.put("version", 64L);

		columnBitmasks.put("data_", 128L);

		columnBitmasks.put("size_", 256L);

		columnBitmasks.put("storeType", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CTSContent _escapedModel;

}