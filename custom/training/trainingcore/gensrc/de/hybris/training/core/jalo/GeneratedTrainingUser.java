/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 07-Jul-2021, 5:02:58 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.User;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.user.User TrainingUser}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedTrainingUser extends User
{
	/** Qualifier of the <code>TrainingUser.age</code> attribute **/
	public static final String AGE = "age";
	/** Qualifier of the <code>TrainingUser.experience</code> attribute **/
	public static final String EXPERIENCE = "experience";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(User.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(AGE, AttributeMode.INITIAL);
		tmp.put(EXPERIENCE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingUser.age</code> attribute.
	 * @return the age
	 */
	public String getAge(final SessionContext ctx)
	{
		return (String)getProperty( ctx, AGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingUser.age</code> attribute.
	 * @return the age
	 */
	public String getAge()
	{
		return getAge( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingUser.age</code> attribute. 
	 * @param value the age
	 */
	public void setAge(final SessionContext ctx, final String value)
	{
		setProperty(ctx, AGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingUser.age</code> attribute. 
	 * @param value the age
	 */
	public void setAge(final String value)
	{
		setAge( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingUser.experience</code> attribute.
	 * @return the experience - Experience of training user
	 */
	public String getExperience(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EXPERIENCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingUser.experience</code> attribute.
	 * @return the experience - Experience of training user
	 */
	public String getExperience()
	{
		return getExperience( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingUser.experience</code> attribute. 
	 * @param value the experience - Experience of training user
	 */
	public void setExperience(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EXPERIENCE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrainingUser.experience</code> attribute. 
	 * @param value the experience - Experience of training user
	 */
	public void setExperience(final String value)
	{
		setExperience( getSession().getSessionContext(), value );
	}
	
}
