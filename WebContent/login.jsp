<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">
	    <title>Login - Whisper</title>
	
	    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/floating-labels/">
	
	    <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
	
	    <!-- Custom styles for this template -->
	    <link href="css/estilologin_cadastro.css" rel="stylesheet">
	    <link href="css/estilonavbar.css" rel="stylesheet">
	    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg fixed-top navbar-light" id="mainNav" style="background-color: white; font-family: 'Montserrat', sans-serif;">
         	<div class="container">
            	<a class="navbar-brand js-scroll-trigger" href="index.jsp">
            		<img src="img/logobird.svg" width="100" height="30" class="d-inline-block align-top" alt=""></a>
           		<button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
                	<span class="navbar-toggler-icon" ></span></button>
            	<div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
	                <ul class="navbar-nav mr-auto"></ul>
	                <ul class="navbar-nav ml-auto">
	                	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="index.jsp">home</a></li>
	                  	<li class="nav-item"><a class="nav-link js-scroll-trigger active" href="#">login</a></li>
	                  	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="cadastro.jsp">cadastre se</a></li>
	            	</ul>
            	</div>     
            </div>
        </nav>
		
		<form class="form-signin animted bounceIn mt-5" action="Login.do" method="POST">
	    	<div class="text-center mb-4">
	        	<img class="mb-4" src="img/logo.svg"  alt="" width="350" >
	        	<p>Faça login e desfrute da mais nova rede social da área!</p>
	      	</div>
	      	<div class="form-label-group">
		        <input type="email" id="inputEmail" name="txtEmail" class="form-control" placeholder="Email" required autofocus>
		        <label for="inputEmail">Email</label>
	      	</div>
	
	      	<div class="form-label-group">
		        <input type="password" id="inputPassword" name="txtSenha" class="form-control" placeholder="Senha" required>
		        <label for="inputPassword">Senha</label>
	      	</div>
	      	<div class="checkbox mb-3">
		        <label>
		        	<input type="checkbox" value="remember-me"> Lembrar
		        </label>
	      	</div>
	      	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
	      	<p class="mt-5 mb-3 text-muted text-center">© 2019-Eternidade</p>
   		</form>
		
		<!-- Bootstrap core JavaScript -->
  		<script src="vendor/jquery/jquery.min.js"></script>
  		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/offcanvas.js"></script>
		
	</body>
</html>