
<%@page import="br.usjt.web.whisper.model.*"%>
<%@page import="br.usjt.web.whisper.service.*"%>
<%@page import="java.util.ArrayList"%>
<head>
	<link rel="stylesheet" href="css/perfil.css">


</head>
<jsp:include page="navbar.jsp"/>
 <body class="bg-light" >

   
<% Usuario user = (Usuario) session.getAttribute("usuarioLogado");%>


<main role="main" class="container">
  <div class=" container d-flex align-items-center p-3 my-3 text-white-50 rounded shadow-sm" style="background-color: #03436A;">
    <img class="mr-3 align-self-start mr-3" src="<%=user.getFoto() %>" alt="" width="48" height="48">
    <div class=" container lh-100">
      <h6 class="mb-0 text-white lh-100"><%=user.getNome()%></h6>
      <small><%=user.getDtNascimento() %></small> <br>
      <small><%=user.getEmail() %></small> <br>
      <small class="d-block mt-2 mb-2 text-left" style="color:white;">
		<a href="#" style="color:white; text-decoration: none;"><i class="fas fa-user-friends mr-1"></i>58</a>
		<i class="fas fa-retweet ml-2 mr-1"></i>58
	
    </small>
    <small class="d-block  text-right">
    	<a href="usuarioupdate.jsp" style="color:white;"><i class="fas fa-pen"></i></a> 	
    </small> 
    </div>
  </div>

	<div class="my-3 p-3 bg-white  rounded shadow-sm">
		<h6 class="pb-2 mb-0  border-bottom border-gray">O que está
			pensando?</h6>
		<div class="container border-bottom border-gray">
			<div class="row">
				<form id="formPost" accept-charset="utf-8" action="Post.do" method="POST" class="w-100"  enctype="multipart/form-data">


					<textarea id="txtPost" name="txtPost" class="form-control"
						placeholder="Não meça suas palavras." rows="5" id="comment"
						style="border: none;"></textarea>
			</div>
		</div>

		<small class="d-block mt-2 text-right">
		
			<div class="element">
				<span class="name mr-1" id="spanName" style="display:none;"> </span>	
				<i id="iconFile" class="fas fa-image" style="color: #0969A2;"></i> <input type="file" name="imagem" id="inputIcon"/>
			</div>
			<button id="btnEnviar buttonscolor" type="submit" style="background: transparent; border:none; color:#0969A2;" class="fas fa-paper-plane"></button>
			</form>
		</small>

  </div>

<div class="alert alert-success" id="alertCadastro"role="alert" style="display:none;">
  	Parece que você tem novos posts. <a href="#" id="btnRefresh">Clique aqui para recarregar</a>
