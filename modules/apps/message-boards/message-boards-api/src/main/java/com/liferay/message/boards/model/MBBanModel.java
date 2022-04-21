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

package com.liferay.message.boards.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MBBan service. Represents a row in the &quot;MBBan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.message.boards.model.impl.MBBanModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.message.boards.model.impl.MBBanImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBBan
 * @generated
 */
@ProviderType
public interface MBBanModel
	extends BaseModel<MBBan>, CTModel<MBBan>, MVCCModel, ShardedModel,
			StagedGroupedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message boards ban model instance should use the {@link MBBan} interface instead.
	 */

	/**
	 * Returns the primary key of this message boards ban.
	 *
	 * @return the primary key of this message boards ban
	 */
	@Override
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message boards ban.
	 *
	 * @param primaryKey the primary key of this message boards ban
	 */
	@Override
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this message boards ban.
	 *
	 * @return the mvcc version of this message boards ban
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this message boards ban.
	 *
	 * @param mvccVersion the mvcc version of this message boards ban
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the ct collection ID of this message boards ban.
	 *
	 * @return the ct collection ID of this message boards ban
	 */
	@Override
	public long getCtCollectionId();

	/**
	 * Sets the ct collection ID of this message boards ban.
	 *
	 * @param ctCollectionId the ct collection ID of this message boards ban
	 */
	@Override
	public void setCtCollectionId(long ctCollectionId);

	/**
	 * Returns the uuid of this message boards ban.
	 *
	 * @return the uuid of this message boards ban
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this message boards ban.
	 *
	 * @param uuid the uuid of this message boards ban
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ban ID of this message boards ban.
	 *
	 * @return the ban ID of this message boards ban
	 */
	public long getBanId();

	/**
	 * Sets the ban ID of this message boards ban.
	 *
	 * @param banId the ban ID of this message boards ban
	 */
	public void setBanId(long banId);

	/**
	 * Returns the group ID of this message boards ban.
	 *
	 * @return the group ID of this message boards ban
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this message boards ban.
	 *
	 * @param groupId the group ID of this message boards ban
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this message boards ban.
	 *
	 * @return the company ID of this message boards ban
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this message boards ban.
	 *
	 * @param companyId the company ID of this message boards ban
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this message boards ban.
	 *
	 * @return the user ID of this message boards ban
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this message boards ban.
	 *
	 * @param userId the user ID of this message boards ban
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this message boards ban.
	 *
	 * @return the user uuid of this message boards ban
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this message boards ban.
	 *
	 * @param userUuid the user uuid of this message boards ban
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this message boards ban.
	 *
	 * @return the user name of this message boards ban
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this message boards ban.
	 *
	 * @param userName the user name of this message boards ban
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this message boards ban.
	 *
	 * @return the create date of this message boards ban
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this message boards ban.
	 *
	 * @param createDate the create date of this message boards ban
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this message boards ban.
	 *
	 * @return the modified date of this message boards ban
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this message boards ban.
	 *
	 * @param modifiedDate the modified date of this message boards ban
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ban user ID of this message boards ban.
	 *
	 * @return the ban user ID of this message boards ban
	 */
	public long getBanUserId();

	/**
	 * Sets the ban user ID of this message boards ban.
	 *
	 * @param banUserId the ban user ID of this message boards ban
	 */
	public void setBanUserId(long banUserId);

	/**
	 * Returns the ban user uuid of this message boards ban.
	 *
	 * @return the ban user uuid of this message boards ban
	 */
	public String getBanUserUuid();

	/**
	 * Sets the ban user uuid of this message boards ban.
	 *
	 * @param banUserUuid the ban user uuid of this message boards ban
	 */
	public void setBanUserUuid(String banUserUuid);

	/**
	 * Returns the last publish date of this message boards ban.
	 *
	 * @return the last publish date of this message boards ban
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this message boards ban.
	 *
	 * @param lastPublishDate the last publish date of this message boards ban
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public MBBan cloneWithOriginalValues();

}