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

package com.liferay.frontend.js.loader.modules.extender.npm;

import com.liferay.portal.kernel.servlet.PortalWebResources;

/**
 * Should be implemented by every {@link PortalWebResources} that is based on
 * Javascript content and needs to be notified every time a {@link JSBundle}
 * gets started in order, for example, to refresh its cached content.
 *
 * @author Mariano Álvaro Sáiz
 */
public interface JavaScriptAwarePortalWebResources extends PortalWebResources {

	public void updateLastModifed(long lastModified);

}