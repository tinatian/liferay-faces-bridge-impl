/**
 * Copyright (c) 2000-2022 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.demos.bean;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;

import com.liferay.faces.demos.dto.BookingType;
import com.liferay.faces.demos.service.BookingTypeService;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
@Named("listModelBean")
public class ListModelBean {

	// Private Data Memebers
	private List<BookingType> bookingTypes;

	// Injections
	@Inject
	private BookingTypeService bookingTypeService;

	public List<BookingType> getBookingTypes() {
		return bookingTypes;
	}

	public BookingTypeService getBookingTypeService() {
		return bookingTypeService;
	}

	@PostConstruct
	public void postConstruct() {
		bookingTypes = bookingTypeService.getAllBookingTypes();
	}

	public void setBookingTypeService(BookingTypeService bookingTypeService) {

		// Injected via @Inject annotation
		this.bookingTypeService = bookingTypeService;
	}
}
