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

package com.liferay.portal.kernel.service;

/**
 * Provides a wrapper for {@link ContactService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactService
 * @generated
 */
public class ContactServiceWrapper
	implements ContactService, ServiceWrapper<ContactService> {

	public ContactServiceWrapper() {
		this(null);
	}

	public ContactServiceWrapper(ContactService contactService) {
		_contactService = contactService;
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Contact>
			getCompanyContacts(long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getCompanyContacts(companyId, start, end);
	}

	@Override
	public int getCompanyContactsCount(long companyId) {
		return _contactService.getCompanyContactsCount(companyId);
	}

	@Override
	public com.liferay.portal.kernel.model.Contact getContact(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getContact(contactId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Contact> getContacts(
			long classNameId, long classPK, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.kernel.model.Contact> orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getContacts(
			classNameId, classPK, start, end, orderByComparator);
	}

	@Override
	public int getContactsCount(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getContactsCount(classNameId, classPK);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _contactService.getOSGiServiceIdentifier();
	}

	@Override
	public ContactService getWrappedService() {
		return _contactService;
	}

	@Override
	public void setWrappedService(ContactService contactService) {
		_contactService = contactService;
	}

	private ContactService _contactService;

}