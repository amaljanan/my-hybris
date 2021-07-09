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
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.training.core.model.DriverModel;
import de.hybris.training.core.model.VehicleModel;
import java.util.Collection;

/**
 * Generated model class for type Dealer first defined at extension trainingcore.
 */
@SuppressWarnings("all")
public class DealerModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Dealer";
	
	/** <i>Generated constant</i> - Attribute key of <code>Dealer.dealerName</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DEALERNAME = "dealerName";
	
	/** <i>Generated constant</i> - Attribute key of <code>Dealer.dealerAddress</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DEALERADDRESS = "dealerAddress";
	
	/** <i>Generated constant</i> - Attribute key of <code>Dealer.dealerId</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DEALERID = "dealerId";
	
	/** <i>Generated constant</i> - Attribute key of <code>Dealer.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String REGISTRATIONNUMBER = "registrationNumber";
	
	/** <i>Generated constant</i> - Attribute key of <code>Dealer.driverId</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String DRIVERID = "driverId";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public DealerModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public DealerModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _dealerId initial attribute declared by type <code>Dealer</code> at extension <code>trainingcore</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public DealerModel(final Integer _dealerId)
	{
		super();
		setDealerId(_dealerId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _dealerId initial attribute declared by type <code>Dealer</code> at extension <code>trainingcore</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public DealerModel(final Integer _dealerId, final ItemModel _owner)
	{
		super();
		setDealerId(_dealerId);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerAddress</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the dealerAddress
	 */
	@Accessor(qualifier = "dealerAddress", type = Accessor.Type.GETTER)
	public AddressModel getDealerAddress()
	{
		return getPersistenceContext().getPropertyValue(DEALERADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerId</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the dealerId
	 */
	@Accessor(qualifier = "dealerId", type = Accessor.Type.GETTER)
	public Integer getDealerId()
	{
		return getPersistenceContext().getPropertyValue(DEALERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerName</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the dealerName
	 */
	@Accessor(qualifier = "dealerName", type = Accessor.Type.GETTER)
	public String getDealerName()
	{
		return getPersistenceContext().getPropertyValue(DEALERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.driverId</code> attribute defined at extension <code>trainingcore</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the driverId
	 */
	@Accessor(qualifier = "driverId", type = Accessor.Type.GETTER)
	public Collection<DriverModel> getDriverId()
	{
		return getPersistenceContext().getPropertyValue(DRIVERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the registrationNumber
	 */
	@Accessor(qualifier = "registrationNumber", type = Accessor.Type.GETTER)
	public Collection<VehicleModel> getRegistrationNumber()
	{
		return getPersistenceContext().getPropertyValue(REGISTRATIONNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Dealer.dealerAddress</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the dealerAddress
	 */
	@Accessor(qualifier = "dealerAddress", type = Accessor.Type.SETTER)
	public void setDealerAddress(final AddressModel value)
	{
		getPersistenceContext().setPropertyValue(DEALERADDRESS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Dealer.dealerId</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the dealerId
	 */
	@Accessor(qualifier = "dealerId", type = Accessor.Type.SETTER)
	public void setDealerId(final Integer value)
	{
		getPersistenceContext().setPropertyValue(DEALERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Dealer.dealerName</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the dealerName
	 */
	@Accessor(qualifier = "dealerName", type = Accessor.Type.SETTER)
	public void setDealerName(final String value)
	{
		getPersistenceContext().setPropertyValue(DEALERNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Dealer.driverId</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the driverId
	 */
	@Accessor(qualifier = "driverId", type = Accessor.Type.SETTER)
	public void setDriverId(final Collection<DriverModel> value)
	{
		getPersistenceContext().setPropertyValue(DRIVERID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Dealer.registrationNumber</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the registrationNumber
	 */
	@Accessor(qualifier = "registrationNumber", type = Accessor.Type.SETTER)
	public void setRegistrationNumber(final Collection<VehicleModel> value)
	{
		getPersistenceContext().setPropertyValue(REGISTRATIONNUMBER, value);
	}
	
}
