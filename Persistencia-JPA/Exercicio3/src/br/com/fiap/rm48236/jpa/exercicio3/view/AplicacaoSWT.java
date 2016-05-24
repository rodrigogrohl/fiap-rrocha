package br.com.fiap.rm48236.jpa.exercicio3.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.fiap.rm48236.jpa.exercicio3.entity.Paciente;
import br.com.fiap.rm48236.jpa.exercicio3.service.jpa.GenericDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AplicacaoSWT {

	private JFrame frame;
	private JTextField txtTxtnasc;
	private JTextField txtNome;
	private JPanel panelPaciente;
	private JTextField txtTelefone;
	private JTextField txtCPF;
	
	private JList showlistPacientes;
	private List<Paciente> listPacientes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoSWT window = new AplicacaoSWT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacaoSWT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		panelPaciente = new JPanel();
		tabbedPane.addTab("Paciente", null, panelPaciente, null);
		panelPaciente.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 11, 46, 14);
		panelPaciente.add(lblCPF);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 36, 46, 14);
		panelPaciente.add(lblNome);
		
		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(10, 61, 67, 14);
		panelPaciente.add(lblNascimento);
		
		txtTxtnasc = new JTextField();
		txtTxtnasc.setText("dd/MM/yyyy");
		txtTxtnasc.setBounds(70, 58, 124, 20);
		panelPaciente.add(txtTxtnasc);
		txtTxtnasc.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(70, 33, 349, 20);
		panelPaciente.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAdicionarPaciente = new JButton("Adicionar");
		btnAdicionarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenericDAO<Paciente> dao = new GenericDAO<>(Paciente.class);
				
				Paciente paciente = new Paciente();
				paciente.setCPF(txtCPF.getText());
				paciente.setNome(txtNome.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					paciente.setNasc(sdf.parse(txtTxtnasc.getText()));
					paciente.setTelefone(txtTelefone.getText());
					dao.adicionar(paciente);
					JOptionPane.showConfirmDialog(frame, "Paciente Cadastrado com Sucesso");
					
					loadPacientes();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdicionarPaciente.setBounds(10, 111, 89, 23);
		panelPaciente.add(btnAdicionarPaciente);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 86, 46, 14);
		panelPaciente.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(70, 86, 124, 20);
		panelPaciente.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(69, 8, 124, 20);
		panelPaciente.add(txtCPF);
		txtCPF.setColumns(10);
		
		showlistPacientes = new JList();
		showlistPacientes.setModel(new AbstractListModel() {
			String[] values = new String[] {"Teste"};
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		showlistPacientes.setBounds(10, 145, 451, 225);
		panelPaciente.add(showlistPacientes);
	}
	public JPanel getPanelPaciente() {
		return panelPaciente;
	}
	
	private void loadPacientes() {
		GenericDAO<Paciente> dao = new GenericDAO<>(Paciente.class);
		this.listPacientes = dao.listar();
		showlistPacientes.updateUI();
	}
}
