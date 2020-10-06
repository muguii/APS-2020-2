package jogo.oito;

import jogo.oito.entidade.Movimentos;
import jogo.oito.entidade.Peca;
import jogo.oito.entidade.Posicao;

public class JogoDoOito {

	private Tabuleiro tabuleiro;
	private boolean gameOver;
	private Integer movimentos;
	
	public JogoDoOito() {
		tabuleiro = new Tabuleiro(3, 3);
		gameOver = false;
		movimentos = 0;
		this.newGame();
	}

	private void newGame() {
		this.setupInicial();
	}

	private void setupInicial() {
		tabuleiro.colocarPeca(new Peca(tabuleiro, 1), new Posicao(0, 0));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 3), new Posicao(0, 1));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 4), new Posicao(0, 2));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 8), new Posicao(1, 0));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 6), new Posicao(1, 1));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 2), new Posicao(1, 2));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 7), new Posicao(2, 0));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 0, true), new Posicao(2, 1));
		tabuleiro.colocarPeca(new Peca(tabuleiro, 5), new Posicao(2, 2));
	}
	
	public void mover(Movimentos direcao) {
		switch(direcao.valor) {
		case 1:
			moveUp();
			break;
		case 2:
			moveRight();
			break;
		case 3:
			moveDown();
			break;
		case 4:
			moveLeft();
			break;
		}
	}
	
	public void moveUp() {
		Posicao origem = tabuleiro.obterPosicaoDoCoringa();
		Posicao alvo = new Posicao(origem.getLinha() - 1, origem.getColuna());
		
		if (alvo.getLinha() >= 0) {
			moverPecas(origem, alvo);
			checkWin();
		}
	}

	public void moveRight() {
		Posicao origem = tabuleiro.obterPosicaoDoCoringa();
		Posicao alvo = new Posicao(origem.getLinha(), origem.getColuna() + 1);
		
		if (alvo.getColuna() <= 2) {
			moverPecas(origem, alvo);
			checkWin();
		}
	}
	
	public void moveDown() {
		Posicao origem = tabuleiro.obterPosicaoDoCoringa();
		Posicao alvo = new Posicao(origem.getLinha() + 1, origem.getColuna());
		
		if (alvo.getLinha() <= 2) {
			moverPecas(origem, alvo);
			checkWin();
		}
	}
	
	public void moveLeft() {
		Posicao origem = tabuleiro.obterPosicaoDoCoringa();
		Posicao alvo = new Posicao(origem.getLinha(), origem.getColuna() - 1);
		
		if (alvo.getColuna() >= 0) {
			moverPecas(origem, alvo);
			checkWin();
		}
	}
	
	private void moverPecas(Posicao origem, Posicao alvo) {
		Peca pecaAlvo = tabuleiro.obterPeca(alvo);
		Peca pecaCoringa = tabuleiro.obterPeca(origem);
		
		tabuleiro.colocarPeca(pecaCoringa, alvo);
		tabuleiro.colocarPeca(pecaAlvo, origem);
		
		movimentos++;
	}

	private void checkWin() {
		Peca[][] pecas = tabuleiro.getPecas();
		Integer valor = 1;
		boolean estado = true;
		
		first:
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 2 && j == 2) {
					valor = 0;
				}
				
				if (pecas[i][j].getValor() != valor) {
					estado = false;
					break first;
				}
				
				valor++;
			}
		}
		
		if (estado == true) {
			gameOver = true;
		}
	}

	public Peca[][] getPecasDoTabuleiro() {
		return tabuleiro.getPecas();
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
