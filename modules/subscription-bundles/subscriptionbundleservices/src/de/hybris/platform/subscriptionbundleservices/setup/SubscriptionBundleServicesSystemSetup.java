/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionbundleservices.setup;

import de.hybris.platform.commerceservices.setup.CommerceServicesSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import de.hybris.platform.subscriptionbundleservices.constants.SubscriptionbundleservicesConstants;
import de.hybris.platform.util.Config;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * This class provides hooks into the system's initialization and update processes.
 * 
 */
@SystemSetup(extension = SubscriptionbundleservicesConstants.EXTENSIONNAME)
public class SubscriptionBundleServicesSystemSetup extends CommerceServicesSystemSetup
{
	private static final Logger LOG = Logger.getLogger(SubscriptionBundleServicesSystemSetup.class);
	
	protected static final String BOOLEAN_TRUE = "yes";
	protected static final String BOOLEAN_FALSE = "no";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";

	/**
	 * Generates the Dropdown and Multi-select boxes for the project data import
	 */
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();
		params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", false));

		return params;
	}

	@SystemSetup(extension = SubscriptionbundleservicesConstants.EXTENSIONNAME, type = Type.PROJECT, process = Process.ALL)
	public void createSampleData(final SystemSetupContext context)
	{
		if (getBooleanSystemSetupParameter(context, IMPORT_SAMPLE_DATA))
		{
			importImpexFile(context, "/resources/impex/subscriptionbundlesampledata.impex", false);
		}
	}
	
	/**
	 * Helper method for checking setting of a Boolean setup parameter.
	 *
	 * @param context
	 * @param key
	 * @return true if parameter is set to Yes
	 */
	protected boolean getBooleanSystemSetupParameter(final SystemSetupContext context, final String key)
	{
		final String setupParamKey = context.getExtensionName() + "_" + key;
		String parameterValue = context.getParameter(setupParamKey);

		if (parameterValue == null)
		{
			parameterValue = Config.getParameter(setupParamKey);
		}

		if (parameterValue != null)
		{
			if (BOOLEAN_TRUE.equals(parameterValue))
			{
				return true;
			}
			else if (BOOLEAN_FALSE.equals(parameterValue))
			{
				return false;
			}
		}

		// Have not been able to determine value from context or properties, fallback to default value
		final boolean defaultValue = getDefaultValueForBooleanSystemSetupParameter(key);
		LOG.debug("Missing setup parameter for key [" + key + "], falling back to defined default [" + defaultValue + "]");
		return defaultValue;
	}
	
	/**
	 * Helper method for creating a Boolean setup parameter.
	 *
	 * @param key
	 * @param label
	 * @param defaultValue
	 */
	protected SystemSetupParameter createBooleanSystemSetupParameter(final String key, final String label,
			final boolean defaultValue)
	{
		final SystemSetupParameter syncProductsParam = new SystemSetupParameter(key);
		syncProductsParam.setLabel(label);
		syncProductsParam.addValue(BOOLEAN_TRUE, defaultValue);
		syncProductsParam.addValue(BOOLEAN_FALSE, !defaultValue);
		return syncProductsParam;
	}
	
	/**
	 * Helper method for getting default value of a Boolean setup parameter.
	 *
	 * @param key
	 * @return the default value
	 */
	protected boolean getDefaultValueForBooleanSystemSetupParameter(final String key)
	{
		final List<SystemSetupParameter> initializationOptions = getInitializationOptions();
		if (initializationOptions == null)
		{
			return false;
		}

		for (final SystemSetupParameter option : initializationOptions)
		{
			if (key.equals(option.getKey()))
			{
				final String[] defaults = option.getDefaults();
				if (defaults != null && defaults.length > 0)
				{
					return BOOLEAN_TRUE.equals(defaults[0]);
				}
			}
		}

		return false;
	}

}
