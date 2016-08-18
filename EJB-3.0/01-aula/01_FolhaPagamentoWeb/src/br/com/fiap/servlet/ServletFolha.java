package br.com.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.interfaces.FolhaPagamento;

/**
 * Servlet implementation class ServletFolha
 */
@WebServlet("/folha")
public class ServletFolha extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	FolhaPagamento fp;

	public ServletFolha() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			double salario = Double.parseDouble(request.getParameter("salario"));
			fp.setSalario(salario);
			fp.setDesconto(10);
			out.println("Sal�rio Bruto: " + salario);
			out.println("<br/>Sal�ro L�quido: " + fp.calcularSalarioLiquido());
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
