<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condi��es de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabe�alho da P�gina -->
<c:import url="cabecalho.inc.jsp">
    <c:param name="pageName" value="Emprestimos" />
</c:import>

<!-- Conte�do da P�gina -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gest�o de Emprestimos</h2>
        </div>
        <div class="panel-body">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label class="control-label">Livro</label>  
                    <div id="selectLivros"></div>
                </div>
                <div class="form-group col-md-6">
                    <label class="control-label" >Aluno</label>  
                    <div id="selectAlunos"></div>
                </div>
            </div>   
            <hr>
            <!-- Formul�rio de pesquisa -->
            <form onsubmit="return false;" class="form-horizontal">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <button class="btn btn-secondary btn-lg btn-block" id="atrasados" onclick="buscarAtrasados()"><i class="fa fa-clock"></i> Atrasados</button>
                    </div>
                    <div class="form-group col-md-6">
                         <button class="btn btn-primary btn-lg btn-block" id="pesquisar" onclick="buscar()"><i class="fa fa-sync"></i> Atualizar</button>
                    </div>
                </div>              
            </form>
            <br>
            <!-- Listagem -->
            <div id="listagem"></div>                 
        </div>
    </div>
</div>
<!-- Rodap� da P�gina -->
<jsp:include page="rodape.inc.jsp" />
<script src="../js/listemprestimos.js" type="text/javascript" charset="utf-8"></script>