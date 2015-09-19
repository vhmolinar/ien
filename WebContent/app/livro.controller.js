angular.module('ien').controller('livroController',[
    '$scope',
    '$ui',
    '$resource',
    '$timeout',
    function($scope,
             $ui,
             $resource,
             $timeout){

    const panels = {
        cadastro: 'cadastro_livros',
        dados: 'dados_livros'
    };

    var $this = {};

    var Livro = $resource('/ien-master/rs/livro/:codigo', {
        codigo: '@codigo'
    },{
        update: {
            method: 'PUT'
        }
    });

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

    $scope.seleciona = function(livro){
        $scope.livro = livro;
        $ui.tab(panels.cadastro);
    };

    $scope.remove = function(livro){
        Livro.$remove(livro, function sucesso(){

            alert('Livro removido!');

        }, function falha(){

            alert('Falha ao atualizar livro!');

        });
    };

    $scope.registra = function(livro){

        var atualizacao = livro.codigo !== undefined && livro.codigo !== null;

        if(atualizacao){

            Livro.$update(livro, function sucesso(){

                $ui.tab(panels.dados);

            }, function falha(){
                alert('Falha ao atualizar livro!');
            });

        } else {

            Livro.$save({
                nome: livro.nome,
                edicao: livro.edicao,
                ano: livro.ano
            }, function sucesso(){

                $ui.tab(panels.dados);
                $this.buscarLivros();

            }, function falha(){
                alert('Falha ao salvar livro!');
            });

        }

    };

    $scope.limpa = function(){
        $scope.livro = {};
    };
}]);
