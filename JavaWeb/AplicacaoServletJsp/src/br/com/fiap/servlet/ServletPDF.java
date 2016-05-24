package br.com.fiap.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPDF
 */
@WebServlet("/verSinopse")
public class ServletPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPDF() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream stream = null;
		BufferedInputStream buffer = null;
		String arquivo = request.getParameter("cod");
		try {
			stream = response.getOutputStream();
			File pdf = new File("D:/rm48236/" + arquivo + ".pdf");
			if (!pdf.exists()) {
				pdf = new File("D:/rm48236/geral.pdf");
			}
			response.setContentType("application/pdf");
			FileInputStream input = new FileInputStream(pdf);
			buffer = new BufferedInputStream(input);
			int bytes = 0;
			while ((bytes = buffer.read()) != -1) {
				stream.write(bytes);
			}
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		} finally {
			if (stream != null) {
				stream.close();
			}
			if (buffer != null) {
				buffer.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
