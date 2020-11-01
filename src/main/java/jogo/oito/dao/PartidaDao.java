package jogo.oito.dao;

import jogo.oito.entidade.Partida;

public interface PartidaDao {
	
	void inserir(Partida partida);
	void atualizarMovimentos(Partida partida);
	
}
