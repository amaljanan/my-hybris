/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 07-Jul-2021, 5:02:58 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.util.Utilities;
import de.hybris.training.core.constants.TrainingCoreConstants;
import de.hybris.training.core.jalo.Dealer;
import de.hybris.training.core.jalo.Driver;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.product.Product Vehicle}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedVehicle extends Product
{
	/** Qualifier of the <code>Vehicle.registrationNumber</code> attribute **/
	public static final String REGISTRATIONNUMBER = "registrationNumber";
	/** Qualifier of the <code>Vehicle.dealerId</code> attribute **/
	public static final String DEALERID = "dealerId";
	/** Relation ordering override parameter constants for DealerToVehicle from ((trainingcore))*/
	protected static String DEALERTOVEHICLE_SRC_ORDERED = "relation.DealerToVehicle.source.ordered";
	protected static String DEALERTOVEHICLE_TGT_ORDERED = "relation.DealerToVehicle.target.ordered";
	/** Relation disable markmodifed parameter constants for DealerToVehicle from ((trainingcore))*/
	protected static String DEALERTOVEHICLE_MARKMODIFIED = "relation.DealerToVehicle.markmodified";
	/** Qualifier of the <code>Vehicle.driverId</code> attribute **/
	public static final String DRIVERID = "driverId";
	/** Relation ordering override parameter constants for DriverToVehicle from ((trainingcore))*/
	protected static String DRIVERTOVEHICLE_SRC_ORDERED = "relation.DriverToVehicle.source.ordered";
	protected static String DRIVERTOVEHICLE_TGT_ORDERED = "relation.DriverToVehicle.target.ordered";
	/** Relation disable markmodifed parameter constants for DriverToVehicle from ((trainingcore))*/
	protected static String DRIVERTOVEHICLE_MARKMODIFIED = "relation.DriverToVehicle.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Product.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(REGISTRATIONNUMBER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.dealerId</code> attribute.
	 * @return the dealerId
	 */
	public Collection<Dealer> getDealerId(final SessionContext ctx)
	{
		final List<Dealer> items = getLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			"Dealer",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.dealerId</code> attribute.
	 * @return the dealerId
	 */
	public Collection<Dealer> getDealerId()
	{
		return getDealerId( getSession().getSessionContext() );
	}
	
	public long getDealerIdCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			"Dealer",
			null
		);
	}
	
	public long getDealerIdCount()
	{
		return getDealerIdCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Vehicle.dealerId</code> attribute. 
	 * @param value the dealerId
	 */
	public void setDealerId(final SessionContext ctx, final Collection<Dealer> value)
	{
		setLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Vehicle.dealerId</code> attribute. 
	 * @param value the dealerId
	 */
	public void setDealerId(final Collection<Dealer> value)
	{
		setDealerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to dealerId. 
	 * @param value the item to add to dealerId
	 */
	public void addToDealerId(final SessionContext ctx, final Dealer value)
	{
		addLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to dealerId. 
	 * @param value the item to add to dealerId
	 */
	public void addToDealerId(final Dealer value)
	{
		addToDealerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from dealerId. 
	 * @param value the item to remove from dealerId
	 */
	public void removeFromDealerId(final SessionContext ctx, final Dealer value)
	{
		removeLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from dealerId. 
	 * @param value the item to remove from dealerId
	 */
	public void removeFromDealerId(final Dealer value)
	{
		removeFromDealerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.driverId</code> attribute.
	 * @return the driverId
	 */
	public Collection<Driver> getDriverId(final SessionContext ctx)
	{
		final List<Driver> items = getLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DRIVERTOVEHICLE,
			"Driver",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.driverId</code> attribute.
	 * @return the driverId
	 */
	public Collection<Driver> getDriverId()
	{
		return getDriverId( getSession().getSessionContext() );
	}
	
	public long getDriverIdCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			TrainingCoreConstants.Relations.DRIVERTOVEHICLE,
			"Driver",
			null
		);
	}
	
	public long getDriverIdCount()
	{
		return getDriverIdCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Vehicle.driverId</code> attribute. 
	 * @param value the driverId
	 */
	public void setDriverId(final SessionContext ctx, final Collection<Driver> value)
	{
		setLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DRIVERTOVEHICLE,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(DRIVERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Vehicle.driverId</code> attribute. 
	 * @param value the driverId
	 */
	public void setDriverId(final Collection<Driver> value)
	{
		setDriverId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to driverId. 
	 * @param value the item to add to driverId
	 */
	public void addToDriverId(final SessionContext ctx, final Driver value)
	{
		addLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DRIVERTOVEHICLE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DRIVERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to driverId. 
	 * @param value the item to add to driverId
	 */
	public void addToDriverId(final Driver value)
	{
		addToDriverId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from driverId. 
	 * @param value the item to remove from driverId
	 */
	public void removeFromDriverId(final SessionContext ctx, final Driver value)
	{
		removeLinkedItems( 
			ctx,
			false,
			TrainingCoreConstants.Relations.DRIVERTOVEHICLE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DRIVERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from driverId. 
	 * @param value the item to remove from driverId
	 */
	public void removeFromDriverId(final Driver value)
	{
		removeFromDriverId( getSession().getSessionContext(), value );
	}
	
	/**
	 * @deprecated since 2011, use {@link Utilities#getMarkModifiedOverride(de.hybris.platform.jalo.type.RelationType)
	 */
	@Override
	@Deprecated(since = "2105", forRemoval = true)
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Dealer");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED);
		}
		ComposedType relationSecondEnd1 = TypeManager.getInstance().getComposedType("Driver");
		if(relationSecondEnd1.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(DRIVERTOVEHICLE_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.registrationNumber</code> attribute.
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber(final SessionContext ctx)
	{
		return (String)getProperty( ctx, REGISTRATIONNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Vehicle.registrationNumber</code> attribute.
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber()
	{
		return getRegistrationNumber( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Vehicle.registrationNumber</code> attribute. 
	 * @param value the registrationNumber
	 */
	public void setRegistrationNumber(final SessionContext ctx, final String value)
	{
		setProperty(ctx, REGISTRATIONNUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Vehicle.registrationNumber</code> attribute. 
	 * @param value the registrationNumber
	 */
	public void setRegistrationNumber(final String value)
	{
		setRegistrationNumber( getSession().getSessionContext(), value );
	}
	
}
