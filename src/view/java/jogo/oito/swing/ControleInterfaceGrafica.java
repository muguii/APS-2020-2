package jogo.oito.swing;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

import jogo.oito.JogoDoOito;
import jogo.oito.entidade.Peca;

public class ControleInterfaceGrafica {
	
	private JogoDoOito jogo;
	
	private List<Component> labels;
	private List<Peca> pecas;
	private JLabel labelQuantidadeDeMovimentos;
	
	public ControleInterfaceGrafica(Component[] componentLabels, JLabel labelQuantidadeDeMovimentos) {
		this.jogo = new JogoDoOito();
		this.labelQuantidadeDeMovimentos = labelQuantidadeDeMovimentos;
		labels = Arrays.asList(componentLabels);
		pecas = jogo.getTabuleiro().getPecas();
	}

	public void iniciarJogo() {
		jogo.iniciarJogo();
		atualizarLabels();
	}
	
	public void moverParaCima() {
		jogo.moverParaCima();
		atualizarLabels();
	}
	
	public void moverParaDireita() {
		jogo.moverParaDireita();
		atualizarLabels();
	}
	
	public void moverParaBaixo() {
		jogo.moverParaBaixo();
		atualizarLabels();
	}

	public void moverParaEsquerda() {
		jogo.moverParaEsquerda();
		atualizarLabels();
	}
	
	private void atualizarLabels() {
		for (int i = 0; i < pecas.size(); i++) {
			Peca peca = pecas.get(i);
			JLabel label = (JLabel)labels.get(i);
			label.setText(peca.getValor().toString());
			
			if (peca.isCoringa())
				label.setText(null);
			
		}
		
		labelQuantidadeDeMovimentos.setText(jogo.getMovimentos().toString());
	}
	
}
