$(function () {
    $('#salvar').click(function () {
        $.ajax({
            url: '../CategoriasServlet',
            data: {
                categoria: {id: $('#id').val() != '' ? $('#id').val() : '-1', nome: $('#nome').val()},
                acao: 'salvar'
            }
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
});