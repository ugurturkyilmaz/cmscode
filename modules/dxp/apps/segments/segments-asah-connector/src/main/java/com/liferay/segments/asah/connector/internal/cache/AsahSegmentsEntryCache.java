/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.segments.asah.connector.internal.cache;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.segments.asah.connector.internal.configuration.SegmentsAsahConfiguration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author David Arques
 */
@Component(
	configurationPid = "com.liferay.segments.asah.connector.internal.configuration.SegmentsAsahConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	service = AsahSegmentsEntryCache.class
)
public class AsahSegmentsEntryCache {

	public long[] getSegmentsEntryIds(String userId) {
		return _portalCache.get(_generateCacheKey(userId));
	}

	public void putSegmentsEntryIds(String userId, long[] segmentsEntryIds) {
		_portalCache.put(
			_generateCacheKey(userId), segmentsEntryIds,
			_anonymousTimeToLiveInSeconds);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		SegmentsAsahConfiguration segmentsAsahConfiguration =
			ConfigurableUtil.createConfigurable(
				SegmentsAsahConfiguration.class, properties);

		_anonymousTimeToLiveInSeconds =
			segmentsAsahConfiguration.
				anonymousUserSegmentsCacheExpirationTime();
	}

	@Reference(unbind = "-")
	protected void setMultiVMPool(MultiVMPool multiVMPool) {
		_portalCache = (PortalCache<String, long[]>)multiVMPool.getPortalCache(
			AsahSegmentsEntryCache.class.getName());
	}

	private String _generateCacheKey(String userId) {
		return _CACHE_PREFIX + userId;
	}

	private static final String _CACHE_PREFIX = "segments-";

	private volatile int _anonymousTimeToLiveInSeconds =
		PortalCache.DEFAULT_TIME_TO_LIVE;
	private PortalCache<String, long[]> _portalCache;

}