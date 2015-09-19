angular.module('ien').controller('categoriaController',[
    '$scope',
    '$ui',
    '$rest',
    '$timeout',
    function($scope,
             $ui,
             $rest,
             $timeout){

    const panels = {
        cadastro: 'cadastro_categorias',
        dados: 'dados_categorias'
    };

    var $this = {};
    $scope.categoria = {};
    $scope.categorias = [];

    var Categoria = $rest.categoria();

    $this.buscarCategorias = function(){
        Categoria.query(function resposta(resp){

            $scope.categorias = resp;

        }, function falha(){
            alert("Falha ao carregar categorias!");
        });
    };

    $timeout($this.buscarCategorias);

    $scope.seleciona = function(categoria){
        $scope.categoria = categoria;
        $ui.tab(panels.cadastro);
    };

    $scope.remove = function(categoria){
        Categoria.remove(categoria, function sucesso(){

            $this.buscarCategorias();
            alert('Categoria removido!');

        }, function falha(){

            alert('Falha ao atualizar categoria!');

        });
    };

    $scope.registra = function(categoria){

        var atualizacao = categoria.codigo !== undefined && categoria.codigo !== null;


        // Categoria.save(categoria, function sucesso(){

        //     $ui.tab(panels.dados);
        //     $this.buscarCategorias();
        //     $scope.limpa();

        // }, function falha(){
        //     alert('Falha ao salvar categoria!');
        // });

        if(atualizacao){

            Categoria.update(categoria, function sucesso(){

                $ui.tab(panels.dados);

            }, function falha(){
                alert('Falha ao atualizar categoria!');
            });

        } else {

            Categoria.save(categoria, function sucesso(){

                $ui.tab(panels.dados);
                $this.buscarCategorias();
                $scope.limpa();

            }, function falha(){
                alert('Falha ao salvar categoria!');
            });

        }

    };

    $scope.limpa = function(){
        $scope.categoria = {};
    };
}]);
