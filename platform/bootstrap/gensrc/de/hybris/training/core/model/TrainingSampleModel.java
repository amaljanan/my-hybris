/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 07-Jul-2021, 5:02:58 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.core.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type TrainingSample first defined at extension trainingcore.
 */
@SuppressWarnings("all")
public class TrainingSampleModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "TrainingSample";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingSample.code</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingSample.firstname</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String FIRSTNAME = "firstname";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingSample.lastname</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String LASTNAME = "lastname";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public TrainingSampleModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public TrainingSampleModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>TrainingSample</code> at extension <code>trainingcore</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TrainingSampleModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>TrainingSample</code> at extension <code>trainingcore</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TrainingSampleModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.code</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.firstname</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the firstname
	 */
	@Accessor(qualifier = "firstname", type = Accessor.Type.GETTER)
	public String getFirstname()
	{
		return getPersistenceContext().getPropertyValue(FIRSTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingSample.lastname</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the lastname
	 */
	@Accessor(qualifier = "lastname", type = Accessor.Type.GETTER)
	public String getLastname()
	{
		return getPersistenceContext().getPropertyValue(LASTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TrainingSample.code</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TrainingSample.firstname</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the firstname
	 */
	@Accessor(qualifier = "firstname", type = Accessor.Type.SETTER)
	public void setFirstname(final String value)
	{
		getPersistenceContext().setPropertyValue(FIRSTNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TrainingSample.lastname</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the lastname
	 */
	@Accessor(qualifier = "lastname", type = Accessor.Type.SETTER)
	public void setLastname(final String value)
	{
		getPersistenceContext().setPropertyValue(LASTNAME, value);
	}
	
}
