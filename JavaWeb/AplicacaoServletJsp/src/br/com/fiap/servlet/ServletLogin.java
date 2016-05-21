package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		String user = getServletConfig().getInitParameter("user");
		String pwd = getServletConfig().getInitParameter("pwd");
		
		if(nome.equals(user) && senha.equals(pwd)) {
			response.sendRedirect("admin/menu.jsp");
		} else {
			// response.sendRedirect("login.jsp");
			request.setAttribute("msgValidacao", "Usuário ou senha Inválidos.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
