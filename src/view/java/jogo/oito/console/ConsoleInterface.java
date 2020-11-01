package jogo.oito.console;

import java.util.List;

import jogo.oito.JogoDoOito;
import jogo.oito.entidade.Peca;

public class ConsoleInterface {
	
	public static void imprimirTabuleiro(JogoDoOito jogo) {
		List<Peca> pecas = jogo.getTabuleiro().getPecas();
		
		for(int i = 0; i < pecas.size(); i++) {
			imprimirPeca(pecas.get(i));
			if (i == 2 || i == 5) {
				System.out.println();
			}
		}
	}
	
	private static void imprimirPeca(Peca peca) {
		System.out.print(peca.getValor() + " ");
	}
	
}
