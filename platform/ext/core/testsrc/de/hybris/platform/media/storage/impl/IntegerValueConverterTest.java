/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.media.storage.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;


public class IntegerValueConverterTest
{
	private final IntegerValueConverter converter = new IntegerValueConverter();


	@Test
	public void shouldConvertCorrectStringRepresentationOfInteger()
	{
		// given
		final String input = "10";

		// when
		final Integer converted = converter.convert(input);

		// then
		assertThat(converted).isNotNull().isEqualTo(10);
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionWhenInputIsNull()
	{
		// given
		final String input = null;

		try
		{
			// when
			converter.convert(input);
			fail("Should throw IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then
			assertThat(e).hasMessage("Conversion input cannot be null");
		}
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionWhenInputIsEmpty()
	{
		// given
		final String input = " ";

		try
		{
			// when
			converter.convert(input);
			fail("Should throw IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then
			assertThat(e).hasMessage(
					"Cannot convert property value: " + input + " into Integer (reason: " + e.getCause().getMessage() + ")");
		}
	}


	@Test
	public void shouldThrowIllegalArgumentExceptionWhenInputIsInvalidStringRepresentationOfInteger()
	{
		// given
		final String input = "blah";

		try
		{
			// when
			converter.convert(input);
			fail("Should throw IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then
			assertThat(e).hasMessage(
					"Cannot convert property value: " + input + " into Integer (reason: " + e.getCause().getMessage() + ")");
		}
	}
}
