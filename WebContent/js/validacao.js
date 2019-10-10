$(document).ready(function(){
				$('#inputNickname').on('input', function(){
					var val = $('#inputNickname').val();
					if(val.length > 0){
						$.ajax({
							type: "GET",
							url: "Valida.do",
							data: {
								nick : val,
								action : 'validaNick'
							},
							success: function(data){
								if (data == "nicktrue")
								{
									$('#inputNickname').removeClass('is-invalid');
									$('#inputNickname').addClass('is-valid');
									$('#divvalidanick').removeClass('invalid-feedback');
									$('#divvalidanick').addClass('valid-feedback');
									$('#divvalidanick').html("");
									$('#divvalidanick').html("Parece bom");
								}
								else
								{
									$('#inputNickname').removeClass('is-valid');
									$('#inputNickname').addClass('is-invalid');
									$('#divvalidanick').removeClass('valid-feedback');
									$('#divvalidanick').addClass('invalid-feedback');
									$('#divvalidanick').html("");
									$('#divvalidanick').html("Nickname ja existe");
								}
							}
						});
					}
					else{
						$('#inputNickname').removeClass('is-valid');
						$('#inputNickname').addClass('is-invalid');
						$('#divvalidanick').removeClass('valid-feedback');
						$('#divvalidanick').addClass('invalid-feedback');
						$('#divvalidanick').html("");
						$('#divvalidanick').html("Digite o nickname");
					}
		
				});
				
			$('#inputEmail').on('input', function(){
				var val = $('#inputEmail').val();
				if(val.length > 0){
					$.ajax({
						type: "GET",
						url: "Valida.do",
						data: {
							email : val,
							action : 'validaEmail'
						},
						success: function(data){
							if (data == "emailtrue")
							{
								$('#inputEmail').removeClass('is-invalid');
								$('#inputEmail').addClass('is-valid');
								$('#divvalidaemail').removeClass('invalid-feedback');
								$('#divvalidaemail').addClass('valid-feedback');
								$('#divvalidaemaildivvalidaemail').html("");
								$('#divvalidaemail').html("Parece bom");
							}
							else
							{
								$('#inputEmail').removeClass('is-valid');
								$('#inputEmail').addClass('is-invalid');
								$('#divvalidaemail').removeClass('valid-feedback');
								$('#divvalidaemaildivvalidaemaildivvalidaemail').addClass('invalid-feedback');
								$('#divvalidaemail').html("");
								$('#divvalidaemail').html("Email ja existe");
							}
						}
					});
				}
				else{
					$('#inputEmail').removeClass('is-valid');
					$('#inputEmail').addClass('is-invalid');
					$('#divvalidaemail').removeClass('valid-feedback');
					$('#divvalidaemail').addClass('invalid-feedback');
					$('#divvalidaemail').html("");
					$('#divvalidaemail').html("Digite o email");
				}

			});
		});
          $(document).ready(function(){
                $('#inputPassword').on('input', function(){
                   var val = $('#inputPassword').val();
                    if (val.length > 0)
                    {
                        $('#inputConfirmarSenha').prop('disabled', false);
                        $('#inputConfirmarSenha').addClass('is-invalid');
                    }
                    else
                    {
                        $('#inputConfirmarSenha').prop('disabled', true);
                       
                    }
                });
              });
          $(document).ready(function(){
              $('#inputConfirmarSenha').on('input', function(){
                 var val = $('#inputPassword').val();
                 var val2 = $('#inputConfirmarSenha').val();
                 
                 if (val2.length > 0 ){
                	 
                  if (val == val2)
                  {
                	  $('#inputConfirmarSenha').removeClass('is-invalid');
                      $('#inputConfirmarSenha').addClass('is-valid');
                      $('#divvalidaconfirmasenha').removeClass('invalid-feedback');
                      $('#divvalidaconfirmasenha').addClass('valid-feedback');
  					  $('#divvalidaconfirmasenha').html("");
					  $('#divvalidaconfirmasenha').html("Senhas iguais");
                  }
                  else
                  {
                	  $('#inputConfirmarSenha').removeClass('is-valid');
                      $('#inputConfirmarSenha').addClass('is-invalid');
                      $('#divvalidaconfirmasenha').removeClass('valid-feedback');
                      $('#divvalidaconfirmasenha').addClass('invalid-feedback');
  					  $('#divvalidaconfirmasenha').html("");
					  $('#divvalidaconfirmasenha').html("Senhas diferentes");
                     
                  }
                 }
                 else
                {
        				$('#inputConfirmarSenha').removeClass('is-valid');
      					$('#inputConfirmarSenha').addClass('is-invalid');
      					$('#divvalidaconfirmasenha').removeClass('valid-feedback');
      					$('#divvalidaconfirmasenha').addClass('invalid-feedback');
      					$('#divvalidaconfirmasenha').html("");
      					$('#divvalidaconfirmasenha').html("Digite a senha");
                }
              });
            });
          
          $(document).ready(function(){
				$('#inputNickname').on('input', function(){
					var val = $('#inputNickname').val();
					if(val.length > 0){
						$.ajax({
							type: "GET",
							url: "Valida.do",
							data: {
								nick : val,
								action : 'validaNick'
							},
							success: function(data){
								if (data == "nicktrue")
								{
									$('#inputNickname').removeClass('is-invalid');
									$('#inputNickname').addClass('is-valid');
									$('#divvalidanick').removeClass('invalid-feedback');
									$('#divvalidanick').addClass('valid-feedback');
									$('#divvalidanick').html("");
									$('#divvalidanick').html("Parece bom");
								}
								else
								{
									$('#inputNickname').removeClass('is-valid');
									$('#inputNickname').addClass('is-invalid');
									$('#divvalidanick').removeClass('valid-feedback');
									$('#divvalidanick').addClass('invalid-feedback');
									$('#divvalidanick').html("");
									$('#divvalidanick').html("Nickname já existe");
								}
							}
						});
					}
					else{
						$('#inputNickname').removeClass('is-valid');
						$('#inputNickname').addClass('is-invalid');
						$('#divvalidanick').removeClass('valid-feedback');
						$('#divvalidanick').addClass('invalid-feedback');
						$('#divvalidanick').html("");
						$('#divvalidanick').html("Digite o nickname");
					}
		
				});
				
			$('#inputEmail').on('input', function(){
				var val = $('#inputEmail').val();
				if(val.length > 0){
					$.ajax({
						type: "GET",
						url: "Valida.do",
						data: {
							email : val,
							action : 'validaEmail'
						},
						success: function(data){
							if (data == "emailtrue")
							{
								$('#inputEmail').removeClass('is-invalid');
								$('#inputEmail').addClass('is-valid');
								$('#divvalidaemail').removeClass('invalid-feedback');
								$('#divvalidaemail').addClass('valid-feedback');
								$('#divvalidaemaildivvalidaemail').html("");
								$('#divvalidaemail').html("Parece bom");
							}
							else
							{
								$('#inputEmail').removeClass('is-valid');
								$('#inputEmail').addClass('is-invalid');
								$('#divvalidaemail').removeClass('valid-feedback');
								$('#divvalidaemail').addClass('invalid-feedback');
								$('#divvalidaemail').html("");
								$('#divvalidaemail').html("Email já existe");
							}
						}
					});
				}
				else{
					$('#inputEmail').removeClass('is-valid');
					$('#inputEmail').addClass('is-invalid');
					$('#divvalidaemail').removeClass('valid-feedback');
					$('#divvalidaemail').addClass('invalid-feedback');
					$('#divvalidaemail').html("");
					$('#divvalidaemail').html("Digite o email");
				}

			});
		});
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
          $(document).ready(function(){
        	 $('#inputNome').on('input', function(){
        		 var val = $('#inputNome').val();
        		 if (val.length > 0)
        		 {
						$('#inputNome').removeClass('is-invalid');
						$('#inputNome').addClass('is-valid');
						$('#divvalidanome').removeClass('invalid-feedback');
						$('#divvalidanome').addClass('valid-feedback');
						$('#divvalidanome').html("");
						$('#divvalidanome').html("Parece bom");
        		 }
        		 else 
        		 {
     				$('#inputNome').removeClass('is-valid');
					$('#inputNome').addClass('is-invalid');
					$('#divvalidanome').removeClass('valid-feedback');
					$('#divvalidanome').addClass('invalid-feedback');
					$('#divvalidanome').html("");
					$('#divvalidanome').html("Digite o nome");
        		 }
        	 }) ;
          });
          $(document).ready(function(){
         	 $('#inputDate').on('input', function(){
         		 var val = $('#inputDate').val();
         		 if (val.length > 0)
         		 {
 						$('#inputDate').removeClass('is-invalid');
 						$('#inputDate').addClass('is-valid');
 						$('#divvalidadata').removeClass('invalid-feedback');
 						$('#divvalidadata').addClass('valid-feedback');
 						$('#divvalidadata').html("");
 						$('#divvalidadata').html("Parece bom");
         		 }
         		 else 
         		 {
      				$('#inputDate').removeClass('is-valid');
 					$('#inputDate').addClass('is-invalid');
 					$('#divvalidadata').removeClass('valid-feedback');
 					$('#divvalidadata').addClass('invalid-feedback');
 					$('#divvalidadata').html("");
 					$('#divvalidadata').html("Digite a data");
         		 }
         	 }) ;
           });
          $(document).ready(function(){
          	 $('#inputPassword').on('input', function(){
          		 var val = $('#inputPassword').val();
          		 if (val.length > 0)
          		 {
  						$('#inputPassword').removeClass('is-invalid');
  						$('#inputPassword').addClass('is-valid');
  						$('#divvalidasenha').removeClass('invalid-feedback');
  						$('#divvalidasenha').addClass('valid-feedback');
  						$('#divvalidasenha').html("");
  						$('#divvalidasenha').html("Parece bom");
          		 }
          		 else 
          		 {
       				$('#inputPassword').removeClass('is-valid');
  					$('#inputPassword').addClass('is-invalid');
  					$('#divvalidsenha').removeClass('valid-feedback');
  					$('#divvalidasenha').addClass('invalid-feedback');
  					$('#divvalidasenha').html("");
  					$('#divvalidasenha').html("Digite a senha");
          		 }
          	 }) ;
            });
