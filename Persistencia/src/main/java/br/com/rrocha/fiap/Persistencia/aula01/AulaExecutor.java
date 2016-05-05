package br.com.rrocha.fiap.Persistencia.aula01;

import javax.swing.JOptionPane;

import br.com.rrocha.fiap.Persistencia.aula01.dao.ClienteDAO;
import br.com.rrocha.fiap.Persistencia.aula01.entity.Cliente;

public class AulaExecutor {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Entre com o Nome:");
		String email = JOptionPane.showInputDialog("Entre com o email:");
		
		ClienteDAO dao = new ClienteDAO();
		try {
			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEmail(email);
			dao.incluir(cliente );
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, e.getLocalizedMessage());
		}
		
		try {
			JOptionPane.showInputDialog(null, 
					"Selecione um Cliente", 
					"Clientes", 
					JOptionPane.INFORMATION_MESSAGE, 
					null, 
					dao.listar().toArray(), 
					null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
