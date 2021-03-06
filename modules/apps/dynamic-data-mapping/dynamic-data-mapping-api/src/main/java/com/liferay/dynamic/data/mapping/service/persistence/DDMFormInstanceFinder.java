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

package com.liferay.dynamic.data.mapping.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface DDMFormInstanceFinder {

	public int countByKeywords(long companyId, long groupId, String keywords);

	public int countByC_G_N_D(
		long companyId, long groupId, String[] names, String[] descriptions,
		boolean andOperator);

	public int filterCountByKeywords(
		long companyId, long groupId, String keywords);

	public int filterCountByKeywords(
		long companyId, long groupId, String keywords, int status);

	public int filterCountByC_G(long companyId, long groupId);

	public int filterCountByC_G_N_D(
		long companyId, long groupId, String[] names, String[] descriptions,
		boolean andOperator);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
			filterFindByKeywords(
				long companyId, long groupId, String keywords, int status,
				int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
						orderByComparator);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
			filterFindByKeywords(
				long companyId, long groupId, String keywords, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
						orderByComparator);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
			filterFindByC_G(long companyId, long groupId, int start, int end);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
			filterFindByC_G_N_D(
				long companyId, long groupId, String[] names,
				String[] descriptions, boolean andOperator, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
						orderByComparator);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
			filterFindByC_G_N_D_S(
				long companyId, long groupId, String[] names,
				String[] descriptions, int status, boolean andOperator,
				int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
						orderByComparator);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance> findByKeywords(
			long companyId, long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
					orderByComparator);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstance> findByC_G_N_D(
			long companyId, long groupId, String[] names, String[] descriptions,
			boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.dynamic.data.mapping.model.DDMFormInstance>
					orderByComparator);

}