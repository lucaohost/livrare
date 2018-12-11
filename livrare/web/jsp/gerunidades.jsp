<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Livros" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <br>
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Unidades</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>

            <fieldset>
                <input type="hidden" name="id" id="id">
                <div class="row">
                    <div class="col">
                        <div class="alert" id="retorno"></div>
                    </div>
                </div>
                <form method="POST" action="LivrosUnidadesServlet">
                    <div class="form-row text-center">
                        <div class="col-8">
                            <div class="form-group col-md-6">
                                <label class="control-label" for="curso">Cadastrar Unidades</label>  
                                <div class="input-group">
                                    <input id="quantidade" name="quantidade" type="number" placeholder="Quantidade de Unidades" class="form-control">
                                    <input name="acao" type="submit" class="btn-primary rounded-right" value="Adicionar">
                                    <input name="idLivroDidatico" type="hidden" class="btn-primary rounded-right" value="${livro.id}">
                                </div>
                            </div>
                        </div>
                    </div>  
                </form>

            </fieldset>
        </div>
    </div>
    <h3 class="panel-title text-center">Unidades Cadastradas</h3>
    <br>
    <div class="panel-body">
        <table class="table table-striped table-bordered table-condensed table-hover">
            <thead class="thead-dark text-center">
                <tr>
                    <th>Codigo</th>
                    <th>Código de Barras</th>
                </tr>
            </thead>
            <tbody id="tableUnidades" class="text-center">
                <c:forEach var="livroUnidade" items="${livro.livros}">
                    <tr>
                        <td width='15%' value='${livroUnidade.id}'>${livroUnidade.codigoDeBarras}</td> 
                        <td width='15%'><svg id='a${livroUnidade.codigoDeBarras}' class="barcode" codigo='${livroUnidade.codigoDeBarras}'></svg></td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>                    
    </div>
</div>
<!-- Rodapé da Página -->
<jsp:include page="../inc/rodape.inc.jsp" />
<script src="/livrare/js/gerunidades.js" type="text/javascript" charset="utf-8"></script>
<script>

    $(".barcode").each(function (index) {
        id = "#a" + $(this).attr("codigo");
        codigo = $(this).attr("codigo");
        JsBarcode(id, codigo);
        $(id).id = codigo;
    });
</script>