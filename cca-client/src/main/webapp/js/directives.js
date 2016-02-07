'use strict';

/* Directives */

var ccaClientDirectives = angular.module('ccaClientDirectives', []);

ccaClientDirectives.directive("checkboxGroup", function() {
    return {
        restrict: "A",
        link: function(scope, elem, attrs) {
            // Determine initial checked boxes
            if (scope.cardCallDetails.brigade.medicList.indexOf(scope.option.medicId) !== -1) {
                elem[0].checked = true;
            }

            // Update array on click
            elem.bind('click', function() {
                var index = scope.cardCallDetails.brigade.medicList.indexOf(scope.option.medicId);
                // Add if checked
                if (elem[0].checked) {
                    if (index === -1) scope.cardCallDetails.brigade.medicList.push(scope.option.medicId);
                }
                // Remove if unchecked
                else {
                    if (index !== -1) scope.cardCallDetails.brigade.medicList.splice(index, 1);
                }
                // Sort and update DOM display
                scope.$apply(scope.cardCallDetails.brigade.medicList.sort(function(a, b) {
                    return a - b
                }));
            });
        }
    }
});