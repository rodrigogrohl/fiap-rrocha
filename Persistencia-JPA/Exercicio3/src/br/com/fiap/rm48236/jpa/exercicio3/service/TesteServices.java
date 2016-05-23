/**
 * 
 */
package br.com.fiap.rm48236.jpa.exercicio3.service;

import java.util.List;

import br.com.fiap.rm48236.jpa.exercicio3.entity.Agenda;
import br.com.fiap.rm48236.jpa.exercicio3.service.jpa.GenericDAO;

/**
 * @author rm48236
 *
 */
public class TesteServices {
	
	public static void main(String[] args) {
		GenericDAO<Agenda> daoAgenda = new GenericDAO<>(Agenda.class);
		List<Agenda> listar = daoAgenda.listar();
	}

}
