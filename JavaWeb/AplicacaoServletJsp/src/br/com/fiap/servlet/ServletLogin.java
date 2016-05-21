package br.com.fiap.servlet;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(
		name = "Servlet Login", 
		urlPatterns = { "/valida" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "admin"), 
				@WebInitParam(name = "pwd", value = "admin")
		})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		//String user = getServletConfig().getInitParameter("user");
		//String pwd = getServletConfig().getInitParameter("pwd");
		UsuarioDAO dao = new UsuarioDAO();
		try {
			Usuario usuario = dao.login(nome, senha);
			request.setAttribute("loggedUser", usuario);
			request.getRequestDispatcher("admin/menu.jsp").forward(request, response);
		} catch (NoResultException nre) {
			request.setAttribute("msgValidacao", "Usuário ou senha Inválidos.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
