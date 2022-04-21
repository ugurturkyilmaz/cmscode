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

package com.liferay.object.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ObjectEntry service. Represents a row in the &quot;ObjectEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.object.model.impl.ObjectEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.object.model.impl.ObjectEntryImpl</code>.
 * </p>
 *
 * @author Marco Leo
 * @see ObjectEntry
 * @generated
 */
@ProviderType
public interface ObjectEntryModel
	extends BaseModel<ObjectEntry>, MVCCModel, ShardedModel, StagedGroupedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a object entry model instance should use the {@link ObjectEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this object entry.
	 *
	 * @return the primary key of this object entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this object entry.
	 *
	 * @param primaryKey the primary key of this object entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this object entry.
	 *
	 * @return the mvcc version of this object entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this object entry.
	 *
	 * @param mvccVersion the mvcc version of this object entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this object entry.
	 *
	 * @return the uuid of this object entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this object entry.
	 *
	 * @param uuid the uuid of this object entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the object entry ID of this object entry.
	 *
	 * @return the object entry ID of this object entry
	 */
	public long getObjectEntryId();

	/**
	 * Sets the object entry ID of this object entry.
	 *
	 * @param objectEntryId the object entry ID of this object entry
	 */
	public void setObjectEntryId(long objectEntryId);

	/**
	 * Returns the group ID of this object entry.
	 *
	 * @return the group ID of this object entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this object entry.
	 *
	 * @param groupId the group ID of this object entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this object entry.
	 *
	 * @return the company ID of this object entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this object entry.
	 *
	 * @param companyId the company ID of this object entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this object entry.
	 *
	 * @return the user ID of this object entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this object entry.
	 *
	 * @param userId the user ID of this object entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this object entry.
	 *
	 * @return the user uuid of this object entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this object entry.
	 *
	 * @param userUuid the user uuid of this object entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this object entry.
	 *
	 * @return the user name of this object entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this object entry.
	 *
	 * @param userName the user name of this object entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this object entry.
	 *
	 * @return the create date of this object entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this object entry.
	 *
	 * @param createDate the create date of this object entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this object entry.
	 *
	 * @return the modified date of this object entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this object entry.
	 *
	 * @param modifiedDate the modified date of this object entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the external reference code of this object entry.
	 *
	 * @return the external reference code of this object entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this object entry.
	 *
	 * @param externalReferenceCode the external reference code of this object entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the object definition ID of this object entry.
	 *
	 * @return the object definition ID of this object entry
	 */
	public long getObjectDefinitionId();

	/**
	 * Sets the object definition ID of this object entry.
	 *
	 * @param objectDefinitionId the object definition ID of this object entry
	 */
	public void setObjectDefinitionId(long objectDefinitionId);

	/**
	 * Returns the last publish date of this object entry.
	 *
	 * @return the last publish date of this object entry
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this object entry.
	 *
	 * @param lastPublishDate the last publish date of this object entry
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this object entry.
	 *
	 * @return the status of this object entry
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this object entry.
	 *
	 * @param status the status of this object entry
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this object entry.
	 *
	 * @return the status by user ID of this object entry
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this object entry.
	 *
	 * @param statusByUserId the status by user ID of this object entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this object entry.
	 *
	 * @return the status by user uuid of this object entry
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this object entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this object entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this object entry.
	 *
	 * @return the status by user name of this object entry
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this object entry.
	 *
	 * @param statusByUserName the status by user name of this object entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this object entry.
	 *
	 * @return the status date of this object entry
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this object entry.
	 *
	 * @param statusDate the status date of this object entry
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this object entry is approved.
	 *
	 * @return <code>true</code> if this object entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this object entry is denied.
	 *
	 * @return <code>true</code> if this object entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this object entry is a draft.
	 *
	 * @return <code>true</code> if this object entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this object entry is expired.
	 *
	 * @return <code>true</code> if this object entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this object entry is inactive.
	 *
	 * @return <code>true</code> if this object entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this object entry is incomplete.
	 *
	 * @return <code>true</code> if this object entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this object entry is pending.
	 *
	 * @return <code>true</code> if this object entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this object entry is scheduled.
	 *
	 * @return <code>true</code> if this object entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public ObjectEntry cloneWithOriginalValues();

}