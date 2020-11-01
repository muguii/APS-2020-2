package jogo.oito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import jogo.oito.entidade.Peca;

public class TesteMovimentacaoPeloJogo {
	
	private JogoDoOito jogo;
	
	@Before
	public void setUp() {
		jogo = new JogoDoOito(null);
	}
	
	@Test
	public void MoverParaCima() throws Exception {
		Peca pecaCoringa = jogo.getTabuleiro().getPecas().get(7);
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(Integer.valueOf(6), pecaCoringa.getVizinhoCima().getValor());
		
		jogo.moverParaCima();
		
		assertFalse(pecaCoringa.isCoringa());
		assertTrue(pecaCoringa.getVizinhoCima().isCoringa());
		pecaCoringa = pecaCoringa.getVizinhoCima();
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(Integer.valueOf(6), pecaCoringa.getVizinhoBaixo().getValor());
		
	}
	
	@Test
	public void MoverParaDireita() throws Exception {
		Peca pecaCoringa = jogo.getTabuleiro().getPecas().get(7);
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(Integer.valueOf(5), pecaCoringa.getVizinhoDireita().getValor());
		
		jogo.moverParaDireita();
		
		assertFalse(pecaCoringa.isCoringa());
		assertTrue(pecaCoringa.getVizinhoDireita().isCoringa());
		pecaCoringa = pecaCoringa.getVizinhoDireita();
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(Integer.valueOf(5), pecaCoringa.getVizinhoEsquerda().getValor());
		
	}
	
	@Test
	public void MoverParaBaixo() throws Exception {
		Peca pecaCoringa = jogo.getTabuleiro().getPecas().get(7);
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(null, pecaCoringa.getVizinhoBaixo());
		
		jogo.moverParaBaixo();
		
		assertTrue(pecaCoringa.isCoringa());
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(null, pecaCoringa.getVizinhoBaixo());
		
	}

	@Test
	public void MoverParaEsquerda() throws Exception {
		Peca pecaCoringa = jogo.getTabuleiro().getPecas().get(7);
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(Integer.valueOf(7), pecaCoringa.getVizinhoEsquerda().getValor());
		
		jogo.moverParaEsquerda();
		
		assertFalse(pecaCoringa.isCoringa());
		assertTrue(pecaCoringa.getVizinhoEsquerda().isCoringa());
		pecaCoringa = pecaCoringa.getVizinhoEsquerda();
		assertEquals(Integer.valueOf(0), pecaCoringa.getValor());
		assertEquals(Integer.valueOf(7), pecaCoringa.getVizinhoDireita().getValor());
		
	}
	
}
