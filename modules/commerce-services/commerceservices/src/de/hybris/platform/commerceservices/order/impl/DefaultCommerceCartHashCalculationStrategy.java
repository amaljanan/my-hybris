/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order.impl;


import de.hybris.platform.commerceservices.order.CommerceCartHashCalculationStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceOrderParameter;
import de.hybris.platform.core.model.order.AbstractOrderModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.codec.Hex;


public class DefaultCommerceCartHashCalculationStrategy implements CommerceCartHashCalculationStrategy
{
	private static final Logger LOG = Logger.getLogger(DefaultCommerceCartHashCalculationStrategy.class);

	/**
	 * @deprecated Since 5.2.
	 */
	@Override
	@Deprecated(since = "5.2", forRemoval = true)
	public String buildHashForAbstractOrder(final AbstractOrderModel abstractOrderModel, final List<String> additionalValues)
	{
		final CommerceOrderParameter parameter = new CommerceOrderParameter();
		parameter.setOrder(abstractOrderModel);
		parameter.setAdditionalValues(additionalValues);
		return this.buildHashForAbstractOrder(parameter);
	}

	@Override
	public String buildHashForAbstractOrder(final CommerceOrderParameter parameter)
	{
		final AbstractOrderModel abstractOrderModel = parameter.getOrder();
		final StringBuilder orderValues = new StringBuilder();

		if (abstractOrderModel.getModifiedtime() != null)
		{
			orderValues.append(abstractOrderModel.getModifiedtime().toString());
		}

		final String orderValue = orderValues.toString();

		try
		{
			final MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(orderValue.getBytes());
			return String.valueOf(Hex.encode(md5.digest()));
		}
		catch (final NoSuchAlgorithmException e)
		{
			LOG.error("NoSuchAlgorithmException while computing the order hash. This should never happen.", e);
		}

		return orderValue;
	}

}
