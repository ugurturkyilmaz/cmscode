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

package com.liferay.portal.servlet.filters.aggregate;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.net.URL;
import java.net.URLConnection;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

/**
 * @author Shuyang Zhou
 */
public class ServletPaths {

	public static String getParentPath(String resourcePath) {
		if (Validator.isNull(resourcePath)) {
			throw new IllegalArgumentException("Resource path is null");
		}

		if (resourcePath.charAt(resourcePath.length() - 1) == CharPool.SLASH) {
			resourcePath = resourcePath.substring(0, resourcePath.length() - 1);
		}

		int index = resourcePath.lastIndexOf(CharPool.SLASH);

		if (index != -1) {
			resourcePath = resourcePath.substring(0, index);
		}

		return resourcePath;
	}

	public ServletPaths(ServletContext servletContext, String resourcePath) {
		if (servletContext == null) {
			throw new NullPointerException("Servlet context is null");
		}

		if (Validator.isNull(resourcePath)) {
			throw new IllegalArgumentException("Resource path is null");
		}

		_servletContext = servletContext;
		_resourcePath = resourcePath;
	}

	public ServletPaths down(String path) {
		String normalizedPath = _normalizePath(path);

		if (normalizedPath.isEmpty()) {
			return this;
		}

		return new ServletPaths(normalizedPath, _servletContext);
	}

	public String getContent() {
		try {
			URL resourceURL = _servletContext.getResource(_resourcePath);

			if (resourceURL == null) {
				return null;
			}

			URLConnection urlConnection = resourceURL.openConnection();

			return StringUtil.read(urlConnection.getInputStream());
		}
		catch (IOException ioException) {
			_log.error(ioException);
		}

		return null;
	}

	public String getResourcePath() {
		return _resourcePath;
	}

	private ServletPaths(String resourcePath, ServletContext servletContext) {
		_resourcePath = resourcePath;
		_servletContext = servletContext;
	}

	private String _normalizePath(String path) {
		if (Validator.isNull(path) || StringPool.SLASH.equals(path)) {
			return StringPool.BLANK;
		}

		int index = path.indexOf(CharPool.QUESTION);

		if (index != -1) {
			path = path.substring(0, index);
		}

		if (path.charAt(path.length() - 1) == CharPool.SLASH) {
			path = path.substring(0, path.length() - 1);
		}

		if ((path.charAt(0) != CharPool.SLASH) &&
			(_resourcePath.charAt(_resourcePath.length() - 1) !=
				CharPool.SLASH)) {

			path = StringPool.SLASH.concat(path);
		}

		if (path.contains("./")) {
			Path downPathObject = Paths.get(_resourcePath, path);

			downPathObject = downPathObject.normalize();

			path = downPathObject.toString();

			path = StringUtil.replace(
				path, CharPool.BACK_SLASH, CharPool.SLASH);
		}
		else {
			path = _resourcePath.concat(path);
		}

		return path;
	}

	private static final Log _log = LogFactoryUtil.getLog(ServletPaths.class);

	private final String _resourcePath;
	private final ServletContext _servletContext;

}