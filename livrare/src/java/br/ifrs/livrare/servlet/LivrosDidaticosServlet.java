package br.ifrs.livrare.servlet;

import br.ifrs.livrare.dao.CategoriaDAO;
import br.ifrs.livrare.dao.LivroDidaticoDAO;
import br.ifrs.livrare.model.Aluno;
import br.ifrs.livrare.model.Categoria;
import br.ifrs.livrare.model.LivroDidatico;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LivrosDidaticosServlet")
public class LivrosDidaticosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroDidaticoDAO dao = new LivroDidaticoDAO();
        String acao = request.getParameter("acao").trim();
        String retorno = "false";

        try {
            if (acao.equals("salvar")) {
                LivroDidatico livro = new LivroDidatico();
                livro.setId(null);
                Categoria categoria = new Categoria();
                Long idCategoria = Long.parseLong(request.getParameter("categoria"));
                categoria.setId(idCategoria);
                livro.setCategoria(categoria);
                livro.setIsbn(request.getParameter("isbn"));
                livro.setAutor(request.getParameter("autor"));
                livro.setNome(request.getParameter("nome"));
                livro.setVolume(request.getParameter("volume"));
                livro.setFotoCapa("link");
                dao.salvar(livro);
                retorno = "true";
            } else if (acao.equals("excluir")) {
                long id = Long.parseLong(request.getParameter("id"));
                dao.excluir(id);
                retorno = "true";
            } else if (acao.equals("atualizar")) {
                LivroDidatico livro = new LivroDidatico();
                livro.setId(Long.parseLong(request.getParameter("id")));
                Categoria categoria = new Categoria();
                Long idCategoria = Long.parseLong(request.getParameter("categoria"));
                categoria.setId(idCategoria);
                livro.setCategoria(categoria);
                livro.setIsbn(request.getParameter("isbn"));
                livro.setAutor(request.getParameter("autor"));
                livro.setNome(request.getParameter("nome"));
                livro.setVolume(request.getParameter("volume"));
                livro.setFotoCapa("link");
                String categoriaJson = request.getParameter("categoriaJson");
                dao.atualizar(livro);
                retorno = "true";
            }
        } catch (Exception e) {
            Logger.getLogger(LivrosDidaticosServlet.class.getName()).log(Level.SEVERE, null, e);
            retorno = e.toString();
        }

        response.setContentType("text/plain");
        response.getWriter().write(retorno);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroDidaticoDAO dao = new LivroDidaticoDAO();
        String acao = request.getParameter("acao").trim();
        String retorno = "false";

        try {
            if (acao.equals("buscar")) {
                String pesquisa = request.getParameter("pesquisa") != null ? request.getParameter("pesquisa").trim() : "";
                retorno = "<table class='table table-striped table-bordered table-condensed table-hover'>"
                        + "                <thead class='thead-dark text-center'>"
                        + "                    <tr>"
                        + "                        <th>Nome</th>"
                        + "                        <th>Autor</th>"
                        + "                        <th>Volume</th>"
                        + "                        <th>Categoria</th>"
                        + "                        <th>ISBN</th>"
                        + "                        <th>Quantidade</th>"
                        + "                        <th>Ação</th>"
                        + "                    </tr>"
                        + "                </thead>"
                        + "                <tbody class='text-center'>";

                List<LivroDidatico> livros = dao.pesquisar(pesquisa);
                for (LivroDidatico liv : livros) {
                    retorno += "<tr>"
                            + "<td>" + liv.getNome() + "</td>"
                            + "<td width='15%'>" + liv.getAutor() + "</td>"
                            + "<td width='15%'>" + liv.getVolume() + "</td>"
                            + "<td width='15%'>" + liv.getCategoria().getNome() + "</td>"
                            + "<td width='15%'>" + liv.getIsbn() + "</td>"
                            + "<td width='15%'>" + "<a class='text-dark' href='/livrare/LivrosDidaticosServlet?acao=gerunidades&id=" + liv.getId() + "'>"
                            + liv.getLivros().size()
                            + "</a>" + "</td>"
                            + "<td width='15%'>"
                            + "<a class='text-dark' href='/livrare/LivrosDidaticosServlet?acao=atualizar&id=" + liv.getId() + "'"
                            + "<i class='fa fa-edit'>"
                            + "</i>"
                            + "Alterar"
                            + "</a> | "
                            + "<a class='text-dark excluir' href='#' idLivro='" + liv.getId() + "'>"
                            + "<i class='fa fa-trash'></i>Excluir"
                            + "</a>"
                            + "</td>"
                            + "</tr>";
                }
                retorno += "</tbody>"
                        + "</table>";
            }
            if (acao.equals("atualizar")) {
                long idLivroDidatico = Long.parseLong(request.getParameter("id"));
                LivroDidatico livroDidatico = dao.obter(idLivroDidatico);
                request.setAttribute("livro", livroDidatico);
                CategoriaDAO daoCat = new CategoriaDAO();
                List<Categoria> categorias = daoCat.pesquisar("");
                request.setAttribute("categorias", categorias);
                RequestDispatcher view = request.getRequestDispatcher("/jsp/cadlivros.jsp");
                view.forward(request, response);
            }
            if (acao.equals("gerunidades")) {
                long idLivroDidatico = Long.parseLong(request.getParameter("id"));
                LivroDidatico livroDidatico = dao.obter(idLivroDidatico);
                request.setAttribute("livro", livroDidatico);
                CategoriaDAO daoCat = new CategoriaDAO();
                List<Categoria> categorias = daoCat.pesquisar("");
                request.setAttribute("categorias", categorias);
                RequestDispatcher view = request.getRequestDispatcher("/jsp/gerunidades.jsp");
                view.forward(request, response);
            }
            if (acao.equals("select")) {
                retorno = "<select id='livro' class='form-control' onchange='atualizarUnidades()'>";
                retorno += "<option value=''>Selecione...</option>";
                List<LivroDidatico> livros = dao.pesquisar("");
                for (LivroDidatico liv : livros) {
                    retorno += "<option value='"+liv.getId()+"'>"+liv.getNome()+"</option>";
                }
                retorno += "</select>";
            }
        } catch (Exception e) {
            Logger.getLogger(LivrosDidaticosServlet.class.getName()).log(Level.SEVERE, null, e);
            retorno = e.toString();
        }

        response.setContentType("text/plain");
        response.getWriter().write(retorno);
    }

}
