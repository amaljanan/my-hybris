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
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type TrainingCatalog first defined at extension trainingcore.
 */
@SuppressWarnings("all")
public class TrainingCatalogModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "TrainingCatalog";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingCatalog.id</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingCatalog.catalogVersion</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>TrainingCatalog.configValue</code> attribute defined at extension <code>trainingcore</code>. */
	public static final String CONFIGVALUE = "configValue";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public TrainingCatalogModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public TrainingCatalogModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>TrainingCatalog</code> at extension <code>trainingcore</code>
	 * @param _configValue initial attribute declared by type <code>TrainingCatalog</code> at extension <code>trainingcore</code>
	 * @param _id initial attribute declared by type <code>TrainingCatalog</code> at extension <code>trainingcore</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TrainingCatalogModel(final CatalogVersionModel _catalogVersion, final String _configValue, final String _id)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setConfigValue(_configValue);
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>TrainingCatalog</code> at extension <code>trainingcore</code>
	 * @param _configValue initial attribute declared by type <code>TrainingCatalog</code> at extension <code>trainingcore</code>
	 * @param _id initial attribute declared by type <code>TrainingCatalog</code> at extension <code>trainingcore</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public TrainingCatalogModel(final CatalogVersionModel _catalogVersion, final String _configValue, final String _id, final ItemModel _owner)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setConfigValue(_configValue);
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.catalogVersion</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.configValue</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the configValue - configValue
	 */
	@Accessor(qualifier = "configValue", type = Accessor.Type.GETTER)
	public String getConfigValue()
	{
		return getPersistenceContext().getPropertyValue(CONFIGVALUE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrainingCatalog.id</code> attribute defined at extension <code>trainingcore</code>. 
	 * @return the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>TrainingCatalog.catalogVersion</code> attribute defined at extension <code>trainingcore</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the catalogVersion - Catalog Version
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>TrainingCatalog.configValue</code> attribute defined at extension <code>trainingcore</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the configValue - configValue
	 */
	@Accessor(qualifier = "configValue", type = Accessor.Type.SETTER)
	public void setConfigValue(final String value)
	{
		getPersistenceContext().setPropertyValue(CONFIGVALUE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>TrainingCatalog.id</code> attribute defined at extension <code>trainingcore</code>. 
	 *  
	 * @param value the id - Identifier
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
}
