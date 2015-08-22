var ienUi = angular.module('IenUi', []);
ienUi.directive('ienMenu', function(){
    return {
        restrict: 'EA',
        replace: false,
        templateUrl: 'scripts/templates/menu.html',
        scope: {
            tipoUsuario: '@'
        }
    };
});
ienUi.service("$ui", function(){
    return{
        tab: function(panelId){
            $('.nav-tabs a[href="#' + panelId + '"]').tab('show');
        }
    };
});

var ienApp = angular.module('IenApp', ['IenUi']);
