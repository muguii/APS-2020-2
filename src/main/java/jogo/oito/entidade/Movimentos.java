package jogo.oito.entidade;

public enum Movimentos {
	CIMA(1),
	DIREITA(2),
	BAIXO(3),
	ESQUERDA(4);

	public int valor;
	
	Movimentos(int valor) {
		this.valor = valor;
	}
}
