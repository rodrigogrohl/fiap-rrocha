package br.com.fiap.rm48236.jpa.exercicio3.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.swing.JOptionPane;

import br.com.fiap.rm48236.jpa.exercicio3.entity.Agenda;
import br.com.fiap.rm48236.jpa.exercicio3.entity.Material;
import br.com.fiap.rm48236.jpa.exercicio3.entity.Paciente;
import br.com.fiap.rm48236.jpa.exercicio3.entity.Procedimento;
import br.com.fiap.rm48236.jpa.exercicio3.service.jpa.GenericDAO;

public class Aplicacao {
	
	private static GenericDAO<Paciente> pacienteDAO = new GenericDAO<>(Paciente.class);
	private static GenericDAO<Agenda> agendaDAO = new GenericDAO<>(Agenda.class);
	private static GenericDAO<Material> materialDAO = new GenericDAO<>(Material.class);
	private static GenericDAO<Procedimento> procedimentoDAO = new GenericDAO<>(Procedimento.class);
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat shf = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) {
		
		try{
			//adicionaPaciente();
			//adicionaAgenda();
			//associaAgendaPaciente();
			//adicionaMaterial();
			//adicionaProcedimento();
			
			listaEstruturaOrderByCriteria();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getLocalizedMessage());
		}
				
	}

	private static void listaEstruturaOrderByCriteria() {
		EntityManager em = pacienteDAO.getEm();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> from = query.from(Paciente.class);
		
		Order order = cb.asc(from.get("nome"));
		query.orderBy(order);
		
		TypedQuery<Paciente> typedQuery = em.createQuery(query);
		List<Paciente> pacientes = typedQuery.getResultList();
		for (Paciente paciente : pacientes) {
			System.out.println("Relatorio Para: " + paciente);
			exibeRelatorio(paciente);
			System.out.println("Fim do Relatorio\n\n");
		}
		
	}

	private static void exibeRelatorio(Paciente paciente) {
		List<Agenda> agendas = paciente.getAgendas();
		System.out.println("\tAGENDAS:");
		for (Agenda agenda : agendas) {
			System.out.println("\t\t" + agenda);
		}
		List<Procedimento> procedimentos = paciente.getProcedimentos();
		System.out.println("\tPROCEDIMENTOS:");
		for (Procedimento procedimento : procedimentos) {
			System.out.println("\t\t" + procedimento);
		}
	}

	private static void adicionaProcedimento() {
		List<Paciente> pacientes = pacienteDAO.listar();
		Paciente paciente = (Paciente) JOptionPane.showInputDialog(null, "Ao Paciente", "Adicionar Procedimento", 0, null, pacientes.toArray(), null);

		String descricao = JOptionPane.showInputDialog("Descricao");
		String stringPreco = JOptionPane.showInputDialog("Preco 999.99");
		Procedimento procedimento = new Procedimento(null, descricao, Double.valueOf(stringPreco), paciente);
		
		procedimentoDAO.adicionar(procedimento);
		
		JOptionPane.showMessageDialog(null, "Procedimento Cadastrado com Sucesso!");
	}

	private static void adicionaMaterial() {
		List<Paciente> pacientes = pacienteDAO.listar();
		Paciente paciente = (Paciente) JOptionPane.showInputDialog(null, "Ao Paciente", "Adicinar Material", 0, null, pacientes.toArray(), null);

		
		String descricao = JOptionPane.showInputDialog("Descricao");
		String stringPreco = JOptionPane.showInputDialog("Preco 999.99");
		String fabricante = JOptionPane.showInputDialog("Fabricante");
		Material material = new Material(null, paciente, descricao, Double.valueOf(stringPreco), fabricante);
		
		materialDAO.adicionar(material);
		JOptionPane.showMessageDialog(null, "Material Cadastrado com Sucesso!");
	}

	private static void associaAgendaPaciente() {
		List<Paciente> pacientes = pacienteDAO.listar();
		Paciente paciente = (Paciente) JOptionPane.showInputDialog(null, "Paciente", "Selecionar", 0, null, pacientes.toArray(), null);
		
		List<Agenda> agendas = agendaDAO.listar();
		Agenda agenda = (Agenda) JOptionPane.showInputDialog(null, "Agenda", "Selecionar", 0, null, agendas.toArray(), null);
		
		agenda.getPacientes().add(paciente);
		agendaDAO.atualizar(agenda);
	}

	private static void adicionaAgenda() throws ParseException {
		String stringData = JOptionPane.showInputDialog("Data dd/MM/yyyy");
		String stringHora = JOptionPane.showInputDialog("Hora hh:mm:ss");
		String descricao = JOptionPane.showInputDialog("Descrição");
		
		Agenda agenda = new Agenda(null, sdf.parse(stringData), shf.parse(stringHora), descricao);
		
		
		agendaDAO.adicionar(agenda);
		JOptionPane.showMessageDialog(null, "Agenda Cadastrada com Sucesso!");
	}

	private static void adicionaPaciente() throws ParseException {
		
		String cpf = JOptionPane.showInputDialog("Entre com o CPF do Paciente");
		String nome = JOptionPane.showInputDialog("Entre com o Nome do Paciente");
		String stringDataNasc = JOptionPane.showInputDialog("Nascimento (dd/MM/yyyy)");
		String telefone = JOptionPane.showInputDialog("Telefone");

		Paciente paciente = new Paciente(cpf, null, null, nome, sdf.parse(stringDataNasc), telefone);
		
		pacienteDAO.adicionar(paciente);
		JOptionPane.showMessageDialog(null, "Paciente Cadastrado com Sucesso!");
	}

}
