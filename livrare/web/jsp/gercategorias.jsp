<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Livros" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Categorias</h2>
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
                    <div class="form-row">
                        <div class="col-8">
                            <div class="form-group col-md-6">
                                <label class="control-label" for="curso">Cadastrar Categoria</label>  
                                <div class="input-group">
                                    <input id="nome" name="nome" type="text" placeholder="Digite o nome da categoria" class="form-control">
                                    <button id="salvar" class="btn-primary rounded-right">Salvar</button>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label class="control-label" for="curso">Pesquisar Categoria</label>  
                                <div class="input-group">
                                    <input id="pesquisa" name="pesquisa" type="text" placeholder="Digite o nome da categoria" class="form-control">
                                    <button id="pesquisar" class="input-group-addon rounded-right" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>          
                </fieldset>
        </div>
    </div>
    <h3 class="panel-title text-center">Categorias Cadastradas</h3>
    <div class="panel-body">
        <table class="table table-striped table-bordered table-condensed table-hover">
            <thead class="thead-dark text-center">
                <tr>
                    <th>Nome</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody id="tabelaCategorias" class="text-center">
            </tbody>
        </table>                    
    </div>
</div>
<!-- Rodapé da Página -->
<jsp:include page="../inc/rodape.inc.jsp" />
<script src="../js/gercategorias.js" type="text/javascript" charset="utf-8"></script>