<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.usjt.web.whisper.model.*"%>
<%@page import="br.usjt.web.whisper.service.PostService"%>
<%@page import="br.usjt.web.whisper.service.ComentarioService"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="navbar.jsp"/>
<head>
	<link rel="stylesheet" href="css/perfil.css">
	

</head>

 <body class="bg-light " >

   
<% Usuario user = (Usuario) session.getAttribute("usuarioLogado");%>


<main role="main" class="container mt-5">
  <div class=" container d-flex align-items-center p-3 my-3 text-white-50 rounded shadow-sm" style="background-color: #03436A;">
    <img class="mr-3 align-self-start mr-3" src="<%=user.getFoto() %>" alt="" width="48" height="48">
    <div class=" container lh-100">
      <h6 class="mb-0 text-white lh-100"><%=user.getNome()%></h6>
      <small><%=user.getDtNascimento() %></small> <br>
      <small><%=user.getEmail() %></small> <br>

    <small class="d-block  text-right">
    <form class="form-signin" action="EditaPerfil.do" method="POST"  enctype="multipart/form-data">
    	<div class="element">
				<span class="name mr-1" id="spanName" style="display:none;"> </span>	
				<i id="iconFile" class="fas fa-image" style="color: white;"></i> <input type="file" name="imagem" id="inputIcon"/>
			</div>
    </small> 
    </div>
  </div>

	      	<div class="form-label-group">
	        	<input type="text" value="<%= user.getNome() %>" id="inputNome" class="form-control " name="txtNome" placeholder="Nome" required autofocus>
	        
			
		</div>
	     	<div class="form-label-group mt-3">
	        	<input type="text" id="inputNickname" value="<%= user.getNickname() %>" disabled name="txtNick" class="form-control" placeholder="NickName" required autofocus>
	        	
				
	      	</div>
	      	<div class="form-label-group  mt-3">
	        	<input type="email" id="inputEmail" value="<%= user.getEmail() %>" disabled name="txtEmail" class="form-control " placeholder="Email address" required autofocus>
	        	
	        	
	      	</div>
	      	<div class="form-label-group  mt-3">
	        	<input type="date" id="inputDate" disabled value="<%= user.getDtNascimento() %>" name="dtNascimento" class="form-control" placeholder="Password" required>
	        	
	        	
	      	</div>
	      	<div class="form-label-group  mt-3">
	        	<input type="password" id="inputPassword" class="form-control " placeholder="Password" required>
	        	
	        
	      	</div>
	    	<div class="form-label-group  mt-3">
	        	<input type="password" id="inputConfirmarSenha" name="txtSenha" class="form-control" placeholder="Password" required disabled>
	        	
	        	
	      	</div>
	      	<button class="btn btn-lg btn-primary btn-block mt-5" type="submit">Atualizar</button>
	      	
		</form>
	



 

</main>

<script type="text/javascript"  src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script> 
<script src="js/offcanvas.js"></script>

<script>
$(document).ready(function(){
    $('#inputPassword').on('input', function(){
       var val = $('#inputPassword').val();
        if (val.length > 0)
        {
            $('#inputConfirmarSenha').prop('disabled', false);
        }
        else
        {
            $('#inputConfirmarSenha').prop('disabled', true);
           
        }
    });
  });
</script>
<script>
$('#iconFile').on('click', function(){
	$('#inputIcon').click();
	$('#iconFile').removeClass("fa-image");
	$('#iconFile').addClass("fa-check-circle");
	$('#iconFile').css("color", "green");
});
$('input[type="file"]').on('change', function() {
	$('#spanName').css("display", "block");
	  var val = $(this).val();
	  $(this).siblings('span').text(val);
	});	

</script>      
</body></html>