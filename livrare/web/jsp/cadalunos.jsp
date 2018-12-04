<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="../inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Alunos" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Alunos</h2>
        </div>
        <div class="panel-body">
            <!-- Mensagens vindas do CriancaController -->
            <c:out value="${mensagem}" escapeXml="false"/>

            <!-- Formulário que envia dados para o CriancaController -->
            <form onsubmit="return false;" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${aluno.id!=null?aluno.id:""}">
                    <div class="row">
                        <div class="col">
                            <div class="alert" id="retorno"></div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label class="control-label" for="matricula">Número da matrícula</label>  
                            <input id="matricula" name="matricula" type="number" placeholder="Digite o número da matrícula" class="form-control" required="" value="${aluno.nome!=null?aluno.nome:""}">
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label" for="curso">Curso</label>  
                            <input id="curso" name="curso" type="text" placeholder="Digite o curso" class="form-control" required="" value="${aluno.nome!=null?aluno.nome:""}">
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label" for="turma">Turma</label>  
                            <input id="turma" name="turma" type="text" placeholder="Digite a turma" class="form-control" required="" value="${aluno.nome!=null?aluno.nome:""}">
                        </div>
                    </div>          
                    <div class="form-group">
                        <div class="alert" style="display: none;" id="msgEmail"></div>
                        <label class="control-label" for="nome">Nome</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome" class="form-control" required="" value="${aluno.email!=null?aluno.email:""}">
                    </div>                    
                    <div class="form-group">
                        <div class="alert" style="display: none;" id="msgEmail"></div>
                        <label class="control-label" for="nome">E-mail:</label>  
                        <input id="email" name="email" type="email" placeholder="Digite o e-mail" class="form-control" required="" value="${aluno.email!=null?aluno.email:""}">
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
<script src="../js/cadalunos.js" type="text/javascript" charset="utf-8"></script>