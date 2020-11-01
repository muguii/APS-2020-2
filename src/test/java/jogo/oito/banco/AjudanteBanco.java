package jogo.oito.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjudanteBanco {
	
	private static final String SQL_DELETE = "DELETE FROM partida; DELETE FROM jogador;";
	
	public static void limparTudo() {
		Connection conexao = BancoJdbc.obterConexao();
		PreparedStatement statement = null;
		
		try {
			
			statement = conexao.prepareStatement(SQL_DELETE);
			statement.executeUpdate();
			
		} 
		catch (SQLException exception) {
			throw new BancoException(exception.getMessage());
		} 
		finally {
			BancoJdbc.fecharConexao(conexao, statement);
		}
		
	}
}

