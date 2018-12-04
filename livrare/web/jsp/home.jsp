<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<!-- Verifica as condi��es de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabe�alho da P�gina -->
<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Home" />
</c:import>

<!-- Conte�do da P�gina -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Livrare</h2>
        </div>
        <%
        //Pega os dados vindos do objeto de sess�o
        String nome=(String)session.getAttribute("nomeUsuario");        
        %>
        <div class="panel-body">
            <p> Seja bem vindo(a), <strong><%=nome %></strong>.</p>
            <p> Este � o Site de Adminitra��o da biblioteca Livrare.</p>
            <p>Neste espa�o � poss�vel:</p>
            <ul class="list">
                <li>Cadastrar livros</li>
                <li>Listar livros</li>
                <li>Cadastrar alunos</li>
                <li>Listar alunos</li>
                <li>Cadastrar o registro de emprestimos</li>
                <li>Listar o registro de emprestimos</li>
                <li>Cadastrar usu�rios</li>
                <li>Listar usu�rios</li>
              </ul>
        </div>
    </div>
</div>    
<!-- Rodap� da P�gina -->
<jsp:include page="../inc/rodape.inc.jsp" />
