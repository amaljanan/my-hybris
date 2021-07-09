/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 07-Jul-2021, 5:03:02 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearchbackoffice.data.AbstractSearchRequestData;
import java.util.List;


import java.util.Objects;
public  class FacetFiltersRequestData extends AbstractSearchRequestData 
{

 

	/** <i>Generated property</i> for <code>FacetFiltersRequestData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String indexProperty;

	/** <i>Generated property</i> for <code>FacetFiltersRequestData.values</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private List<String> values;
	
	public FacetFiltersRequestData()
	{
		// default constructor
	}
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
	public void setValues(final List<String> values)
	{
		this.values = values;
	}

	public List<String> getValues() 
	{
		return values;
	}
	

}