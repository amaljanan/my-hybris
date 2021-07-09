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
import de.hybris.training.core.model.DealerModel;
import de.hybris.training.core.model.VehicleModel;
import java.util.Collection;

/**
 * Generated model class for type Driver first defined at extension trainingcore.
 */
@SuppressWarnings("all")
public class DriverModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Driver";
	
	/**<i>Generated relation code constant for relation <code>DealerToDriver</code> defining source attribute <code>dealerId</code> in extension <code>trainingcore</code>.</i>*/
	public static final String _DEALERTODRIVER = "DealerToDriver";
	
	/** <i>Generated constant</i> - Attribute key of <code>Driver.driverId</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DRIVERID = "driverId";
	
	/** <i>Generated constant</i> - Attribute key of <code>Driver.driverName</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DRIVERNAME = "driverName";
	
	/** <i>Generated constant</i> - Attribute key of <code>Driver.experience</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String EXPERIENCE = "experience";
	
	/** <i>Generated constant</i> - Attribute key of <code>Driver.dealerId</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DEALERID = "dealerId";
	
	/** <i>Generated constant</i> - Attribute key of <code>Driver.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String REGISTRATIONNUMBER = "registrationNumber";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public DriverModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public DriverModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _driverId initial attribute declared by type <code>Driver</code> at extension <code>trainingcore</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public DriverModel(final Integer _driverId)
	{
		super();
		setDriverId(_driverId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _driverId initial attribute declared by type <code>Driver</code> at extension <code>trainingcore</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public DriverModel(final Integer _driverId, final ItemModel _owner)
	{
		super();
		setDriverId(_driverId);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Driver.dealerId</code> attribute defined at extension <code>trainingcore</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the dealerId
	 */
	@Accessor(qualifier = "dealerId", type = Accessor.Type.GETTER)
	public Collection<DealerModel> getDealerId()
	{
		return getPersistenceContext().getPropertyValue(DEALERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Driver.driverId</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the driverId
	 */
	@Accessor(qualifier = "driverId", type = Accessor.Type.GETTER)
	public Integer getDriverId()
	{
		return getPersistenceContext().getPropertyValue(DRIVERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Driver.driverName</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the driverName
	 */
	@Accessor(qualifier = "driverName", type = Accessor.Type.GETTER)
	public String getDriverName()
	{
		return getPersistenceContext().getPropertyValue(DRIVERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Driver.experience</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the experience
	 */
	@Accessor(qualifier = "experience", type = Accessor.Type.GETTER)
	public Integer getExperience()
	{
		return getPersistenceContext().getPropertyValue(EXPERIENCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Driver.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the registrationNumber
	 */
	@Accessor(qualifier = "registrationNumber", type = Accessor.Type.GETTER)
	public Collection<VehicleModel> getRegistrationNumber()
	{
		return getPersistenceContext().getPropertyValue(REGISTRATIONNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Driver.dealerId</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the dealerId
	 */
	@Accessor(qualifier = "dealerId", type = Accessor.Type.SETTER)
	public void setDealerId(final Collection<DealerModel> value)
	{
		getPersistenceContext().setPropertyValue(DEALERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Driver.driverId</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the driverId
	 */
	@Accessor(qualifier = "driverId", type = Accessor.Type.SETTER)
	public void setDriverId(final Integer value)
	{
		getPersistenceContext().setPropertyValue(DRIVERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Driver.driverName</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the driverName
	 */
	@Accessor(qualifier = "driverName", type = Accessor.Type.SETTER)
	public void setDriverName(final String value)
	{
		getPersistenceContext().setPropertyValue(DRIVERNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Driver.experience</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the experience
	 */
	@Accessor(qualifier = "experience", type = Accessor.Type.SETTER)
	public void setExperience(final Integer value)
	{
		getPersistenceContext().setPropertyValue(EXPERIENCE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Driver.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the registrationNumber
	 */
	@Accessor(qualifier = "registrationNumber", type = Accessor.Type.SETTER)
	public void setRegistrationNumber(final Collection<VehicleModel> value)
	{
		getPersistenceContext().setPropertyValue(REGISTRATIONNUMBER, value);
	}
	
}
