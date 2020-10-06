package jogo.oito.console;

import jogo.oito.JogoDoOito;
import jogo.oito.entidade.Peca;

public class ConsoleInterface {
	
	public static void printBoard(JogoDoOito jogo) {
		Peca[][] pecas = jogo.getPecasDoTabuleiro();
		
		for (int i = 0; i < pecas.length; i++) {
			for (int j = 0; j < pecas.length; j++) {
				printPeca(pecas[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void printPeca(Peca peca) {
		if (peca.getValor() != 0) {
			System.out.print(peca.getValor() + " ");
		} else {
			System.out.print("- ");
		}
	}
}
