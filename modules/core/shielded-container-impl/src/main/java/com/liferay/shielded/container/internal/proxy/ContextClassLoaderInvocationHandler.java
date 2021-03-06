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

package com.liferay.shielded.container.internal.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Shuyang Zhou
 */
public class ContextClassLoaderInvocationHandler implements InvocationHandler {

	public ContextClassLoaderInvocationHandler(
		ClassLoader contextClassLoader, Object target) {

		_contextClassLoader = contextClassLoader;
		_target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		currentThread.setContextClassLoader(_contextClassLoader);

		try {
			return method.invoke(_target, args);
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	private final ClassLoader _contextClassLoader;
	private final Object _target;

}