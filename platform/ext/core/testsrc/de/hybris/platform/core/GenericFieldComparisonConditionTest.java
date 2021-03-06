/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.core;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.testframework.Assert;

import org.junit.Test;


/**
 * Unit tests for {@link GenericFieldComparisonCondition}
 */
@UnitTest
public class GenericFieldComparisonConditionTest
{

	private static final GenericSearchField ANY_FIELD = new GenericSearchField("TEST_FIELD");
	private static final GenericSearchField OTHER_FIELD = new GenericSearchField("TEST_OTHER_FIELD");

	@Test
	public void sameFieldsShouldBeEqual()
	{
		final GenericCondition condition1 = GenericCondition.getComparison(ANY_FIELD, Operator.EQUAL, ANY_FIELD);
		final GenericCondition condition2 = GenericCondition.getComparison(ANY_FIELD, Operator.EQUAL, ANY_FIELD);

		Assert.assertEquals(condition1, condition2);
	}

	@Test
	public void differentComparisonFieldsShouldNotBeEqual()
	{
		final GenericCondition condition1 = GenericCondition.getComparison(ANY_FIELD, Operator.EQUAL, ANY_FIELD);
		final GenericCondition condition2 = GenericCondition.getComparison(ANY_FIELD, Operator.EQUAL, OTHER_FIELD);

		Assert.assertNotEquals(condition1, condition2);
	}

}
