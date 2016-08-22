/**
 * 
 */
package br.com.fiap.data;

import javax.enterprise.context.ApplicationScoped;

import br.com.fiap.model.Professor;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class ProfessorRepository extends GenericDAO<Professor> {

	public ProfessorRepository() {
		super(Professor.class);
	}
	
}
