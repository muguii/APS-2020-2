package jogo.oito;

public class JogoDoOito {

	private Tabuleiro tabuleiro;
	private Integer movimentos;
	
	public JogoDoOito() {
		tabuleiro = new Tabuleiro();
		movimentos = 0;
	}

	public void iniciarJogo() {
		tabuleiro.configuracaoInicial();
	}

	public void moverParaCima() {
		tabuleiro.getCoringa().moverParaCima();
		movimentos++;
	}

	public void moverParaDireita() {
		tabuleiro.getCoringa().moverParaDireita();
		movimentos++;
	}
	
	public void moverParaBaixo() {
		tabuleiro.getCoringa().moverParaBaixo();
		movimentos++;
	}

	public void moverParaEsquerda() {
		tabuleiro.getCoringa().moverParaEsquerda();
		movimentos++;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public Integer getMovimentos() {
		return movimentos;
	}
}
