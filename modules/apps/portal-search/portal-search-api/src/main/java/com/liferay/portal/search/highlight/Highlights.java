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

package com.liferay.portal.search.highlight;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 */
@ProviderType
public interface Highlights {

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link
	 *             HighlightBuilderFactory#builder()}
	 */
	@Deprecated
	public HighlightBuilder builder();

	/**
	 * @deprecated As of Cavanaugh (7.4.x), with no direct replacement
	 */
	@Deprecated
	public FieldConfig fieldConfig(String field);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link
	 *             FieldConfigBuilderFactory#builder(String)}
	 */
	@Deprecated
	public FieldConfigBuilder fieldConfigBuilder();

	public Highlight highlight(FieldConfig fieldConfig);

}