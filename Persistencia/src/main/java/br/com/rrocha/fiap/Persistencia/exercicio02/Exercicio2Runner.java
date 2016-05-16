/**
 * 
 */
package br.com.rrocha.fiap.Persistencia.exercicio02;

import java.util.List;
import java.util.Random;

import br.com.rrocha.fiap.Persistencia.exercicio01.Cliente;
import de.svenjacobs.loremipsum.LoremIpsum;

/**
 * @author rm48236
 *
 */
public class Exercicio2Runner {

	public static void main(String[] args) {
		
		LoremIpsum ipsum = new LoremIpsum();
		GenericDAO<Cliente> dao = new GenericDAO<>(Cliente.class);
		
		Cliente adicionar = new Cliente(null, ipsum.getWords(3,6).replace(",", ""), ipsum.getWords(3).replace(" ", "") + "@teste.com");
		dao.adicionar(adicionar);
		System.out.println("Adicionado: " + adicionar);
		
		Cliente encontrado = dao.buscar( new Random().nextInt(10));
		System.out.println("Encontrado: " + encontrado);
		
		encontrado.setNome( encontrado.getNome() + " fiap!");
		dao.atualizar(encontrado);
		System.out.println("Atualizado: " + encontrado);
//		
//		for (int i = 0; i < 10; i++) {
//			encontrado = dao.buscar( new Random().nextInt(50));
//			String newName = encontrado.getNome() + " " + ipsum.getWords(3);
//			newName = newName.replace("Lorem ipsum", "").replace("  ", " ");
//			if(newName.length() > 45)
//				newName = newName.substring(0,43);
//			encontrado.setNome( newName );
//			dao.atualizar(encontrado);
//			System.out.println("Alterado: " + encontrado);
//		}
		
		Cliente clienteRM = new Cliente(null, ipsum.getWords(2), ipsum.getWords(1) + "@teste.com");
		dao.adicionar(clienteRM);
		System.out.println("Removido: " + clienteRM);
		dao.remover(clienteRM);
		
		List<Cliente> list = dao.listar();
		System.out.println("Lista: ");
		for (Cliente cliente : list) {
			System.out.println(cliente);
		}
		dao.em.close();
	}
}
