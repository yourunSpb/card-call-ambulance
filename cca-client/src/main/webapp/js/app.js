'use strict';

/* App Module */

var ccaClientApp = angular.module('ccaClientApp', [
  'ngRoute',
  'ccaClientService',
  'ccaClientControllers',
  'ccaClientDirectives'
//  'cardCallFilters'
//  'ngTable'
]);

ccaClientApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.when('/card-calls', {
          templateUrl: 'partials/card-call-list.html',
          controller: 'CardCallListCtrl'
        });
    $routeProvider.when('/card-calls/:cardCallId', {
          templateUrl: 'partials/card-call.html',
            controller: 'CardCallUpdateCtrl'
        });
    $routeProvider.when('/card-calls/create-card-call', {
           templateUrl: 'partials/card-call.html',
             controller: 'CardCallUpdateCtrl'
         });
    $routeProvider.otherwise({redirectTo: '/card-calls'});
  }]);
