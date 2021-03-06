/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
(function() {
    /**
     * @ngdoc overview
     * @name pageListLinkModule
     * @description
     * # The pageListLinkModule
     *
     * The pageListLinkModule provides a directive to display a link to the list of pages of a catalogue
     *
     */
    angular
        .module('pageListLinkModule', [])
        /**
         * @ngdoc directive
         * @name pageListLinkModule.directive:pageListLink
         * @scope
         * @restrict E
         * @element <page-list-link></page-list-link>
         *
         * @description
         * Directive that displays a link to the list of pages of a catalogue. It can only be used if catalog.catalogVersions is in the current scope.
         *
         * @param {< Object} catalog Object representing the provided catalog.
         * @param {< Boolean} catalogVersion Object representing the provided catalog version.
         * @param {< String} siteId The ID of the site the provided catalog is associated with.
         */
        .component('pageListLink', {
            templateUrl: 'pageListLinkDirectiveTemplate.html',
            bindings: {
                catalog: '<',
                catalogVersion: '<',
                siteId: '<'
            }
        });
})();
