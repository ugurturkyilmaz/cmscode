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

package com.liferay.layout.page.template.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LayoutPageTemplateEntry service. Represents a row in the &quot;LayoutPageTemplateEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.layout.page.template.model.impl.LayoutPageTemplateEntryImpl"
)
@ProviderType
public interface LayoutPageTemplateEntry
	extends LayoutPageTemplateEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.layout.page.template.model.impl.LayoutPageTemplateEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LayoutPageTemplateEntry, Long>
		LAYOUT_PAGE_TEMPLATE_ENTRY_ID_ACCESSOR =
			new Accessor<LayoutPageTemplateEntry, Long>() {

				@Override
				public Long get(
					LayoutPageTemplateEntry layoutPageTemplateEntry) {

					return layoutPageTemplateEntry.
						getLayoutPageTemplateEntryId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<LayoutPageTemplateEntry> getTypeClass() {
					return LayoutPageTemplateEntry.class;
				}

			};
	public static final Accessor<LayoutPageTemplateEntry, String>
		NAME_ACCESSOR = new Accessor<LayoutPageTemplateEntry, String>() {

			@Override
			public String get(LayoutPageTemplateEntry layoutPageTemplateEntry) {
				return layoutPageTemplateEntry.getName();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<LayoutPageTemplateEntry> getTypeClass() {
				return LayoutPageTemplateEntry.class;
			}

		};

	public String getImagePreviewURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay);

}