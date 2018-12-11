<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="Livrare">
            <meta name="author" content="IFRS-BG">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
            <title>Livrare</title>
        </head>
        <body>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Livrare</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <%
                        //Se não for a página de login ou de erro então mostra o menu
                        String pageName = request.getParameter("pageName");
                        if (!pageName.equalsIgnoreCase("Login") && !pageName.equalsIgnoreCase("Erro")) {

                    %>    
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("Home")) ? "active" : ""%>">
                                <a class="nav-link" href="/livrare/jsp/home.jsp">Home <%= (pageName.equalsIgnoreCase("Home")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>
                            <li class="nav-item dropdown <%= (pageName.equalsIgnoreCase("Livros")) ? "active" : ""%>">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Livros <%= (pageName.equalsIgnoreCase("Livros")) ? "<span class='sr-only'>(current)</span>" : ""%>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="/livrare/jsp/listlivros.jsp">Listar</a>
                                    <a class="dropdown-item" href="/livrare/jsp/cadlivros.jsp">Cadastrar</a>
                                    <a class="dropdown-item" href="/livrare/jsp/gercategorias.jsp">Categorias</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown <%= (pageName.equalsIgnoreCase("Alunos")) ? "active" : ""%>">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Alunos <%= (pageName.equalsIgnoreCase("Alunos")) ? "<span class='sr-only'>(current)</span>" : ""%>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="/livrare/jsp/listalunos.jsp">Listar</a>
                                    <a class="dropdown-item" href="/livrare/jsp/cadalunos.jsp">Adicionar</a>                      
                                </div>
                            </li>
                            <li class="nav-item dropdown <%= (pageName.equalsIgnoreCase("Emprestimos")) ? "active" : ""%>">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Empréstimos <%= (pageName.equalsIgnoreCase("Emprestimos")) ? "<span class='sr-only'>(current)</span>" : ""%>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="/livrare/jsp/listemprestimos.jsp">Listar</a>
                                    <a class="dropdown-item" href="/livrare/jsp/cademprestimos.jsp">Adicionar</a>                      
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/livrare/UsuarioController?acao=sair">Sair</a>
                            </li>
                        </ul>
                    </div>
                    <%
                        }
                    %>            
                </div>
            </nav>

