package jogo.oito;

import java.util.LinkedList;
import java.util.List;

import jogo.oito.entidade.Peca;

public class Tabuleiro {
	
	List<Peca> pecas;
	
	public Tabuleiro() {
		pecas = new LinkedList<Peca>();
	}

	public void configuracaoInicial() {
		//1 3 4 
		//8 6 2 
		//7 0 5
		
		pecas.add(new Peca(this, 1));
		pecas.add(new Peca(this, 3));
		pecas.add(new Peca(this, 4));
		pecas.add(new Peca(this, 8));
		pecas.add(new Peca(this, 6));
		pecas.add(new Peca(this, 2));
		pecas.add(new Peca(this, 7));
		pecas.add(new Peca(this, 0, Boolean.TRUE));
		pecas.add(new Peca(this, 5));
		
		configurarVizinhos();
	}
	
	private void configurarVizinhos() {
		Peca cimaEsquerda = pecas.get(0);
		Peca cima = pecas.get(1);
		Peca cimaDireita = pecas.get(2);
		
		Peca meioEsquerda = pecas.get(3);
		Peca meio = pecas.get(4);
		Peca meioDireita = pecas.get(5);
		
		Peca baixoEsquerda = pecas.get(6);
		Peca baixo = pecas.get(7);
		Peca baixoDireita = pecas.get(8);
		
		//cimaEsquerda.setVizinhoCima(null);
		cimaEsquerda.setVizinhoDireita(cimaDireita);
		cimaEsquerda.setVizinhoBaixo(meioEsquerda);
		//cimaEsquerda.setVizinhoEsquerda(null);
		
		//cima.setVizinhoCima(null);
		cima.setVizinhoDireita(cimaDireita);
		cima.setVizinhoBaixo(meio);
		cima.setVizinhoEsquerda(cimaEsquerda);
		
		//cimaDireita.setVizinhoCima(null);
		//cimaDireita.setVizinhoDireita(null);
		cimaDireita.setVizinhoBaixo(meioDireita);
		cimaDireita.setVizinhoEsquerda(cima);
		
		meioEsquerda.setVizinhoCima(cimaEsquerda);
		meioEsquerda.setVizinhoDireita(meio);
		meioEsquerda.setVizinhoBaixo(baixoEsquerda);
		//meioEsquerda.setVizinhoEsquerda(null);
		
		meio.setVizinhoCima(cima);
		meio.setVizinhoDireita(meioDireita);
		meio.setVizinhoBaixo(baixo);
		meio.setVizinhoEsquerda(meioEsquerda);
		
		meioDireita.setVizinhoCima(cimaDireita);
		//meioDireita.setVizinhoDireita(null);
		meioDireita.setVizinhoBaixo(baixoDireita);
		meioDireita.setVizinhoEsquerda(meio);
		
		baixoEsquerda.setVizinhoCima(meioEsquerda);
		baixoEsquerda.setVizinhoDireita(baixo);
		//baixoEsquerda.setVizinhoBaixo(null);
		//baixoEsquerda.setVizinhoEsquerda(null);
		
		baixo.setVizinhoCima(meio);
		baixo.setVizinhoDireita(baixoDireita);
		//baixo.setVizinhoBaixo(null);
		baixo.setVizinhoEsquerda(baixoEsquerda);
		
		baixoDireita.setVizinhoCima(meioDireita);
		//baixoDireita.setVizinhoDireita(null);
		//baixoDireita.setVizinhoBaixo(null);
		baixoDireita.setVizinhoEsquerda(baixo);
	}

	public List<Peca> getPecas() {
		return pecas;
	}
	
	public Peca getCoringa() {
		for(Peca peca : pecas) {
			if (peca.isCoringa())
				return peca;
		}
		
		return null;
	}
}
