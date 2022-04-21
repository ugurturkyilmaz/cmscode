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

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.bean.AutoEscape;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PortalPreferenceValue service. Represents a row in the &quot;PortalPreferenceValue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.PortalPreferenceValueModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.PortalPreferenceValueImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortalPreferenceValue
 * @generated
 */
@ProviderType
public interface PortalPreferenceValueModel
	extends BaseModel<PortalPreferenceValue>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a portal preference value model instance should use the {@link PortalPreferenceValue} interface instead.
	 */

	/**
	 * Returns the primary key of this portal preference value.
	 *
	 * @return the primary key of this portal preference value
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this portal preference value.
	 *
	 * @param primaryKey the primary key of this portal preference value
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this portal preference value.
	 *
	 * @return the mvcc version of this portal preference value
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this portal preference value.
	 *
	 * @param mvccVersion the mvcc version of this portal preference value
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the portal preference value ID of this portal preference value.
	 *
	 * @return the portal preference value ID of this portal preference value
	 */
	public long getPortalPreferenceValueId();

	/**
	 * Sets the portal preference value ID of this portal preference value.
	 *
	 * @param portalPreferenceValueId the portal preference value ID of this portal preference value
	 */
	public void setPortalPreferenceValueId(long portalPreferenceValueId);

	/**
	 * Returns the company ID of this portal preference value.
	 *
	 * @return the company ID of this portal preference value
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this portal preference value.
	 *
	 * @param companyId the company ID of this portal preference value
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the portal preferences ID of this portal preference value.
	 *
	 * @return the portal preferences ID of this portal preference value
	 */
	public long getPortalPreferencesId();

	/**
	 * Sets the portal preferences ID of this portal preference value.
	 *
	 * @param portalPreferencesId the portal preferences ID of this portal preference value
	 */
	public void setPortalPreferencesId(long portalPreferencesId);

	/**
	 * Returns the index of this portal preference value.
	 *
	 * @return the index of this portal preference value
	 */
	public int getIndex();

	/**
	 * Sets the index of this portal preference value.
	 *
	 * @param index the index of this portal preference value
	 */
	public void setIndex(int index);

	/**
	 * Returns the key of this portal preference value.
	 *
	 * @return the key of this portal preference value
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this portal preference value.
	 *
	 * @param key the key of this portal preference value
	 */
	public void setKey(String key);

	/**
	 * Returns the large value of this portal preference value.
	 *
	 * @return the large value of this portal preference value
	 */
	@AutoEscape
	public String getLargeValue();

	/**
	 * Sets the large value of this portal preference value.
	 *
	 * @param largeValue the large value of this portal preference value
	 */
	public void setLargeValue(String largeValue);

	/**
	 * Returns the namespace of this portal preference value.
	 *
	 * @return the namespace of this portal preference value
	 */
	@AutoEscape
	public String getNamespace();

	/**
	 * Sets the namespace of this portal preference value.
	 *
	 * @param namespace the namespace of this portal preference value
	 */
	public void setNamespace(String namespace);

	/**
	 * Returns the small value of this portal preference value.
	 *
	 * @return the small value of this portal preference value
	 */
	@AutoEscape
	public String getSmallValue();

	/**
	 * Sets the small value of this portal preference value.
	 *
	 * @param smallValue the small value of this portal preference value
	 */
	public void setSmallValue(String smallValue);

	@Override
	public PortalPreferenceValue cloneWithOriginalValues();

}