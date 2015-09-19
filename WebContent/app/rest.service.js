angular.module('ien').service('$rest',['$resource',function($resource){
    return {

        livro: function(){

            return $resource('/ien/rs/livro/:codigo', {
                codigo: '@codigo'
            },{
                update: {
                    method: 'PUT'
                }
            });

        },

        autor: function(){

            return $resource('/ien/rs/autor/:codigo', {
                codigo: '@codigo'
            },{
                update: {
                    method: 'PUT'
                }
            });

        },

        categoria: function(){

            return $resource('/ien/rs/categoria/:codigo', {
                codigo: '@codigo'
            },{
                update: {
                    method: 'PUT'
                }
            });

        }
    };
}]);
