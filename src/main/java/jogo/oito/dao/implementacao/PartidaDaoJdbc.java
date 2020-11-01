package jogo.oito.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jogo.oito.banco.BancoException;
import jogo.oito.banco.BancoJdbc;
import jogo.oito.dao.PartidaDao;
import jogo.oito.entidade.Partida;

public class PartidaDaoJdbc implements PartidaDao {

	private static final String SQL_INSERT = "INSERT INTO partida (jogador_id) VALUES (?);";
	private static final String SQL_UPDATE_MOVIMENTO = "UPDATE partida SET movimentos = ? WHERE id = ?;";
	
	public PartidaDaoJdbc() {
	}
	
	@Override
	public void inserir(Partida partida) {
		Connection conexao = BancoJdbc.obterConexao();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
				
		try {
			statement = conexao.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			
			statement.setLong(1, partida.getJogador().getId());
			
			int linhasAfetadas = statement.executeUpdate();
			
			if(linhasAfetadas > 0) {
				resultSet = statement.getGeneratedKeys();	
				
				if (resultSet.next()) {
					Long id = resultSet.getLong(1);
					partida.setId(id);
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
	public void atualizarMovimentos(Partida partida) {
		Connection conexao = BancoJdbc.obterConexao();
		PreparedStatement statement = null;
				
		try {
			statement = conexao.prepareStatement(SQL_UPDATE_MOVIMENTO);
			statement.setInt(1, partida.getMovimentos());
			statement.setLong(2, partida.getId());
			
			int linhasAfetadas = statement.executeUpdate();
			
			if(linhasAfetadas <= 0)
				throw new BancoException("Nenhuma linha afetada!");
			
		}
		catch (SQLException exception) {
			throw new BancoException(exception.getMessage());
		} 
		finally {
			BancoJdbc.fecharConexao(conexao, statement);
		}
	}

}
