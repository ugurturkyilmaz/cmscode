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

package com.liferay.commerce.shipping.engine.fixed.model.impl;

import com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOptionQualifier;
import com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionQualifierLocalServiceUtil;

/**
 * The extended model base implementation for the CommerceShippingFixedOptionQualifier service. Represents a row in the &quot;CSFixedOptionQualifier&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceShippingFixedOptionQualifierImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceShippingFixedOptionQualifierImpl
 * @see CommerceShippingFixedOptionQualifier
 * @generated
 */
public abstract class CommerceShippingFixedOptionQualifierBaseImpl
	extends CommerceShippingFixedOptionQualifierModelImpl
	implements CommerceShippingFixedOptionQualifier {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce shipping fixed option qualifier model instance should use the <code>CommerceShippingFixedOptionQualifier</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CommerceShippingFixedOptionQualifierLocalServiceUtil.
				addCommerceShippingFixedOptionQualifier(this);
		}
		else {
			CommerceShippingFixedOptionQualifierLocalServiceUtil.
				updateCommerceShippingFixedOptionQualifier(this);
		}
	}

}