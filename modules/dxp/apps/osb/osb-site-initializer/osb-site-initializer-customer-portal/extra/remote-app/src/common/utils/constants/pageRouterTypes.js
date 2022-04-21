/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import getLiferaySiteName from '../getLiferaySiteName';
import {API_BASE_URL} from './apiBaseUrl';
import {ROUTE_TYPES} from './routeTypes';

const BASE_API = `${API_BASE_URL}/${getLiferaySiteName()}`;

export const PAGE_ROUTER_TYPES = {
	onboarding: (externalReferenceCode) =>
		`${BASE_API}/${ROUTE_TYPES.onboarding}/#/${externalReferenceCode}`,
	project: (externalReferenceCode) =>
		`${BASE_API}/${ROUTE_TYPES.project}/#/${externalReferenceCode}`,
};
