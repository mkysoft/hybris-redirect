/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.mkysoft.hybris.setup;

import static com.mkysoft.hybris.constants.RedirectConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.mkysoft.hybris.constants.RedirectConstants;
import com.mkysoft.hybris.service.RedirectSetupService;


@SystemSetup(extension = RedirectConstants.EXTENSIONNAME)
public class RedirectSystemSetup
{
	private final RedirectSetupService redirectSetupService;

	public RedirectSystemSetup(final RedirectSetupService redirectSetupService)
	{
		this.redirectSetupService = redirectSetupService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		redirectSetupService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return RedirectSystemSetup.class.getResourceAsStream("/redirect/sap-hybris-platform.png");
	}
}
