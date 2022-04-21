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

package com.liferay.commerce.term.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CTermEntryLocalization service. Represents a row in the &quot;CTermEntryLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.term.model.impl.CTermEntryLocalizationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.term.model.impl.CTermEntryLocalizationImpl</code>.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CTermEntryLocalization
 * @generated
 */
@ProviderType
public interface CTermEntryLocalizationModel
	extends BaseModel<CTermEntryLocalization>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a c term entry localization model instance should use the {@link CTermEntryLocalization} interface instead.
	 */

	/**
	 * Returns the primary key of this c term entry localization.
	 *
	 * @return the primary key of this c term entry localization
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this c term entry localization.
	 *
	 * @param primaryKey the primary key of this c term entry localization
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this c term entry localization.
	 *
	 * @return the mvcc version of this c term entry localization
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this c term entry localization.
	 *
	 * @param mvccVersion the mvcc version of this c term entry localization
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the c term entry localization ID of this c term entry localization.
	 *
	 * @return the c term entry localization ID of this c term entry localization
	 */
	public long getCTermEntryLocalizationId();

	/**
	 * Sets the c term entry localization ID of this c term entry localization.
	 *
	 * @param cTermEntryLocalizationId the c term entry localization ID of this c term entry localization
	 */
	public void setCTermEntryLocalizationId(long cTermEntryLocalizationId);

	/**
	 * Returns the company ID of this c term entry localization.
	 *
	 * @return the company ID of this c term entry localization
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this c term entry localization.
	 *
	 * @param companyId the company ID of this c term entry localization
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the commerce term entry ID of this c term entry localization.
	 *
	 * @return the commerce term entry ID of this c term entry localization
	 */
	public long getCommerceTermEntryId();

	/**
	 * Sets the commerce term entry ID of this c term entry localization.
	 *
	 * @param commerceTermEntryId the commerce term entry ID of this c term entry localization
	 */
	public void setCommerceTermEntryId(long commerceTermEntryId);

	/**
	 * Returns the language ID of this c term entry localization.
	 *
	 * @return the language ID of this c term entry localization
	 */
	@AutoEscape
	public String getLanguageId();

	/**
	 * Sets the language ID of this c term entry localization.
	 *
	 * @param languageId the language ID of this c term entry localization
	 */
	public void setLanguageId(String languageId);

	/**
	 * Returns the description of this c term entry localization.
	 *
	 * @return the description of this c term entry localization
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this c term entry localization.
	 *
	 * @param description the description of this c term entry localization
	 */
	public void setDescription(String description);

	/**
	 * Returns the label of this c term entry localization.
	 *
	 * @return the label of this c term entry localization
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this c term entry localization.
	 *
	 * @param label the label of this c term entry localization
	 */
	public void setLabel(String label);

	@Override
	public CTermEntryLocalization cloneWithOriginalValues();

}