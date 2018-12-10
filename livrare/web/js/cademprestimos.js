listLivros();
listAlunos();

$('#salvar').click(function () {
    $.ajax({
        url: '../EmprestimosServlet',
        data: {}
    }).done(function (retorno) {
        if (retorno == "true" && $('#id').val() == '') {
            swal({
                title: "Sucesso!",
                text: "Emprestimo cadastrado com sucesso!",
                icon: "success",
                buttons: {
                    listagem: {
                        text: "Ir para listagem",
                        className: "btn-secondary"
                    },
                    ok: "Ok"
                },
                dangerMode: true,
            }).then((value) => {
                if (value == 'listagem') {
                    window.location.href = "listemprestimos.jsp";
                } else {
                    limparCampos();
                }
            });
        } else if (retorno == "true" && $('#id').val() != '') {
            swal({
                title: "Sucesso!",
                text: "Emprestimo atualizado com sucesso!",
                icon: "success",
                buttons: {
                    listagem: {
                        text: "Ir para listagem",
                        className: "btn-secondary"
                    },
                    ok: "Ok"
                },
                dangerMode: true,
            }).then((value) => {
                if (value == 'listagem') {
                    window.location.href = "listemprestimos.jsp";
                } else {
                    limparCampos();
                }
            });
        } else {
            swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
        }
    });
});

function limparCampos() {
    $('input').val('');
}

function listLivros() {
    $.ajax({
        url: '../LivrosServlet',
        data: {acao: "select"}
    }).done(function (retorno) {
        $('#selectLivros').html(retorno);
    });
}

function listAlunos() {
    $.ajax({
        url: '../AlunosServlet',
        data: {acao: "select"}
    }).done(function (retorno) {
        $('#selectAlunos').html(retorno);
    });
}