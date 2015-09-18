angular.module('ien').controller('alunoController',['$scope', function($scope){

    $scope.alunos = [
        {codigo:1, matricula:"123456", nome: "Joao Pedro", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"},
        {codigo:2, matricula:"123456", nome: "Joao Augusto", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"},
        {codigo:3, matricula:"123456", nome: "Maria", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"},
        {codigo:4, matricula:"123456", nome: "Joana", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"}
    ];

    var contador = $scope.alunos.length;

    $scope.seleciona = function(aluno){
        $scope.aluno = aluno;
    };

    $scope.registra = function(novoAluno){

        var atualizacao = false;

        for(var i=0; i<$scope.alunos.length; ++i){
            var aluno = $scope.alunos[i];

            if(atualizacao = (aluno.codigo == novoAluno.codigo)){
                angular.extend(aluno, novoAluno);
                break;
            }
        }

        if(!atualizacao){
            novoAluno.codigo = ++contador;
            $scope.alunos.push(novoAluno);
        }
    };

    $scope.limpa = function(){
        $scope.aluno = {};
    };
}]);
