package br.ifrs.livrare.controller;

import br.ifrs.livrare.dao.EmprestimoDAO;
import br.ifrs.livrare.model.Emprestimo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmprestimoController", urlPatterns = {"/EmprestimoController"})
public class EmprestimoController extends HttpServlet {
    private static String LOGIN = "/login.jsp";
    private static String HOME = "/jsp/home.jsp";
    private static String ERRO = "/erro.jsp";
    private static String LISTAGEM = "/jsp/listemprestimos.jsp";
    private static String CADASTRO = "/jsp/cademprestimos.jsp";
    
    private final EmprestimoDAO dao;

    public EmprestimoController() {
        super();
        //Cria a classe DAO
        this.dao = new EmprestimoDAO();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String forward = "";
        try{
            
            //Recebe os dados da URL
            String acao = request.getParameter("acao").toLowerCase();
            
            if (acao.equalsIgnoreCase("atualizar")){
                int idEmprestimo = Integer.parseInt(request.getParameter("id"));
                Emprestimo emprestimo = this.dao.obter(idEmprestimo);
                forward = CADASTRO;        
                request.setAttribute("emprestimo", emprestimo);    
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
