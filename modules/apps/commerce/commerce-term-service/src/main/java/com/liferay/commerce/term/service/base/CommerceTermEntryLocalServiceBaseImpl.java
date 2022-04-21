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

package com.liferay.commerce.term.service.base;

import com.liferay.commerce.term.model.CTermEntryLocalization;
import com.liferay.commerce.term.model.CommerceTermEntry;
import com.liferay.commerce.term.service.CommerceTermEntryLocalService;
import com.liferay.commerce.term.service.CommerceTermEntryLocalServiceUtil;
import com.liferay.commerce.term.service.persistence.CTermEntryLocalizationPersistence;
import com.liferay.commerce.term.service.persistence.CommerceTermEntryPersistence;
import com.liferay.commerce.term.service.persistence.CommerceTermEntryRelPersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
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
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the commerce term entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.term.service.impl.CommerceTermEntryLocalServiceImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see com.liferay.commerce.term.service.impl.CommerceTermEntryLocalServiceImpl
 * @generated
 */
public abstract class CommerceTermEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CommerceTermEntryLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceTermEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceTermEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce term entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTermEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTermEntry the commerce term entry
	 * @return the commerce term entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceTermEntry addCommerceTermEntry(
		CommerceTermEntry commerceTermEntry) {

		commerceTermEntry.setNew(true);

		return commerceTermEntryPersistence.update(commerceTermEntry);
	}

	/**
	 * Creates a new commerce term entry with the primary key. Does not add the commerce term entry to the database.
	 *
	 * @param commerceTermEntryId the primary key for the new commerce term entry
	 * @return the new commerce term entry
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceTermEntry createCommerceTermEntry(long commerceTermEntryId) {
		return commerceTermEntryPersistence.create(commerceTermEntryId);
	}

	/**
	 * Deletes the commerce term entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTermEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTermEntryId the primary key of the commerce term entry
	 * @return the commerce term entry that was removed
	 * @throws PortalException if a commerce term entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceTermEntry deleteCommerceTermEntry(long commerceTermEntryId)
		throws PortalException {

		return commerceTermEntryPersistence.remove(commerceTermEntryId);
	}

	/**
	 * Deletes the commerce term entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTermEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTermEntry the commerce term entry
	 * @return the commerce term entry that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceTermEntry deleteCommerceTermEntry(
			CommerceTermEntry commerceTermEntry)
		throws PortalException {

		return commerceTermEntryPersistence.remove(commerceTermEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return commerceTermEntryPersistence.dslQuery(dslQuery);
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
			CommerceTermEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceTermEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.term.model.impl.CommerceTermEntryModelImpl</code>.
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

		return commerceTermEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.term.model.impl.CommerceTermEntryModelImpl</code>.
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

		return commerceTermEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceTermEntryPersistence.countWithDynamicQuery(dynamicQuery);
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

		return commerceTermEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommerceTermEntry fetchCommerceTermEntry(long commerceTermEntryId) {
		return commerceTermEntryPersistence.fetchByPrimaryKey(
			commerceTermEntryId);
	}

	/**
	 * Returns the commerce term entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the commerce term entry's external reference code
	 * @return the matching commerce term entry, or <code>null</code> if a matching commerce term entry could not be found
	 */
	@Override
	public CommerceTermEntry fetchCommerceTermEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return commerceTermEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchCommerceTermEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public CommerceTermEntry fetchCommerceTermEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchCommerceTermEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the commerce term entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the commerce term entry's external reference code
	 * @return the matching commerce term entry
	 * @throws PortalException if a matching commerce term entry could not be found
	 */
	@Override
	public CommerceTermEntry getCommerceTermEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return commerceTermEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the commerce term entry with the primary key.
	 *
	 * @param commerceTermEntryId the primary key of the commerce term entry
	 * @return the commerce term entry
	 * @throws PortalException if a commerce term entry with the primary key could not be found
	 */
	@Override
	public CommerceTermEntry getCommerceTermEntry(long commerceTermEntryId)
		throws PortalException {

		return commerceTermEntryPersistence.findByPrimaryKey(
			commerceTermEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commerceTermEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceTermEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("commerceTermEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commerceTermEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CommerceTermEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceTermEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commerceTermEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceTermEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("commerceTermEntryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceTermEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commerceTermEntryLocalService.deleteCommerceTermEntry(
			(CommerceTermEntry)persistedModel);
	}

	@Override
	public BasePersistence<CommerceTermEntry> getBasePersistence() {
		return commerceTermEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceTermEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce term entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.term.model.impl.CommerceTermEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce term entries
	 * @param end the upper bound of the range of commerce term entries (not inclusive)
	 * @return the range of commerce term entries
	 */
	@Override
	public List<CommerceTermEntry> getCommerceTermEntries(int start, int end) {
		return commerceTermEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce term entries.
	 *
	 * @return the number of commerce term entries
	 */
	@Override
	public int getCommerceTermEntriesCount() {
		return commerceTermEntryPersistence.countAll();
	}

	/**
	 * Updates the commerce term entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceTermEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceTermEntry the commerce term entry
	 * @return the commerce term entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceTermEntry updateCommerceTermEntry(
		CommerceTermEntry commerceTermEntry) {

		return commerceTermEntryPersistence.update(commerceTermEntry);
	}

	@Override
	public CTermEntryLocalization fetchCTermEntryLocalization(
		long commerceTermEntryId, String languageId) {

		return cTermEntryLocalizationPersistence.
			fetchByCommerceTermEntryId_LanguageId(
				commerceTermEntryId, languageId);
	}

	@Override
	public CTermEntryLocalization getCTermEntryLocalization(
			long commerceTermEntryId, String languageId)
		throws PortalException {

		return cTermEntryLocalizationPersistence.
			findByCommerceTermEntryId_LanguageId(
				commerceTermEntryId, languageId);
	}

	@Override
	public List<CTermEntryLocalization> getCTermEntryLocalizations(
		long commerceTermEntryId) {

		return cTermEntryLocalizationPersistence.findByCommerceTermEntryId(
			commerceTermEntryId);
	}

	@Override
	public CTermEntryLocalization updateCTermEntryLocalization(
			CommerceTermEntry commerceTermEntry, String languageId,
			String description, String label)
		throws PortalException {

		commerceTermEntry = commerceTermEntryPersistence.findByPrimaryKey(
			commerceTermEntry.getPrimaryKey());

		CTermEntryLocalization cTermEntryLocalization =
			cTermEntryLocalizationPersistence.
				fetchByCommerceTermEntryId_LanguageId(
					commerceTermEntry.getCommerceTermEntryId(), languageId);

		return _updateCTermEntryLocalization(
			commerceTermEntry, cTermEntryLocalization, languageId, description,
			label);
	}

	@Override
	public List<CTermEntryLocalization> updateCTermEntryLocalizations(
			CommerceTermEntry commerceTermEntry,
			Map<String, String> descriptionMap, Map<String, String> labelMap)
		throws PortalException {

		commerceTermEntry = commerceTermEntryPersistence.findByPrimaryKey(
			commerceTermEntry.getPrimaryKey());

		Map<String, String[]> localizedValuesMap =
			new HashMap<String, String[]>();

		for (Map.Entry<String, String> entry : descriptionMap.entrySet()) {
			String languageId = entry.getKey();

			String[] localizedValues = localizedValuesMap.get(languageId);

			if (localizedValues == null) {
				localizedValues = new String[2];

				localizedValuesMap.put(languageId, localizedValues);
			}

			localizedValues[0] = entry.getValue();
		}

		for (Map.Entry<String, String> entry : labelMap.entrySet()) {
			String languageId = entry.getKey();

			String[] localizedValues = localizedValuesMap.get(languageId);

			if (localizedValues == null) {
				localizedValues = new String[2];

				localizedValuesMap.put(languageId, localizedValues);
			}

			localizedValues[1] = entry.getValue();
		}

		List<CTermEntryLocalization> cTermEntryLocalizations =
			new ArrayList<CTermEntryLocalization>(localizedValuesMap.size());

		for (CTermEntryLocalization cTermEntryLocalization :
				cTermEntryLocalizationPersistence.findByCommerceTermEntryId(
					commerceTermEntry.getCommerceTermEntryId())) {

			String[] localizedValues = localizedValuesMap.remove(
				cTermEntryLocalization.getLanguageId());

			if (localizedValues == null) {
				cTermEntryLocalizationPersistence.remove(
					cTermEntryLocalization);
			}
			else {
				cTermEntryLocalization.setCompanyId(
					commerceTermEntry.getCompanyId());

				cTermEntryLocalization.setDescription(localizedValues[0]);
				cTermEntryLocalization.setLabel(localizedValues[1]);

				cTermEntryLocalizations.add(
					cTermEntryLocalizationPersistence.update(
						cTermEntryLocalization));
			}
		}

		long batchCounter =
			counterLocalService.increment(
				CTermEntryLocalization.class.getName(),
				localizedValuesMap.size()) - localizedValuesMap.size();

		for (Map.Entry<String, String[]> entry :
				localizedValuesMap.entrySet()) {

			String languageId = entry.getKey();
			String[] localizedValues = entry.getValue();

			CTermEntryLocalization cTermEntryLocalization =
				cTermEntryLocalizationPersistence.create(++batchCounter);

			cTermEntryLocalization.setCommerceTermEntryId(
				commerceTermEntry.getCommerceTermEntryId());
			cTermEntryLocalization.setCompanyId(
				commerceTermEntry.getCompanyId());

			cTermEntryLocalization.setLanguageId(languageId);

			cTermEntryLocalization.setDescription(localizedValues[0]);
			cTermEntryLocalization.setLabel(localizedValues[1]);

			cTermEntryLocalizations.add(
				cTermEntryLocalizationPersistence.update(
					cTermEntryLocalization));
		}

		return cTermEntryLocalizations;
	}

	private CTermEntryLocalization _updateCTermEntryLocalization(
			CommerceTermEntry commerceTermEntry,
			CTermEntryLocalization cTermEntryLocalization, String languageId,
			String description, String label)
		throws PortalException {

		if (cTermEntryLocalization == null) {
			long cTermEntryLocalizationId = counterLocalService.increment(
				CTermEntryLocalization.class.getName());

			cTermEntryLocalization = cTermEntryLocalizationPersistence.create(
				cTermEntryLocalizationId);

			cTermEntryLocalization.setCommerceTermEntryId(
				commerceTermEntry.getCommerceTermEntryId());
			cTermEntryLocalization.setLanguageId(languageId);
		}

		cTermEntryLocalization.setCompanyId(commerceTermEntry.getCompanyId());

		cTermEntryLocalization.setDescription(description);
		cTermEntryLocalization.setLabel(label);

		return cTermEntryLocalizationPersistence.update(cTermEntryLocalization);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CommerceTermEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		commerceTermEntryLocalService = (CommerceTermEntryLocalService)aopProxy;

		_setLocalServiceUtilService(commerceTermEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceTermEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceTermEntry.class;
	}

	protected String getModelClassName() {
		return CommerceTermEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceTermEntryPersistence.getDataSource();

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
		CommerceTermEntryLocalService commerceTermEntryLocalService) {

		try {
			Field field =
				CommerceTermEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, commerceTermEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected CommerceTermEntryLocalService commerceTermEntryLocalService;

	@Reference
	protected CommerceTermEntryPersistence commerceTermEntryPersistence;

	@Reference
	protected CommerceTermEntryRelPersistence commerceTermEntryRelPersistence;

	@Reference
	protected CTermEntryLocalizationPersistence
		cTermEntryLocalizationPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}