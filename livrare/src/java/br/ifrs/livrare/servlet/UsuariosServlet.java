package br.ifrs.livrare.servlet;

import br.ifrs.livrare.dao.UsuarioDAO;
import br.ifrs.livrare.model.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/UsuariosServlet")
public class UsuariosServlet extends HttpServlet {

    private UsuarioDAO dao;


    public static boolean verificaAcesso(HttpServletRequest request) throws Exception {
        
        HttpSession session = request.getSession(true);
        String nome = (String) session.getAttribute("nomeUsuario");
        if (nome != null) {
            return true;
        } else {
            return false;
        }

    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String forward = "";
//        try {
//
//            
//            String acao = request.getParameter("acao").toLowerCase();
//
//            
//            if (acao.equalsIgnoreCase("sair")) {
//                
//                HttpSession session = request.getSession(true);
//                
//                session.invalidate();
//                
//                forward = "/jsp/login.jsp";
//            }
//
//            if (acao.equalsIgnoreCase("atualizar")) {
//                int idUsuarioDB = Integer.parseInt(request.getParameter("id"));
//                Usuario usuarioDB = this.dao.obter(idUsuarioDB);
//                forward = CADASTRO;
//                request.setAttribute("usuario", usuarioDB);
//            }
//            if (acao.equalsIgnoreCase("excluir")) {
//                int idUsuarioDB = Integer.parseInt(request.getParameter("id"));
//                this.dao.excluir(idUsuarioDB);
//                forward = LISTAGEM;
//                String mensagem = "<div class='alert alert-success'>"
//                        + "<strong>Sucesso!</strong> Usuario apagado com sucesso!"
//                        + "</div>";
//                request.setAttribute("mensagem", mensagem);
//            }
//        } catch (Exception ex) {
//            
//            forward = ERRO;
//            request.setAttribute("mensagem", ex.toString());
//        } finally {
//            
//            if (!forward.equals("")) {
//                RequestDispatcher view = request.getRequestDispatcher(forward);
//                view.forward(request, response);
//            }
//        }
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {

            if (request.getParameter("nome") == null && request.getParameter("nome_pesquisa") == null) {
                
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                
                HttpSession session = request.getSession(true);

                
                Usuario usuario = this.dao.logar(email, senha);
                if (usuario != null) { 

                    
                    session.setAttribute("idUsuario", usuario.getId());
                    session.setAttribute("nomeUsuario", usuario.getNome());

                    
                    forward = "/jsp/home.jsp";

                } else { 

                    
                    session.invalidate();

                    
                    forward = "/jsp/login.jsp";
                    String mensagem = "<div class='alert alert-warning'>"
                            + "<strong>Alerta!</strong> Usuário e/ou senha incorretos!"
                            + "</div>";
                    request.setAttribute("mensagem", mensagem);
                }
            } 
//            else {
//                if (request.getParameter("nome_pesquisa") != null) {
//                    String nomePesquisa = request.getParameter("nome_pesquisa");
//                    List<Usuario> users = this.dao.pesquisar(nomePesquisa);
//                    forward = "";
//                    Gson gsonObj = new Gson();
//                    ServerResponse vr = new ServerResponse();
//                    String jsonUsers = gsonObj.toJson(users);
//                    vr.message = jsonUsers;
//                    String json = gsonObj.toJson(vr);
//                    response.setContentType("text/plain");
//                    response.setCharacterEncoding("UTF-8");
//                    response.getWriter().write(json);
//                } else if (request.getParameter("nome") != null) {
//                    Usuario user = new Usuario();
//                    preencheModel(request, user);
//                    String mensagem = "";
//                    if (user.getId() != null) {
//                        this.dao.atualizar(user);
//                        mensagem = "<div class='alert alert-success'>"
//                                + "<strong>Sucesso!</strong> Usuário atualizado com sucesso!"
//                                + "</div>";
//                        forward = CADASTRO;
//                    } else {
//                        this.dao.salvar(user);
//                        mensagem = "<div class='alert alert-success'>"
//                                + "<strong>Sucesso!</strong> Novo usuário criado com sucesso!"
//                                + "</div>";
//                        forward = LISTAGEM;
//                    }
//                    request.setAttribute("mensagem", mensagem);
//                }
//            }
        } catch (Exception ex) {
            forward = "/jsp/login.jsp";
            request.setAttribute("mensagem", ex.toString());
        } finally {
            if (!forward.equals("")) {
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }
        }
    }
//
    private void preencheModel(HttpServletRequest request, Usuario user) {
        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
            user.setId(Integer.parseInt(request.getParameter("id")));
        }
        user.setNome(request.getParameter("nome"));
        user.setEmail(request.getParameter("email"));
        user.setSenha(request.getParameter("senha"));
    }
}
