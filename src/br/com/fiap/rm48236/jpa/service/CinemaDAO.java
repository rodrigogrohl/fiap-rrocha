/**
 * 
 */
package br.com.fiap.rm48236.jpa.service;

import br.com.fiap.rm48236.jpa.entity.Cinema;
import br.com.fiap.rm48236.jpa.service.jpa.GenericDAO;

/**
 * @author rm48236
 *
 */
public class CinemaDAO extends GenericDAO<Cinema>{

	public CinemaDAO() {
		super(Cinema.class);
	}

}
