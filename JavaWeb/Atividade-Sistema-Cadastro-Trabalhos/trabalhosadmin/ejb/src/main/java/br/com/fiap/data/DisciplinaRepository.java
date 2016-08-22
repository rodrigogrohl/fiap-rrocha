/**
 * 
 */
package br.com.fiap.data;

import javax.enterprise.context.ApplicationScoped;

import br.com.fiap.model.Disciplina;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class DisciplinaRepository extends GenericDAO<Disciplina> {

	public DisciplinaRepository() {
		super(Disciplina.class);
	}
	
}
