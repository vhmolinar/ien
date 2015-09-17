var ien = angular.module('ien', ['ngRoute','ngResource', 'ienUi']);

ien.run(['$location','$timeout', function($location, $timeout){

    $timeout(function(){
        $location.path('/home');
    });

}]);

ien.controller('homeControl',['$rootScope','$location',
    function($rootScope, $location){

    $rootScope.go = function(path){
        $location.path(path);
    };

}]);

ien.config(['$routeProvider','$locationProvider',
    function($routeProvider, $locationProvider){

    $routeProvider.when('/livro/:id?', {

        templateUrl: 'views/livro.html',
        controller: 'livroControl'

    }).when('/home', {

        templateUrl: 'views/home.html',
        controller: 'homeControl'

    }).otherwise({

        redirectTo: '/home'

    });

    $locationProvider.html5Mode(false);
}]);
