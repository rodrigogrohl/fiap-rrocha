package br.com.fiap.rm48236.jpa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ApplicationWindow {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
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
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 481, 328);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelCinemas = new JPanel();
		tabbedPane.addTab("Cinemas", null, panelCinemas, null);
		panelCinemas.setLayout(null);
		
		JLabel lblCinemaID = new JLabel("ID");
		lblCinemaID.setBounds(10, 11, 46, 14);
		panelCinemas.add(lblCinemaID);
		
		JLabel lblCinemaDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblCinemaDescricao.setBounds(10, 36, 46, 14);
		panelCinemas.add(lblCinemaDescricao);
		
		JLabel lblCinemaContato = new JLabel("Contato");
		lblCinemaContato.setBounds(10, 61, 46, 14);
		panelCinemas.add(lblCinemaContato);
		
		table_1 = new JTable();
		table_1.setBounds(10, 99, 456, 190);
		panelCinemas.add(table_1);
		

	}
}
