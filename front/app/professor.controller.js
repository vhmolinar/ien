angular.module('ien').controller('ProfessorController',['$scope', function($scope){

    $scope.professores = [
        {codigo:1, matricula:"123456", nome: "Marcelo", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"},
        {codigo:2, matricula:"123456", nome: "Manuela", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"},
        {codigo:3, matricula:"123456", nome: "Joaquina", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"},
		{codigo:4, matricula:"123456", nome: "Pedrinho", cpf: "12345678909", nascimento: "23/04/1990", endereco: "rua tal bairro tal"}
    ];

    var contador = $scope.professores.length;

    $scope.seleciona = function(professor){
        $scope.professor = professor;
    };

    $scope.registra = function(novoProfessor){

        var atualizacao = false;

        for(var i=0; i<$scope.professores.length; ++i){
            var professor = $scope.professores[i];

            if(atualizacao = (professor.codigo == novoProfessor.codigo)){
                angular.extend(professor, novoProfessor);
                break;
            }
        }

        if(!atualizacao){
            novoProfessor.codigo = ++contador;
            $scope.professores.push(novoProfessor);
        }
    };

    $scope.limpa = function(){
        $scope.professor = {};
    };
}]);
