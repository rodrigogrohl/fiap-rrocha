package br.com.fiap.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.dao.jdbc.JdbcCursosDAO;
import br.com.fiap.dao.jdbc.JdbcEscolasDAO;
import br.com.fiap.entidades.Curso;

@Controller
public class CursosController {
	@RequestMapping("/curso/cadastro")
	public String incluir(ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcEscolasDAO dao_e = (JdbcEscolasDAO) ctx.getBean("jdbcEscolasDAO");
		try {
			model.addAttribute("escolas", dao_e.listarEscolas());
			return "cadastros/incluirCurso";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}

	@RequestMapping(value = "/cadcurso", method = RequestMethod.POST)
	public String incluir(@RequestParam("idc") int idc, Curso curso, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			JdbcEscolasDAO dao_e = (JdbcEscolasDAO) ctx.getBean("jdbcEscolasDAO");
			curso.setEscola(dao_e.buscarEscola(idc));
			JdbcCursosDAO dao = (JdbcCursosDAO) ctx.getBean("jdbcCursosDAO");
			dao.incluirCurso(curso);
			model.addAttribute("msg", "Escola " + curso.getDescricao() + "incluída");
			return "cadastros/incluirCurso";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
}