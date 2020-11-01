package jogo.oito.banco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jogo.oito.dao.JogadorDao;
import jogo.oito.dao.implementacao.JogadorDaoJdbc;
import jogo.oito.entidade.Jogador;

public class TesteJogadorBancoJdbc {
	
	private JogadorDao jogadorDao;
	
	@Before
	public void setUp() {
		jogadorDao = new JogadorDaoJdbc();
		AjudanteBanco.limparTudo();
	}
	
	@Test
	public void inserirJogadorNoBanco() throws Exception {
		Jogador jogador = new Jogador("Muriel", "mugui", "123");
		jogadorDao.inserir(jogador);
	}
	
	@Test
	public void pesquisarJogadorPeloLogin() throws Exception {
		inserirJogadorNoBanco();
		String login = "mugui";
		Jogador jogador = jogadorDao.pesquisarJogador(login);
		assertEquals(login, jogador.getLogin());
	}
}
