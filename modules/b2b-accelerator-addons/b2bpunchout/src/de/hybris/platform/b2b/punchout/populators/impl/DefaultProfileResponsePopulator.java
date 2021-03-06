/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.populators.impl;

import de.hybris.platform.acceleratorservices.urlresolver.SiteBaseUrlResolutionService;
import de.hybris.platform.b2b.punchout.util.CXmlDateUtil;
import de.hybris.platform.basecommerce.jalo.site.BaseSite;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.site.BaseSiteService;

import java.util.Date;
import java.util.Map;

import org.cxml.CXML;
import org.cxml.ProfileResponse;
import org.cxml.Transaction;
import org.cxml.URL;
import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of a {@link Populator} that fills in all {@link ProfileResponse} details.
 */
public class DefaultProfileResponsePopulator implements Populator<CXML, ProfileResponse>
{

	private Map<String, String> supportedTransactionURLPaths;

	private BaseSiteService baseSiteService;

	private SiteBaseUrlResolutionService siteBaseUrlResolutionService;

	private CXmlDateUtil cXmlDateUtil;

	private Date lastRefreshTime = new Date();

	/** 
	 * 
	 */
	@Override
	public void populate(final CXML source, final ProfileResponse target) throws ConversionException
	{
		target.setEffectiveDate(cXmlDateUtil.formatDate(new Date()));
		target.setLastRefresh(cXmlDateUtil.formatDate(lastRefreshTime));

		for (final Map.Entry<String, String> entry : getSupportedTransactionURLPaths().entrySet())
		{
			final Transaction transaction = new Transaction();
			transaction.setRequestName(entry.getKey());
			final URL url = new URL();
			url.setvalue(formCompleteURL(entry.getValue()));
			transaction.setURL(url);
			target.getTransaction().add(transaction);
		}
	}

	/**
	 * Forms a complete URL by using the {@link SiteBaseUrlResolutionService} and the given path.
	 * 
	 * @param urlPath
	 *           the URL path value
	 * @return full secure URL for this {@link BaseSite}
	 */
	protected String formCompleteURL(final String urlPath)
	{
		return siteBaseUrlResolutionService.getWebsiteUrlForSite(baseSiteService.getCurrentBaseSite(), "", true, urlPath);
	}

	public Map<String, String> getSupportedTransactionURLPaths()
	{
		return supportedTransactionURLPaths;
	}

	@Required
	public void setSupportedTransactionURLPaths(final Map<String, String> supportedTransactionURLPaths)
	{
		this.supportedTransactionURLPaths = supportedTransactionURLPaths;
	}

	public BaseSiteService getBaseSiteService()
	{
		return baseSiteService;
	}

	@Required
	public void setBaseSiteService(final BaseSiteService baseSiteService)
	{
		this.baseSiteService = baseSiteService;
	}

	public SiteBaseUrlResolutionService getSiteBaseUrlResolutionService()
	{
		return siteBaseUrlResolutionService;
	}

	@Required
	public void setSiteBaseUrlResolutionService(final SiteBaseUrlResolutionService siteBaseUrlResolutionService)
	{
		this.siteBaseUrlResolutionService = siteBaseUrlResolutionService;
	}

	public CXmlDateUtil getcXmlDateUtil()
	{
		return cXmlDateUtil;
	}

	public void setcXmlDateUtil(final CXmlDateUtil cXmlDateUtil)
	{
		this.cXmlDateUtil = cXmlDateUtil;
	}

	public Date getLastRefreshTime()
	{
		return lastRefreshTime;
	}

	public void setLastRefreshTime(final Date lastRefreshTime)
	{
		this.lastRefreshTime = lastRefreshTime;
	}

}
