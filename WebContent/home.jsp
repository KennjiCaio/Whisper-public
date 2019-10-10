<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.web.whisper.model.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	<body>
		<% Usuario user = (Usuario) session.getAttribute("usuarioLogado");%>
	
		<h1>Home</h1>
		<label>Olá, @<%=user.getNickname()%></label><br>
		<a href="Logout.do">Sair</a>
		
	</body>
</html>