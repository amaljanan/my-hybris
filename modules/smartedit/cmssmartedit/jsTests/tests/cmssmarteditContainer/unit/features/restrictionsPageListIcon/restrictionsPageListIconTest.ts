/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { RestrictionsPageListIconComponent } from 'cmssmarteditcontainer/components/pages/restrictionsPageListIcon/RestrictionsPageListIconComponent';
import { AssetsService } from 'cmscommons';

describe('restrictionsPageListIcon', () => {
    let controller: RestrictionsPageListIconComponent;
    let assetsService: jasmine.SpyObj<AssetsService>;
    let $translate: jasmine.SpyObj<angular.translate.ITranslateService>;

    beforeEach(() => {
        assetsService = jasmine.createSpyObj<AssetsService>('assetsService', ['getAssetsRoot']);
        $translate = jasmine.createSpyObj<angular.translate.ITranslateService>('$translate', [
            'instant'
        ]);

        assetsService.getAssetsRoot.and.returnValue('/cmssmartedit');

        controller = new RestrictionsPageListIconComponent(assetsService, $translate);
        controller.numberOfRestrictions = 3;
    });

    it('should set the tooltip text', () => {
        controller.title;
        expect($translate.instant).toHaveBeenCalledWith('se.icon.tooltip.visibility', {
            numberOfRestrictions: 3
        });
    });

    it('should set the image source with small blue restricted icon', () => {
        const url = controller.imageSrc;
        expect(assetsService.getAssetsRoot).toHaveBeenCalled();
        expect(url).toBe('/cmssmartedit/images/icon_restriction_small_blue.png');
    });

    it('should set the image source with small grey restricted icon', () => {
        controller.numberOfRestrictions = 0;
        const url = controller.imageSrc;

        expect(assetsService.getAssetsRoot).toHaveBeenCalled();
        expect(url).toBe('/cmssmartedit/images/icon_restriction_small_grey.png');
    });
});
