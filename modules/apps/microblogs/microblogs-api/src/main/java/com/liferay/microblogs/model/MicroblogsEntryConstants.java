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

package com.liferay.microblogs.model;

/**
 * @author     Jonathan Lee
 * @deprecated As of Athanasius (7.3.x), replaced by {@link
 *             com.liferay.microblogs.constants.MicroblogsEntryConstants}
 */
@Deprecated
public class MicroblogsEntryConstants {

	public static final int NOTIFICATION_TYPE_REPLY = 0;

	public static final int NOTIFICATION_TYPE_REPLY_TO_REPLIED = 1;

	public static final int NOTIFICATION_TYPE_REPLY_TO_TAGGED = 2;

	public static final int NOTIFICATION_TYPE_TAG = 3;

	public static final int NOTIFICATION_TYPE_UNKNOWN = -1;

	public static final int TYPE_EVERYONE = 0;

	public static final int TYPE_REPLY = 1;

	public static final int TYPE_REPOST = 2;

}