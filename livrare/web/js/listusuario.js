buscar();

function buscar() {
    $.ajax({
        url: '/livrare/UsuariosServlet',
        data: {pesquisa: $('#pesquisa').val(), acao: 'buscar'}
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
                url: '/livrare/UsuariosServlet',
                data: {id: id, acao: 'excluir'}
            }).done(function (retorno) {
                swal({
                    title: "Feito!",
                    text: "Seu registro foi excluído com sucesso!",
                    icon: "success",
                }).then(() => {
                    window.location.href = 'listusuario.jsp';
                });
            });
        }
    });
}