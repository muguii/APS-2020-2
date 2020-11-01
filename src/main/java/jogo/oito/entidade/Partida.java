package jogo.oito.entidade;

public class Partida {
	
	private Long id;
	private Jogador jogador;
	private Integer movimentos;
	
	public Partida() {
		movimentos = 0;
	}
	
	public Partida(Jogador jogador) {
		this.jogador = jogador;
		movimentos = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Integer getMovimentos() {
		return movimentos;
	}

	public void incrementarMovimentos() {
		movimentos++;
	}
	
	
}
