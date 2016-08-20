package br.com.fiap.ejbws;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.entity.Livros;

@Remote
public interface LivroBeanRemote {
	void add(Livros livro);
	List<Livros> getAll();
}
