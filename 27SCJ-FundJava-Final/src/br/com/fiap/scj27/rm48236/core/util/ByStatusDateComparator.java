package br.com.fiap.scj27.rm48236.core.util;

import java.util.Comparator;

import twitter4j.Status;

/**
 * Custom comparator, com base na Data de Criacao
 * @author Rodrigo
 *
 */
public class ByStatusDateComparator implements Comparator<Status>{

	@Override
	public int compare(Status statusA, Status statusB) {
		return statusA.getCreatedAt().compareTo(statusB.getCreatedAt());
	}

}
