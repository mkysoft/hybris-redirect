/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.mkysoft.hybris.dao.impl;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mkysoft.hybris.dao.RedirectDao;
import com.mkysoft.hybris.model.RedirectModel;

/**
 *
 */
public class DefaultRedirectDao implements RedirectDao
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultRedirectDao.class);

   private static final String SEARCH_QUERY = "SELECT {rt:" + ItemModel.PK + "}" //
			+ " FROM {" + RedirectModel._TYPECODE + " AS rt}" //
			+ " WHERE ?requestedUrl LIKE {rt:" + RedirectModel.REQUESTEDURL + "}";

	private final FlexibleSearchService flexibleSearchService;

	public DefaultRedirectDao(final FlexibleSearchService flexibleSearchService) {
		this.flexibleSearchService = flexibleSearchService;
   }

	@Override
	public List<RedirectModel> findByRequestedUrl(final String requestedUrl)
	{
		final Map<String, Object> params = new HashMap<>();
		params.put("requestedUrl", "%" + requestedUrl + "%");

		final FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(SEARCH_QUERY, params);

		List<RedirectModel> searchResult = flexibleSearchService.<RedirectModel> search(flexibleSearchQuery).getResult();
		if (searchResult == null)
		{
			searchResult = Collections.emptyList();
		}
		return searchResult;
	}
}