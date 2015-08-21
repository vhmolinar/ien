ienApp.controller('EmprestimoController',['$scope', function($scope){

    $scope.emprestimos = [
        {codigo:1, dataEmprestimo:"20/08/2015", dataDevolucao: "05/09/2015", usuario: "aluno"},
        {codigo:2, dataEmprestimo:"10/08/2015", dataDevolucao: "10/10/2015", usuario: "prof1"},
        {codigo:3, dataEmprestimo:"30/07/2015", dataDevolucao: "30/09/2015", usuario: "prof2"}
    ];

    var contador = $scope.emprestimos.length;

    $scope.seleciona = function(emprestimo){
        $scope.emprestimo = emprestimo;
    };

    $scope.registra = function(novoEmprestimo){

        var atualizacao = false;

        for(var i=0; i<$scope.emprestimos.length; ++i){
            var emprestimo = $scope.emprestimos[i];

            if(atualizacao = (emprestimo.codigo == novoEmprestimo.codigo)){
                angular.extend(emprestimo, novoEmprestimo);
                break;
            }
        }

        if(!atualizacao){
            novoEmprestimo.codigo = ++contador;
            $scope.emprestimos.push(novoEmprestimo);
        }
    };

    $scope.limpa = function(){
        $scope.emprestimo = {};
    };
}]);
