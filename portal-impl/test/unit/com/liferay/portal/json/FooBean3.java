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

package com.liferay.portal.json;

import com.liferay.petra.string.StringBundler;

import java.util.Arrays;

/**
 * @author Miguel Pastor
 */
public class FooBean3 {

	public double[] getDoubleArray() {
		return _doubleArray;
	}

	public int[] getIntegerArray() {
		return _integerArray;
	}

	public long[] getLongArray() {
		return _longArray;
	}

	public void setDoubleArray(double[] doubleArray) {
		_doubleArray = doubleArray;
	}

	public void setIntegerArray(int[] integerArray) {
		_integerArray = integerArray;
	}

	public void setLongArray(long[] longArray) {
		_longArray = longArray;
	}

	@Override
	public String toString() {
		return StringBundler.concat(
			"{doubleArray=", Arrays.toString(_doubleArray), ", integerArray=",
			Arrays.toString(_integerArray), ", longArray=",
			Arrays.toString(_longArray), "}");
	}

	private double[] _doubleArray;
	private int[] _integerArray;
	private long[] _longArray;

}