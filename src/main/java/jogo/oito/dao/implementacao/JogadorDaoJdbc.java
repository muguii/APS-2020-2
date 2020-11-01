package jogo.oito.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jogo.oito.banco.BancoException;
import jogo.oito.banco.BancoJdbc;
import jogo.oito.dao.JogadorDao;
import jogo.oito.entidade.Jogador;

public class JogadorDaoJdbc implements JogadorDao {

	private static final String SQL_INSERT = "INSERT INTO jogador (nome, login, senha) VALUES (?, ?, ?);";
	
	public JogadorDaoJdbc() {
	}
	
	@Override
	public void inserir(Jogador jogador) {
		Connection conexao = BancoJdbc.obterConexao();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
				
		try {
			statement = conexao.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, jogador.getNome());
			statement.setString(2, jogador.getLogin());
			statement.setString(3, jogador.getSenha());
			
			int linhasAfetadas = statement.executeUpdate();
			
			if(linhasAfetadas > 0) {
				resultSet = statement.getGeneratedKeys();	
				
				if (resultSet.next()) {
					Long id = resultSet.getLong(1);
					jogador.setId(id);
				}
			}
			else 
				throw new BancoException("Nenhuma linha afetada!");
			
		} 
		catch (SQLException exception) {
			throw new BancoException(exception.getMessage());
		} 
		finally {
			BancoJdbc.fecharConexao(conexao, statement, resultSet);
		}
		
	}

	@Override
	public Jogador pesquisarJogador(String login) {
		Connection conexao = BancoJdbc.obterConexao();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = conexao.prepareStatement("SELECT * FROM jogador WHERE UPPER(login) = UPPER(?);");
			statement.setString(1, login);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Jogador jogador = instanciarJogador(resultSet);
				return jogador;
			}
			
			return null;
			
		} 
		catch (SQLException exception) {
			throw new BancoException(exception.getMessage());
		}
		finally {
			BancoJdbc.fecharConexao(conexao, statement, resultSet);
		}
		
	}

	private Jogador instanciarJogador(ResultSet resultSet) throws SQLException {
			Jogador jogador = new Jogador();
			
			jogador.setId(resultSet.getLong("id"));
			jogador.setNome(resultSet.getString("nome"));
			jogador.setLogin(resultSet.getString("login"));
			jogador.setSenha(resultSet.getString("senha"));
			
			return jogador;
	}

}
