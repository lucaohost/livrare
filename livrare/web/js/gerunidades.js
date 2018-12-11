$(function () {
    $('#salvar').click(function () {
        $('#salvar').prop("disabled", true);
        categoriaJson = JSON.stringify({id: $('#id').val() != '' ? $('#id').val() : '-1', nome: $('#nome').val()});
        $.ajax({
            type: 'POST',
            url: '../CategoriasServlet',
            data: {
                categoria: categoriaJson,
                acao: 'salvar'
            }
        }).done(function (retorno) {
            if (retorno === "true") {
                swal("Sucesso!", "Categoria cadastrada com sucesso!", "success");
            } else {
                swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
            }
            $('#salvar').prop("disabled", false);
            $('#nome').val("");
            pesquisar();
        });
    });

    $('#pesquisar').click(function () {
        pesquisar();
    });

    function pesquisar() {
        $.ajax({
            type: 'GET',
            url: '../CategoriasServlet',
            data: {
                pesquisa: $("#pesquisa").val(),
                acao: 'buscar'
            }
        }).done(function (retorno) {
            if (retorno === "false") {
                swal("Nenhuma categoria de nome " + $("#pesquisa").val() + " ou similar encontrada.");
            }
            jsonCategorias = JSON.parse(retorno);
            $("#tabelaCategorias").html("");
            for (i = 0; i < jsonCategorias.length; i++) {
                $("#tabelaCategorias").append("<tr><td><input class='form-control' disabled='true' id='" + jsonCategorias[i].id + "' value='" + jsonCategorias[i].nome + "'></td><td width='15%'><a class='text-dark atualizar' href='#' idCategoria='" + jsonCategorias[i].id + "'><i class='fa fa-edit'></i>Alterar</a> | <a class='text-dark excluir' href='#' idCategoria='" + jsonCategorias[i].id + "'><i class='fa fa-trash'></i>Excluir</a></td>");
            }
            setarEventos();
        });
    }

    function setarEventos() {
        $(".excluir").click(function () {
            swal({
                title: "Confirmação",
                text: "Você realmente deseja excluir este registro?",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            }).then((willDelete) => {
                $.ajax({
                    type: 'POST',
                    url: '../CategoriasServlet',
                    data: {
                        id: $(this).attr("idCategoria"),
                        acao: 'excluir'
                    }
                }).done(function (retorno) {
                    if (retorno === "true") {
                        swal("Sucesso!", "Categoria excluída com sucesso!", "success");
                        pesquisar();
                    } else {
                        swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
                    }
                });
            });
        });

        $(".atualizar").click(function () {
            $(this).html("<i class='fas fa-check-circle'></i>Salvar");
            $("#" + $(this).attr("idCategoria")).attr("disabled", false);
            $("#" + $(this).attr("idCategoria")).focus();
            $(this).click(function () {
                alterarCategoria($(this).attr("idCategoria"));
            });
        });
    }

    function alterarCategoria(idCategoria) {
        categoriaJson = JSON.stringify({id: idCategoria, nome: $('#'+idCategoria).val()});
        $.ajax({
            type: 'POST',
            url: '../CategoriasServlet',
            data: {
                categoriaJson: categoriaJson,
                acao: 'atualizar'
            }
        }).done(function (retorno) {
            if (retorno === "true") {
                swal("Sucesso!", "Categoria atualizada com sucesso!", "success");
                pesquisar();
            } else {
                swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
            }
        });
    }
});