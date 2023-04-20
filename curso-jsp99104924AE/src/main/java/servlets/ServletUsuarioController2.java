package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

import beandto.BeanDtoGraficoSalarioUser;
import dao.DAOUsuarioRepository;
import model.ModelLogin;
import util.ReportUtil;

@MultipartConfig
@WebServlet(urlPatterns = {"/ServletUsuarioController2"})
public class ServletUsuarioController2 extends ServleGenericUtil {
	
	private static final long serialVersionUID = 1L;
	
	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();
	
	public ServletUsuarioController2() {
        
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// para deletar e consultar
		
		try {
		
		String acao = request.getParameter("acao");
		 
		if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {
			
			String idUser = request.getParameter("id");
			
			daoUsuarioRepository.deleteUser(idUser);
			
			List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
			request.setAttribute("msg", "usuários carregados");
			request.setAttribute("modelLogins", modelLogins);
			
			
			request.setAttribute("msg", "Exclusão feito com sucesso");
			request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			
		} 
		else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarajax")) {
				
				String idUser = request.getParameter("id");
				
				daoUsuarioRepository.deleteUser(idUser);
				
				response.getWriter().write("Exclusão feita com sucesso");
				
		}
		
		else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserajax")) {
			
			String nomeBusca = request.getParameter("nomeBusca");
			List<ModelLogin> dadosJsonUser = daoUsuarioRepository.consultaUsuarioList(nomeBusca, super.getUserLogado(request)); 
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dadosJsonUser);
			
