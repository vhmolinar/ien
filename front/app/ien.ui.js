var ienUi = angular.module('ienUi', []);

ienUi.directive('ienMenu', function(){
    return {
        restrict: 'EA',
        replace: false,
        templateUrl: 'app/templates/menu.html',
        scope: {
            tipoUsuario: '@'
        }
    };
});

ienUi.service("$ui", function(){
    return{
        tab: function(panelId){
            $('.nav-tabs a[data-target="#' + panelId + '"]').tab('show');
        }
    };
});
