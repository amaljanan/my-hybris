/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 07-Jul-2021, 5:02:58 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem TrainingSample}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedTrainingSample extends GenericItem
{
	/** Qualifier of the <code>TrainingSample.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>TrainingSample.firstname</code> attribute **/
	public static final String FIRSTNAME = "firstname";
	/** Qualifier of the <code>TrainingSample.lastname</code> attribute **/
	public static final String LASTNAME = "lastname";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(FIRSTNAME, AttributeMode.INITIAL);
		tmp.put(LASTNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingSample.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingSample.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.firstname</code> attribute.
	 * @return the firstname
	 */
	public String getFirstname(final SessionContext ctx)
	{
		return (String)getProperty( ctx, FIRSTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.firstname</code> attribute.
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return getFirstname( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingSample.firstname</code> attribute. 
	 * @param value the firstname
	 */
	public void setFirstname(final SessionContext ctx, final String value)
	{
		setProperty(ctx, FIRSTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingSample.firstname</code> attribute. 
	 * @param value the firstname
	 */
	public void setFirstname(final String value)
	{
		setFirstname( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.lastname</code> attribute.
	 * @return the lastname
	 */
	public String getLastname(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LASTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.lastname</code> attribute.
	 * @return the lastname
	 */
	public String getLastname()
	{
		return getLastname( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingSample.lastname</code> attribute. 
	 * @param value the lastname
	 */
	public void setLastname(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LASTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingSample.lastname</code> attribute. 
	 * @param value the lastname
	 */
	public void setLastname(final String value)
	{
		setLastname( getSession().getSessionContext(), value );
	}
	
}
