'use strict';

/* Controllers */

var ccaClientControllers = angular.module('ccaClientControllers', []);

ccaClientControllers.controller('CardCallUpdateCtrl', ['$scope',
                                                       'Departments',
                                                       'FormSections',
                                                       'Profiles',
                                                       'Medics',
                                                       'AddOrEditCard',
                               function($scope, Departments, FormSections, Profiles, Medics, AddOrEditCard) {

    $scope.it = 0;
    $scope.cardCall = {
        brigade: {
            brigadeNumber: null,
            departmentId: null,
            profileId: null,
            medicList: [],
        },
        sections: [],
        updatedBy: 4

    };
    $scope.populates = [];

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

    $scope.updateAnswer = function(it, questionId, answerValue, answerId) {
        $scope.populates[it].questionId = questionId
    }

    $scope.saveButton = function() {

        for (var count = 0; count < $scope.populates.length; count++) {
            if ($scope.populates[count] != null) {
                $scope.cardCall.sections.push($scope.populates[count]);
            }
        }
        AddOrEditCard.saveCardCall($scope.cardCall);
    }

}]);