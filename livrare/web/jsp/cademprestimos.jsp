<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Emprestimos" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Emprestimos</h2>
        </div>
        <div class="panel-body">
            <!-- Mensagens vindas do CriancaController -->
            <c:out value="${mensagem}" escapeXml="false"/>

            <!-- Formulário que envia dados para o CriancaController -->
            <form onsubmit="return false;" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${emprestimo.id!=null?emprestimo.id:0}">
                    <div class="row">
                        <div class="col">
                            <div class="alert" id="retorno"></div>
                        </div>
                    </div>
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
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label">Livro Unidade (C�digo de barras)</label>  
                            <div id="selectUnidades"></div>
                        </div>
                    </div>
                    <div class="form-row">
                       <div class="form-group col-md-6">
                            <label class="control-label">Ano de</label> <br>
                            <input type="number" id="anoDe" class="form-control" value="${emprestimo.anode!=null?emprestimo.anode:""}">
                            <label class="control-label">Ano at�</label> <br>
                            <input type="number" id="anoAte" class="form-control" value="${emprestimo.anoate!=null?emprestimo.anoate:""}">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Status</label>
                            <select id="status" disabled class="form-control">
                                <option value="1">Ativo</option>
                                <option value="0">Inativo</option>
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
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listaluno.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>   
                </fieldset>
            </form>

        </div>
    </div>
</div>
<!-- Rodapé da Página -->
<jsp:include page="../inc/rodape.inc.jsp" />
<script src="../js/cademprestimos.js" type="text/javascript" charset="utf-8"></script>
