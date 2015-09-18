angular.module('ien').controller('livroController',[
    '$scope',
    '$ui',
    '$resource',
    '$timeout',
    function($scope,
             $ui,
             $resource,
             $timeout){

    var Livro = $resource('/ien-master/livro');

    var $this = {};


    $this.buscarLivros = function(){
        Livro.query(function resposta(resp){
            console.log(resp);
        }, function falha(){
            alert("Falha ao carregar livros!");
        });
    };

    $timeout($this.buscarLivros);

    $scope.livros = [
        {codigo:1, nome:"O Monge e o Executivo", edicao: "1", ano: 2015},
        {codigo:2, nome:"Shantala", edicao: "1a", ano: 2013},
        {codigo:3, nome:"Ansiedade, Mal do Século", edicao: "10", ano: 2014}
    ];

    const panels = {
        cadastro: 'cadastro_livros',
        dados: 'dados_livros'
    };

    var contador = $scope.livros.length;

    $scope.seleciona = function(livro){
        $scope.livro = livro;

        $ui.tab(panels.cadastro);
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

        $ui.tab(panels.dados);
    };

    $scope.limpa = function(){
        $scope.livro = {};
    };
}]);
