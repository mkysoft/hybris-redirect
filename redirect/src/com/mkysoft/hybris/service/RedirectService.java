/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.mkysoft.hybris.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.mkysoft.hybris.model.RedirectModel;


public interface RedirectService
{
	/**
	 * Find redirect model
	 */
	Optional<RedirectModel> findRedirect(HttpServletRequest request);
}
