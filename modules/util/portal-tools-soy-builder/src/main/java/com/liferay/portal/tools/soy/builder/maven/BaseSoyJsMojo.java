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

package com.liferay.portal.tools.soy.builder.maven;

import com.liferay.portal.tools.soy.builder.commands.BaseSoyJsCommand;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.codehaus.plexus.util.Scanner;

import org.sonatype.plexus.build.incremental.BuildContext;

/**
 * @author Andrea Di Giorgi
 * @author Gregory Amerson
 */
public abstract class BaseSoyJsMojo<T extends BaseSoyJsCommand>
	extends AbstractMojo {

	public BaseSoyJsMojo() {
		command = createCommand();
	}

	@Override
	public void execute() throws MojoExecutionException {
		try {
			if (_buildContext.isIncremental()) {
				Scanner scanner = _buildContext.newScanner(_baseDir);

				scanner.setIncludes(new String[] {"", "**/*.soy"});

				scanner.scan();

				String[] includedFiles = scanner.getIncludedFiles();

				if (includedFiles.length > 0) {
					command.execute();
				}
			}
			else {
				command.execute();
			}
		}
		catch (Exception exception) {
			throw new MojoExecutionException(exception.getMessage(), exception);
		}
	}

	/**
	 * The directory containing the .soy.js files to process.
	 *
	 * @parameter
	 * @required
	 */
	public void setDir(File dir) {
		command.setDir(dir);
	}

	protected abstract T createCommand();

	protected final T command;

	/**
	 * @parameter default-value="${project.basedir}"
	 * @readonly
	 */
	private File _baseDir;

	/**
	 * @component
	 */
	private BuildContext _buildContext;

}