</div>
<div class="my-3 p-3 bg-white rounded shadow-sm">
  <h6 class="pb-2 mb-0">Seus Posts</h6>
  <% PostService ps = new PostService(); 

  	ArrayList<Post> lista = ps.consultaPostSeguidores(user.getId());
  	int i = 0;
  	for (Post post: lista)
  	{
  		i = i + 1;
	%>
  <div class="container border-top border-gray " >
    <div class="media text-muted pt-3" data-toggle="modal" data-target="#modal<%=post.getId()%>">
      	<img class="mr-3 align-self-start mr-3" src="<%=post.getUsuario().getFoto() %>" alt="" width="48" height="48">
      <p class="media-body pb-3 mb-0 small lh-125 ">
        <%=post.getUsuario().getNome() %><strong class="d-block mb-2 text-gray-dark">@<%=post.getUsuario().getNickname() %></strong>
      	<%= post.getDescricao() %>
      </p>

    </div>
    <%if (post.getImagem() != null){ %>
    <div class="container text-center" data-toggle="modal" data-target="#modal<%=post.getId()%>">
    	<img style="max-width:200px !important"src="<%=post.getImagem() %> " class="img-fluid">
    </div>
    <%} %>
    <small class="d-block mt-5 mb-2 text-center">
  		<a data-target="#modal<%=post.getId()%>" data-toggle="modal" class="mr-2"><i class="fas fa-comment-dots" style="color: #0969A2;"></i></a>
  		
  			<%
			CurtidaPostService curtiPostServ = new CurtidaPostService();
			CurtidaPost cPost = new CurtidaPost();
			cPost.setPost(post);
			cPost.setUsuario(user);
			%>	
  			<%if(curtiPostServ.consultaCurtida(cPost)){%>
  			<button type="button" value="<%=post.getId()%>" style="background: transparent; border:none; color: #0000ff;" class="fas fa-thumbs-up btnDesCurtir"></button>
				<%=post.getCurtidas()%>
			<%}
			else{%>
			<button type="button" value="<%=post.getId()%>" style="background: transparent; border:none; color: #0969A2;" class="fas fa-thumbs-up btnCurtir"></button>
				<%=post.getCurtidas()%>
			<%}%>
    </small>
   </div>
   


<!-- Modal -->
<div class="modal fade" id="modal<%=post.getId() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	 <div class="media text-muted pt-3">
      	<img class="mr-3 align-self-start mr-3"  src="<%=user.getFoto() %>" alt="" width="48" height="48">
      <p class="media-body pb-3 mb-0 small lh-125 ">
        <%=user.getNome() %><strong class="d-block mb-2 text-gray-dark">@<%=user.getNickname() %></strong>
      </p>
	
    </div>
    	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="container mb-5" style="min-height:200px;">
						<p class="h2 text-center  mt-5 mb-5">
							<%=post.getDescricao()%>
						</p>
						<%
							if (post.getImagem() != null) {
						%>
						<div class="container mt-5 text-center">
							<img src="<%=post.getImagem()%>" class="img-fluid">
						</div>
						<%
							}
						%>
	</div>
	<div class="container mt-5">  	
     <h5 class="mt-5">Comentários</h5>
      </div>
      <div class="container w-100">
          <div class="media text-muted pt-3">
      	<img class="align-self-start mr-3" src="img/logobird.svg" alt="" width="48" height="48">
								<form class="w-100" action="CadastraComentario.do" method="POST"
									enctype="multipart/form-data">
									<div class="row">
										<input type="text" name="idPost" style="display:none;"value="<%=post.getId()%>"/>
										<div class="col-12">

											<textarea id="txtPost" name="txtComentario" class="form-control"
												placeholder="Não meça suas palavras." rows="5" id="comment"
												style="border: none;"></textarea>

										</div>
										<div class="col-12 mt-2 text-right">
											<div class="element">
												<i class="fas fa-image iconFile2"
													style="color: #0969A2;" id="iconFileNovo<%=i %>" onclick="functionOpen(<%=i%>)"></i> <input type="file"
													name="imagem" id="inputIconNovo<%=i %>" class="inputIcon2">
											</div>
											<button id="btnEnviar" type="submit"
												style="background: transparent; border: none; color: #0969A2;"
												class="fas fa-paper-plane"></button>
										</div>
									</div>
								</form>
							</div>
							<% ComentarioService comService = new ComentarioService(); %>
							<h6>Outros comment's:</h6>
							<%if(comService.listaComentariosPost(post.getId()) != null){%>
							<% ArrayList<Comentario> listaComentario = comService.listaComentariosPost(post.getId());%>
							<%for(Comentario com : listaComentario){ %>
							<div class="container border-top border-gray">
								<div class="media text-muted pt-3">
									<img class="mr-3" src="img/logobird.svg" alt="" width="48" height="48">
									<p class="media-body pb-3 mb-0 small lh-125 "><%=com.getUsuario().getNome()%>
										<strong class="d-block mb-2 text-gray-dark">@<%=com.getUsuario().getNickname()%></strong>
										<%=com.getTexto()%>
									</p>
								</div>
								<% if (com.getImagem() != null) { %>
								<div class="container text-center">
									<img style="max-width: 200px !important" src="<%=com.getImagem()%> " class="img-fluid">
								</div>
								<% } %>
								<small class="d-block mt-4 mb-2 text-center">
								
									<%
									CurtidaComentarioService curtiComServ = new CurtidaComentarioService();
									CurtidaComentario cCom = new CurtidaComentario();
									cCom.setComentario(com);
									cPost.setUsuario(user);
									%>
									<input type="text" value=""/>
						  			<%if(curtiComServ.consultaCurtida(cCom)){%>
						  			<button type="button" value="<%=com.getId()%>" style="background: transparent; border:none; color: #0000ff;" class="fas fa-thumbs-up btnDesCurtir"></button>
										<%=com.getCurtidasComent()%>
									<%}
									else{%>
									<button type="button" value="<%=post.getId()%>" style="background: transparent; border:none; color: #0969A2;" class="fas fa-thumbs-up btnCurtir"></button>
										<%=com.getCurtidasComent()%>
									<%}%>
								
									<button type="button" value="<%=com.getId()%>" style="background: transparent; border:none; color: #0969A2;" 
									class="fas fa-thumbs-up btnCurtirComent"></button><%=com.getCurtidasComent()%>
								</small>
							</div>
							<%}%>
							<%}%>
					</div>
      <div class="modal-footer">

      </div>
    </div>
  </div>
</div>
   </div>
    <%
     	}
  %>
	
