$('#salvar').click(function () {
    $.ajax({
        url: '../AlunosServlet',
        data: {id: $('#id').val() != '' ? $('#id').val() : '-1', matricula: $('#matricula').val(), curso: $('#curso').val(), turma: $('#turma').val(), nome: $('#nome').val(), email: $('#email').val(), acao: 'salvar'}
    }).done(function (retorno) {
        if (retorno == "true" && $('#id').val() == '') {
            swal({
                title: "Sucesso!",
                text: "Aluno cadastrado com sucesso!",
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
                        window.location.href = "listalunos.jsp";
                 } else {
                    limparCampos();
                 }
            });
        } else if (retorno == "true" && $('#id').val() != '') {
            swal({
                title: "Sucesso!",
                text: "Aluno atualizado com sucesso!",
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
                        window.location.href = "listalunos.jsp";
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