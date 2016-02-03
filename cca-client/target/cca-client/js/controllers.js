'use strict';

/* Controllers */

var ccaClientControllers = angular.module('ccaClientControllers', []);

ccaClientControllers.controller('CardCallUpdateCtrl', ['$scope',
                                                       'Departments',
                                                       'FormSections',
                                                       'Profiles',
                                                       'Medics',
                               function($scope, Departments, FormSections, Profiles, Medics) {


    $scope.cardCall = {
        departmentSelect: null,
        profileSelect: null,
        brigadeNumber: null,
        medics: [],
        questions: null

    }
    $scope.hello = 'Hello Habr!';

    Medics.getMedicList(function(response) {
        $scope.medics = response.medics;
    });

    Profiles.getProfileList(function(response) {
        $scope.profiles = response.profiles;
    });

    Departments.getDepartmentList(function(response) {
        $scope.departments = response.departments;
    });

    FormSections.getFormSectionList(function(response) {
        $scope.sections = response.sections;
        $scope.currentSection = response.sections[0];
    });


    $scope.onClickTab = function (section) {
        $scope.currentSection = section;
    }

    $scope.isActiveTab = function(section) {
        return section.sectionId == $scope.currentSection.sectionId;
    }

}]);