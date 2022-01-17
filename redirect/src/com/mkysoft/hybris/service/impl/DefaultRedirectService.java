/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.mkysoft.hybris.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mkysoft.hybris.dao.RedirectDao;
import com.mkysoft.hybris.model.RedirectModel;
import com.mkysoft.hybris.service.RedirectService;


public class DefaultRedirectService implements RedirectService
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultRedirectService.class);

	final private RedirectDao redirectDao;

	public DefaultRedirectService(final RedirectDao redirectDao)
	{
		this.redirectDao = redirectDao;
	}

	@Override
	public Optional<RedirectModel> findRedirect(final HttpServletRequest request)
	{
		final String requestedUrl = request.getRequestURL().toString();
		LOG.debug("Requested Url is {}", requestedUrl);
		return redirectDao.findByRequestedUrl(requestedUrl).stream().findFirst();
	}
}
