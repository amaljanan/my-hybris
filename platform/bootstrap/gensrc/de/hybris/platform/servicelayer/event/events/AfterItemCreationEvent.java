/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 07-Jul-2021, 5:03:03 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.event.events;

import java.io.Serializable;

import de.hybris.platform.servicelayer.event.events.AbstractPersistenceEvent;

public  class AfterItemCreationEvent extends AbstractPersistenceEvent {


	/** <i>Generated property</i> for <code>AfterItemCreationEvent.typeCode</code> property defined at extension <code>core</code>. */
		
	private String typeCode;
	
	public AfterItemCreationEvent()
	{
		super();
	}

	public AfterItemCreationEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	


}
