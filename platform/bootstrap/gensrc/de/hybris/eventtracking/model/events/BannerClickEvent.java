/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 07-Jul-2021, 5:03:02 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.model.events;

import java.io.Serializable;

import de.hybris.eventtracking.model.events.AbstractTrackingEvent;

public  class BannerClickEvent extends AbstractTrackingEvent {


	/** <i>Generated property</i> for <code>BannerClickEvent.bannerId</code> property defined at extension <code>eventtrackingmodel</code>. */
		
	private String bannerId;
	
	public BannerClickEvent()
	{
		super();
	}

	public BannerClickEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setBannerId(final String bannerId)
	{
		this.bannerId = bannerId;
	}

	public String getBannerId() 
	{
		return bannerId;
	}
	


}
