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

package com.liferay.commerce.account.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Marco Leo
 */
public class NoSuchAccountGroupException extends NoSuchModelException {

	public NoSuchAccountGroupException() {
	}

	public NoSuchAccountGroupException(String msg) {
		super(msg);
	}

	public NoSuchAccountGroupException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAccountGroupException(Throwable throwable) {
		super(throwable);
	}

}