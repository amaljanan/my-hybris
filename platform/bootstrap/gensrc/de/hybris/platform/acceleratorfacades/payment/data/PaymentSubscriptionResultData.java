/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 07-Jul-2021, 5:03:01 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorfacades.payment.data;

import de.hybris.platform.acceleratorservices.payment.data.PaymentSubscriptionResult;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;


import java.util.Objects;
public  class PaymentSubscriptionResultData extends PaymentSubscriptionResult 
{

 

	/** <i>Generated property</i> for <code>PaymentSubscriptionResultData.storedCard</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private CCPaymentInfoData storedCard;
	
	public PaymentSubscriptionResultData()
	{
		// default constructor
	}
	
	public void setStoredCard(final CCPaymentInfoData storedCard)
	{
		this.storedCard = storedCard;
	}

	public CCPaymentInfoData getStoredCard() 
	{
		return storedCard;
	}
	

}