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

package com.liferay.batch.engine.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.io.Serializable;

import java.sql.Blob;

import java.util.Date;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BatchEngineExportTask service. Represents a row in the &quot;BatchEngineExportTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.batch.engine.model.impl.BatchEngineExportTaskModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.batch.engine.model.impl.BatchEngineExportTaskImpl</code>.
 * </p>
 *
 * @author Shuyang Zhou
 * @see BatchEngineExportTask
 * @generated
 */
@ProviderType
public interface BatchEngineExportTaskModel
	extends BaseModel<BatchEngineExportTask>, MVCCModel, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a batch engine export task model instance should use the {@link BatchEngineExportTask} interface instead.
	 */

	/**
	 * Returns the primary key of this batch engine export task.
	 *
	 * @return the primary key of this batch engine export task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this batch engine export task.
	 *
	 * @param primaryKey the primary key of this batch engine export task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this batch engine export task.
	 *
	 * @return the mvcc version of this batch engine export task
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this batch engine export task.
	 *
	 * @param mvccVersion the mvcc version of this batch engine export task
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this batch engine export task.
	 *
	 * @return the uuid of this batch engine export task
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this batch engine export task.
	 *
	 * @param uuid the uuid of this batch engine export task
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the batch engine export task ID of this batch engine export task.
	 *
	 * @return the batch engine export task ID of this batch engine export task
	 */
	public long getBatchEngineExportTaskId();

	/**
	 * Sets the batch engine export task ID of this batch engine export task.
	 *
	 * @param batchEngineExportTaskId the batch engine export task ID of this batch engine export task
	 */
	public void setBatchEngineExportTaskId(long batchEngineExportTaskId);

	/**
	 * Returns the company ID of this batch engine export task.
	 *
	 * @return the company ID of this batch engine export task
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this batch engine export task.
	 *
	 * @param companyId the company ID of this batch engine export task
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this batch engine export task.
	 *
	 * @return the user ID of this batch engine export task
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this batch engine export task.
	 *
	 * @param userId the user ID of this batch engine export task
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this batch engine export task.
	 *
	 * @return the user uuid of this batch engine export task
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this batch engine export task.
	 *
	 * @param userUuid the user uuid of this batch engine export task
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this batch engine export task.
	 *
	 * @return the create date of this batch engine export task
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this batch engine export task.
	 *
	 * @param createDate the create date of this batch engine export task
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this batch engine export task.
	 *
	 * @return the modified date of this batch engine export task
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this batch engine export task.
	 *
	 * @param modifiedDate the modified date of this batch engine export task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the callback url of this batch engine export task.
	 *
	 * @return the callback url of this batch engine export task
	 */
	@AutoEscape
	public String getCallbackURL();

	/**
	 * Sets the callback url of this batch engine export task.
	 *
	 * @param callbackURL the callback url of this batch engine export task
	 */
	public void setCallbackURL(String callbackURL);

	/**
	 * Returns the class name of this batch engine export task.
	 *
	 * @return the class name of this batch engine export task
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this batch engine export task.
	 *
	 * @param className the class name of this batch engine export task
	 */
	public void setClassName(String className);

	/**
	 * Returns the content of this batch engine export task.
	 *
	 * @return the content of this batch engine export task
	 */
	public Blob getContent();

	/**
	 * Sets the content of this batch engine export task.
	 *
	 * @param content the content of this batch engine export task
	 */
	public void setContent(Blob content);

	/**
	 * Returns the content type of this batch engine export task.
	 *
	 * @return the content type of this batch engine export task
	 */
	@AutoEscape
	public String getContentType();

	/**
	 * Sets the content type of this batch engine export task.
	 *
	 * @param contentType the content type of this batch engine export task
	 */
	public void setContentType(String contentType);

	/**
	 * Returns the end time of this batch engine export task.
	 *
	 * @return the end time of this batch engine export task
	 */
	public Date getEndTime();

	/**
	 * Sets the end time of this batch engine export task.
	 *
	 * @param endTime the end time of this batch engine export task
	 */
	public void setEndTime(Date endTime);

	/**
	 * Returns the error message of this batch engine export task.
	 *
	 * @return the error message of this batch engine export task
	 */
	@AutoEscape
	public String getErrorMessage();

	/**
	 * Sets the error message of this batch engine export task.
	 *
	 * @param errorMessage the error message of this batch engine export task
	 */
	public void setErrorMessage(String errorMessage);

	/**
	 * Returns the field names of this batch engine export task.
	 *
	 * @return the field names of this batch engine export task
	 */
	@AutoEscape
	public String getFieldNames();

	/**
	 * Sets the field names of this batch engine export task.
	 *
	 * @param fieldNames the field names of this batch engine export task
	 */
	public void setFieldNames(String fieldNames);

	/**
	 * Returns the execute status of this batch engine export task.
	 *
	 * @return the execute status of this batch engine export task
	 */
	@AutoEscape
	public String getExecuteStatus();

	/**
	 * Sets the execute status of this batch engine export task.
	 *
	 * @param executeStatus the execute status of this batch engine export task
	 */
	public void setExecuteStatus(String executeStatus);

	/**
	 * Returns the parameters of this batch engine export task.
	 *
	 * @return the parameters of this batch engine export task
	 */
	public Map<String, Serializable> getParameters();

	/**
	 * Sets the parameters of this batch engine export task.
	 *
	 * @param parameters the parameters of this batch engine export task
	 */
	public void setParameters(Map<String, Serializable> parameters);

	/**
	 * Returns the processed items count of this batch engine export task.
	 *
	 * @return the processed items count of this batch engine export task
	 */
	public int getProcessedItemsCount();

	/**
	 * Sets the processed items count of this batch engine export task.
	 *
	 * @param processedItemsCount the processed items count of this batch engine export task
	 */
	public void setProcessedItemsCount(int processedItemsCount);

	/**
	 * Returns the start time of this batch engine export task.
	 *
	 * @return the start time of this batch engine export task
	 */
	public Date getStartTime();

	/**
	 * Sets the start time of this batch engine export task.
	 *
	 * @param startTime the start time of this batch engine export task
	 */
	public void setStartTime(Date startTime);

	/**
	 * Returns the task item delegate name of this batch engine export task.
	 *
	 * @return the task item delegate name of this batch engine export task
	 */
	@AutoEscape
	public String getTaskItemDelegateName();

	/**
	 * Sets the task item delegate name of this batch engine export task.
	 *
	 * @param taskItemDelegateName the task item delegate name of this batch engine export task
	 */
	public void setTaskItemDelegateName(String taskItemDelegateName);

	/**
	 * Returns the total items count of this batch engine export task.
	 *
	 * @return the total items count of this batch engine export task
	 */
	public int getTotalItemsCount();

	/**
	 * Sets the total items count of this batch engine export task.
	 *
	 * @param totalItemsCount the total items count of this batch engine export task
	 */
	public void setTotalItemsCount(int totalItemsCount);

	@Override
	public BatchEngineExportTask cloneWithOriginalValues();

}