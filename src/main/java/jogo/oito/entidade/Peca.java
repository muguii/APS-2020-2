package jogo.oito.entidade;

import jogo.oito.Tabuleiro;

public class Peca {
	
	private Tabuleiro tabuleiro;
	private Integer valor;
	private Posicao posicao;
	private boolean coringa;
	
	public Peca(Tabuleiro tabuleiro, Integer valor, boolean coringa) {
		this.tabuleiro = tabuleiro;
		this.valor = valor;
		posicao = null;
		this.coringa = coringa;
	}
	
	public Peca(Tabuleiro tabuleiro, Integer valor) {
		this.tabuleiro = tabuleiro;
		this.valor = valor;
		posicao = null;
		coringa = false;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public Integer getValor() {
		return valor;
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public boolean isCoringa() {
		return coringa;
	}
}
