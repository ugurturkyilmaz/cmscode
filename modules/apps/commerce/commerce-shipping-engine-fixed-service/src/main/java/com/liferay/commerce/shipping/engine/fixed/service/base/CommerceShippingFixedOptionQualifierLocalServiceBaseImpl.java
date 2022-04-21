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

package com.liferay.commerce.shipping.engine.fixed.service.base;

import com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOptionQualifier;
import com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionQualifierLocalService;
import com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionQualifierLocalServiceUtil;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionPersistence;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionQualifierPersistence;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionRelFinder;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionRelPersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce shipping fixed option qualifier local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.shipping.engine.fixed.service.impl.CommerceShippingFixedOptionQualifierLocalServiceImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see com.liferay.commerce.shipping.engine.fixed.service.impl.CommerceShippingFixedOptionQualifierLocalServiceImpl
 * @generated
 */
public abstract class CommerceShippingFixedOptionQualifierLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommerceShippingFixedOptionQualifierLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceShippingFixedOptionQualifierLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceShippingFixedOptionQualifierLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce shipping fixed option qualifier to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceShippingFixedOptionQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceShippingFixedOptionQualifier the commerce shipping fixed option qualifier
	 * @return the commerce shipping fixed option qualifier that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceShippingFixedOptionQualifier
		addCommerceShippingFixedOptionQualifier(
			CommerceShippingFixedOptionQualifier
				commerceShippingFixedOptionQualifier) {

		commerceShippingFixedOptionQualifier.setNew(true);

		return commerceShippingFixedOptionQualifierPersistence.update(
			commerceShippingFixedOptionQualifier);
	}

	/**
	 * Creates a new commerce shipping fixed option qualifier with the primary key. Does not add the commerce shipping fixed option qualifier to the database.
	 *
	 * @param commerceShippingFixedOptionQualifierId the primary key for the new commerce shipping fixed option qualifier
	 * @return the new commerce shipping fixed option qualifier
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceShippingFixedOptionQualifier
		createCommerceShippingFixedOptionQualifier(
			long commerceShippingFixedOptionQualifierId) {

		return commerceShippingFixedOptionQualifierPersistence.create(
			commerceShippingFixedOptionQualifierId);
	}

	/**
	 * Deletes the commerce shipping fixed option qualifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceShippingFixedOptionQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceShippingFixedOptionQualifierId the primary key of the commerce shipping fixed option qualifier
	 * @return the commerce shipping fixed option qualifier that was removed
	 * @throws PortalException if a commerce shipping fixed option qualifier with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceShippingFixedOptionQualifier
			deleteCommerceShippingFixedOptionQualifier(
				long commerceShippingFixedOptionQualifierId)
		throws PortalException {

		return commerceShippingFixedOptionQualifierPersistence.remove(
			commerceShippingFixedOptionQualifierId);
	}

	/**
	 * Deletes the commerce shipping fixed option qualifier from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceShippingFixedOptionQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceShippingFixedOptionQualifier the commerce shipping fixed option qualifier
	 * @return the commerce shipping fixed option qualifier that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceShippingFixedOptionQualifier
		deleteCommerceShippingFixedOptionQualifier(
			CommerceShippingFixedOptionQualifier
				commerceShippingFixedOptionQualifier) {

		return commerceShippingFixedOptionQualifierPersistence.remove(
			commerceShippingFixedOptionQualifier);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return commerceShippingFixedOptionQualifierPersistence.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommerceShippingFixedOptionQualifier.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceShippingFixedOptionQualifierPersistence.
			findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.shipping.engine.fixed.model.impl.CommerceShippingFixedOptionQualifierModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commerceShippingFixedOptionQualifierPersistence.
			findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.shipping.engine.fixed.model.impl.CommerceShippingFixedOptionQualifierModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commerceShippingFixedOptionQualifierPersistence.
			findWithDynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceShippingFixedOptionQualifierPersistence.
			countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return commerceShippingFixedOptionQualifierPersistence.
			countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public CommerceShippingFixedOptionQualifier
		fetchCommerceShippingFixedOptionQualifier(
			long commerceShippingFixedOptionQualifierId) {

		return commerceShippingFixedOptionQualifierPersistence.
			fetchByPrimaryKey(commerceShippingFixedOptionQualifierId);
	}

	/**
	 * Returns the commerce shipping fixed option qualifier with the primary key.
	 *
	 * @param commerceShippingFixedOptionQualifierId the primary key of the commerce shipping fixed option qualifier
	 * @return the commerce shipping fixed option qualifier
	 * @throws PortalException if a commerce shipping fixed option qualifier with the primary key could not be found
	 */
	@Override
	public CommerceShippingFixedOptionQualifier
			getCommerceShippingFixedOptionQualifier(
				long commerceShippingFixedOptionQualifierId)
		throws PortalException {

		return commerceShippingFixedOptionQualifierPersistence.findByPrimaryKey(
			commerceShippingFixedOptionQualifierId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commerceShippingFixedOptionQualifierLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommerceShippingFixedOptionQualifier.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceShippingFixedOptionQualifierId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commerceShippingFixedOptionQualifierLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommerceShippingFixedOptionQualifier.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceShippingFixedOptionQualifierId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commerceShippingFixedOptionQualifierLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommerceShippingFixedOptionQualifier.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceShippingFixedOptionQualifierId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceShippingFixedOptionQualifierPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commerceShippingFixedOptionQualifierLocalService.
			deleteCommerceShippingFixedOptionQualifier(
				(CommerceShippingFixedOptionQualifier)persistedModel);
	}

	@Override
	public BasePersistence<CommerceShippingFixedOptionQualifier>
		getBasePersistence() {

		return commerceShippingFixedOptionQualifierPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceShippingFixedOptionQualifierPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce shipping fixed option qualifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.shipping.engine.fixed.model.impl.CommerceShippingFixedOptionQualifierModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce shipping fixed option qualifiers
	 * @param end the upper bound of the range of commerce shipping fixed option qualifiers (not inclusive)
	 * @return the range of commerce shipping fixed option qualifiers
	 */
	@Override
	public List<CommerceShippingFixedOptionQualifier>
		getCommerceShippingFixedOptionQualifiers(int start, int end) {

		return commerceShippingFixedOptionQualifierPersistence.findAll(
			start, end);
	}

	/**
	 * Returns the number of commerce shipping fixed option qualifiers.
	 *
	 * @return the number of commerce shipping fixed option qualifiers
	 */
	@Override
	public int getCommerceShippingFixedOptionQualifiersCount() {
		return commerceShippingFixedOptionQualifierPersistence.countAll();
	}

	/**
	 * Updates the commerce shipping fixed option qualifier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceShippingFixedOptionQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceShippingFixedOptionQualifier the commerce shipping fixed option qualifier
	 * @return the commerce shipping fixed option qualifier that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceShippingFixedOptionQualifier
		updateCommerceShippingFixedOptionQualifier(
			CommerceShippingFixedOptionQualifier
				commerceShippingFixedOptionQualifier) {

		return commerceShippingFixedOptionQualifierPersistence.update(
			commerceShippingFixedOptionQualifier);
	}

	/**
	 * Returns the commerce shipping fixed option local service.
	 *
	 * @return the commerce shipping fixed option local service
	 */
	public com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionLocalService
			getCommerceShippingFixedOptionLocalService() {

		return commerceShippingFixedOptionLocalService;
	}

	/**
	 * Sets the commerce shipping fixed option local service.
	 *
	 * @param commerceShippingFixedOptionLocalService the commerce shipping fixed option local service
	 */
	public void setCommerceShippingFixedOptionLocalService(
		com.liferay.commerce.shipping.engine.fixed.service.
			CommerceShippingFixedOptionLocalService
				commerceShippingFixedOptionLocalService) {

		this.commerceShippingFixedOptionLocalService =
			commerceShippingFixedOptionLocalService;
	}

	/**
	 * Returns the commerce shipping fixed option persistence.
	 *
	 * @return the commerce shipping fixed option persistence
	 */
	public CommerceShippingFixedOptionPersistence
		getCommerceShippingFixedOptionPersistence() {

		return commerceShippingFixedOptionPersistence;
	}

	/**
	 * Sets the commerce shipping fixed option persistence.
	 *
	 * @param commerceShippingFixedOptionPersistence the commerce shipping fixed option persistence
	 */
	public void setCommerceShippingFixedOptionPersistence(
		CommerceShippingFixedOptionPersistence
			commerceShippingFixedOptionPersistence) {

		this.commerceShippingFixedOptionPersistence =
			commerceShippingFixedOptionPersistence;
	}

	/**
	 * Returns the commerce shipping fixed option qualifier local service.
	 *
	 * @return the commerce shipping fixed option qualifier local service
	 */
	public CommerceShippingFixedOptionQualifierLocalService
		getCommerceShippingFixedOptionQualifierLocalService() {

		return commerceShippingFixedOptionQualifierLocalService;
	}

	/**
	 * Sets the commerce shipping fixed option qualifier local service.
	 *
	 * @param commerceShippingFixedOptionQualifierLocalService the commerce shipping fixed option qualifier local service
	 */
	public void setCommerceShippingFixedOptionQualifierLocalService(
		CommerceShippingFixedOptionQualifierLocalService
			commerceShippingFixedOptionQualifierLocalService) {

		this.commerceShippingFixedOptionQualifierLocalService =
			commerceShippingFixedOptionQualifierLocalService;
	}

	/**
	 * Returns the commerce shipping fixed option qualifier persistence.
	 *
	 * @return the commerce shipping fixed option qualifier persistence
	 */
	public CommerceShippingFixedOptionQualifierPersistence
		getCommerceShippingFixedOptionQualifierPersistence() {

		return commerceShippingFixedOptionQualifierPersistence;
	}

	/**
	 * Sets the commerce shipping fixed option qualifier persistence.
	 *
	 * @param commerceShippingFixedOptionQualifierPersistence the commerce shipping fixed option qualifier persistence
	 */
	public void setCommerceShippingFixedOptionQualifierPersistence(
		CommerceShippingFixedOptionQualifierPersistence
			commerceShippingFixedOptionQualifierPersistence) {

		this.commerceShippingFixedOptionQualifierPersistence =
			commerceShippingFixedOptionQualifierPersistence;
	}

	/**
	 * Returns the commerce shipping fixed option rel local service.
	 *
	 * @return the commerce shipping fixed option rel local service
	 */
	public com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionRelLocalService
			getCommerceShippingFixedOptionRelLocalService() {

		return commerceShippingFixedOptionRelLocalService;
	}

	/**
	 * Sets the commerce shipping fixed option rel local service.
	 *
	 * @param commerceShippingFixedOptionRelLocalService the commerce shipping fixed option rel local service
	 */
	public void setCommerceShippingFixedOptionRelLocalService(
		com.liferay.commerce.shipping.engine.fixed.service.
			CommerceShippingFixedOptionRelLocalService
				commerceShippingFixedOptionRelLocalService) {

		this.commerceShippingFixedOptionRelLocalService =
			commerceShippingFixedOptionRelLocalService;
	}

	/**
	 * Returns the commerce shipping fixed option rel persistence.
	 *
	 * @return the commerce shipping fixed option rel persistence
	 */
	public CommerceShippingFixedOptionRelPersistence
		getCommerceShippingFixedOptionRelPersistence() {

		return commerceShippingFixedOptionRelPersistence;
	}

	/**
	 * Sets the commerce shipping fixed option rel persistence.
	 *
	 * @param commerceShippingFixedOptionRelPersistence the commerce shipping fixed option rel persistence
	 */
	public void setCommerceShippingFixedOptionRelPersistence(
		CommerceShippingFixedOptionRelPersistence
			commerceShippingFixedOptionRelPersistence) {

		this.commerceShippingFixedOptionRelPersistence =
			commerceShippingFixedOptionRelPersistence;
	}

	/**
	 * Returns the commerce shipping fixed option rel finder.
	 *
	 * @return the commerce shipping fixed option rel finder
	 */
	public CommerceShippingFixedOptionRelFinder
		getCommerceShippingFixedOptionRelFinder() {

		return commerceShippingFixedOptionRelFinder;
	}

	/**
	 * Sets the commerce shipping fixed option rel finder.
	 *
	 * @param commerceShippingFixedOptionRelFinder the commerce shipping fixed option rel finder
	 */
	public void setCommerceShippingFixedOptionRelFinder(
		CommerceShippingFixedOptionRelFinder
			commerceShippingFixedOptionRelFinder) {

		this.commerceShippingFixedOptionRelFinder =
			commerceShippingFixedOptionRelFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOptionQualifier",
			commerceShippingFixedOptionQualifierLocalService);

		_setLocalServiceUtilService(
			commerceShippingFixedOptionQualifierLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOptionQualifier");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceShippingFixedOptionQualifierLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceShippingFixedOptionQualifier.class;
	}

	protected String getModelClassName() {
		return CommerceShippingFixedOptionQualifier.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceShippingFixedOptionQualifierPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		CommerceShippingFixedOptionQualifierLocalService
			commerceShippingFixedOptionQualifierLocalService) {

		try {
			Field field =
				CommerceShippingFixedOptionQualifierLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, commerceShippingFixedOptionQualifierLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionLocalService.class
	)
	protected com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionLocalService
			commerceShippingFixedOptionLocalService;

	@BeanReference(type = CommerceShippingFixedOptionPersistence.class)
	protected CommerceShippingFixedOptionPersistence
		commerceShippingFixedOptionPersistence;

	@BeanReference(
		type = CommerceShippingFixedOptionQualifierLocalService.class
	)
	protected CommerceShippingFixedOptionQualifierLocalService
		commerceShippingFixedOptionQualifierLocalService;

	@BeanReference(type = CommerceShippingFixedOptionQualifierPersistence.class)
	protected CommerceShippingFixedOptionQualifierPersistence
		commerceShippingFixedOptionQualifierPersistence;

	@BeanReference(
		type = com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionRelLocalService.class
	)
	protected com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionRelLocalService
			commerceShippingFixedOptionRelLocalService;

	@BeanReference(type = CommerceShippingFixedOptionRelPersistence.class)
	protected CommerceShippingFixedOptionRelPersistence
		commerceShippingFixedOptionRelPersistence;

	@BeanReference(type = CommerceShippingFixedOptionRelFinder.class)
	protected CommerceShippingFixedOptionRelFinder
		commerceShippingFixedOptionRelFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}