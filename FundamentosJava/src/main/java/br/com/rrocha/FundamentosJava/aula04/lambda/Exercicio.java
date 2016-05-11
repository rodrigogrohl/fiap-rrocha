package br.com.rrocha.FundamentosJava.aula04.lambda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Exercicio {
	
	public static void main(String[] args) {
		
		List<Cliente> clientes = new ArrayList<>();
		
		clientes.add(new Cliente("José", 45, true, LocalDateTime.of(2015, 8, 5, 5, 0)));
		clientes.add(new Cliente("Daniel", 22, true, LocalDateTime.of(2008, 1, 15, 15, 8)));
		clientes.add(new Cliente("Sérgio", 38, true, LocalDateTime.of(2006, 5, 9, 19, 8)));
		
//		clientes.stream()
//			.filter(c -> Period.between(c.setDataPrimeiraCompra, endDateExclusive));
		
		
	}

}
