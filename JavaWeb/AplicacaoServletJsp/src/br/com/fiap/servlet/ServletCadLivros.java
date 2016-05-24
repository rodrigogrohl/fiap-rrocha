package br.com.fiap.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

/**
 * Servlet implementation class ServletCadLivros
 */
@WebServlet("/admin/cadlivros")
@MultipartConfig
public class ServletCadLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadLivros() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		InputStream inputStream = null;
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String data = request.getParameter("datapub");
			Date datapub = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			double preco = Double.parseDouble(request.getParameter("preco"));
			Part filePart = request.getPart("foto");
			byte[] imagem = new byte[(int) filePart.getSize()];
			if (filePart != null) {
				inputStream = filePart.getInputStream();
				inputStream.read(imagem, 0, (int) filePart.getSize());
			}
			Livro livro = new Livro();
			livro.setCodigo(codigo);
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setDataPublicacao(datapub);
			livro.setPreco(preco);
			livro.setImagem(imagem);
			GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
			dao.adicionar(livro);

			//request.getRequestDispatcher("")
		} catch (Exception e) {
			System.out.println(e);
			out.write(e.getMessage());
		}
	}

}
