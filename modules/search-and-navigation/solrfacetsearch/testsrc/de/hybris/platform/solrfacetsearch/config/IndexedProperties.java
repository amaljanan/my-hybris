/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.config;

import de.hybris.platform.core.Registry;
import de.hybris.platform.solrfacetsearch.provider.FacetDisplayNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;

import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;


public final class IndexedProperties
{
	static private final String DEFAULT_RANGE_SET_QUALIFIER = "default";

	// Suppresses default constructor, ensuring non-instantiability.
	private IndexedProperties()
	{
	}

	public static boolean isRanged(final IndexedProperty property)
	{
		return !CollectionUtils.isEmpty(property.getValueRangeSets());
	}

	public static FieldValueProvider getFieldValueProvider(final IndexedProperty property)
	{
		final String name = property.getFieldValueProvider();
		return name == null ? null : Registry.getGlobalApplicationContext().getBean(name, FieldValueProvider.class);
	}

	public static FacetDisplayNameProvider getFacetDisplayNameProvider(final IndexedProperty property)
	{
		final String name = property.getFacetDisplayNameProvider();
		return name == null ? null : Registry.getGlobalApplicationContext().getBean(name, FacetDisplayNameProvider.class);
	}

	public static FacetSortProvider getFacetSortProvider(final IndexedProperty property)
	{
		final String name = property.getFacetSortProvider();
		return name == null ? null : Registry.getGlobalApplicationContext().getBean(name, FacetSortProvider.class);
	}

	public static List<ValueRange> getValueRanges(final IndexedProperty property, final String qualifier)
	{
		ValueRangeSet valueRangeSet;
		if (qualifier == null)
		{
			valueRangeSet = property.getValueRangeSets().get(DEFAULT_RANGE_SET_QUALIFIER);
		}
		else
		{
			valueRangeSet = property.getValueRangeSets().get(qualifier);
			if (valueRangeSet == null)
			{
				valueRangeSet = property.getValueRangeSets().get(DEFAULT_RANGE_SET_QUALIFIER);
			}
		}
		if (valueRangeSet != null)
		{
			return valueRangeSet.getValueRanges();
		}
		else
		{
			return Collections.emptyList();
		}
	}
}
