/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
angular
    .module('displayConditionsPageVariationsControllerModule', [])
    .controller('displayConditionsPageVariationsController', function($translate) {
        this.variationPagesTitleI18nKey = 'se.cms.display.conditions.variation.pages.title';
        this.noVariationsI18nKey = 'se.cms.display.conditions.no.variations';
        this.variationsDescriptionI18nKey = 'se.cms.display.conditions.variations.description';

        this.itemsPerPage = 3;

        this.keys = [
            {
                property: 'pageName',
                i18n: 'se.cms.display.conditions.header.page.name'
            },
            {
                property: 'creationDate',
                i18n: 'se.cms.display.conditions.header.creation.date'
            },
            {
                property: 'restrictions',
                i18n: 'se.cms.display.conditions.header.restrictions'
            }
        ];

        this.renderers = {
            creationDate: function() {
                return '<span>{{item.creationDate | date: "short"}}</span>';
            },
            helpTemplate: function() {
                return '<span>' + $translate.instant(this.variationsDescriptionI18nKey) + '</span>';
            }.bind(this)
        };
    });
