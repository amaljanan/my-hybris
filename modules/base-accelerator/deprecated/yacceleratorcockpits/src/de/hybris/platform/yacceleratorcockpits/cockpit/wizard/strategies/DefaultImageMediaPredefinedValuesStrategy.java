/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.yacceleratorcockpits.cockpit.wizard.strategies;

import de.hybris.platform.cockpit.session.impl.CreateContext;
import de.hybris.platform.cockpit.wizards.generic.strategies.PredefinedValuesStrategy;
import de.hybris.platform.core.model.media.MediaFolderModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.media.MediaService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

public class DefaultImageMediaPredefinedValuesStrategy implements PredefinedValuesStrategy
{
	private MediaService mediaService;
	private String mediaFolderName;

	@Override
	public Map<String, Object> getPredefinedValues(final CreateContext paramCreateContext)
	{
		final Map<String, Object> ret = new HashMap<String, Object>();

		final MediaFolderModel mediaFolder = findMediaFolder();
		if (mediaFolder != null)
		{
			ret.put(MediaModel._TYPECODE + "." + MediaModel.FOLDER, mediaFolder);
		}
		return ret;
	}

	protected MediaFolderModel findMediaFolder()
	{
		return getMediaService().getFolder(getMediaFolderName());
	}

	protected MediaService getMediaService()
	{
		return mediaService;
	}

	@Required
	public void setMediaService(final MediaService mediaService)
	{
		this.mediaService = mediaService;
	}

	protected String getMediaFolderName()
	{
		return mediaFolderName;
	}

	@Required
	public void setMediaFolderName(final String mediaFolderName)
	{
		this.mediaFolderName = mediaFolderName;
	}
}
