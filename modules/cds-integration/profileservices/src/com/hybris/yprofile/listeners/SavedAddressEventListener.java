/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.hybris.yprofile.listeners;

import com.hybris.yprofile.services.ProfileTransactionService;
import de.hybris.platform.commerceservices.event.AbstractSiteEventListener;
import de.hybris.platform.commerceservices.event.SavedAddressEvent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class SavedAddressEventListener extends AbstractSiteEventListener<SavedAddressEvent> {

    private static final Logger LOG = Logger.getLogger(SavedAddressEventListener.class);

    private ProfileTransactionService profileTransactionService;

    @Override
    protected void onSiteEvent(SavedAddressEvent event) {

        try {
            final String consentReference = event.getCustomer().getConsentReference();
            final String baseSiteId = event.getBaseStore().getUid();
            this.getProfileTransactionService().sendAddressSavedEvent(event.getCustomer(), baseSiteId, consentReference);
        } catch (Exception e) {
            LOG.error("Error sending Saved Address event: " + e.getMessage());
            LOG.debug("Error sending Saved Address event: ", e);
        }
    }

    @Override
    protected boolean shouldHandleEvent(SavedAddressEvent event) {
        return event.getCustomer() != null && event.getCustomer().getConsentReference() != null ;
    }

    @Required
    public void setProfileTransactionService(ProfileTransactionService profileTransactionService) {
        this.profileTransactionService = profileTransactionService;
    }

    private ProfileTransactionService getProfileTransactionService() {
        return profileTransactionService;
    }
}
