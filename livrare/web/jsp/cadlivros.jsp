<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="LivrosDidaticos" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Livros Didáticos</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>

            <fieldset>
                <input type="hidden" name="id" id="id" value="${livro.id!=null?livro.id:""}">
                <div class="row">
                    <div class="col">
                        <div class="alert" id="retorno"></div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="control-label" for="matricula">Nome do Livro</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome do Livro" class="form-control" required="" value="${livro.nome!=null?livro.nome:""}">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="control-label" for="categoria">Categoria:</label>
                        <select id="categoria" name="categoria" class="form-control">
                            <c:forEach var="categoria" items="${categorias}"> 
                                <option value='${categoria.id}'>${categoria.nome}</option> 
                            </c:forEach>
                        </select>
                    </div>   
                    <div class="form-group col-md-4">
                        <label class="control-label" for="turma">ISBN</label>  
                        <input id="isbn" name="isbn" type="text" placeholder="Digite o ISBN do livro" class="form-control" required="" value="${livro.isbn!=null?livro.isbn:""}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="control-label" for="autor">Autor</label>  
                        <input id="autor" name="autor" type="text" placeholder="Digite o nome do Autor do Livro" class="form-control" required="" value="${livro.autor!=null?livro.autor:""}">
                    </div> 
                    <div class="form-group col-md-4">
                        <label class="control-label" for="volume">Volume</label>  
                        <input id="volume" name="volume" type="text" placeholder="Digite o volume do Livro" class="form-control" required="" value="${livro.volume!=null?livro.volume:""}">
                    </div> 
                    <div class="form-group col-md-4">
                        <label class="control-label" for="foto">Foto</label>
                        <input class="form-control"  type="file" name="foto" id="foto" />
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 tex-center">
                            <!--<img style="display: none" id="fotoUpada" name="fotoUpada" class="form-control" src="${livro.fotoCapa!=null?livro.fotoCapa:""}">-->
                            <img style="display: none" id="fotoUpada" name="fotoUpada" src="${livro.fotoCapa!=null?livro.fotoCapa:""}" width="300" height="400">
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="control-label" for="salvar"></label>
                        <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label" for="cancelar"></label>
                        <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listlivros.jsp'" type="button">Cancelar</button>
                    </div>
                </div>   
            </fieldset>
        </div>
    </div>
</div>
<!-- Rodapé da Página -->
<jsp:include page="../inc/rodape.inc.jsp" />
<script src="../js/cadlivros.js" type="text/javascript" charset="utf-8"></script>