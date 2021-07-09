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
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.training.core.model.DealerModel;
import de.hybris.training.core.model.DriverModel;
import java.util.Collection;

/**
 * Generated model class for type Vehicle first defined at extension trainingcore.
 */
@SuppressWarnings("all")
public class VehicleModel extends ProductModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Vehicle";
	
	/**<i>Generated relation code constant for relation <code>DealerToVehicle</code> defining source attribute <code>dealerId</code> in extension <code>trainingcore</code>.</i>*/
	public static final String _DEALERTOVEHICLE = "DealerToVehicle";
	
	/**<i>Generated relation code constant for relation <code>DriverToVehicle</code> defining source attribute <code>driverId</code> in extension <code>trainingcore</code>.</i>*/
	public static final String _DRIVERTOVEHICLE = "DriverToVehicle";
	
	/** <i>Generated constant</i> - Attribute key of <code>Vehicle.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String REGISTRATIONNUMBER = "registrationNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>Vehicle.dealerId</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DEALERID = "dealerId";
	
	/** <i>Generated constant</i> - Attribute key of <code>Vehicle.driverId</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DRIVERID = "driverId";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public VehicleModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public VehicleModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 * @param _registrationNumber initial attribute declared by type <code>Vehicle</code> at extension <code>trainingcore</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public VehicleModel(final CatalogVersionModel _catalogVersion, final String _code, final String _registrationNumber)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setRegistrationNumber(_registrationNumber);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>Product</code> at extension <code>catalog</code>
	 * @param _code initial attribute declared by type <code>Product</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _registrationNumber initial attribute declared by type <code>Vehicle</code> at extension <code>trainingcore</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public VehicleModel(final CatalogVersionModel _catalogVersion, final String _code, final ItemModel _owner, final String _registrationNumber)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setOwner(_owner);
		setRegistrationNumber(_registrationNumber);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.dealerId</code> attribute defined at extension <code>trainingcore</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the dealerId
	 */
	@Accessor(qualifier = "dealerId", type = Accessor.Type.GETTER)
	public Collection<DealerModel> getDealerId()
	{
		return getPersistenceContext().getPropertyValue(DEALERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.driverId</code> attribute defined at extension <code>trainingcore</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the driverId
	 */
	@Accessor(qualifier = "driverId", type = Accessor.Type.GETTER)
	public Collection<DriverModel> getDriverId()
	{
		return getPersistenceContext().getPropertyValue(DRIVERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the registrationNumber
	 */
	@Accessor(qualifier = "registrationNumber", type = Accessor.Type.GETTER)
	public String getRegistrationNumber()
	{
		return getPersistenceContext().getPropertyValue(REGISTRATIONNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Vehicle.dealerId</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the dealerId
	 */
	@Accessor(qualifier = "dealerId", type = Accessor.Type.SETTER)
	public void setDealerId(final Collection<DealerModel> value)
	{
		getPersistenceContext().setPropertyValue(DEALERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Vehicle.driverId</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the driverId
	 */
	@Accessor(qualifier = "driverId", type = Accessor.Type.SETTER)
	public void setDriverId(final Collection<DriverModel> value)
	{
		getPersistenceContext().setPropertyValue(DRIVERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Vehicle.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the registrationNumber
	 */
	@Accessor(qualifier = "registrationNumber", type = Accessor.Type.SETTER)
	public void setRegistrationNumber(final String value)
	{
		getPersistenceContext().setPropertyValue(REGISTRATIONNUMBER, value);
	}
	
}
