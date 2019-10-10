package br.usjt.web.whisper.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.model.Post;
import br.usjt.web.whisper.service.PostService;
@WebServlet("/Post.do")
public class CadastraPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogado");
			
			PostService postService = new PostService();
			Post post = new Post();
			post.setUsuario(user);
			
            /*Faz o parse do request*/
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
 
            /*Escreve a o arquivo na pasta img*/
            for (FileItem item : multiparts) {
            	if(item.isFormField()) {
            		String parametro;
            		/*Inserindo dados do parametro no objeto*/
            		if(item.getFieldName().equals("txtPost")) {
            			parametro = item.getString("UTF-8");
            		
            			post.setDescricao(parametro);
            			System.out.println("txtR:" + parametro);
            		}
            	}
            	/*Inserindo a imagem no diretório*/
                if (!item.isFormField()) {
                	
                	String imagem = item.getName();
                	if (imagem.equals(""))
                	{
                		post.setImagem(null);
                		System.out.println("Entrou");
                	}
                	else
                	{
                		System.out.println("Entrou else");
                		System.out.println(request.getServletContext().getRealPath("arquivos")+ File.separator + imagem);	
                		post.setImagem("arquivos"+ File.separator + imagem);
                		item.write(new File(request.getServletContext().getRealPath("arquivos")+ File.separator + imagem));
                	}
                	System.out.println("Name:" + imagem);
                	
                    
                }
            }
            postService.cadastrar(post);
            
    		PrintWriter print = response.getWriter();
    		print.print("cadastro-true");
	
			
        } catch (Exception ex) {
        	ex.printStackTrace();
        	response.getWriter().print("Erro ao enviar a atividade");
			
        }
	}
}

