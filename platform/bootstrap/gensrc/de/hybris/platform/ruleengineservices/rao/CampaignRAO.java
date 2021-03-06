/*
* ----------------------------------------------------------------
* --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
* --- Generated at 07-Jul-2021, 5:03:03 PM
* ----------------------------------------------------------------
*
* Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
*/
package de.hybris.platform.ruleengineservices.rao;

import java.io.Serializable;
import java.util.Objects;

public  class CampaignRAO  implements Serializable 
{

	/** <i>Generated property</i> for <code>CampaignRAO.code</code> property defined at extension <code>ruleengineservices</code>. */
	private String code;
		
	public CampaignRAO()
	{
		// default constructor
	}
	
		public void setCode(final String code)
	{
		this.code = code;
	}
		public String getCode() 
	{
		return code;
	}
		
	
		@Override
	public boolean equals(final Object o)
	{
		
		if (o == null) return false;
		if (o == this) return true;

		if (getClass() != o.getClass()) return false;

		final CampaignRAO other = (CampaignRAO) o;
		return				Objects.equals(getCode(), other.getCode())
  ;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

				attribute = code;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		
		return result;
	}
	}
