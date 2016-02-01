'use strict';

/* Directives */

var ccaClientDirectives = angular.module('ccaClientDirectives', []);

ccaClientDirectives.directive('formSection', function() {
    return {
        restrict: 'E',
        template: '<span>Hello World</span>',
        scope: true
    }
});