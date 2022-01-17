package com.mkysoft.hybris.filters;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mkysoft.hybris.model.RedirectModel;
import com.mkysoft.hybris.service.RedirectService;

/**
 *
 */
public class RedirectFilter extends OncePerRequestFilter
{
	private static final Logger LOG = LoggerFactory.getLogger(RedirectFilter.class);

	private final RedirectService redirectService;

	public RedirectFilter(final RedirectService redirectService)
	{
		this.redirectService = redirectService;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException
	{
		final Optional<RedirectModel> redirect = redirectService.findRedirect(request);
		if (redirect.isPresent())
		{
			LOG.trace("Redirecting to '{}', requested url '' match with: '{}'", redirect.get().getTargetUrl(),
					request.getRequestURI(),
					redirect.get().getTargetUrl());
			response.setStatus(HttpStatus.valueOf(redirect.get().getHttpCode().getCode()).value());
			response.addHeader("Location", redirect.get().getTargetUrl());
			return;
		}

		filterChain.doFilter(request, response);
	}
}
