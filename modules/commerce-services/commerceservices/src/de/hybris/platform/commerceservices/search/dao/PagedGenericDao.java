/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.search.dao;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.servicelayer.internal.dao.SortParameters;

import java.util.Map;


/**
 * Paged version of the {@link de.hybris.platform.servicelayer.internal.dao.GenericDao}.
 *
 * @deprecated Since 6.6. Use {@link de.hybris.platform.servicelayer.search.paginated.dao.PaginatedGenericDao} instead
 * @param <M>
 *           The type of item returned from the search
 */
@Deprecated(since = "6.6", forRemoval = true)
public interface PagedGenericDao<M>
{
	/**
	 * Searches for all instances of model given as a generic type.
	 *
	 * @param pageableData
	 *           the page of results to return
	 * @return The matching page of search results
	 */
	SearchPageData<M> find(PageableData pageableData);

	/**
	 * Searches for all instances of model given as a generic type matching given parameters.
	 *
	 * @param params
	 *           parameters to add to search query as {@link java.util.Map} with parameter name as a key and parameter
	 *           value as a value.
	 * @param pageableData
	 *           the page of results to return
	 * @return The matching page of search results
	 */
	SearchPageData<M> find(Map<String, ?> params, PageableData pageableData);

	/**
	 * Searches for all instances of model given as a generic type using given
	 * {@link de.hybris.platform.servicelayer.internal.dao.SortParameters} to sort results.
	 *
	 * @param sortParameters
	 *           {@link de.hybris.platform.servicelayer.internal.dao.SortParameters} object used to sort results.
	 * @param pageableData
	 *           the page of results to return
	 * @return The matching page of search results
	 */
	SearchPageData<M> find(SortParameters sortParameters, PageableData pageableData);

	/**
	 * Searches for all instances of model given as a generic type matching given parameters using given
	 * {@link SortParameters} to sort results.
	 *
	 * @param params
	 *           parameters to add to search query as {@link Map} with parameter name as a key and parameter value as a
	 *           value.
	 * @param sortParameters
	 *           {@link SortParameters} object used to sort results.
	 * @param pageableData
	 *           the page of results to return
	 * @return The matching page of search results
	 */
	SearchPageData<M> find(Map<String, ?> params, SortParameters sortParameters, PageableData pageableData);
}
