/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.strategies.impl;

import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.user.UserService;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;


public class DefaultCheckoutCustomerStrategy implements CheckoutCustomerStrategy
{
	private UserService userService;
	private CartService cartService;


	@Override
	public boolean isAnonymousCheckout()
	{
		return getUserService().isAnonymousUser(getUserService().getCurrentUser());
	}

	@Override
	public CustomerModel getCurrentUserForCheckout()
	{
		if (isAnonymousCheckout())
		{
			final CustomerModel checkoutCustomer = (CustomerModel) getUserService().getUserForUID(
					getCartService().getSessionCart().getUser().getUid());

			Assert.state(!getUserService().isAnonymousUser(checkoutCustomer), "Checkout user must not be the anonymous user");

			return checkoutCustomer;
		}
		return (CustomerModel) getUserService().getCurrentUser();
	}

	protected UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	protected CartService getCartService()
	{
		return cartService;
	}

	@Required
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

}
