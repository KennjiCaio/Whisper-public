package br.usjt.web.whisper.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.usjt.web.whisper.model.Comentario;
import br.usjt.web.whisper.model.Post;
import br.usjt.web.whisper.model.SubComentario;
import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.service.ComentarioService;
import br.usjt.web.whisper.service.SubComentarioService;

@WebServlet("/CadastraComentario.do")
public class CadastraComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//VER SE O FROM É MULTIPART
		//CRIAR A PASTA NO SERVER
		try {
			Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogado");
			int idComentario = 0;
			
			ComentarioService comService = new ComentarioService();
			Comentario comentario = new Comentario();
			Post post = new Post();
			comentario.setUsuario(user);
			
            /*Faz o parse do request*/
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
 
            /*Escreve a o arquivo na pasta img*/
            for (FileItem item : multiparts) {
            	if(item.isFormField()) {
            		String parametro;
            		/*Inserindo dados do parametro no objeto*/
            		if(item.getFieldName().equals("txtComentario")) {
            			parametro = item.getString();
            			comentario.setTexto(parametro);
            			System.out.println("txtR:" + parametro);
            		}
            		if(item.getFieldName().equals("idPost")) {
            			parametro = item.getString();
            			post.setId(Integer.parseInt(parametro));
            			comentario.setPost(post);
            			System.out.println("txtR:" + parametro);
            		}
            		if(item.getFieldName().equals("idComentario")) {
            			parametro = item.getString();
            			idComentario = Integer.parseInt(parametro);
            			System.out.println("txtR:" + parametro);
            		}
            	}
            	/*Inserindo a imagem no diretório*/
                if (!item.isFormField()) {
                	String imagem = item.getName();
                	if(imagem.equals("")) {
                		comentario.setImagem(null);
                		System.out.println("Entrou");
                	}
                	else {
                		System.out.println("Entrou else");
                		System.out.println(request.getServletContext().getRealPath("arquivos")+ File.separator + imagem);
                		comentario.setImagem("arquivos" + File.separator + imagem);
                		item.write(new File(request.getServletContext().getRealPath("arquivos")+ File.separator + imagem));
                	}
                	System.out.println("Name:" + imagem);
                }
            }
            
            int idGerado = comService.cadastrar(comentario);
            System.out.println("Comentario cad: " + idGerado);
            
            if(idComentario != 0) {
            	SubComentarioService subComService = new SubComentarioService();
            	SubComentario subCom = new SubComentario();
            	Comentario comCad = comService.consultar(idGerado);
            	subCom.setComentario(comCad);
            	subCom.setIdComPrincipal(idComentario);
            	subComService.cadastrar(subCom);
            }
            
    		response.getWriter().print("Envio realizado com sucesso");
			response.addHeader("REFRESH", "2;URL=perfil.jsp");
			
        } catch (Exception ex) {
        	ex.printStackTrace();
        	response.getWriter().print("Erro ao enviar a atividade");
			response.addHeader("REFRESH", "3;URL=index.jsp");
        }
		
	}

}
