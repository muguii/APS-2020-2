package jogo.oito;

import jogo.oito.entidade.Peca;
import jogo.oito.entidade.Posicao;

public class Tabuleiro {
	
	private Integer linhas;
	private Integer colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(Integer linhas, Integer colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}
	
	public Peca obterPeca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.setPosicao(posicao);
	}
	
	public Posicao obterPosicaoDoCoringa() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(pecas[i][j].isCoringa()) {
					return pecas[i][j].getPosicao();
				}
			}
		}
		return null;
	}
	
	public Integer getLinhas() {
		return linhas;
	}
	
	public Integer getColunas() {
		return colunas;
	}
	
	public Peca[][] getPecas() {
		return pecas;
	}
}
