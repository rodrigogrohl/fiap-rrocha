package br.com.fiap.servlets;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.service.FuncionarioServiceRemote;

/**
 * Servlet implementation class FuncionarioServlet
 */
@WebServlet("/funcionario")
public class FuncionarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String LOOKUP_ADDRESS = "ejb:/Exercicio02_Funcionarios/FuncionarioService!br.com.fiap.service.FuncionarioServiceRemote";
	private FuncionarioServiceRemote service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext context = new InitialContext();
			service = (FuncionarioServiceRemote) context.lookup(LOOKUP_ADDRESS);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Funcionario> list = service.listAll();
		System.out.println("> Total " + list.size() + " Workers.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		
		
		System.out.println("Adding: " + cpf);
		
		doGet(request, response);
	}

}
