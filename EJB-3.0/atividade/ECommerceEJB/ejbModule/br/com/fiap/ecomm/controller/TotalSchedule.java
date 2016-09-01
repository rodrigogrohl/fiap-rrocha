package br.com.fiap.ecomm.controller;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class TotalSchedule {

	@EJB
	private ComentarioService service;
	
	@Schedule(second= "*/5", minute = "*", hour = "*", persistent = false)
	public void atRun() {
		int size = service.listar().size();
		System.out.println("Total de Comentários Registrados: "+ size);
	}
}
