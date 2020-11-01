package jogo.oito.dao;

import jogo.oito.entidade.Jogador;

public interface JogadorDao {
	
	void inserir(Jogador jogador);
	Jogador pesquisarJogador(String login);
	
}
