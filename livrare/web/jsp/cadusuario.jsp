<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="cabecalho.inc.jsp">
    <c:param name="pageName" value="Usuarios" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Usuários</h2>
        </div>
        <div class="panel-body">
            <!-- Mensagens vindas do CriancaController -->
            <c:out value="${mensagem}" escapeXml="false"/>

            <!-- Formulário que envia dados para o CriancaController -->
            <form onsubmit="return false;" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${usuario.id!=null?usuario.id:""}">
                    <div class="row">
                        <div class="col">
                            <div class="alert" id="retorno"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome:</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome" class="form-control" required="" value="${usuario.nome!=null?usuario.nome:""}">
                    </div>           
                    <div class="form-group">
                        <div class="alert" style="display: none;" id="msgEmail"></div>
                        <label class="control-label" for="nome">E-mail:</label>  
                        <input id="email" name="email" type="email" placeholder="Digite o e-mail" class="form-control" required="" value="${usuario.email!=null?usuario.email:""}" >
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="alert" style="display: none;" id="msgSenha"></div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="nome">Senha:</label>  
                            <input id="senha" name="senha" type="password" class="form-control" required="">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="perfil">Perfil:</label>  
                            <select class="form-control" id="perfil" name="perfil">
                                <option value="A" ${(usuario.perfil!=null && usuario.perfil=="A")?"selected='selected'": ""}>Administrador</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="salvar"></label>
                            <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="cancelar"></label>
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listusuario.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>                    
                </fieldset>
            </form>

        </div>
    </div>
</div>
<!-- Rodapé da Página -->
<jsp:include page="rodape.inc.jsp" />
<script src="https://cdn.jsdelivr.net/gh/danpalmer/jquery.complexify.js/jquery.complexify.js"></script>
<script src="/livrare/js/cadusuario.js" type="text/javascript" charset="utf-8"></script>


