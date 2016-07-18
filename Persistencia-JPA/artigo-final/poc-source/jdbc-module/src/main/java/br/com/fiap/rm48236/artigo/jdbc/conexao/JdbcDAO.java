package br.com.fiap.rm48236.artigo.jdbc.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.rm48236.artigo.jdbc.entidade.Aluno;
import br.com.fiap.rm48236.artigo.jdbc.entidade.Classe;

public class JdbcDAO {

	private Connection connection;

	public JdbcDAO(Connection connection) {
		this.connection = connection;

	}

	public void adicionarClasse(Classe classe) throws SQLException {
		String sql = "insert into Classe (sigla,coordenador)" + " values (?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, classe.getSigla());
		stmt.setString(2, classe.getCoordenador());
		
		stmt.executeUpdate();
		ResultSet generatedKeys = stmt.getGeneratedKeys();
		
		generatedKeys.next();
		int id = generatedKeys.getInt(1);
		classe.setId(id);
	}

	public void adicionarAluno(Classe classe, Aluno aluno) throws SQLException {
		String sql = "insert into ALUNO (CLASSE_ID,NOME,EMAIL)" + " values (?,?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, classe.getId());
		stmt.setString(2, aluno.getNome());
		stmt.setString(3, aluno.getEmail());
				
		stmt.executeUpdate();
	}

	public List<Classe> listar() throws SQLException {
		List<Classe> classes = new ArrayList<Classe>();
		String query = "SELECT * FROM CLASSE";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt("ID");
			String sigla = resultSet.getString("SIGLA");
			String coordenador = resultSet.getString("COORDENADOR");
			Classe classe = new Classe(id, sigla, coordenador);
			classe.setAlunos(listarAlunos(classe));
			classes.add(classe);
		}
		return classes;
	}

	public List<Aluno> listarAlunos(Classe classe) throws SQLException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		String query = "SELECT * FROM ALUNO WHERE CLASSE_ID = " + classe.getId();
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int matricula = resultSet.getInt("MATRICULA");
			String nome = resultSet.getString("NOME");
			String email = resultSet.getString("EMAIL");
			Aluno aluno = new Aluno(matricula, nome, email, classe);
			alunos.add(aluno);
		}
		return alunos;
	}

	public Classe getClasse(int id) throws SQLException {
		String query = "SELECT * FROM CLASSE WHERE ID =" + id;
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();
		if (resultSet.next()) {
			String sigla = resultSet.getString("SIGLA");
			String coordenador = resultSet.getString("COORDENADOR");
			Classe classe = new Classe(id, sigla, coordenador);
			classe.setAlunos(listarAlunos(classe));
			return classe;
		}
		return null;
	}

	public void update(Classe classe) throws SQLException {
		String sql = "update Classe SET sigla = ?, coordenador = ? WHERE id = ?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, classe.getSigla());
		stmt.setString(2, classe.getCoordenador());
		stmt.setInt(3, classe.getId());
		
		stmt.executeUpdate();
	}
	
}
