<jsp:include page="navbar.jsp" />
<%@page import="br.usjt.web.whisper.model.Usuario"%>
<%@page import="br.usjt.web.whisper.model.Post"%>
<%@page import="br.usjt.web.whisper.service.PostService"%>
<%@page import="java.util.ArrayList"%>
	<body class="bg-light">
	
		<% 
		Usuario user = (Usuario) session.getAttribute("usuarioLogado");
		PostService postService = new PostService();
		%>
		
		<main role="main" class="container mt-2">


	<div class="container w-100 mt-5">
		<form>
			<div class="form-row">
				<div class="col-2 col-md-1">
					 <label for="txtNome" class="form-label">Nick:</label>
				</div>
				<div class="col">
					<input type="text" name="txtNome" id="txtNome" class="form-control" placeholder="Last name">
				</div>
			</div>
		</form>
	</div>

	<div class="my-3 p-3 bg-white rounded shadow-sm" >
				<h6 class="border-bottom border-gray pb-2 mb-0">Todos os usuários</h6>
				<div class="container-fluid" id="divBody">
				</div>
			</div>
		</main>
		
		<script type="text/javascript"  src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script src="js/offcanvas.js"></script>
		<script>
			$(document).ready(function(){
				$('#txtNome').on('input', function(){
					var val = $('#txtNome').val();
					if (val == ""){
						$('#divBody').html("");
							}
					else{
					$.ajax({
						type: "GET",
						url: "Busca.do",
						data: {
							nick : val,
							action : 'buscaNick'
						},
						success: function(data){
							$('#divBody').html(data);
						}
					});
					}
				});
			
			});
		</script>
	</body>
</html>