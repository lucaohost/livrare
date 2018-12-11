validarSession();

function validarSession() {
    $.ajax({
        url: '/livrare/UsuariosServlet?acao=validarsessao',
        method: "GET"
    }).done(function (retorno) {
        if (retorno === "false") {
            swal({
                title: "Alerta!",
                text: "Acesso Restrito!",
                icon: "warning",
                buttons: {
                    ok: "Ok"
                },
                dangerMode: true,
            }).then((value) => {
                window.location.href = "/livrare/jsp/login.jsp";
            });
        } else {
            buscar();
            listAlunos();
            listLivros();
        }
    });
}

function buscar() {
    $.ajax({
        url: '/livrare/EmprestimosServlet',
        method: "get",
        data: {pesquisa: $('#pesquisa').val(), acao: 'buscar'}
    }).done(function (retorno) {
        $('#listagem').html(retorno);
    });
}

function buscarAtrasados() {
    $.ajax({
        url: '/livrare/EmprestimosServlet',
        method: "get",
        data: {pesquisa: $('#pesquisa').val(), acao: 'atrasados'}
    }).done(function (retorno) {
        $('#listagem').html(retorno);
    });
}

function excluir(id) {
    swal({
        title: "Você tem certeza?",
        text: "Uma vez deletado, você não poderá recuperar esse registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: '/livrare/EmprestimosServlet',
                data: {id: id, acao: 'excluir'}
            }).done(function (retorno) {
                if (retorno == 'true') {
                    swal({
                        title: "Feito!",
                        text: "Seu registro foi excluído com sucesso!",
                        icon: "success",
                    }).then(() => {
                        buscar();
                    });
                } else {
                    swal("Erro!", "Algo de errado aconteceu: " + retorno, 'error');
                }
            });
        }
    });
}

function alterar(id) {
    window.location.href = '/livrare/EmprestimoController?acao=atualizar&id=' + id;
}

function devolver(id) {
    swal({
        content: {
            element: "input",
            attributes: {
                placeholder: "Qual o estado do livro (BOM = 1, RUIM = 2, EXTRAVIADO = 3)",
                type: "number",
            },
        },
    }).then((a) => {
        var estado1 = '';
        if (a == 1) {
            estado1 = "BOM";
        } else if (a == 2) {
            estado1 = "RUIM";
        } else {
            estado1 = "EXTRAVIADO";
        }
        $.ajax({
            url: '/livrare/EmprestimosServlet',
            data: {id: id, estado: estado1, acao: 'devolver'}
        }).done(function (retorno) {
            if (retorno == "true") {
                swal({
                    title: "Feito!",
                    text: "Emprestimo devolvido com sucesso!",
                    icon: "success",
                }).then(() => {
                    buscar();
                });
            } else {
                swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
            }
        });
    });
}

function listLivros() {
    $.ajax({
        url: '/livrare/LivrosDidaticosServlet',
        data: {acao: "select"}
    }).done(function (retorno) {
        $('#selectLivros').html(retorno);
    });
}

function listAlunos() {
    $.ajax({
        url: '/livrare/AlunosServlet',
        data: {acao: "select"}
    }).done(function (retorno) {
        $('#selectAlunos').html(retorno);
    });
}

function listarAlunos() {
    $.ajax({
        url: '/livrare/AlunosServlet',
        method: "get",
        data: {id: $('#aluno').val(), acao: 'emprestimos'}
    }).done(function (retorno) {
        $('#listagem').html(retorno);
    });
}

function atualizarUnidades() {
    $.ajax({
        url: '/livrare/LivrosDidaticosServlet',
        method: "get",
        data: {id: $('#livro').val(), acao: 'emprestimos'}
    }).done(function (retorno) {
        $('#listagem').html(retorno);
    });
}
