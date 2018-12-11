$(function () {
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
            }
        });
    }

    function buscar() {
        $.ajax({
            url: '/livrare/LivrosDidaticosServlet',
            method: "GET",
            data: {pesquisa: $('#pesquisa').val(), acao: 'buscar'}
        }).done(function (retorno) {
            $('#listagem').html(retorno);
            setarEventos();
        });
    }

    $("#pesquisar").click(function () {
        buscar();
    });

    function setarEventos() {
        $(".excluir").click(function () {
            swal({
                title: "Você tem certeza?",
                text: "Uma vez deletado, você não poderá recuperar esse registro!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            }).then((willDelete) => {
                if (willDelete) {
                    id = $(this).attr("idLivro");
                    $.ajax({
                        method: "POST",
                        url: '/livrare/LivrosDidaticosServlet',
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
                            buscar();
                        } else {
                            swal("Erro!", "Algo de errado aconteceu: " + retorno, 'error');
                        }
                    });
                }
            });
        });
    }
})
