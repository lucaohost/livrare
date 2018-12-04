<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Home" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Livrare</h2>
        </div>
        <%
        //Pega os dados vindos do objeto de sessão
        String nome=(String)session.getAttribute("nomeUsuario");        
        %>
        <div class="panel-body">
            <p> Seja bem vindo(a), <strong><%=nome %></strong>.</p>
            <p> Este é o Site de Adminitração da biblioteca Livrare.</p>
            <p>Neste espaço é possível:</p>
            <ul class="list">
                <li>Cadastrar livros</li>
                <li>Listar livros</li>
                <li>Cadastrar alunos</li>
                <li>Listar alunos</li>
                <li>Cadastrar o registro de emprestimos</li>
                <li>Listar o registro de emprestimos</li>
                <li>Cadastrar usuários</li>
                <li>Listar usuários</li>
              </ul>
        </div>
    </div>
</div>    
<!-- Rodapé da Página -->
<jsp:include page="../inc/rodape.inc.jsp" />
