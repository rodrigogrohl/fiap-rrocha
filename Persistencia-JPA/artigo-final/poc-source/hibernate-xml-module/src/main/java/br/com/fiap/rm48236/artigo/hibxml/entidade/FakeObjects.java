package br.com.fiap.rm48236.artigo.hibxml.entidade;

import java.util.ArrayList;
import java.util.List;

public class FakeObjects {
	
	public static List<Classe> getFullClasses(int quantidadeClasses, int quantidadeAlunos) {
		List<Classe> classes = new ArrayList<Classe>();
		for (int i = 0; i <= quantidadeClasses; i++) {
			Classe classe = new Classe(); 
			classe.setSigla("SCJ" + i);
			classe.setCoordenador("Coord Nome " + i);
			putAlunosIn(classe, quantidadeAlunos);
			classes.add(classe);
		}
		return classes;
	}

	
	private static void putAlunosIn(Classe classe, int quantidadeAlunos) {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		for (int i = 0; i <= quantidadeAlunos; i++) {
			Aluno aluno = new Aluno();
			aluno.setClasse(classe);
			aluno.setNome("Nome Sobrenome " + i);
			aluno.setEmail("email@poc.com.br");
			alunos.add(aluno);
		}
		classe.setAlunos(alunos);
	}

}
