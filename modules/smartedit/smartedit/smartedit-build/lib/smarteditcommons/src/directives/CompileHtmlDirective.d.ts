import { ElementRef, OnChanges, Renderer2, SimpleChanges } from '@angular/core';
import { UpgradeModule } from '@angular/upgrade/static';
import { TypedMap } from '@smart/utils';
import { CompileHtml, CompileHtmlNgController } from './CompileHtml';
/**
 * @ngdoc directive
 * @name CompileHtmlDirective
 * @element [seCompileHtml]
 *
 * @description
 *  Used as support for legacy AngularJS templates in Angular components.
 *  Compiles the template provided by the HTML Template string and scope
 *  @param {string} seCompileHtml HTML Template string to be compiled by directive e.g. <div>some text</div>
 *  @param {Object} scope Data to be consumed by AngularJS template
 *  @param {CompileHtmlNgController} compileHtmlNgController
 */
export declare class CompileHtmlDirective extends CompileHtml implements OnChanges {
    seCompileHtml: string;
    scope: TypedMap<any>;
    compileHtmlNgController: CompileHtmlNgController;
    constructor(elementRef: ElementRef, renderer: Renderer2, upgrade: UpgradeModule);
    ngOnChanges(changes: SimpleChanges): void;
}
