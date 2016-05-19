package br.com.fiap.rm48236.jpa;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.rm48236.jpa.entity.Cinema;
import br.com.fiap.rm48236.jpa.entity.Filme;
import br.com.fiap.rm48236.jpa.entity.Local;
import br.com.fiap.rm48236.jpa.service.CinemaDAO;
import br.com.fiap.rm48236.jpa.service.jpa.GenericDAO;

public class Application {

	// Nao gerei os demais DAO's especificos por conta das implementacoes
	private static CinemaDAO cinemaDAO = new CinemaDAO();
	private static GenericDAO<Local> localDAO = new GenericDAO<>(Local.class);
	private static GenericDAO<Filme> filmeDAO = new GenericDAO<>(Filme.class);
	
	public static void main(String[] args) {

		adicionaCinema();
		adicionaLocal();
		adicionaFilme();
	}


	private static void adicionaFilme() {
		List<Local> locais = localDAO.listar();
		Local local = (Local) JOptionPane.showInputDialog(null, "Inserir Filme Em", "Selecionar Local", 1, null, locais.toArray(), null);
		
		String nome = JOptionPane.showInputDialog("Qual o nome do Filme?");
		String duracao = JOptionPane.showInputDialog("Qual a duração do Filme?");
		String stringNumeroSala = JOptionPane.showInputDialog("Qual o número da Sala de exibição?");
		
		Filme filme = new Filme(null, local, nome, Double.parseDouble(duracao), Integer.parseInt(stringNumeroSala));
		filmeDAO.adicionar(filme);
		
	}


	private static void adicionaCinema() {
		String nomeCinema = JOptionPane.showInputDialog("Entre com o Nome do Cinema");
		String contatoCinema = JOptionPane.showInputDialog("Entre com o Contato do Cinema");

		Cinema cinema = new Cinema(null, nomeCinema, contatoCinema);
		cinemaDAO.adicionar(cinema);
	}	
	
	private static void adicionaLocal() {
		List<Cinema> cinemas = cinemaDAO.listar();
		Cinema cinema = (Cinema) JOptionPane.showInputDialog(null, "Inserir Local Em", "Selecionar Cinema", 0, null, cinemas.toArray(), null);
		String nomeLocal = JOptionPane.showInputDialog("Entre com o Nome do Local");
		String stringQtdeSalas = JOptionPane.showInputDialog("Quantidade de Salas");
		
		Local local = new Local(null, cinema, nomeLocal, Integer.parseInt(stringQtdeSalas));
		localDAO.adicionar(local);		
	}
	
	
	
}
