<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import ="br.usjt.web.whisper.service.*" %>
<%@ page import ="br.usjt.web.whisper.model.*" %>
<!DOCTYPE html>
<html lang="pt-br"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Whisper</title>
    
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/offcanvas/">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
    <!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/estilonavbar.css" rel="stylesheet">
</head>
<body>
 <nav class="navbar navbar-expand-lg fixed-top navbar-light" id="mainNav" style="background-color: white; font-family: 'Montserrat', sans-serif;">
  <a class="navbar-brand mr-auto mr-lg-0" href="homepage.jsp"><img src="img/logobird.svg" width="100" height="30" class="d-inline-block align-top" alt=""></a>
  <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
  <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
        <a class="nav-link" href="homepage.jsp">Dashboard <span class="sr-only"></span></a>
      </li>
  </ul>
    <ul class="navbar-nav ml-auto">

      <li class="nav-item">
        <a class="nav-link" href="perfil.jsp">Perfil</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Logout.do">Sair</a>
      </li>

    </ul>

  </div>
</nav>
<% SeguidoresService seg = new SeguidoresService();
	Usuario user = (Usuario) session.getAttribute("usuarioLogado");

%>
<div class="nav-scroller bg-white shadow-sm">
  <nav class="nav navbar-light nav-underline">
    <a class="nav-link active" href="homepage.jsp">Homepage</a>
    <a class="nav-link" href="telaseguidores.jsp">
      Seguidores
      <span class="badge badge-pill bg-light align-text-bottom"><%=seg.qtdSeguidores(user.getId())%></span>
    </a>
    <a class="nav-link" href="usuarios.jsp">Buscar</a>

  </nav>
</div>
</body>
</html>