ienApp.controller('LivroController',['$scope', function($scope){

    $scope.livros = [
        {codigo:1, nome:"O Monge e o Executivo", edicao: "1", ano: 2015},
        {codigo:2, nome:"Shantala", edicao: "1a", ano: 2013},
        {codigo:3, nome:"Ansiedade, Mal do Século", edicao: "10", ano: 2014}
    ];

    var contador = $scope.livros.length;

    $scope.seleciona = function(livro){
        $scope.livro = livro;
    };

    $scope.registra = function(novoLivro){

        var atualizacao = false;

        for(var i=0; i<$scope.livros.length; ++i){
            var livro = $scope.livros[i];

            if(atualizacao = (livro.codigo == novoLivro.codigo)){
                angular.extend(livro, novoLivro);
                break;
            }
        }

        if(!atualizacao){
            novoLivro.codigo = ++contador;
            $scope.livros.push(novoLivro);
        }
    };

}]);
