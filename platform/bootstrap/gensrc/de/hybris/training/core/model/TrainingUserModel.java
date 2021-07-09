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
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;

/**
 * Generated model class for type TrainingUser first defined at extension trainingcore.
 * <p>
 * Training user.
 */
@SuppressWarnings("all")
public class TrainingUserModel extends UserModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "TrainingUser";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingUser.age</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String AGE = "age";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingUser.experience</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String EXPERIENCE = "experience";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public TrainingUserModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public TrainingUserModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _loginDisabled initial attribute declared by type <code>User</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TrainingUserModel(final boolean _loginDisabled, final String _uid)
	{
		super();
		setLoginDisabled(_loginDisabled);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _customerReviews initial attribute declared by type <code>User</code> at extension <code>customerreview</code>
	 * @param _loginDisabled initial attribute declared by type <code>User</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TrainingUserModel(final Collection<CustomerReviewModel> _customerReviews, final boolean _loginDisabled, final ItemModel _owner, final String _uid)
	{
		super();
		setCustomerReviews(_customerReviews);
		setLoginDisabled(_loginDisabled);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingUser.age</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the age
	 */
	@Accessor(qualifier = "age", type = Accessor.Type.GETTER)
	public String getAge()
	{
		return getPersistenceContext().getPropertyValue(AGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingUser.experience</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the experience - Experience of training user
	 */
	@Accessor(qualifier = "experience", type = Accessor.Type.GETTER)
	public String getExperience()
	{
		return getPersistenceContext().getPropertyValue(EXPERIENCE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TrainingUser.age</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the age
	 */
	@Accessor(qualifier = "age", type = Accessor.Type.SETTER)
	public void setAge(final String value)
	{
		getPersistenceContext().setPropertyValue(AGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TrainingUser.experience</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the experience - Experience of training user
	 */
	@Accessor(qualifier = "experience", type = Accessor.Type.SETTER)
	public void setExperience(final String value)
	{
		getPersistenceContext().setPropertyValue(EXPERIENCE, value);
	}
	
}