			response.addHeader("totalPagina", ""+ daoUsuarioRepository.consultaUsuarioListTotalPaginaPaginacao(nomeBusca, super.getUserLogado(request)));
			response.getWriter().write(json);
			
	}
		
		else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserAjaxPage")) {
			 
			 String nomeBusca = request.getParameter("nomeBusca");
			 String pagina = request.getParameter("pagina");
			 
			 List<ModelLogin> dadosJsonUser =  daoUsuarioRepository.consultaUsuarioListOffSet(nomeBusca, super.getUserLogado(request), Integer.parseInt(pagina));
			 
			 ObjectMapper mapper = new ObjectMapper();
			 
			 String json = mapper.writeValueAsString(dadosJsonUser);
			 
			 response.addHeader("totalPagina", ""+ daoUsuarioRepository.consultaUsuarioListTotalPaginaPaginacao(nomeBusca, super.getUserLogado(request)));
			 response.getWriter().write(json);
			 
		 	}	
		else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarEditar")) {
			String id = request.getParameter("id");
			
			
					
			ModelLogin modelLogin = daoUsuarioRepository.consultarUsuarioID(id, super.getUserLogado(request));
			
			List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
			
			request.setAttribute("msg", "usuários carregados");
			request.setAttribute("modelLogins", modelLogins);
			
			request.setAttribute("msg", "usuário em edição");
			request.setAttribute("modelLogin", modelLogin);
			request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			
			
			
		}
		else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarUser")) {
				
 			List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
 			
			request.setAttribute("msg", "usuários carregados");
			request.setAttribute("modelLogins", modelLogins);
			request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response); 
		}
		else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarTabUser")) {	
			
				List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
				
				request.setAttribute("msg", "usuários carregados");
				request.setAttribute("modelLogins", modelLogins);
				request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
				request.getRequestDispatcher("principal/tabelaUsuario.jsp").forward(request, response);
		}
			
			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("downloadFoto")) {
			 
			 String idUser = request.getParameter("id");
			 
			 ModelLogin modelLogin =  daoUsuarioRepository.consultarUsuarioID(idUser, super.getUserLogado(request));
			 if (modelLogin.getFotouser() != null && !modelLogin.getFotouser().isEmpty()) {
				 
				 response.setHeader("Content-Disposition", "attachment;filename=foto-user." + modelLogin.getExtensaofotouser());
				 response.getOutputStream().write(new Base64().decodeBase64(modelLogin.getFotouser().split("\\,")[1]));
				 
			 }
			 
		 }
		 else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("paginar")) {
			 
			 Integer offset = Integer.parseInt(request.getParameter("pagina"));
			 
			 List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioListPaginada(this.getUserLogado(request), offset);
			 
			 request.setAttribute("modelLogins", modelLogins);
		     request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
			 request.getRequestDispatcher("principal/tabelaUsuario.jsp").forward(request, response);
			 
		 }
		
		 else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("imprimirRelatorioUser")) {
			 
			 String dataInicial = request.getParameter("dataInicial");
			 String dataFinal = request.getParameter("dataFinal");
			 
			
			 if (dataInicial == null || dataInicial.isEmpty() 
					 && dataFinal == null || dataFinal.isEmpty()) {
				 
				 request.setAttribute("listaUser", daoUsuarioRepository.consultaUsuarioListRel(super.getUserLogado(request)));
				 
			 }else {
				
				 request.setAttribute("listaUser", daoUsuarioRepository
						 .consultaUsuarioListRel(super.getUserLogado(request), dataInicial, dataFinal));
				 
			 }
			 
			 
			 request.setAttribute("dataInicial", dataInicial);
			 request.setAttribute("dataFinal", dataFinal);
			 request.getRequestDispatcher("principal/reluser.jsp").forward(request, response);
			 
		 }
 		else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("imprimirRelatorioPDF")) {
	 //ou ele imprime com as datas
			 String dataInicial = request.getParameter("dataInicial");
			 String dataFinal = request.getParameter("dataFinal");
			 
			 List<ModelLogin> modelLogins = null;
			 
			 if (dataInicial == null || dataInicial.isEmpty() 
					 && dataFinal == null || dataFinal.isEmpty()) {
				 
				 modelLogins = daoUsuarioRepository.consultaUsuarioListRel(super.getUserLogado(request));
		 
	 }else {
		 //ou imprime sem as datas
		 		modelLogins = daoUsuarioRepository.consultaUsuarioListRel(super.getUserLogado(request), dataInicial, dataFinal);
	 }
	 // mas mesmo assim gera o relatório
	 
		 HashMap<String, Object> params = new HashMap<String, Object>();
		 params.put("PARAM_SUB_REPORT", request.getServletContext().getRealPath("relatorio") + File.separator);
		 
		byte[] relatorio = new ReportUtil().geraReltorioPDF(modelLogins, "rel-usuarioA-jsp",params ,request.getServletContext());
		 
		 
		 response.setHeader("Content-Disposition", "attachment;filename=relatório.pdf");
		 response.getOutputStream().write(relatorio);
		 
 } else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("graficoSalario")) {
	 String dataInicial = request.getParameter("dataInicial");
	 String dataFinal = request.getParameter("dataFinal");
	 
	 
	 if (dataInicial == null || dataInicial.isEmpty() 
			 && dataFinal == null || dataFinal.isEmpty()) {
		 
		 
		 BeanDtoGraficoSalarioUser beanDtoGraficoSalarioUser =   daoUsuarioRepository.
				 montarGraficoMediaSalario(super.getUserLogado(request));
		 
		   ObjectMapper mapper = new ObjectMapper();
		 
		   String json = mapper.writeValueAsString(beanDtoGraficoSalarioUser);
		 
		   response.getWriter().write(json);
		 
		 
	 }else {
		 
		 BeanDtoGraficoSalarioUser beanDtoGraficoSalarioUser =   daoUsuarioRepository.
				 montarGraficoMediaSalario(super.getUserLogado(request), dataInicial, dataFinal);
		 
		   ObjectMapper mapper = new ObjectMapper();
		 
		   String json = mapper.writeValueAsString(beanDtoGraficoSalarioUser);
		 
		   response.getWriter().write(json);
		 

	 }
 }
		 else {	
			
			List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
			
			request.setAttribute("msg", "usuários carregados");
			request.setAttribute("modelLogins", modelLogins);
			request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pra atualizar e gravar
		try {
			
			String msg = "Operação realizada com sucesso";
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String perfil = request.getParameter("perfil");
		String sexo = request.getParameter("sexo");
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		String localidade = request.getParameter("localidade");
		String uf = request.getParameter("uf");
		String numero = request.getParameter("numero");
		String dataNascimento = request.getParameter("dataNascimento");
		String rendamensal = request.getParameter("rendamensal");
		
		//necessário quebra com espaço para vir somente a numeração
	
		
		
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
		modelLogin.setNome(nome);
		modelLogin.setEmail(email);
		modelLogin.setLogin(login);
		modelLogin.setSenha(senha);
		modelLogin.setCep(cep);
		modelLogin.setLogradouro(logradouro);
		modelLogin.setBairro(bairro);
		modelLogin.setLocalidade(localidade);
		modelLogin.setUf(uf);
		modelLogin.setNumero(numero);
		modelLogin.setDataNascimento(Date.valueOf(new SimpleDateFormat("yyyy-mm-dd").format(new SimpleDateFormat("dd/mm/yyyy").parse(dataNascimento))));
	
		
		if(request.getPart("filefoto") != null) {
			Part part = request.getPart("filefoto"); // pega a foto da tela
			
			if(part.getSize() > 0) {
				byte[] foto = IOUtils.toByteArray(part.getInputStream());  // convert img para byte
				String imagembase64 = "data:image/"+part.getContentType().split("\\/")[1] +";base64,"+ new Base64().encodeBase64String(foto);
				
				modelLogin.setFotouser(imagembase64);
				modelLogin.setExtensaofotouser(part.getContentType().split("\\/")[1]);	
			}
			
		}
		
			
		if(daoUsuarioRepository.validarLogin(modelLogin.getLogin()) && modelLogin.getId() == null) {
			msg = "Já existe um login cadastrado, informe outro login e também recarregue a foto do usuário;";
			
		} else {
			if(modelLogin.isNovo()) {
				msg = "Gravado com sucesso";
			} else {
				msg = "Atualizado com sucesso";
			}
			modelLogin = daoUsuarioRepository.gravarUsuario(modelLogin, super.getUserLogado(request));
		}
		
		
		
		
		
		List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
		request.setAttribute("msg", "usuários carregados");
		request.setAttribute("modelLogins", modelLogins);
		
		request.setAttribute("msg", msg);
		request.setAttribute("modelLogin", modelLogin);
		request.setAttribute("totalPagina", daoUsuarioRepository.totalPagina(this.getUserLogado(request)));
		request.getRequestDispatcher("principal/contausuario.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
		
	}

}
