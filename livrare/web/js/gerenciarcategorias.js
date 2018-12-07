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
                swal("Sucesso!", "Categoria cadastrada com sucesso!", "success");
            } else {
                swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
            }
        });
    });
});