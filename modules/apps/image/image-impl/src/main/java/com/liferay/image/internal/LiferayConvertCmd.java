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

package com.liferay.image.internal;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.LinkedList;
import java.util.List;

import org.im4java.core.ConvertCmd;
import org.im4java.process.ProcessTask;

/**
 * @author Alexander Chow
 * @author Ivica Cardic
 */
public class LiferayConvertCmd extends ConvertCmd {

	public ProcessTask getProcessTask(
			String globalSearchPath, List<String> resourceLimits,
			List<String> commandArguments)
		throws Exception {

		setGlobalSearchPath(globalSearchPath);

		LinkedList<String> arguments = new LinkedList<>();

		arguments.addAll(_liferayConvertCmd.getCommand());
		arguments.addAll(resourceLimits);
		arguments.addAll(commandArguments);

		if (_log.isInfoEnabled()) {
			StringBundler sb = new StringBundler(arguments.size() * 2);

			for (String argument : arguments) {
				sb.append(argument);
				sb.append(StringPool.SPACE);
			}

			_log.info("Excecuting command '" + sb.toString() + "'");
		}

		return getProcessTask(arguments);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LiferayConvertCmd.class);

	private static final LiferayConvertCmd _liferayConvertCmd =
		new LiferayConvertCmd();

}