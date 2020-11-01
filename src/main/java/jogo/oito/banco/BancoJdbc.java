package jogo.oito.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoJdbc {

	private static final String URL = "jdbc:postgresql://localhost:5432/APS2020-2";
	private static final String USER = "AdminAPS";
	private static final String PASSWORD = "123456";

	public static Connection obterConexao() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} 
		catch (SQLException e) {
			throw new BancoException("Erro na conexão com o Banco de Dados. " + e.getMessage());
		} 
	}

	public static void fecharConexao(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} 
			catch (SQLException e) {
				throw new BancoException("Erro ao fechar conexão com o Banco de Dados. " + e.getMessage());
			}
		}
	}

	public static void fecharConexao(Connection conexao, PreparedStatement statement) {
		fecharConexao(conexao);
		if (statement != null) {
			try {
				statement.close();
			} 
			catch (SQLException e) {
				throw new BancoException("Erro ao fechar conexão com o Banco de Dados. " + e.getMessage());
			}
		}
	}

	public static void fecharConexao(Connection conexao, PreparedStatement statement, ResultSet resultSet) {
		fecharConexao(conexao, statement);
		if (resultSet != null) {
			try {
				resultSet.close();
			} 
			catch (SQLException e) {
				throw new BancoException("Erro ao fechar conexão com o Banco de Dados. " + e.getMessage());
			}
		}
	}

}
