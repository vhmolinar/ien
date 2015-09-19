angular.module('ien').controller('autorController',[
    '$scope',
    '$ui',
    '$rest',
    '$timeout',
    function($scope,
             $ui,
             $rest,
             $timeout){

    const panels = {
        cadastro: 'cadastro_autores',
        dados: 'dados_autores'
    };

    var $this = {};
    $scope.autor = {};
    $scope.autores = [];

    var Autor = $rest.autor();

    $this.buscarAutores = function(){
        Autor.query(function resposta(resp){

            $scope.autores = resp;

        }, function falha(){
            alert("Falha ao carregar autores!");
        });
    };

    $timeout($this.buscarAutores);

    $scope.seleciona = function(autor){
        $scope.autor = autor;
        $ui.tab(panels.cadastro);
    };

    $scope.remove = function(autor){
        Autor.remove(autor, function sucesso(){

            $this.buscarAutores();
            alert('Autor removido!');

        }, function falha(){

            alert('Falha ao atualizar autor!');

        });
    };

    $scope.registra = function(autor){

        var atualizacao = autor.codigo !== undefined && autor.codigo !== null;

        if(atualizacao){

            Autor.update(autor, function sucesso(){

                $ui.tab(panels.dados);

            }, function falha(){
                alert('Falha ao atualizar autor!');
            });

        } else {

            Autor.save(autor, function sucesso(){

                $ui.tab(panels.dados);
                $this.buscarAutores();
                $scope.limpa();

            }, function falha(){
                alert('Falha ao salvar autor!');
            });

        }

    };

    $scope.limpa = function(){
        $scope.autor = {};
    };
}]);
