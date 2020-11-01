package jogo.oito;

import jogo.oito.entidade.Partida;

public class JogoDoOito {

	private Tabuleiro tabuleiro;
	private Partida partida;
	
	public JogoDoOito(Partida partida) {
		tabuleiro = new Tabuleiro();
		this.partida = partida;
	}

	public void iniciarJogo() {
		tabuleiro.configuracaoInicial();
	}

	public void moverParaCima() {
		tabuleiro.getCoringa().moverParaCima();
		partida.incrementarMovimentos();
	}

	public void moverParaDireita() {
		tabuleiro.getCoringa().moverParaDireita();
		partida.incrementarMovimentos();
	}
	
	public void moverParaBaixo() {
		tabuleiro.getCoringa().moverParaBaixo();
		partida.incrementarMovimentos();
	}

	public void moverParaEsquerda() {
		tabuleiro.getCoringa().moverParaEsquerda();
		partida.incrementarMovimentos();
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public Partida getPartida() {
		return partida;
	}
	
}
