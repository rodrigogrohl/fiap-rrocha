package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.interfaces.Funcionarios;

/**
 * Servlet implementation class FuncionariosServlet
 */
@WebServlet("/funcionarios")
public class FuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	Funcionarios funcionarios;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionariosServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setAttribute("lista", funcionarios.listar());
		// response.sendRedirect("funcionarios.jsp");
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("<br>");
		List<String> lista = funcionarios.listar();
		for (String nome : lista) {
			response.getWriter().append(nome + "<br>");
		}
		response.getWriter().append("<a href='funcionario.jsp'>Novo</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		funcionarios.adicionar(nome);
		doGet(request, response);
	}

}
