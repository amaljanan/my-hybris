/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
describe('componentCloneOptionForm', function() {
    var $controller;

    beforeEach(function() {
        //GIVEN
        var harness = AngularUnitTestHelper.prepareModule(
            'componentCloneOptionFormModule'
        ).controller('componentCloneOptionFormController');
        $controller = harness.injected.$controller(
            'componentCloneOptionFormController',
            {
                $scope: {}
            },
            {
                onSelectionChange: function() {}
            }
        );
    });

    it('should expose a "componentInSlotOption" object when onInit is called', function() {
        //WHEN
        $controller.$onInit();

        //THEN
        expect($controller.componentInSlotOption).toBeDefined();
    });

    it('should set default "componentInSlotOption" value to "CLONE_COMPONENTS_IN_CONTENT_SLOTS_OPTION.REFERENCE_EXISTING" when onInit is called', function() {
        //WHEN
        $controller.$onInit();

        //THEN
        expect($controller.componentInSlotOption).toBe(
            $controller.CLONE_COMPONENTS_IN_CONTENT_SLOTS_OPTION.REFERENCE_EXISTING
        );
    });

    it('should set "componentInSlotOption" value to "CLONE_COMPONENTS_IN_CONTENT_SLOTS_OPTION.CLONE" when updateComponentInSlotOption is called with "CLONE_COMPONENTS_IN_CONTENT_SLOTS_OPTION.CLONE"', function() {
        //WHEN
        $controller.updateComponentInSlotOption(
            $controller.CLONE_COMPONENTS_IN_CONTENT_SLOTS_OPTION.CLONE
        );

        //THEN
        expect($controller.componentInSlotOption).toBe(
            $controller.CLONE_COMPONENTS_IN_CONTENT_SLOTS_OPTION.CLONE
        );
    });
});
