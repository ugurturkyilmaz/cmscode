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

package com.liferay.sass.compiler.jni.internal;

import com.liferay.sass.compiler.SassCompiler;

import java.io.File;

import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Gregory Amerson
 */
public class JniSassCompilerTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		System.setProperty("jna.nosys", Boolean.TRUE.toString());
	}

	@Test
	public void testBoxShadowTransparent() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		String expectedOutput =
			"foo { box-shadow: 2px 4px 7px rgba(0, 0, 0, 0.5); }";
		String actualOutput = sassCompiler.compileString(
			"foo { box-shadow: 2px 4px 7px rgba(0, 0, 0, 0.5); }", "");

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	@Test
	public void testCompileFileClayCss() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		Class<?> clazz = getClass();

		URL url = clazz.getResource("dependencies/clay-css");

		File clayCssDir = new File(url.toURI());

		for (File inputFile : clayCssDir.listFiles()) {
			if (inputFile.isDirectory()) {
				continue;
			}

			String fileName = inputFile.getName();

			if (fileName.startsWith("_") || !fileName.endsWith("scss")) {
				continue;
			}

			String actualOutput = sassCompiler.compileFile(
				inputFile.getCanonicalPath(), "", true);

			Assert.assertNotNull("Testing: " + fileName, actualOutput);

			String expectedOutputFileName =
				"expected" + File.separator + fileName.replace("scss", "css");

			File expectedOutputFile = new File(
				clayCssDir, expectedOutputFileName);

			if (expectedOutputFile.exists()) {
				String expectedOutput = _read(expectedOutputFile.toPath());

				Assert.assertEquals(
					"Testing: " + fileName, _stripNewLines(expectedOutput),
					_stripNewLines(actualOutput));
			}
		}
	}

	@Test
	public void testCompileFileSassSpec() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		Class<?> clazz = getClass();

		URL url = clazz.getResource("dependencies/sass-spec");

		File sassSpecDir = new File(url.toURI());

		for (File testDir : sassSpecDir.listFiles()) {
			File inputFile = new File(testDir, "input.scss");

			String dirName = testDir.getName();

			if (!inputFile.exists() || dirName.endsWith("-4.0")) {
				continue;
			}

			String actualOutput = sassCompiler.compileFile(
				inputFile.getCanonicalPath(), "", false);

			Assert.assertNotNull("Testing: " + dirName, actualOutput);

			File expectedOutputFile = new File(testDir, "expected_output.css");

			String expectedOutput = _read(expectedOutputFile.toPath());

			Assert.assertEquals(
				"Testing: " + dirName, _stripNewLines(expectedOutput),
				_stripNewLines(actualOutput));
		}
	}

	@Test
	public void testCompileFileSassVariableWithUnicode() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		Class<?> clazz = getClass();

		URL url = clazz.getResource("dependencies");

		File inputDir = new File(url.toURI());

		File inputFile = new File(inputDir, "/unicode/input.scss");

		String actualOutput = sassCompiler.compileFile(
			inputFile.getCanonicalPath(), "");

		Assert.assertNotNull(actualOutput);

		File expectedOutputFile = new File(
			inputDir, "/unicode/expected_output.css");

		String expectedOutput = _read(expectedOutputFile.toPath());

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	@Test
	public void testCompileFileWithSourceMap() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		Class<?> clazz = getClass();

		URL url = clazz.getResource("dependencies");

		File inputDir = new File(url.toURI());

		File inputFile = new File(inputDir, "/sass-spec/14_imports/input.scss");

		File sourceMapFile = new File(
			inputDir, "/sass-spec/14_imports/.sass-cache/input.css.map");

		sourceMapFile.deleteOnExit();

		Assert.assertFalse(sourceMapFile.exists());

		String actualOutput = sassCompiler.compileFile(
			inputFile.getCanonicalPath(), "", true,
			sourceMapFile.getCanonicalPath());

		Assert.assertNotNull(actualOutput);

		Assert.assertTrue(sourceMapFile.exists());

		File expectedOutputFile = new File(
			inputDir, "/sourcemap/expected_output_custom_source_map.css");

		String expectedOutput = _read(expectedOutputFile.toPath());

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	@Test
	public void testCompileString() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		String expectedOutput = "foo { margin: 42px; }";
		String actualOutput = sassCompiler.compileString(
			"foo { margin: 21px * 2; }", "");

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	@Test
	public void testCompileStringSassVariableWithUnicode() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		Class<?> clazz = getClass();

		URL url = clazz.getResource("dependencies");

		File inputDir = new File(url.toURI());

		File inputFile = new File(inputDir, "/unicode/input.scss");

		String input = _read(inputFile.toPath());

		String actualOutput = sassCompiler.compileString(input, "");

		Assert.assertNotNull(actualOutput);

		File expectedOutputFile = new File(
			inputDir, "/unicode/expected_output.css");

		String expectedOutput = _read(expectedOutputFile.toPath());

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	@Test
	public void testCompileStringWithSourceMap() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler();

		Class<?> clazz = getClass();

		URL url = clazz.getResource("dependencies");

		File inputDir = new File(url.toURI());

		File inputFile = new File(inputDir, "/sass-spec/14_imports/input.scss");

		File sourceMapFile = new File(
			inputDir, "/sass-spec/14_imports/input.css.map");

		sourceMapFile.deleteOnExit();

		Assert.assertFalse(sourceMapFile.exists());

		String input = _read(inputFile.toPath());

		String actualOutput = sassCompiler.compileString(
			input, inputFile.getCanonicalPath(), "", true);

		Assert.assertNotNull(actualOutput);

		Assert.assertTrue(sourceMapFile.exists());

		File expectedOutputFile = new File(
			inputDir, "/sourcemap/expected_output.css");

		String expectedOutput = _read(expectedOutputFile.toPath());

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	@Test
	public void testSassPrecision() throws Exception {
		SassCompiler sassCompiler = new JniSassCompiler(10);

		String expectedOutput = ".foo { line-height: 1.428571429; }";
		String actualOutput = sassCompiler.compileString(
			"$val: 1.428571429;.foo { line-height: $val; }", "");

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));

		sassCompiler = new JniSassCompiler(3);

		expectedOutput = ".foo { line-height: 1.429; }";
		actualOutput = sassCompiler.compileString(
			"$val: 1.428571429;.foo { line-height: $val; }", "");

		Assert.assertEquals(
			_stripNewLines(expectedOutput), _stripNewLines(actualOutput));
	}

	private String _read(Path filePath) throws Exception {
		return new String(Files.readAllBytes(filePath));
	}

	private String _stripNewLines(String string) {
		string = string.replaceAll("\\n|\\r", "");

		return string.replaceAll("\\s", "");
	}

}