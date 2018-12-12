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
            }
        });
    }

$('#retorno').hide();

$('#salvar').click(function () {
    $.ajax({
        url: '/livrare/UsuariosServlet',
        data: {id: $('#id').val(), nome: $('#nome').val(), email: $('#email').val(), senha: $('#senha').val(), perfil: $('#perfil').val(), acao: 'salvar'}
    }).done(function (retorno) {
        swal("Sucesso!", "Usuario cadastrado com sucesso!", "success");
        $('#retorno').html("Usuario cadastrado com sucesso").addClass('alert-success').removeClass('alert-danger').show();
    });
});