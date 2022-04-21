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

package com.liferay.portlet.exportimport.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.model.ExportImportConfiguration;
import com.liferay.exportimport.kernel.model.ExportImportConfigurationModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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
 * The base model implementation for the ExportImportConfiguration service. Represents a row in the &quot;ExportImportConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ExportImportConfigurationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExportImportConfigurationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExportImportConfigurationImpl
 * @generated
 */
@JSON(strict = true)
public class ExportImportConfigurationModelImpl
	extends BaseModelImpl<ExportImportConfiguration>
	implements ExportImportConfigurationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a export import configuration model instance should use the <code>ExportImportConfiguration</code> interface instead.
	 */
	public static final String TABLE_NAME = "ExportImportConfiguration";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"exportImportConfigurationId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"type_", Types.INTEGER}, {"settings_", Types.CLOB},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("exportImportConfigurationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("settings_", Types.CLOB);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ExportImportConfiguration (mvccVersion LONG default 0 not null,exportImportConfigurationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(200) null,description STRING null,type_ INTEGER,settings_ TEXT null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table ExportImportConfiguration";

	public static final String ORDER_BY_JPQL =
		" ORDER BY exportImportConfiguration.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ExportImportConfiguration.createDate ASC";

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
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.exportimport.kernel.model.ExportImportConfiguration"));

	public ExportImportConfigurationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _exportImportConfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExportImportConfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _exportImportConfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ExportImportConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ExportImportConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ExportImportConfiguration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ExportImportConfiguration, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExportImportConfiguration, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ExportImportConfiguration)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ExportImportConfiguration, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ExportImportConfiguration, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ExportImportConfiguration)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ExportImportConfiguration, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ExportImportConfiguration, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ExportImportConfiguration>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ExportImportConfiguration.class.getClassLoader(),
			ExportImportConfiguration.class, ModelWrapper.class);

		try {
			Constructor<ExportImportConfiguration> constructor =
				(Constructor<ExportImportConfiguration>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<ExportImportConfiguration, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ExportImportConfiguration, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<ExportImportConfiguration, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ExportImportConfiguration, Object>>();
		Map<String, BiConsumer<ExportImportConfiguration, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ExportImportConfiguration, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", ExportImportConfiguration::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<ExportImportConfiguration, Long>)
				ExportImportConfiguration::setMvccVersion);
		attributeGetterFunctions.put(
			"exportImportConfigurationId",
			ExportImportConfiguration::getExportImportConfigurationId);
		attributeSetterBiConsumers.put(
			"exportImportConfigurationId",
			(BiConsumer<ExportImportConfiguration, Long>)
				ExportImportConfiguration::setExportImportConfigurationId);
		attributeGetterFunctions.put(
			"groupId", ExportImportConfiguration::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ExportImportConfiguration, Long>)
				ExportImportConfiguration::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ExportImportConfiguration::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ExportImportConfiguration, Long>)
				ExportImportConfiguration::setCompanyId);
		attributeGetterFunctions.put(
			"userId", ExportImportConfiguration::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ExportImportConfiguration, Long>)
				ExportImportConfiguration::setUserId);
		attributeGetterFunctions.put(
			"userName", ExportImportConfiguration::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ExportImportConfiguration, String>)
				ExportImportConfiguration::setUserName);
		attributeGetterFunctions.put(
			"createDate", ExportImportConfiguration::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ExportImportConfiguration, Date>)
				ExportImportConfiguration::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ExportImportConfiguration::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ExportImportConfiguration, Date>)
				ExportImportConfiguration::setModifiedDate);
		attributeGetterFunctions.put(
			"name", ExportImportConfiguration::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<ExportImportConfiguration, String>)
				ExportImportConfiguration::setName);
		attributeGetterFunctions.put(
			"description", ExportImportConfiguration::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<ExportImportConfiguration, String>)
				ExportImportConfiguration::setDescription);
		attributeGetterFunctions.put(
			"type", ExportImportConfiguration::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<ExportImportConfiguration, Integer>)
				ExportImportConfiguration::setType);
		attributeGetterFunctions.put(
			"settings", ExportImportConfiguration::getSettings);
		attributeSetterBiConsumers.put(
			"settings",
			(BiConsumer<ExportImportConfiguration, String>)
				ExportImportConfiguration::setSettings);
		attributeGetterFunctions.put(
			"status", ExportImportConfiguration::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<ExportImportConfiguration, Integer>)
				ExportImportConfiguration::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", ExportImportConfiguration::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<ExportImportConfiguration, Long>)
				ExportImportConfiguration::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", ExportImportConfiguration::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<ExportImportConfiguration, String>)
				ExportImportConfiguration::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", ExportImportConfiguration::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<ExportImportConfiguration, Date>)
				ExportImportConfiguration::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getExportImportConfigurationId() {
		return _exportImportConfigurationId;
	}

	@Override
	public void setExportImportConfigurationId(
		long exportImportConfigurationId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_exportImportConfigurationId = exportImportConfigurationId;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalType() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("type_"));
	}

	@JSON
	@Override
	public String getSettings() {
		if (_settings == null) {
			return "";
		}
		else {
			return _settings;
		}
	}

	@Override
	public void setSettings(String settings) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_settings = settings;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException {

		if (!isInTrash()) {
			return null;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if (Validator.isNotNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException noSuchModelException) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler =
					com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
						getTrashHandler(
							trashHandler.getContainerModelClassName(
								containerModel.getContainerModelId()));

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(
					containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
			getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if ((trashHandler == null) ||
			Validator.isNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			return false;
		}

		try {
			ContainerModel containerModel =
				trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception exception) {
		}

		return false;
	}

	@Override
	public boolean isInTrashExplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isInTrashImplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
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
			getCompanyId(), ExportImportConfiguration.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ExportImportConfiguration toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ExportImportConfiguration>
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
		ExportImportConfigurationImpl exportImportConfigurationImpl =
			new ExportImportConfigurationImpl();

		exportImportConfigurationImpl.setMvccVersion(getMvccVersion());
		exportImportConfigurationImpl.setExportImportConfigurationId(
			getExportImportConfigurationId());
		exportImportConfigurationImpl.setGroupId(getGroupId());
		exportImportConfigurationImpl.setCompanyId(getCompanyId());
		exportImportConfigurationImpl.setUserId(getUserId());
		exportImportConfigurationImpl.setUserName(getUserName());
		exportImportConfigurationImpl.setCreateDate(getCreateDate());
		exportImportConfigurationImpl.setModifiedDate(getModifiedDate());
		exportImportConfigurationImpl.setName(getName());
		exportImportConfigurationImpl.setDescription(getDescription());
		exportImportConfigurationImpl.setType(getType());
		exportImportConfigurationImpl.setSettings(getSettings());
		exportImportConfigurationImpl.setStatus(getStatus());
		exportImportConfigurationImpl.setStatusByUserId(getStatusByUserId());
		exportImportConfigurationImpl.setStatusByUserName(
			getStatusByUserName());
		exportImportConfigurationImpl.setStatusDate(getStatusDate());

		exportImportConfigurationImpl.resetOriginalValues();

		return exportImportConfigurationImpl;
	}

	@Override
	public ExportImportConfiguration cloneWithOriginalValues() {
		ExportImportConfigurationImpl exportImportConfigurationImpl =
			new ExportImportConfigurationImpl();

		exportImportConfigurationImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		exportImportConfigurationImpl.setExportImportConfigurationId(
			this.<Long>getColumnOriginalValue("exportImportConfigurationId"));
		exportImportConfigurationImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		exportImportConfigurationImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		exportImportConfigurationImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		exportImportConfigurationImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		exportImportConfigurationImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		exportImportConfigurationImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		exportImportConfigurationImpl.setName(
			this.<String>getColumnOriginalValue("name"));
		exportImportConfigurationImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		exportImportConfigurationImpl.setType(
			this.<Integer>getColumnOriginalValue("type_"));
		exportImportConfigurationImpl.setSettings(
			this.<String>getColumnOriginalValue("settings_"));
		exportImportConfigurationImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		exportImportConfigurationImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		exportImportConfigurationImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		exportImportConfigurationImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));

		return exportImportConfigurationImpl;
	}

	@Override
	public int compareTo(ExportImportConfiguration exportImportConfiguration) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), exportImportConfiguration.getCreateDate());

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

		if (!(object instanceof ExportImportConfiguration)) {
			return false;
		}

		ExportImportConfiguration exportImportConfiguration =
			(ExportImportConfiguration)object;

		long primaryKey = exportImportConfiguration.getPrimaryKey();

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

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ExportImportConfiguration> toCacheModel() {
		ExportImportConfigurationCacheModel
			exportImportConfigurationCacheModel =
				new ExportImportConfigurationCacheModel();

		exportImportConfigurationCacheModel.mvccVersion = getMvccVersion();

		exportImportConfigurationCacheModel.exportImportConfigurationId =
			getExportImportConfigurationId();

		exportImportConfigurationCacheModel.groupId = getGroupId();

		exportImportConfigurationCacheModel.companyId = getCompanyId();

		exportImportConfigurationCacheModel.userId = getUserId();

		exportImportConfigurationCacheModel.userName = getUserName();

		String userName = exportImportConfigurationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			exportImportConfigurationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			exportImportConfigurationCacheModel.createDate =
				createDate.getTime();
		}
		else {
			exportImportConfigurationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			exportImportConfigurationCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			exportImportConfigurationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		exportImportConfigurationCacheModel.name = getName();

		String name = exportImportConfigurationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			exportImportConfigurationCacheModel.name = null;
		}

		exportImportConfigurationCacheModel.description = getDescription();

		String description = exportImportConfigurationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			exportImportConfigurationCacheModel.description = null;
		}

		exportImportConfigurationCacheModel.type = getType();

		exportImportConfigurationCacheModel.settings = getSettings();

		String settings = exportImportConfigurationCacheModel.settings;

		if ((settings != null) && (settings.length() == 0)) {
			exportImportConfigurationCacheModel.settings = null;
		}

		exportImportConfigurationCacheModel.status = getStatus();

		exportImportConfigurationCacheModel.statusByUserId =
			getStatusByUserId();

		exportImportConfigurationCacheModel.statusByUserName =
			getStatusByUserName();

		String statusByUserName =
			exportImportConfigurationCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			exportImportConfigurationCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			exportImportConfigurationCacheModel.statusDate =
				statusDate.getTime();
		}
		else {
			exportImportConfigurationCacheModel.statusDate = Long.MIN_VALUE;
		}

		return exportImportConfigurationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ExportImportConfiguration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ExportImportConfiguration, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExportImportConfiguration, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ExportImportConfiguration)this);

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
		Map<String, Function<ExportImportConfiguration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ExportImportConfiguration, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExportImportConfiguration, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((ExportImportConfiguration)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, ExportImportConfiguration>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _exportImportConfigurationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _description;
	private int _type;
	private String _settings;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ExportImportConfiguration, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ExportImportConfiguration)this);
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
		_columnOriginalValues.put(
			"exportImportConfigurationId", _exportImportConfigurationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("type_", _type);
		_columnOriginalValues.put("settings_", _settings);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("type_", "type");
		attributeNames.put("settings_", "settings");

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

		columnBitmasks.put("exportImportConfigurationId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("description", 512L);

		columnBitmasks.put("type_", 1024L);

		columnBitmasks.put("settings_", 2048L);

		columnBitmasks.put("status", 4096L);

		columnBitmasks.put("statusByUserId", 8192L);

		columnBitmasks.put("statusByUserName", 16384L);

		columnBitmasks.put("statusDate", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ExportImportConfiguration _escapedModel;

}