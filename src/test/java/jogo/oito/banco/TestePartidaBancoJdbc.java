package jogo.oito.banco;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.oito.dao.JogadorDao;
import jogo.oito.dao.PartidaDao;
import jogo.oito.dao.implementacao.JogadorDaoJdbc;
import jogo.oito.dao.implementacao.PartidaDaoJdbc;
import jogo.oito.entidade.Jogador;
import jogo.oito.entidade.Partida;

public class TestePartidaBancoJdbc {
	
	private PartidaDao partidaDao;
	private JogadorDao jogadorDao;
	
	@Before
	public void setUp() {
		partidaDao = new PartidaDaoJdbc();
		jogadorDao = new JogadorDaoJdbc();
		AjudanteBanco.limparTudo();
	}
	
	@Test
	public void iniciarPartida() throws Exception {
		jogadorDao.inserir(new Jogador("Muriel", "mugui", "123"));
		String login = "mugui";
		Jogador jogador = jogadorDao.pesquisarJogador(login);
		Partida partida = new Partida(jogador);
		partidaDao.inserir(partida);
		assertEquals(Integer.valueOf(0), partida.getMovimentos());
	}
	
	@Test
	public void incrementarMovimentos() throws Exception {
		jogadorDao.inserir(new Jogador("Muriel", "mugui2", "123"));
		String login = "mugui2";
		Jogador jogador = jogadorDao.pesquisarJogador(login);
		
		Partida partida = new Partida(jogador);
		partidaDao.inserir(partida);
		
		Integer movimentos = partida.getMovimentos();
		assertEquals(Integer.valueOf(0), movimentos);
		
		movimentos++;
		partida.incrementarMovimentos();
		partidaDao.atualizarMovimentos(partida);
		assertEquals(movimentos, partida.getMovimentos());
	}
}
