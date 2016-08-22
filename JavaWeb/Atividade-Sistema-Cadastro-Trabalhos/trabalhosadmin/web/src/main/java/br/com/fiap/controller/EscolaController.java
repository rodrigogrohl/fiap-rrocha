/**
 * 
 */
package br.com.fiap.controller;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Escola;
import br.com.fiap.service.EscolaService;

/**
 * @author Rodrigo
 *
 */

@Model
@Named(value = "escolaBean")
public class EscolaController implements Serializable {
	
	private static final long serialVersionUID = -2340054197166179506L;

	private Escola escola;
	
	@Inject
	private EscolaService service;
	
	public void cadastar() {
		service.cadastrar(escola);		
	}

	public Escola getEscola() {
		if(escola == null)
			escola = new Escola();
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}
