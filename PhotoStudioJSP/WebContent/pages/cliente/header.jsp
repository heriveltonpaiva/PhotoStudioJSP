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
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">PhotoStudio</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Pagina Inicial</a></li>
             
			<li class="dropdown">
              <a href="ListAlbumClienteServlet" >Visualizar Albuns</a>
            </li>
			<li class="dropdown">
              <a href="ListCarrinhoServlet" >Meu Carrinho</a>
            </li>
            <li class="dropdown">
              <a href="ListHistoricoServlet" >Meu Historico</a>
            </li>
            <li>
             <a href="index.jsp">Encerrar Sessão</a>
             </li>
            <li>
             <a ><b>Bem vindo, ${usuario}</b> - Perfil Cliente</a>
             </li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
    
    