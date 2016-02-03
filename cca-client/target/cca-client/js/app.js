'use strict';

/* App Module */

var ccaClientApp = angular.module('ccaClientApp', [
  'ngRoute',
  'ccaClientService',
  'ccaClientControllers',
  'ccaClientDirectives'
]);

ccaClientApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.when('/departments', {templateUrl: 'partials/cardcall.html', controller: 'CardCallUpdateCtrl'});
  //  $routeProvider.when('/departments2', {templateUrl: 'partials/departments2.html', controller: 'DepartmentsCtrl'});
    $routeProvider.otherwise({redirectTo: '/departments'});
  }]);
