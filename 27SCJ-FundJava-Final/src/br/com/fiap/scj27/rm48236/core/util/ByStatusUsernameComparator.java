package br.com.fiap.scj27.rm48236.core.util;

import java.util.Comparator;

import twitter4j.Status;

/**
 * Custom comparator, checa o nome do usuario
 * @author Rodrigo
 *
 */
public class ByStatusUsernameComparator implements Comparator<Status>{

	@Override
	public int compare(Status statusA, Status statusB) {
		return statusA.getUser().getName().compareTo(statusB.getUser().getName());
	}

}
