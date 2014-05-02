<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Inicio</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="css/theme.css" rel="stylesheet">
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">PhotoStudio</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Pagina Inicial</a></li>
            
              <li class="dropdown">
              <a href="cliente.jsp" class="dropdown-toggle" data-toggle="dropdown">Meus Fotografo<b class="caret"></b></a>
               <ul class="dropdown-menu">
                <li><a href="formFotografo.jsp">Cadastrar Fotografo</a></li>
                <li><a href="../../FotografoServlet">Listar Fotografo</a></li>
              </ul>
            
            </li>
            <li class="dropdown">
              <a href="album.jsp" class="dropdown-toggle" data-toggle="dropdown">Acesso Restrito<b class="caret"></b></a>
             <ul class="dropdown-menu">
                <li><a href="acesso.jsp">Alterar Login</a></li>
              </ul>
            </li>	
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
    
    