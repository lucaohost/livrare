$(function () {
    buscar();

    function buscar() {
        $.ajax({
            url: '/livrare/LivrosDidaticosServlet',
            method: "GET",
            data: {pesquisa: $('#pesquisa').val(), acao: 'buscar'}
        }).done(function (retorno) {
            $('#listagem').html(retorno);
        });
    }
    
    $("#pesquisar").click(function(){
        buscar();
    });
})