</div>



 

</main>

<script type="text/javascript"  src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script> 
<script src="js/offcanvas.js"></script>
<script>
function functionOpen(i)
{
	var ts = 	'#inputIconNovo';
	var string = ts + i;
	var icon = '#iconFileNovo' + i;
	$(string).click();
	
	$(icon).removeClass("fa-image");
	$(icon).addClass("fa-check-circle");
	$(icon).css("color", "green");
	}
</script>
<script>
$(document).ready(function () {
	$('#btnRefresh').on('click', function(){
		window.location.reload();
	});
});

</script>
<script>
$(document).ready(function () {
    $('.modal').on('show.bs.modal', function () {
       
            // no-scroll
            $('body').addClass("modal-open-noscroll");
     
    });
    $('.modal').on('hide.bs.modal', function () {
        $('body').removeClass("modal-open-noscroll");
    });
})
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
	<!-- Ajax Curtir Comentario -->
	<script>
		$(document).ready(function() {
			$('.btnCurtirComent').click(function() {
				var val = $(this).val();
				alert(val);
				$.ajax({
					type : "GET",
					url : "Curtida.do",
					data : {
						idComentario : val,
						action : 'curtirComentario'
					},
					success : function(data) {
						alert(data);
					}
				});
			});
		});
	</script>
	<!-- Ajax Curtir Comentario-->
<script>
$("#formPost").on("submit", function (e) {
    e.preventDefault();
    var formData = new FormData(this);
    $.ajax({
        url: "Post.do",
        method: "POST",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        enctype: 'multipart/form-data',
        success: function (data) {
            // Aqui você receberia do json um status talvez, que diz se foi feito o upload com sucesso ou não. No nosso caso vamos simular que sim.
         if (data == "cadastro-true")
       	{
        	 $('#alertCadastro').css("display","block");
       	}
        }
    });
})
</script>
	<!-- Ajax Curtir -->
	<script>
		$(document).ready(function() {
			$('.btnCurtir').click(function() {
				var val = $(this).val();
				alert(val);
				$.ajax({
					type : "GET",
					url : "Curtida.do",
					data : {
						idPost : val,
						action : 'curtirPost'
					},
					success : function(data) {
						alert(data);
					}
				});
			});
		});
	</script>

<!-- Ajax DesCurtirCom -->
	<script>
		$(document).ready(function() {
			$('.btnDesCurtir').click(function() {
				var val = $(this).val();
				alert(val);
				$.ajax({
					type : "GET",
					url : "Curtida.do",
					data : {
						idComentario : val,
						action : 'descurtirComentario'
					},
					success : function(data) {
						alert(data);
					}
				});
			});
		});
	</script>

</body></html>