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

package com.liferay.dynamic.data.mapping.kernel;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rafael Praxedes
 */
public class StructureDefinitionException extends PortalException {

	public StructureDefinitionException() {
	}

	public StructureDefinitionException(String msg) {
		super(msg);
	}

	public StructureDefinitionException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public StructureDefinitionException(Throwable throwable) {
		super(throwable);
	}

}