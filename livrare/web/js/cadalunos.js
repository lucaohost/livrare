$('#salvar').click(function () {
        $.ajax({
            url: '../AlunosServlet',
            data: {id: $('#id').val() != '' ? $('#id').val() : '-1', matricula: $('#matricula').val(), curso: $('#curso').val(), turma: $('#turma').val(), nome: $('#nome').val(), email: $('#email').val(), acao: 'salvar'}
        }).done(function (retorno) {
            if (retorno == "true" && $('#id').val() == '') {
                swal("Sucesso!", "Aluno cadastrado com sucesso!", "success");
            } else if (retorno == "true" && $('#id').val() != '') {
                swal("Sucesso!", "Usuario atualizado com sucesso!", "success");
            } else {
                swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
            }
        });
});