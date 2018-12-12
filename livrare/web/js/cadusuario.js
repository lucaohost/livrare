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