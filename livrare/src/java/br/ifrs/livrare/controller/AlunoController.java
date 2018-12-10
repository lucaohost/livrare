package br.ifrs.livrare.controller;

import br.ifrs.livrare.dao.AlunoDAO;
import br.ifrs.livrare.model.Aluno;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoController", urlPatterns = {"/AlunoController"})
public class AlunoController extends HttpServlet {
    private static String LOGIN = "/login.jsp";
    private static String HOME = "/jsp/home.jsp";
    private static String ERRO = "/erro.jsp";
    private static String LISTAGEM = "/jsp/listalunos.jsp";
    private static String CADASTRO = "/jsp/cadalunos.jsp";
    
    private final AlunoDAO dao;

    public AlunoController() {
        super();
        //Cria a classe DAO
        this.dao = new AlunoDAO();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String forward = "";
        try{
            
            //Recebe os dados da URL
            String acao = request.getParameter("acao").toLowerCase();
            
            if (acao.equalsIgnoreCase("atualizar")){
                int idAluno = Integer.parseInt(request.getParameter("id"));
                Aluno aluno = this.dao.obter(idAluno);
                forward = CADASTRO;        
                request.setAttribute("aluno", aluno);    
            }
        }
        catch(Exception ex){
            //Define a página e atributos para redirecionar o site
            forward = ERRO;        
            request.setAttribute("mensagem", ex.toString());    
        }finally{
            //Redireciona para a página correta
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }   
    }
}
