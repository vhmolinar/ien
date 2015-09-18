ienApp.controller('RenovarEmprestimoController',['$scope', '$filter', '$ui', function($scope, $filter, $ui){

    $scope.livros = [
        {codigo:1, nome:"O Monge e o Executivo", edicao: "1", ano: 2015},
        {codigo:2, nome:"Shantala", edicao: "1a", ano: 2013},
        {codigo:3, nome:"Ansiedade, Mal do Século", edicao: "10", ano: 2014},
        {codigo:4, nome:"POO", edicao:"1", ano:2015},
        {codigo:5, nome:"Psicologia Analítica", edicao:"1", ano:2000},
        {codigo:6, nome:"Ruby on Raills", edicao:"1", ano:2013},
        {codigo:7, nome:"JavaScript the good parts", edicao:"1", ano:2004},
        {codigo:8, nome:"Java - Head first", edicao:"1", ano:2007}
    ];

    $scope.pessoas = [
        {codigo:101, nome:"Aluno João da Silva"},
        {codigo:102, nome:"Aluno Joaquim Xavier"},
        {codigo:103, nome:"Professor Watson Souza"},
        {codigo:104, nome:"Professor José de Oliveira"}
    ];

    $scope.emprestimos = [
        {codigo:1001, usuario:"Aluno João da Silva", livro:"O Monge e o Executivo", data_emprestimo:"01/08/2015", data_devolucao:"16/08/2015"},
        {codigo:1002, usuario:"Aluno João da Silva", livro:"Shantala", data_emprestimo:"01/08/2015", data_devolucao:"16/08/2015"},
        {codigo:1003, usuario:"Aluno Joaquim Xavier", livro:"Shantala", data_emprestimo:"05/08/2015", data_devolucao:"21/08/2015"},
        {codigo:1004, usuario:"Professor Watson Souza", livro:"POO", data_emprestimo:"17/07/2015", data_devolucao:"18/08/2015"},
        {codigo:1005, usuario:"Professor Watson Souza", livro:"Ruby on Raills", data_emprestimo:"17/07/2015", data_devolucao:"18/08/2015"},
        {codigo:1006, usuario:"Professor Watson Souza", livro:"JavaScript the good parts", data_emprestimo:"17/07/2015", data_devolucao:"18/08/2015"}
    ];

    const panels = {
        renova: 'renova_emprestimo',
        dados: 'dados_emprestimos'
    };    

    var codLivro  = $scope.livros.length;
    var codPessoa = $scope.livros.length + 100;
    var codEmprestimo = $scope.emprestimos.length + 1000;

    $scope.seleciona_pessoa = function(pessoa){
        $scope.pessoa = pessoa;
    };    

    $scope.seleciona_livro = function(livro){
        $scope.livro = livro;
    };

    $scope.seleciona_emprestimo = function(emprestimo){
        $scope.emprestimo = emprestimo;
        var dataAtual = new Date();
        $scope.novaDataEmp = { value: dataAtual };
        $scope.novaDataDev = { value: new Date().setDate(dataAtual.getDate() + 15) };

        $ui.tab(panels.renova);
    };    

    $scope.renova_emprestimo = function(novoEmprestimo){

        var dateFilter = $filter('date');
        novoEmprestimo.data_emprestimo = dateFilter($scope.novaDataEmp.value, 'dd/MM/yyyy');;
        novoEmprestimo.data_devolucao  = dateFilter($scope.novaDataDev.value, 'dd/MM/yyyy');

        var atualizacao = false;

        for(var i=0; i<$scope.emprestimos.length; ++i){
            var emprestimo = $scope.emprestimos[i];

            if(atualizacao = (emprestimo.codigo == novoEmprestimo.codigo)){
                angular.extend(emprestimo, novoEmprestimo);
                break;
            }
        }

        if(!atualizacao){
            novoEmprestimo.codigo = ++codEmprestimo;
            $scope.emprestimos.push(novoEmprestimo);
        }

        $ui.tab(panels.dados);

        $scope.limpa();
    };

    $scope.limpa = function(){
        $scope.livro = {};
        $scope.pessoa = {};
        $scope.emprestimo = {};
        $scope.novaDataEmp = {};
        $scope.novaDataDev = {};
    };
}]);
