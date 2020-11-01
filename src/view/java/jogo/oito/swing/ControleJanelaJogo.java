package jogo.oito.swing;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

import jogo.oito.JogoDoOito;
import jogo.oito.dao.PartidaDao;
import jogo.oito.dao.implementacao.PartidaDaoJdbc;
import jogo.oito.entidade.Jogador;
import jogo.oito.entidade.Partida;
import jogo.oito.entidade.Peca;

public class ControleJanelaJogo {
	
	private JogoDoOito jogo;
	private PartidaDao partidaDao;
	
	private List<Component> labels;
	private List<Peca> pecas;
	private JLabel labelQuantidadeDeMovimentos;

	
	public ControleJanelaJogo(Component[] componentLabels, JLabel labelQuantidadeDeMovimentos, Partida partida) {
		this.jogo = new JogoDoOito(partida);
		partidaDao = new PartidaDaoJdbc();
		this.labelQuantidadeDeMovimentos = labelQuantidadeDeMovimentos;
		labels = Arrays.asList(componentLabels);
		pecas = jogo.getTabuleiro().getPecas();
	}

	public void iniciarJogo() {
		jogo.iniciarJogo();
		atualizar();
	}
	
	public void moverParaCima() {
		jogo.moverParaCima();
		atualizar();
	}
	
	public void moverParaDireita() {
		jogo.moverParaDireita();
		atualizar();
	}
	
	public void moverParaBaixo() {
		jogo.moverParaBaixo();
		atualizar();
	}

	public void moverParaEsquerda() {
		jogo.moverParaEsquerda();
		atualizar();
	}
	
	public void novoJogo() {
		Jogador jogadorAtual = jogo.getPartida().getJogador();
		Partida novaPartida = new Partida(jogadorAtual);
		partidaDao.inserir(novaPartida);
		
		this.jogo = new JogoDoOito(novaPartida);
		pecas = jogo.getTabuleiro().getPecas();
		
		iniciarJogo();
	}
	
	private void atualizar() {
		for (int i = 0; i < pecas.size(); i++) {
			Peca peca = pecas.get(i);
			JLabel label = (JLabel)labels.get(i);
			label.setText(peca.getValor().toString());
			
			if (peca.isCoringa())
				label.setText(null);
			
		}
		
		partidaDao.atualizarMovimentos(jogo.getPartida());
		labelQuantidadeDeMovimentos.setText(jogo.getPartida().getMovimentos().toString());
	}

}
