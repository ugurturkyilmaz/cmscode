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

package com.liferay.commerce.inventory.model.impl;

import com.liferay.commerce.inventory.model.CommerceInventoryReplenishmentItem;
import com.liferay.commerce.inventory.model.CommerceInventoryReplenishmentItemModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

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
 * The base model implementation for the CommerceInventoryReplenishmentItem service. Represents a row in the &quot;CIReplenishmentItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceInventoryReplenishmentItemModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceInventoryReplenishmentItemImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceInventoryReplenishmentItemImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceInventoryReplenishmentItemModelImpl
	extends BaseModelImpl<CommerceInventoryReplenishmentItem>
	implements CommerceInventoryReplenishmentItemModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce inventory replenishment item model instance should use the <code>CommerceInventoryReplenishmentItem</code> interface instead.
	 */
	public static final String TABLE_NAME = "CIReplenishmentItem";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"CIReplenishmentItemId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"commerceInventoryWarehouseId", Types.BIGINT}, {"sku", Types.VARCHAR},
		{"availabilityDate", Types.TIMESTAMP}, {"quantity", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CIReplenishmentItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceInventoryWarehouseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sku", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("availabilityDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CIReplenishmentItem (mvccVersion LONG default 0 not null,CIReplenishmentItemId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceInventoryWarehouseId LONG,sku VARCHAR(75) null,availabilityDate DATE null,quantity INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table CIReplenishmentItem";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceInventoryReplenishmentItem.commerceInventoryReplenishmentItemId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CIReplenishmentItem.CIReplenishmentItemId ASC";

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
	public static final long AVAILABILITYDATE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMMERCEINVENTORYWAREHOUSEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SKU_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long
		COMMERCEINVENTORYREPLENISHMENTITEMID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.inventory.model.CommerceInventoryReplenishmentItem"));

	public CommerceInventoryReplenishmentItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceInventoryReplenishmentItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceInventoryReplenishmentItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceInventoryReplenishmentItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceInventoryReplenishmentItem.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceInventoryReplenishmentItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceInventoryReplenishmentItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String, Function<CommerceInventoryReplenishmentItem, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryReplenishmentItem, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceInventoryReplenishmentItem)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceInventoryReplenishmentItem, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceInventoryReplenishmentItem, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceInventoryReplenishmentItem)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceInventoryReplenishmentItem, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceInventoryReplenishmentItem, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function
		<InvocationHandler, CommerceInventoryReplenishmentItem>
			_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceInventoryReplenishmentItem.class.getClassLoader(),
			CommerceInventoryReplenishmentItem.class, ModelWrapper.class);

		try {
			Constructor<CommerceInventoryReplenishmentItem> constructor =
				(Constructor<CommerceInventoryReplenishmentItem>)
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
		<String, Function<CommerceInventoryReplenishmentItem, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceInventoryReplenishmentItem, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceInventoryReplenishmentItem, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<CommerceInventoryReplenishmentItem, Object>>();
		Map<String, BiConsumer<CommerceInventoryReplenishmentItem, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String,
					 BiConsumer<CommerceInventoryReplenishmentItem, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CommerceInventoryReplenishmentItem::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CommerceInventoryReplenishmentItem, Long>)
				CommerceInventoryReplenishmentItem::setMvccVersion);
		attributeGetterFunctions.put(
			"commerceInventoryReplenishmentItemId",
			CommerceInventoryReplenishmentItem::
				getCommerceInventoryReplenishmentItemId);
		attributeSetterBiConsumers.put(
			"commerceInventoryReplenishmentItemId",
			(BiConsumer<CommerceInventoryReplenishmentItem, Long>)
				CommerceInventoryReplenishmentItem::
					setCommerceInventoryReplenishmentItemId);
		attributeGetterFunctions.put(
			"companyId", CommerceInventoryReplenishmentItem::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceInventoryReplenishmentItem, Long>)
				CommerceInventoryReplenishmentItem::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceInventoryReplenishmentItem::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceInventoryReplenishmentItem, Long>)
				CommerceInventoryReplenishmentItem::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceInventoryReplenishmentItem::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceInventoryReplenishmentItem, String>)
				CommerceInventoryReplenishmentItem::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceInventoryReplenishmentItem::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceInventoryReplenishmentItem, Date>)
				CommerceInventoryReplenishmentItem::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate",
			CommerceInventoryReplenishmentItem::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceInventoryReplenishmentItem, Date>)
				CommerceInventoryReplenishmentItem::setModifiedDate);
		attributeGetterFunctions.put(
			"commerceInventoryWarehouseId",
			CommerceInventoryReplenishmentItem::
				getCommerceInventoryWarehouseId);
		attributeSetterBiConsumers.put(
			"commerceInventoryWarehouseId",
			(BiConsumer<CommerceInventoryReplenishmentItem, Long>)
				CommerceInventoryReplenishmentItem::
					setCommerceInventoryWarehouseId);
		attributeGetterFunctions.put(
			"sku", CommerceInventoryReplenishmentItem::getSku);
		attributeSetterBiConsumers.put(
			"sku",
			(BiConsumer<CommerceInventoryReplenishmentItem, String>)
				CommerceInventoryReplenishmentItem::setSku);
		attributeGetterFunctions.put(
			"availabilityDate",
			CommerceInventoryReplenishmentItem::getAvailabilityDate);
		attributeSetterBiConsumers.put(
			"availabilityDate",
			(BiConsumer<CommerceInventoryReplenishmentItem, Date>)
				CommerceInventoryReplenishmentItem::setAvailabilityDate);
		attributeGetterFunctions.put(
			"quantity", CommerceInventoryReplenishmentItem::getQuantity);
		attributeSetterBiConsumers.put(
			"quantity",
			(BiConsumer<CommerceInventoryReplenishmentItem, Integer>)
				CommerceInventoryReplenishmentItem::setQuantity);

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
	public long getCommerceInventoryReplenishmentItemId() {
		return _commerceInventoryReplenishmentItemId;
	}

	@Override
	public void setCommerceInventoryReplenishmentItemId(
		long commerceInventoryReplenishmentItemId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceInventoryReplenishmentItemId =
			commerceInventoryReplenishmentItemId;
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
	public long getCommerceInventoryWarehouseId() {
		return _commerceInventoryWarehouseId;
	}

	@Override
	public void setCommerceInventoryWarehouseId(
		long commerceInventoryWarehouseId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceInventoryWarehouseId = commerceInventoryWarehouseId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceInventoryWarehouseId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commerceInventoryWarehouseId"));
	}

	@JSON
	@Override
	public String getSku() {
		if (_sku == null) {
			return "";
		}
		else {
			return _sku;
		}
	}

	@Override
	public void setSku(String sku) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sku = sku;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSku() {
		return getColumnOriginalValue("sku");
	}

	@JSON
	@Override
	public Date getAvailabilityDate() {
		return _availabilityDate;
	}

	@Override
	public void setAvailabilityDate(Date availabilityDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_availabilityDate = availabilityDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalAvailabilityDate() {
		return getColumnOriginalValue("availabilityDate");
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_quantity = quantity;
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
			getCompanyId(), CommerceInventoryReplenishmentItem.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceInventoryReplenishmentItem toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceInventoryReplenishmentItem>
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
		CommerceInventoryReplenishmentItemImpl
			commerceInventoryReplenishmentItemImpl =
				new CommerceInventoryReplenishmentItemImpl();

		commerceInventoryReplenishmentItemImpl.setMvccVersion(getMvccVersion());
		commerceInventoryReplenishmentItemImpl.
			setCommerceInventoryReplenishmentItemId(
				getCommerceInventoryReplenishmentItemId());
		commerceInventoryReplenishmentItemImpl.setCompanyId(getCompanyId());
		commerceInventoryReplenishmentItemImpl.setUserId(getUserId());
		commerceInventoryReplenishmentItemImpl.setUserName(getUserName());
		commerceInventoryReplenishmentItemImpl.setCreateDate(getCreateDate());
		commerceInventoryReplenishmentItemImpl.setModifiedDate(
			getModifiedDate());
		commerceInventoryReplenishmentItemImpl.setCommerceInventoryWarehouseId(
			getCommerceInventoryWarehouseId());
		commerceInventoryReplenishmentItemImpl.setSku(getSku());
		commerceInventoryReplenishmentItemImpl.setAvailabilityDate(
			getAvailabilityDate());
		commerceInventoryReplenishmentItemImpl.setQuantity(getQuantity());

		commerceInventoryReplenishmentItemImpl.resetOriginalValues();

		return commerceInventoryReplenishmentItemImpl;
	}

	@Override
	public CommerceInventoryReplenishmentItem cloneWithOriginalValues() {
		CommerceInventoryReplenishmentItemImpl
			commerceInventoryReplenishmentItemImpl =
				new CommerceInventoryReplenishmentItemImpl();

		commerceInventoryReplenishmentItemImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		commerceInventoryReplenishmentItemImpl.
			setCommerceInventoryReplenishmentItemId(
				this.<Long>getColumnOriginalValue("CIReplenishmentItemId"));
		commerceInventoryReplenishmentItemImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		commerceInventoryReplenishmentItemImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		commerceInventoryReplenishmentItemImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		commerceInventoryReplenishmentItemImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		commerceInventoryReplenishmentItemImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		commerceInventoryReplenishmentItemImpl.setCommerceInventoryWarehouseId(
			this.<Long>getColumnOriginalValue("commerceInventoryWarehouseId"));
		commerceInventoryReplenishmentItemImpl.setSku(
			this.<String>getColumnOriginalValue("sku"));
		commerceInventoryReplenishmentItemImpl.setAvailabilityDate(
			this.<Date>getColumnOriginalValue("availabilityDate"));
		commerceInventoryReplenishmentItemImpl.setQuantity(
			this.<Integer>getColumnOriginalValue("quantity"));

		return commerceInventoryReplenishmentItemImpl;
	}

	@Override
	public int compareTo(
		CommerceInventoryReplenishmentItem commerceInventoryReplenishmentItem) {

		long primaryKey = commerceInventoryReplenishmentItem.getPrimaryKey();

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

		if (!(object instanceof CommerceInventoryReplenishmentItem)) {
			return false;
		}

		CommerceInventoryReplenishmentItem commerceInventoryReplenishmentItem =
			(CommerceInventoryReplenishmentItem)object;

		long primaryKey = commerceInventoryReplenishmentItem.getPrimaryKey();

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
	public CacheModel<CommerceInventoryReplenishmentItem> toCacheModel() {
		CommerceInventoryReplenishmentItemCacheModel
			commerceInventoryReplenishmentItemCacheModel =
				new CommerceInventoryReplenishmentItemCacheModel();

		commerceInventoryReplenishmentItemCacheModel.mvccVersion =
			getMvccVersion();

		commerceInventoryReplenishmentItemCacheModel.
			commerceInventoryReplenishmentItemId =
				getCommerceInventoryReplenishmentItemId();

		commerceInventoryReplenishmentItemCacheModel.companyId = getCompanyId();

		commerceInventoryReplenishmentItemCacheModel.userId = getUserId();

		commerceInventoryReplenishmentItemCacheModel.userName = getUserName();

		String userName = commerceInventoryReplenishmentItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceInventoryReplenishmentItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceInventoryReplenishmentItemCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceInventoryReplenishmentItemCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceInventoryReplenishmentItemCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceInventoryReplenishmentItemCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		commerceInventoryReplenishmentItemCacheModel.
			commerceInventoryWarehouseId = getCommerceInventoryWarehouseId();

		commerceInventoryReplenishmentItemCacheModel.sku = getSku();

		String sku = commerceInventoryReplenishmentItemCacheModel.sku;

		if ((sku != null) && (sku.length() == 0)) {
			commerceInventoryReplenishmentItemCacheModel.sku = null;
		}

		Date availabilityDate = getAvailabilityDate();

		if (availabilityDate != null) {
			commerceInventoryReplenishmentItemCacheModel.availabilityDate =
				availabilityDate.getTime();
		}
		else {
			commerceInventoryReplenishmentItemCacheModel.availabilityDate =
				Long.MIN_VALUE;
		}

		commerceInventoryReplenishmentItemCacheModel.quantity = getQuantity();

		return commerceInventoryReplenishmentItemCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceInventoryReplenishmentItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry
				<String, Function<CommerceInventoryReplenishmentItem, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryReplenishmentItem, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CommerceInventoryReplenishmentItem)this);

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
		Map<String, Function<CommerceInventoryReplenishmentItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry
				<String, Function<CommerceInventoryReplenishmentItem, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryReplenishmentItem, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceInventoryReplenishmentItem)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceInventoryReplenishmentItem>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _commerceInventoryReplenishmentItemId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceInventoryWarehouseId;
	private String _sku;
	private Date _availabilityDate;
	private int _quantity;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CommerceInventoryReplenishmentItem, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CommerceInventoryReplenishmentItem)this);
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
			"CIReplenishmentItemId", _commerceInventoryReplenishmentItemId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put(
			"commerceInventoryWarehouseId", _commerceInventoryWarehouseId);
		_columnOriginalValues.put("sku", _sku);
		_columnOriginalValues.put("availabilityDate", _availabilityDate);
		_columnOriginalValues.put("quantity", _quantity);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put(
			"CIReplenishmentItemId", "commerceInventoryReplenishmentItemId");

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

		columnBitmasks.put("CIReplenishmentItemId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("commerceInventoryWarehouseId", 128L);

		columnBitmasks.put("sku", 256L);

		columnBitmasks.put("availabilityDate", 512L);

		columnBitmasks.put("quantity", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CommerceInventoryReplenishmentItem _escapedModel;

}