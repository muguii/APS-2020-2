package jogo.oito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jogo.oito.entidade.Peca;

public class TesteMovimentacaoPelaPeca {
	
	private JogoDoOito jogo;
	private Tabuleiro tabuleiro;
	
	@Before
	public void setUp() {
		jogo = new JogoDoOito(null);
		tabuleiro = jogo.getTabuleiro();
	}
	
	@Test
	public void MoverCoringaPecaParaCima() throws Exception {
		Peca coringa = new Peca(tabuleiro, 0);
		
		Peca vizinhoCima = new Peca(tabuleiro, 2);
		Peca vizinhoDireita = new Peca(tabuleiro, 6);
		Peca vizinhoBaixo = new Peca(tabuleiro, 7);
		Peca vizinhoEsquerda = new Peca(tabuleiro, 4);
		
		coringa.setVizinhoCima(vizinhoCima);
		coringa.setVizinhoDireita(vizinhoDireita);                                                                                                                     
		coringa.setVizinhoBaixo(vizinhoBaixo);
		coringa.setVizinhoEsquerda(vizinhoEsquerda);
		
		coringa.moverParaCima();       
		
		assertEquals(vizinhoCima.getValor(), Integer.valueOf(0));
	}
	
	@Test
	public void MoverCoringaPecaParaDireita() throws Exception {
		Peca coringa = new Peca(tabuleiro, 0);
		
		Peca vizinhoCima = new Peca(tabuleiro, 2);
		Peca vizinhoDireita = new Peca(tabuleiro, 6);
		Peca vizinhoBaixo = new Peca(tabuleiro, 7);
		Peca vizinhoEsquerda = new Peca(tabuleiro, 4);
		
		coringa.setVizinhoCima(vizinhoCima);
		coringa.setVizinhoDireita(vizinhoDireita);                                                                                                                     
		coringa.setVizinhoBaixo(vizinhoBaixo);
		coringa.setVizinhoEsquerda(vizinhoEsquerda);
		
		coringa.moverParaDireita();       
		
		assertEquals(vizinhoDireita.getValor(), Integer.valueOf(0));
	}
	
	@Test
	public void MoverCoringaPecaParaBaixo() throws Exception {
		Peca coringa = new Peca(tabuleiro, 0);
		
		Peca vizinhoCima = new Peca(tabuleiro, 2);
		Peca vizinhoDireita = new Peca(tabuleiro, 6);
		Peca vizinhoBaixo = new Peca(tabuleiro, 7);
		Peca vizinhoEsquerda = new Peca(tabuleiro, 4);
		
		coringa.setVizinhoCima(vizinhoCima);
		coringa.setVizinhoDireita(vizinhoDireita);                                                                                                                     
		coringa.setVizinhoBaixo(vizinhoBaixo);
		coringa.setVizinhoEsquerda(vizinhoEsquerda);
		
		coringa.moverParaBaixo();       
		
		assertEquals(vizinhoBaixo.getValor(), Integer.valueOf(0));
	}
	
	@Test
	public void MoverCoringaPecaParaEsquerda() throws Exception {
		Peca coringa = new Peca(tabuleiro, 0);
		
		Peca vizinhoCima = new Peca(tabuleiro, 2);
		Peca vizinhoDireita = new Peca(tabuleiro, 6);
		Peca vizinhoBaixo = new Peca(tabuleiro, 7);
		Peca vizinhoEsquerda = new Peca(tabuleiro, 4);
		
		coringa.setVizinhoCima(vizinhoCima);
		coringa.setVizinhoDireita(vizinhoDireita);                                                                                                                     
		coringa.setVizinhoBaixo(vizinhoBaixo);
		coringa.setVizinhoEsquerda(vizinhoEsquerda);
		
		coringa.moverParaEsquerda();       
		
		assertEquals(vizinhoEsquerda.getValor(), Integer.valueOf(0));
	}
}                                                                                                                                                                             