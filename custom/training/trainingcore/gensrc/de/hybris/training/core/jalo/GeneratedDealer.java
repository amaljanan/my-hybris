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
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.util.Utilities;
import de.hybris.training.core.constants.TrainingCoreConstants;
import de.hybris.training.core.jalo.Driver;
import de.hybris.training.core.jalo.Vehicle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Dealer}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedDealer extends GenericItem
{
	/** Qualifier of the <code>Dealer.dealerName</code> attribute **/
	public static final String DEALERNAME = "dealerName";
	/** Qualifier of the <code>Dealer.dealerAddress</code> attribute **/
	public static final String DEALERADDRESS = "dealerAddress";
	/** Qualifier of the <code>Dealer.dealerId</code> attribute **/
	public static final String DEALERID = "dealerId";
	/** Qualifier of the <code>Dealer.registrationNumber</code> attribute **/
	public static final String REGISTRATIONNUMBER = "registrationNumber";
	/** Relation ordering override parameter constants for DealerToVehicle from ((trainingcore))*/
	protected static String DEALERTOVEHICLE_SRC_ORDERED = "relation.DealerToVehicle.source.ordered";
	protected static String DEALERTOVEHICLE_TGT_ORDERED = "relation.DealerToVehicle.target.ordered";
	/** Relation disable markmodifed parameter constants for DealerToVehicle from ((trainingcore))*/
	protected static String DEALERTOVEHICLE_MARKMODIFIED = "relation.DealerToVehicle.markmodified";
	/** Qualifier of the <code>Dealer.driverId</code> attribute **/
	public static final String DRIVERID = "driverId";
	/** Relation ordering override parameter constants for DealerToDriver from ((trainingcore))*/
	protected static String DEALERTODRIVER_SRC_ORDERED = "relation.DealerToDriver.source.ordered";
	protected static String DEALERTODRIVER_TGT_ORDERED = "relation.DealerToDriver.target.ordered";
	/** Relation disable markmodifed parameter constants for DealerToDriver from ((trainingcore))*/
	protected static String DEALERTODRIVER_MARKMODIFIED = "relation.DealerToDriver.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(DEALERNAME, AttributeMode.INITIAL);
		tmp.put(DEALERADDRESS, AttributeMode.INITIAL);
		tmp.put(DEALERID, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerAddress</code> attribute.
	 * @return the dealerAddress
	 */
	public Address getDealerAddress(final SessionContext ctx)
	{
		return (Address)getProperty( ctx, DEALERADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerAddress</code> attribute.
	 * @return the dealerAddress
	 */
	public Address getDealerAddress()
	{
		return getDealerAddress( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerAddress</code> attribute. 
	 * @param value the dealerAddress
	 */
	public void setDealerAddress(final SessionContext ctx, final Address value)
	{
		setProperty(ctx, DEALERADDRESS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerAddress</code> attribute. 
	 * @param value the dealerAddress
	 */
	public void setDealerAddress(final Address value)
	{
		setDealerAddress( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerId</code> attribute.
	 * @return the dealerId
	 */
	public Integer getDealerId(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, DEALERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerId</code> attribute.
	 * @return the dealerId
	 */
	public Integer getDealerId()
	{
		return getDealerId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerId</code> attribute. 
	 * @return the dealerId
	 */
	public int getDealerIdAsPrimitive(final SessionContext ctx)
	{
		Integer value = getDealerId( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerId</code> attribute. 
	 * @return the dealerId
	 */
	public int getDealerIdAsPrimitive()
	{
		return getDealerIdAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerId</code> attribute. 
	 * @param value the dealerId
	 */
	public void setDealerId(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, DEALERID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerId</code> attribute. 
	 * @param value the dealerId
	 */
	public void setDealerId(final Integer value)
	{
		setDealerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerId</code> attribute. 
	 * @param value the dealerId
	 */
	public void setDealerId(final SessionContext ctx, final int value)
	{
		setDealerId( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerId</code> attribute. 
	 * @param value the dealerId
	 */
	public void setDealerId(final int value)
	{
		setDealerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerName</code> attribute.
	 * @return the dealerName
	 */
	public String getDealerName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, DEALERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.dealerName</code> attribute.
	 * @return the dealerName
	 */
	public String getDealerName()
	{
		return getDealerName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerName</code> attribute. 
	 * @param value the dealerName
	 */
	public void setDealerName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, DEALERNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.dealerName</code> attribute. 
	 * @param value the dealerName
	 */
	public void setDealerName(final String value)
	{
		setDealerName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.driverId</code> attribute.
	 * @return the driverId
	 */
	public Collection<Driver> getDriverId(final SessionContext ctx)
	{
		final List<Driver> items = getLinkedItems( 
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTODRIVER,
			"Driver",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.driverId</code> attribute.
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
			true,
			TrainingCoreConstants.Relations.DEALERTODRIVER,
			"Driver",
			null
		);
	}
	
	public long getDriverIdCount()
	{
		return getDriverIdCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.driverId</code> attribute. 
	 * @param value the driverId
	 */
	public void setDriverId(final SessionContext ctx, final Collection<Driver> value)
	{
		setLinkedItems( 
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTODRIVER,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTODRIVER_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.driverId</code> attribute. 
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
			true,
			TrainingCoreConstants.Relations.DEALERTODRIVER,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTODRIVER_MARKMODIFIED)
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
			true,
			TrainingCoreConstants.Relations.DEALERTODRIVER,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTODRIVER_MARKMODIFIED)
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
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Vehicle");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED);
		}
		ComposedType relationSecondEnd1 = TypeManager.getInstance().getComposedType("Driver");
		if(relationSecondEnd1.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(DEALERTODRIVER_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.registrationNumber</code> attribute.
	 * @return the registrationNumber
	 */
	public Collection<Vehicle> getRegistrationNumber(final SessionContext ctx)
	{
		final List<Vehicle> items = getLinkedItems( 
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			"Vehicle",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Dealer.registrationNumber</code> attribute.
	 * @return the registrationNumber
	 */
	public Collection<Vehicle> getRegistrationNumber()
	{
		return getRegistrationNumber( getSession().getSessionContext() );
	}
	
	public long getRegistrationNumberCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			"Vehicle",
			null
		);
	}
	
	public long getRegistrationNumberCount()
	{
		return getRegistrationNumberCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.registrationNumber</code> attribute. 
	 * @param value the registrationNumber
	 */
	public void setRegistrationNumber(final SessionContext ctx, final Collection<Vehicle> value)
	{
		setLinkedItems( 
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Dealer.registrationNumber</code> attribute. 
	 * @param value the registrationNumber
	 */
	public void setRegistrationNumber(final Collection<Vehicle> value)
	{
		setRegistrationNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to registrationNumber. 
	 * @param value the item to add to registrationNumber
	 */
	public void addToRegistrationNumber(final SessionContext ctx, final Vehicle value)
	{
		addLinkedItems( 
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to registrationNumber. 
	 * @param value the item to add to registrationNumber
	 */
	public void addToRegistrationNumber(final Vehicle value)
	{
		addToRegistrationNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from registrationNumber. 
	 * @param value the item to remove from registrationNumber
	 */
	public void removeFromRegistrationNumber(final SessionContext ctx, final Vehicle value)
	{
		removeLinkedItems( 
			ctx,
			true,
			TrainingCoreConstants.Relations.DEALERTOVEHICLE,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(DEALERTOVEHICLE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from registrationNumber. 
	 * @param value the item to remove from registrationNumber
	 */
	public void removeFromRegistrationNumber(final Vehicle value)
	{
		removeFromRegistrationNumber( getSession().getSessionContext(), value );
	}
	
}
