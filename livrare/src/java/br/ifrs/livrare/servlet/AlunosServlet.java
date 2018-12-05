/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.livrare.servlet;

import br.ifrs.livrare.dao.AlunoDAO;
import br.ifrs.livrare.model.Aluno;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valdir Jr
 */
@WebServlet("/AlunosServlet")
public class AlunosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();

        String acao = request.getParameter("acao").trim();
        String pesquisa = request.getParameter("pesquisa") != null ? request.getParameter("pesquisa").trim() : "";
        String retorno = "false";

        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").trim()) : -1;
        String nome = request.getParameter("nome") != null ? request.getParameter("nome").trim() : "";
        String email = request.getParameter("email") != null ? request.getParameter("email").trim() : "";
        String curso = request.getParameter("curso") != null ? request.getParameter("curso").trim() : "";
        String matricula = request.getParameter("matricula") != null ? request.getParameter("matricula").trim() : "";
        String turma = request.getParameter("turma") != null ? request.getParameter("turma").trim() : "";

        if(id != -1){
            aluno.setId(id);
        }
        aluno.setMatricula(matricula);
        aluno.setTurma(turma);
        aluno.setCurso(curso);
        aluno.setNome(nome);
        aluno.setEmail(email);

        if (acao.equals("salvar")) {

            if (aluno.getId() <= 0) {
                try {
                    dao.salvar(aluno);
                    retorno = "true";
                } catch (Exception ex) {
                    Logger.getLogger(AlunosServlet.class.getName()).log(Level.SEVERE, null, ex);
                    retorno = ex.toString();
                }
            } else {
                try {
                    dao.atualizar(aluno);
                    retorno = "true";
                } catch (Exception ex) {
                    Logger.getLogger(AlunosServlet.class.getName()).log(Level.SEVERE, null, ex);
                    retorno = ex.toString();
                }
            }

        } else if (acao.equals("buscar")) {

            retorno = "<table class='table table-striped table-bordered table-condensed table-hover'>"
                    + "                <thead class='thead-dark text-center'>"
                    + "                    <tr>"
                    + "                        <th>Nome</th>"
                    + "                        <th>Matricula</th>"
                    + "                        <th>Ação</th>"
                    + "                    </tr>"
                    + "                </thead>"
                    + "                <tbody>";

            try {
                List<Aluno> alunos = dao.pesquisar(pesquisa);
                for (Aluno alu : alunos) {
                    retorno += "<tr>"
                            + "<td>" + alu.getNome() + "</td>"
                            + "<td width='15%'>" + alu.getMatricula() + "</td>"
                            + "<td width='15%'>"
                            + "<a class='text-dark' href='#' onclick='alterar(" + alu.getId() + ");'>"
                            + "<i class='fa fa-edit'>"
                            + "</i>"
                            + "Alterar"
                            + "</a> | "
                            + "<a class='text-dark' href='#' onclick='excluir(" + alu.getId() + ");'>"
                            + "<i class='fa fa-trash'></i>Excluir"
                            + "</a>"
                            + "</td>"
                            + "</tr>";
                }
            } catch (Exception ex) {
                Logger.getLogger(AlunosServlet.class.getName()).log(Level.SEVERE, null, ex);
                retorno = ex.toString();
            }

            retorno += "</tbody>"
                    + "</table>";

        } else if (acao.equals("excluir")) {
            try {
                dao.excluir(aluno.getId());
                retorno = "true";
            } catch (Exception ex) {
                Logger.getLogger(AlunosServlet.class.getName()).log(Level.SEVERE, null, ex);
                retorno = ex.toString();
            }
        } else {
            retorno = "Ação não definida!";
        }

        response.setContentType("text/plain");
        response.getWriter().write(retorno);
    }

}
