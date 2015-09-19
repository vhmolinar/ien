angular.module('ien').controller('livroController',[
    '$scope',
    '$ui',
    '$rest',
    '$timeout',
    function($scope,
             $ui,
             $rest,
             $timeout){

    const panels = {
        cadastro: 'cadastro_livros',
        dados: 'dados_livros'
    };

    var $this = {};
    $scope.livro = {
        codAutor: 1,
        codCategoria: 1
    };
    $scope.livros = [];
    $scope.categorias = [];
    $scope.autores = [];

    var Livro = $rest.livro();
    var Autor = $rest.autor();
    var Categoria = $rest.categoria();

    $this.buscarLivros = function(){
        Livro.query(function resposta(resp){

            $scope.livros = resp;

        }, function falha(){
            alert("Falha ao carregar livros!");
        });
    };

    $timeout(function(){

        $this.buscarLivros();

        Autor.query(function(resp){

            $scope.autores = resp;

        }, function falha(){

            alert('Falha ao buscar autores!');

        });

        Categoria.query(function(resp){

            $scope.categorias = resp;

        }, function falha(){

            alert('Falha ao buscar categorias!');

        });

    });

    $scope.seleciona = function(livro){
        $scope.livro = livro;
        $ui.tab(panels.cadastro);
    };

    $scope.remove = function(livro){
        Livro.remove(livro, function sucesso(){

            $this.buscarLivros();
            alert('Livro removido!');

        }, function falha(){

            alert('Falha ao atualizar livro!');

        });
    };

    $scope.registra = function(livro){

        var atualizacao = livro.codigo !== undefined && livro.codigo !== null;

        if(atualizacao){

            Livro.update(livro, function sucesso(){

                $ui.tab(panels.dados);

            }, function falha(){
                alert('Falha ao atualizar livro!');
            });

        } else {

            Livro.save(livro, function sucesso(){

                $ui.tab(panels.dados);
                $this.buscarLivros();
                $scope.limpa();

            }, function falha(){
                alert('Falha ao salvar livro!');
            });

        }

    };

    $scope.limpa = function(){
        $scope.livro = {};
    };
}]);
