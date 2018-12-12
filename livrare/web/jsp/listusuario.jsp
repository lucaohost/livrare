<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<!-- Verifica as condi��es de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabe�alho da P�gina -->
<c:import url="cabecalho.inc.jsp">
    <c:param name="pageName" value="Usuarios" />
</c:import>

<!-- Conte�do da P�gina -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gest�o de Usu�rios</h2>
        </div>
        <div class="panel-body">
            
            <!-- Formul�rio de pesquisa -->
            <form onsubmit="return false;" class="form-horizontal">
                <div class="input-group">
                  <input class="form-control border-secondary py-2" type="search" id="pesquisa" name="pesquisa" placeholder="Pesquisar...">
                  <div class="input-group-append">
                      <button class="btn btn-outline-secondary" id="pesquisar" onclick="buscar()">
                          <i class="fa fa-search"></i>
                      </button>
                  </div>
              </div>              
              <br>
            </form>
            <!-- Listagem -->
            <div id="listagem"></div>                 
        </div>
    </div>
</div>
<!-- Rodap� da P�gina -->
<jsp:include page="rodape.inc.jsp" />
<script src="/livrare/js/listusuario.js" type="text/javascript" charset="utf-8"></script>