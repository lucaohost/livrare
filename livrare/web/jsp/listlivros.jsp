<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<c:import url="cabecalho.inc.jsp">
    <c:param name="pageName" value="Livros" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Listagem de Livros</h2>
        </div>
        <div class="panel-body">
            
            <!-- Formulário de pesquisa -->
            <form onsubmit="return false;" class="form-horizontal">
                <div class="input-group">
                  <input class="form-control border-secondary py-2" type="search" id="pesquisa" name="pesquisa" placeholder="Pesquisar...">
                  <div class="input-group-append">
                      <button class="btn btn-outline-secondary" id="pesquisar">
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
<!-- Rodapé da Página -->
<jsp:include page="rodape.inc.jsp" />
<script src="/livrare/js/listlivros.js" type="text/javascript" charset="utf-8"></script>