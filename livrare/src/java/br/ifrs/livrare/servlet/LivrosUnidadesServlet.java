package br.ifrs.livrare.servlet;

import br.ifrs.livrare.dao.CategoriaDAO;
import br.ifrs.livrare.dao.LivroDidaticoDAO;
import br.ifrs.livrare.dao.LivroUnidadeDAO;
import br.ifrs.livrare.model.Categoria;
import br.ifrs.livrare.model.Emprestimo;
import br.ifrs.livrare.model.LivroDidatico;
import br.ifrs.livrare.model.LivroUnidade;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LivrosUnidadesServlet")
public class LivrosUnidadesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroUnidadeDAO dao = new LivroUnidadeDAO();
        LivroDidaticoDAO daolivro = new LivroDidaticoDAO();
        String acao = request.getParameter("acao").trim();
        String retorno = "false";

        try {
            if (acao.equals("Adicionar")) {
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                long idLivroDidatico = Long.parseLong(request.getParameter("idLivroDidatico"));
                int proximoId = dao.obterUltimoId() + 1;
                for (int i = 0; i < quantidade; i++) {
                    LivroUnidade lu = new LivroUnidade();
                    Random rand = new Random();
                    int numeroRandomico = rand.nextInt(1000000);
                    String codigoBarras = Integer.toString(proximoId) + Long.toString(idLivroDidatico) + Integer.toString(numeroRandomico);
                    lu.setCodigoDeBarras(codigoBarras);
                    LivroDidatico ld = new LivroDidatico();
                    ld.setId(idLivroDidatico);
                    lu.setLivro(ld);
                    dao.salvar(lu);
                    proximoId++;

                    LivroDidatico livroDidatico = daolivro.obter(idLivroDidatico);
                    request.setAttribute("livro", livroDidatico);
                    CategoriaDAO daoCat = new CategoriaDAO();
                    List<Categoria> categorias = daoCat.pesquisar("");
                    request.setAttribute("categorias", categorias);
                    RequestDispatcher view = request.getRequestDispatcher("/jsp/gerunidades.jsp");
                    view.forward(request, response);
                }

            }
        } catch (Exception e) {
            Logger.getLogger(LivrosUnidadesServlet.class.getName()).log(Level.SEVERE, null, e);
            retorno = e.toString();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroDidaticoDAO dao = new LivroDidaticoDAO();
        String acao = request.getParameter("acao").trim();
        Long id = Long.parseLong(request.getParameter("id").trim());
        String retorno = "false";

        try {
            if (acao.equals("select")) {
                retorno = "<select id='livroUnidade' class='form-control' required>";
                retorno += "<option value=''>Selecione...</option>";
                LivroDidatico livroD = dao.obter(id);
                List<LivroUnidade> livrosUnidades = livroD.getLivros();
                for (LivroUnidade liv : livrosUnidades) {
                    if(liv.getEmprestimosEnvolvidos().size() <= 0) {
                        retorno += "<option value='"+liv.getId()+"'>"+liv.getCodigoDeBarras()+"</option>";
                    }
                }
                retorno += "</select>";
            }
        } catch (Exception e) {
            Logger.getLogger(LivrosUnidadesServlet.class.getName()).log(Level.SEVERE, null, e);
            retorno = e.toString();
        }

        response.setContentType("text/plain");
        response.getWriter().write(retorno);
    }

}
