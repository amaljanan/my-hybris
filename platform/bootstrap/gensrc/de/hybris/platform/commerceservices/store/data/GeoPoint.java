/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 07-Jul-2021, 5:03:01 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.store.data;

import java.io.Serializable;


import java.util.Objects;
public  class GeoPoint  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>GeoPoint.latitude</code> property defined at extension <code>commerceservices</code>. */
		
	private double latitude;

	/** <i>Generated property</i> for <code>GeoPoint.longitude</code> property defined at extension <code>commerceservices</code>. */
		
	private double longitude;
	
	public GeoPoint()
	{
		// default constructor
	}
	
	public void setLatitude(final double latitude)
	{
		this.latitude = latitude;
	}

	public double getLatitude() 
	{
		return latitude;
	}
	
	public void setLongitude(final double longitude)
	{
		this.longitude = longitude;
	}

	public double getLongitude() 
	{
		return longitude;
	}
	

}