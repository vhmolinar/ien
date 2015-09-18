angular.module('ien').controller('SugestaoController',['$scope', function($scope){

    $scope.sugestoes = [
        {codigo:1, professor:"Pedrinho", livro: "livro A"},
        {codigo:2, professor:"Manuela", livro: "1ivro B"},
        {codigo:3, professor:"Joaquina", livro: "livro C"}
    ];

    var contador = $scope.sugestoes.length;

    $scope.seleciona = function(sugestao){
        $scope.sugestao = sugestao;
    };

    $scope.registra = function(novoSugestao){

        var atualizacao = false;

        for(var i=0; i<$scope.sugestoes.length; ++i){
            var sugestao = $scope.sugestoes[i];

            if(atualizacao = (sugestao.codigo == novoSugestao.codigo)){
                angular.extend(sugestao, novoSugestao);
                break;
            }
        }

        if(!atualizacao){
            novoSugestao.codigo = ++contador;
            $scope.sugestoes.push(novoSugestao);
        }
    };

    $scope.limpa = function(){
        $scope.sugestao = {};
    };
}]);
