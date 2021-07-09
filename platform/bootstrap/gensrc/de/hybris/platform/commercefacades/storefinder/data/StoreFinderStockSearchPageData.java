/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 07-Jul-2021, 5:03:02 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.storefinder.data;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.storefinder.data.StoreFinderSearchPageData;


import java.util.Objects;
public  class StoreFinderStockSearchPageData<RESULT> extends StoreFinderSearchPageData<RESULT> 
{

 

	/** <i>Generated property</i> for <code>StoreFinderStockSearchPageData<RESULT>.product</code> property defined at extension <code>commercefacades</code>. */
		
	private ProductData product;
	
	public StoreFinderStockSearchPageData()
	{
		// default constructor
	}
	
	public void setProduct(final ProductData product)
	{
		this.product = product;
	}

	public ProductData getProduct() 
	{
		return product;
	}
	

}