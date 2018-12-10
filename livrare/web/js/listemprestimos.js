buscar();

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
        var estado = '';
        if(a == 1) {
            estado = "BOM";
        } else if(a == 2) {
            estado = "RUIM";
        } else {
            estado = "EXTRAVIADO";
        }
        $.ajax({
            url: '/livrare/EmprestimoServlet',
            data: {id: id, estdao: estado, acao: 'devolver'}
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