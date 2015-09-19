angular.module('ien', ['ngRoute','ngResource', 'ienUi']);

angular.module('ien').run(['$location','$timeout', function($location, $timeout){

    $timeout(function(){
        $location.path('/home');
    });

}]);

angular.module('ien').controller('homeController',['$rootScope','$location',
    function($rootScope, $location){

    $rootScope.go = function(path){
        $location.path(path);
    };

}]);

angular.module('ien').config(['$routeProvider','$locationProvider',
    function($routeProvider, $locationProvider){

    $routeProvider.when('/livro/:id?', {

        templateUrl: 'views/livro.html',
        controller: 'livroController'

    }).when('/livros/categoria/:id?', {

        templateUrl: 'views/categoria.html',
        controller: 'categoriaController'

    }).when('/livros/autor/:id?', {

        templateUrl: 'views/autor.html',
        controller: 'autorController'

    }).when('/home', {

        templateUrl: 'views/home.html',
        controller: 'homeController'

    }).otherwise({

        redirectTo: '/home'

    });

    $locationProvider.html5Mode(false);
}]);
