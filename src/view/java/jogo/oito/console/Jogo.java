package jogo.oito.console;

import java.util.Scanner;

import jogo.oito.JogoDoOito;
import jogo.oito.entidade.Movimentos;

public class Jogo {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		JogoDoOito jogo = new JogoDoOito();
		
		System.out.println("-------------TABULEIRO-------------");
		ConsoleInterface.printBoard(jogo);
		
		jogo.moveUp();		
		System.out.println("----------------MOVER PARA CIMA-----------------");
		ConsoleInterface.printBoard(jogo);
		
		jogo.moveRight();
		System.out.println("---------------MOVER PARA DIREITA---------------");
		ConsoleInterface.printBoard(jogo);
		
		jogo.moveDown();
		System.out.println("---------------MOVER PARA BAIXO----------------");
		ConsoleInterface.printBoard(jogo);
		
		jogo.moveLeft();
		System.out.println("---------------MOVER PARA ESQUERDA----------------");
		ConsoleInterface.printBoard(jogo);
				
		while (jogo.isGameOver() == false) {		
			System.out.print("\n\nEscolha entre CIMA - DIREITA - BAIXO - ESQUERDA: ");
			String direction = scan.nextLine();
			
			System.out.println("\n********** Você moveu para " + direction +  " **********");
			jogo.mover(Movimentos.valueOf(direction.toUpperCase().trim()));
			ConsoleInterface.printBoard(jogo);
		}
		
		System.out.println("\n\n--- PARABENS, VOCE VENCEU! ---");
		scan.close();
	}
	
}
