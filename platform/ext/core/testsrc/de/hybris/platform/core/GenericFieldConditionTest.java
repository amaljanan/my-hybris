/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.testframework.Assert;

import java.util.Map;

import org.junit.Test;


/**
 * Unit tests for {@link GenericFieldCondition}.
 */
@UnitTest
public class GenericFieldConditionTest
{

	private static final GenericSearchField ANY_SEARCH_FIELD = new GenericSearchField("TEST_FIELD");
	private static final GenericSearchField OTHER_SEARCH_FIELD = new GenericSearchField("TEST_OTHER_FIELD");

	@Test
	public void sameFieldAndOperatorShouldBeEqual()
	{
		final TestableGenericFieldCondition condition1 = new TestableGenericFieldCondition(ANY_SEARCH_FIELD, Operator.EQUAL);
		final TestableGenericFieldCondition condition2 = new TestableGenericFieldCondition(ANY_SEARCH_FIELD, Operator.EQUAL);

		Assert.assertEquals(condition1, condition2);
	}

	@Test
	public void differentFieldsShouldNotBeEqual()
	{
		final TestableGenericFieldCondition condition1 = new TestableGenericFieldCondition(ANY_SEARCH_FIELD, Operator.EQUAL);
		final TestableGenericFieldCondition condition2 = new TestableGenericFieldCondition(OTHER_SEARCH_FIELD, Operator.EQUAL);

		Assert.assertNotEquals(condition1, condition2);
	}

	@Test
	public void differentOperatorsShouldNotBeEqual()
	{
		final TestableGenericFieldCondition condition1 = new TestableGenericFieldCondition(ANY_SEARCH_FIELD, Operator.EQUAL);
		final TestableGenericFieldCondition condition2 = new TestableGenericFieldCondition(ANY_SEARCH_FIELD, Operator.UNEQUAL);

		Assert.assertNotEquals(condition1, condition2);
	}

	/**
	 * Subclass of {@link GenericFieldCondition} to make constructor accessible for testing.
	 */
	protected static class TestableGenericFieldCondition extends GenericFieldCondition
	{

		protected TestableGenericFieldCondition(final GenericSearchField field, final Operator operator)
		{
			super(field, operator);
		}

		@Override
		protected void checkOperator()
		{
			// No implementation
		}

		@Override
		public Map getResettableValues()
		{
			// No implementation
			return null;
		}

		@Override
		public void setResettableValue(final String key, final Object value)
		{
			// No implementation
		}

	}
}
