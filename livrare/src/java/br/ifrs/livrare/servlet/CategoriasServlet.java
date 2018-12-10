package br.ifrs.livrare.servlet;

import br.ifrs.livrare.dao.CategoriaDAO;
import br.ifrs.livrare.model.Categoria;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoriasServlet")
public class CategoriasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAO();
        Gson gson = new Gson();
        String acao = request.getParameter("acao").trim();
        String retorno = "false";

        try {
            if (acao.equals("salvar")) {
                String categoriaJson = request.getParameter("categoria");
                Categoria categoria = gson.fromJson(categoriaJson, Categoria.class);
                int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").trim()) : -1;
                String nome = request.getParameter("nome") != null ? request.getParameter("nome").trim() : "";

                if (categoria.getId() == -1) {
                    categoria.setId(null);
                }
                dao.salvar(categoria);
                retorno = "true";
            } else if (acao.equals("excluir")) {
                long id = Long.parseLong(request.getParameter("id"));
                dao.excluir(id);
                retorno = "true";
            } else if (acao.equals("atualizar")) {
                String categoriaJson = request.getParameter("categoriaJson");
                Categoria categoriaAtualizar = gson.fromJson(categoriaJson, Categoria.class);
                dao.atualizar(categoriaAtualizar);
                retorno = "true";
            }
        } catch (Exception e) {
            Logger.getLogger(CategoriasServlet.class.getName()).log(Level.SEVERE, null, e);
            retorno = e.toString();
        }

        response.setContentType("text/plain");
        response.getWriter().write(retorno);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAO();
        Gson gson = new Gson();
        String acao = request.getParameter("acao").trim();
        String retorno = "false";

        try {
            if (acao.equals("buscar")) {
                String pesquisa = request.getParameter("pesquisa") != null ? request.getParameter("pesquisa").trim() : "";
                List<Categoria> categorias = dao.pesquisar(pesquisa);
                retorno = gson.toJson(categorias);
            }
        } catch (Exception e) {
            Logger.getLogger(CategoriasServlet.class.getName()).log(Level.SEVERE, null, e);
            retorno = e.toString();
        }

        response.setContentType("text/plain");
        response.getWriter().write(retorno);
    }

}
