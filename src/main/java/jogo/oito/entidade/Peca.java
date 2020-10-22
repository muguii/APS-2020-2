package jogo.oito.entidade;

import jogo.oito.Tabuleiro;

public class Peca implements Movimentos {
	
	private Tabuleiro tabuleiro;
	private Integer valor;
	private Boolean coringa;
	private Peca vizinhoCima;
	private Peca vizinhoDireita;
	private Peca vizinhoBaixo;
	private Peca vizinhoEsquerda;
	
	public Peca(Tabuleiro tabuleiro, Integer valor) {
		this.tabuleiro = tabuleiro;
		this.valor = valor;
		coringa = Boolean.FALSE;
		vizinhoCima = null;
		vizinhoDireita = null;
		vizinhoBaixo = null;
		vizinhoEsquerda = null;
	}
	
	public Peca(Tabuleiro tabuleiro, Integer valor, Boolean coringa) {
		this.tabuleiro = tabuleiro;
		this.valor = valor;
		this.coringa = coringa;
		vizinhoCima = null;
		vizinhoDireita = null;
		vizinhoBaixo = null;
		vizinhoEsquerda = null;
	}
	
	public void moverParaCima() {
		trocarValor(this, vizinhoCima);
	}
	
	public void moverParaDireita() {
		trocarValor(this, vizinhoDireita);
	}
	
	public void moverParaBaixo() {
		trocarValor(this, vizinhoBaixo);
	}
	
	public void moverParaEsquerda() {
		trocarValor(this, vizinhoEsquerda);
	}
	
	private void trocarValor(Peca origem, Peca alvo) {
		if (alvo != null) {
			Integer auxiliar = origem.getValor();
			
			origem.setValor(alvo.getValor());
			alvo.setValor(auxiliar);
			
			alvo.coringa = Boolean.TRUE;
			origem.coringa = Boolean.FALSE;
		}
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public Integer getValor() {
		return valor;
	}
	
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public Peca getVizinhoCima() {
		return vizinhoCima;
	}

	public void setVizinhoCima(Peca vizinhoCima) {
		this.vizinhoCima = vizinhoCima;
	}

	public Peca getVizinhoDireita() {
		return vizinhoDireita;
	}

	public void setVizinhoDireita(Peca vizinhoDireita) {
		this.vizinhoDireita = vizinhoDireita;
	}

	public Peca getVizinhoBaixo() {
		return vizinhoBaixo;
	}

	public void setVizinhoBaixo(Peca vizinhoBaixo) {
		this.vizinhoBaixo = vizinhoBaixo;
	}

	public Peca getVizinhoEsquerda() {
		return vizinhoEsquerda;
	}

	public void setVizinhoEsquerda(Peca vizinhoEsquerda) {
		this.vizinhoEsquerda = vizinhoEsquerda;
	}

	public Boolean isCoringa() {
		return coringa;
	}

}
