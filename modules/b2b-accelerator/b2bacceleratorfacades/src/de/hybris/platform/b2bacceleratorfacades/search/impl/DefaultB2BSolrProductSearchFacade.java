/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.search.impl;

import de.hybris.platform.b2bacceleratorfacades.api.search.SearchFacade;
import de.hybris.platform.b2bacceleratorfacades.search.data.ProductSearchStateData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.data.AutocompleteSuggestionData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commercefacades.search.solrfacetsearch.impl.DefaultSolrProductSearchFacade;
import de.hybris.platform.commerceservices.search.facetdata.ProductSearchPageData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.converters.Populator;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of Search Facade to B2B Solr Product Search.
 *
 * @param <ITEM>
 *           type of item to be searched that extends ProductData.
 */
public class DefaultB2BSolrProductSearchFacade<ITEM extends ProductData> extends DefaultSolrProductSearchFacade<ITEM>
		implements SearchFacade<ProductData, ProductSearchStateData>
{
	private Populator<Object, ProductSearchPageData<SearchStateData, ITEM>> productSearchPageVariantsPopulator;

	@Override
	public SearchPageData<ProductData> search(final ProductSearchStateData searchState, final PageableData pageableData)
	{
		final ProductSearchPageData productSearchPageData = super.textSearch(searchState, pageableData);

		if (searchState.getPopulateVariants())
		{
			productSearchPageVariantsPopulator.populate(null, productSearchPageData);
		}

		return productSearchPageData;
	}

	@Override
	public List<AutocompleteSuggestionData> autocomplete(final ProductSearchStateData searchState)
	{
		if (searchState.getQuery() != null)
		{
			return super.getAutocompleteSuggestions(searchState.getQuery().getValue());
		}

		return Collections.emptyList();
	}

	@Required
	public void setProductSearchPageVariantsPopulator(
			final Populator<Object, ProductSearchPageData<SearchStateData, ITEM>> productSearchPageVariantsPopulator)
	{
		this.productSearchPageVariantsPopulator = productSearchPageVariantsPopulator;
	}

	protected Populator<Object, ProductSearchPageData<SearchStateData, ITEM>> getProductSearchPageVariantsPopulator()
	{
		return productSearchPageVariantsPopulator;
	}
}
