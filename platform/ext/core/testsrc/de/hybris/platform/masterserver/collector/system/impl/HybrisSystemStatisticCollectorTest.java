/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.masterserver.collector.system.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.util.Config;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class HybrisSystemStatisticCollectorTest extends ServicelayerTransactionalBaseTest
{
	private HybrisSystemStatisticCollector collector;

	@Before
	public void setUp() throws Exception
	{
		collector = new HybrisSystemStatisticCollector();
	}

	@Test
	public void testCollectStatistics() throws Exception
	{
		// when
		final Map<String, Map<String, Object>> result = collector.collectStatistics();

		// then
		assertThat(result).isNotNull().isNotEmpty();
		assertThat(result.get("hybris")).isNotNull().isNotEmpty().hasSize(11);
		assertThat(result.get("hybris").get("licenseID")).isNotNull();
		assertThat(result.get("hybris").get("licenseExpirationDate")).isNotNull();
		assertThat(result.get("hybris").get("licenseCacheLimit")).isNotNull();
		assertThat(result.get("hybris").get("modules")).isNotNull();
		assertThat(result.get("hybris").get("slaveTenants")).isNotNull();
		assertThat(result.get("hybris").get("currentTenant")).isNotNull();
		assertThat(result.get("hybris").get("isDemoOrDevelop")).isNotNull();
		assertThat(result.get("hybris").get("daysLeftForDemoOrDevelop")).isNotNull();
		assertThat(result.get("hybris").get("buildNumber")).isEqualTo(Config.getParameter("build.number"));
		assertThat(result.get("hybris").get("buildVersion")).isEqualTo(Config.getParameter("build.version"));
		assertThat(result.get("hybris").get("applicationServer")).isNotNull();
	}
}
