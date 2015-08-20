var ienUi = angular.module('IenUi', []);
ienUi.directive('ienMenu', function(){
    return {
        restrict: 'EA',
        replace: false,
        templateUrl: 'scripts/templates/menu.html'
    };
});

var ienApp = angular.module('IenApp', ['IenUi']);
