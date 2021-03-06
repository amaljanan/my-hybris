/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.stocknotificationfacades.url.impl;

import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.core.model.product.ProductModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.netty.util.internal.StringUtil;


/**
 * 
 */
public class StockNotificationSiteMessageUrlResolverTest
{
	private static final String URL = "url";

	private StockNotificationSiteMessageUrlResolver resolver;

	@Mock
	private UrlResolver<ProductModel> productModelUrlResolver;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		resolver = new StockNotificationSiteMessageUrlResolver();
		resolver.setProductModelUrlResolver(productModelUrlResolver);
	}

	@Test
	public void test_Resolve()
	{
		Assert.assertEquals(StringUtil.EMPTY_STRING, resolver.resolve(null));

		Mockito.when(productModelUrlResolver.resolve(Mockito.any())).thenReturn(URL);

		ProductModel source = new ProductModel();
		Assert.assertEquals(URL, resolver.resolve(source));


	}

}
