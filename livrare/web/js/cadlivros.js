$(function () {
    obterCategorias();
    function obterCategorias() {
        $.ajax({
            type: 'GET',
            url: '../CategoriasServlet',
            data: {
                pesquisa: "",
                acao: "buscar"
            }
        }).done(function (retorno) {
            jsonCategorias = JSON.parse(retorno);
            $("#categoria").html("");
            for (i = 0; i < jsonCategorias.length; i++) {
                $("#categoria").append("<option value='" + jsonCategorias[i].id + "'>" + jsonCategorias[i].nome + "</option>");
            }
        });
    }

    $('#salvar').click(function () {
        $.ajax({
            type: 'POST',
            url: '../LivrosDidaticosServlet',
            data: {
                acao: "salvar",
                nome: $('#nome').val() != '' ? $('#nome').val() : '',
                categoria: $('#categoria').val() != '' ? $('#categoria').val() : '',
                autor: $('#autor').val() != '' ? $('#autor').val() : '',
                volume: $('#volume').val() != '' ? $('#volume').val() : '',
                isbn: $('#isbn').val() != '' ? $('#isbn').val() : '',
            }
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
                        window.location.href = "listlivros.jsp";
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
                        window.location.href = "listlivros.jsp";
                    } else {
                        limparCampos();
                    }
                });
            } else {
                swal("Erro!", "Algo de errado aconteceu: " + retorno, "error");
            }
        });
    });

//$('#foto').change(function () {
//    var file = $('#foto')[0].files[0];
//    var foto = new FormData();
//    foto.append('foto', file);
//    $.ajax({
//        type: 'POST',
//        url: '../LivrosDidaticosServlet',
//        data: foto,
//        processData: false,
//        contentType: false,
//    }).done(function (retorno) {
//        $("#fotoUpada").css("display","block");
//        $("#fotoUpada").attr("src",retorno);
//    });
//});

    function limparCampos() {
        $('input').val('');
    }
});