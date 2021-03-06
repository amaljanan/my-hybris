/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
describe('displayConditionsPageInfoController', function() {
    var controller;

    beforeEach(function() {
        var harness = AngularUnitTestHelper.prepareModule(
            'displayConditionsPageInfoControllerModule'
        ).controller('displayConditionsPageInfoController');
        controller = harness.controller;
    });

    describe('init', function() {
        it('should initialize the i18n keys on the scope', function() {
            expect(controller.displayConditionLabelI18nKey).toBe('se.cms.display.conditions.label');
        });
    });

    describe('getPageDisplayConditionI18nKey', function() {
        it('should return the primary value i18n key if the page is primary', function() {
            controller.isPrimary = true;
            expect(controller.getPageDisplayConditionI18nKey()).toBe(
                'se.cms.display.conditions.primary.id'
            );
        });

        it('should return the variation value i18n key if the page is a variation', function() {
            controller.isPrimary = false;
            expect(controller.getPageDisplayConditionI18nKey()).toBe(
                'se.cms.display.conditions.variation.id'
            );
        });
    });

    describe('getPageDisplayConditionDescriptionI18nKey', function() {
        it('should return the primary description i18n key if the page is primary', function() {
            controller.isPrimary = true;
            expect(controller.getPageDisplayConditionDescriptionI18nKey()).toBe(
                'se.cms.display.conditions.primary.description'
            );
        });

        it('should return the variation description i18n key if the page is a variation', function() {
            controller.isPrimary = false;
            expect(controller.getPageDisplayConditionDescriptionI18nKey()).toBe(
                'se.cms.display.conditions.variation.description'
            );
        });
    });
});
