/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.mkysoft.hybris.service;

/**
 *
 */
public interface RedirectSetupService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
