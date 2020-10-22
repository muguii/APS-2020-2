package jogo.oito.console;

import java.util.Scanner;

import jogo.oito.JogoDoOito;

public class AplicacaoConsole {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		JogoDoOito jogo = new JogoDoOito();
		
		System.out.println("------------- TABULEIRO -------------");
		ConsoleInterface.imprimirTabuleiro(jogo);
		
		jogo.moverParaCima();		
		System.out.println("\n\n------------- MOVER PARA CIMA -------------");
		ConsoleInterface.imprimirTabuleiro(jogo);
		
		jogo.moverParaDireita();
		System.out.println("\n\n------------- MOVER PARA DIREITA -------------");
		ConsoleInterface.imprimirTabuleiro(jogo);
		
		jogo.moverParaBaixo();
		System.out.println("\n\n------------- MOVER PARA BAIXO -------------");
		ConsoleInterface.imprimirTabuleiro(jogo);
		
		jogo.moverParaEsquerda();
		System.out.println("\n\n------------- MOVER PARA ESQUERDA -------------");
		ConsoleInterface.imprimirTabuleiro(jogo);
				
		scan.close();
	}
	
}
