/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.mkysoft.hybris.dao;

import java.util.List;

import com.mkysoft.hybris.model.RedirectModel;


/**
 *
 */
public interface RedirectDao
{

	/**
	 *
	 */
	List<RedirectModel> findByRequestedUrl(String requestedUrl);

}
