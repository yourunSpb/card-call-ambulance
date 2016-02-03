'use strict';

/* Services */

var ccaClientService = angular.module('ccaClientService', ['ngResource']);

ccaClientService.factory('Departments', ['$resource',
  function($resource){
    return $resource('http://localhost:7001/ccaMgmt/cardCall/departmentList', {}, {
      getDepartmentList: {method:'GET', params:{}, isArray:false}
    });
  }]);

ccaClientService.factory('FormSections', ['$resource',
  function($resource){
    return $resource('http://localhost:7001/ccaMgmt/cardCall/formSections', {}, {
      getFormSectionList: {method:'GET', params:{}, isArray:false}
    });
  }]);

ccaClientService.factory('Profiles', ['$resource',
  function($resource){
    return $resource('http://localhost:7001/ccaMgmt/cardCall/profileList', {}, {
      getProfileList: {method:'GET', params:{}, isArray:false}
    });
  }]);

ccaClientService.factory('Medics', ['$resource',
  function($resource){
    return $resource('http://localhost:7001/ccaMgmt/user/medicList', {}, {
      getMedicList: {method:'GET', params:{}, isArray:false}
    });
  }]);

ccaClientService.factory('AddOrEditCard', ['$resource',
  function($resource){
    return $resource('http://localhost:7001//ccaMgmt/cardCall/addOrEdit', {}, {
      saveCardCall: {method:'POST', headers: [{'Content-Type': 'application/json'}]}
    });
  }]);


