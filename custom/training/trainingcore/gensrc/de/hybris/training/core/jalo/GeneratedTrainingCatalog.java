/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 07-Jul-2021, 5:02:58 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.catalog.jalo.CatalogVersion;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem TrainingCatalog}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedTrainingCatalog extends GenericItem
{
	/** Qualifier of the <code>TrainingCatalog.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>TrainingCatalog.catalogVersion</code> attribute **/
	public static final String CATALOGVERSION = "catalogVersion";
	/** Qualifier of the <code>TrainingCatalog.configValue</code> attribute **/
	public static final String CONFIGVALUE = "configValue";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(CATALOGVERSION, AttributeMode.INITIAL);
		tmp.put(CONFIGVALUE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.catalogVersion</code> attribute.
	 * @return the catalogVersion - Catalog Version
	 */
	public CatalogVersion getCatalogVersion(final SessionContext ctx)
	{
		return (CatalogVersion)getProperty( ctx, CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.catalogVersion</code> attribute.
	 * @return the catalogVersion - Catalog Version
	 */
	public CatalogVersion getCatalogVersion()
	{
		return getCatalogVersion( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingCatalog.catalogVersion</code> attribute. 
	 * @param value the catalogVersion - Catalog Version
	 */
	protected void setCatalogVersion(final SessionContext ctx, final CatalogVersion value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+CATALOGVERSION+"' is not changeable", 0 );
		}
		setProperty(ctx, CATALOGVERSION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingCatalog.catalogVersion</code> attribute. 
	 * @param value the catalogVersion - Catalog Version
	 */
	protected void setCatalogVersion(final CatalogVersion value)
	{
		setCatalogVersion( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.configValue</code> attribute.
	 * @return the configValue - configValue
	 */
	public String getConfigValue(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONFIGVALUE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.configValue</code> attribute.
	 * @return the configValue - configValue
	 */
	public String getConfigValue()
	{
		return getConfigValue( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingCatalog.configValue</code> attribute. 
	 * @param value the configValue - configValue
	 */
	protected void setConfigValue(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+CONFIGVALUE+"' is not changeable", 0 );
		}
		setProperty(ctx, CONFIGVALUE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingCatalog.configValue</code> attribute. 
	 * @param value the configValue - configValue
	 */
	protected void setConfigValue(final String value)
	{
		setConfigValue( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.id</code> attribute.
	 * @return the id - Identifier
	 */
	public String getId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.id</code> attribute.
	 * @return the id - Identifier
	 */
	public String getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingCatalog.id</code> attribute. 
	 * @param value the id - Identifier
	 */
	public void setId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingCatalog.id</code> attribute. 
	 * @param value the id - Identifier
	 */
	public void setId(final String value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
}
