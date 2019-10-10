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

	<div class="my-3 p-3 bg-white rounded shadow-sm">
				<h6 class="border-bottom border-gray pb-2 mb-0">Seguidores</h6>
				<div class="media text-muted pt-3">
					<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
						xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: 32x32">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#007bff"></rect>
						<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
					<div
						class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
						<div class="d-flex justify-content-between align-items-center w-100">
							<strong class="text-gray-dark">Full Name</strong> <a href="#">Follow</a>
						</div>
						<span class="d-block">@username</span>
					</div>
				</div>
				<div class="media text-muted pt-3">
					<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
						xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: 32x32">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#007bff"></rect>
						<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
					<div
						class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
						<div class="d-flex justify-content-between align-items-center w-100">
							<strong class="text-gray-dark">Full Name</strong> <a href="#">Follow</a>
						</div>
						<span class="d-block">@username</span>
					</div>
				</div>
				<div class="media text-muted pt-3">
					<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
						xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: 32x32">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#007bff"></rect>
						<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
					<div
						class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
						<div class="d-flex justify-content-between align-items-center w-100">
							<strong class="text-gray-dark">Full Name</strong> <a href="#">Follow</a>
						</div>
						<span class="d-block">@username</span>
					</div>
				</div>
				<small class="d-block text-right mt-3"> <a href="#">All
						suggestions</a>
				</small>
			</div>
		</main>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="js/offcanvas.js"></script>

	</body>
</html>