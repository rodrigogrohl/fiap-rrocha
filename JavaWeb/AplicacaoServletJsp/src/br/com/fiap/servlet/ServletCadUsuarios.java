package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletCadUsuarios
 */
@WebServlet("/admin/cadusuarios")
public class ServletCadUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadUsuarios() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String user = request.getParameter("usuario");
			String pass = request.getParameter("senha");
			Integer nivel = Integer.parseInt( request.getParameter("nivel") );
			
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario(user, pass, nivel);
			dao.adicionar(usuario);
			request.setAttribute("msgCadastros", String.format("Usuário ID %d cadastrado com sucesso!", usuario.getId()));
		} catch (Exception e) {
			request.setAttribute("msgCadastros", "Erro: " + e.getLocalizedMessage());
		} finally {
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
		
	}

}
