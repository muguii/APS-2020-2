package jogo.oito;

import java.util.Random;

public class JogoOitoOLD {

	private Integer[][] board;
	private boolean gameOver;
	
	
	public JogoOitoOLD() {
		board = new Integer[3][3];
		gameOver = false;
		this.newGame();
	}

	private void newGame() {
		Integer values = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.board[i][j] = values;
				values++;
			}
		}
		
		this.mixBoard(18);
	}

	private void mixBoard(Integer times) {
		for (int i = 0; i < times; i++) {
			Integer pos1X = new Random().nextInt(3);
			Integer pos1Y = new Random().nextInt(3);
			Integer pos2X = new Random().nextInt(3);
			Integer pos2Y = new Random().nextInt(3);
			
			Integer aux = getValueByPostion(pos1X, pos1Y);
			this.board[pos1X][pos1Y] = getValueByPostion(pos2X, pos2Y);
			this.board[pos2X][pos2Y] = aux;
		}
	}
	
	public void move(String direction) {
		direction = direction.toUpperCase();
		switch(direction) {
		case "CIMA":
			moveUp();
			break;
		case "DIREITA":
			moveRight();
			break;
		case "BAIXO":
			moveDown();
			break;
		case "ESQUERDA":
			moveLeft();
			break;
		default:
			System.out.println("Voce digitou errado a direção desejada. \n"
					+ "Escolha entre: CIMA - DIREITA - BAIXO - ESQUERDA");
		}
	}
	
	public void moveUp() {
		Integer[] source = this.getPositionByValue(0);
		Integer[] target = new Integer[2];
		
		if (source[0] != 0) {
			target[0] = source[0] - 1;
			target[1] = source[1];
			
			changePlaces(source, target);
			checkWin();		
		}
	}

	public void moveRight() {
		Integer[] source = this.getPositionByValue(0);
		Integer[] target = new Integer[2];
		
		if (source[1] != 2) {
			target[0] = source[0];
			target[1] = source[1] + 1;
			
			changePlaces(source, target);
			checkWin();	
		}
	}
	
	public void moveDown() {
		Integer[] source = this.getPositionByValue(0);
		Integer[] target = new Integer[2];
		
		if (source[0] != 2) {
			target[0] = source[0] + 1;
			target[1] = source[1];
			
			changePlaces(source, target);
			checkWin();	
		}
	}
	
	public void moveLeft() {
		Integer[] source = this.getPositionByValue(0);
		Integer[] target = new Integer[2];
		
		if (source[1] != 0) {
			target[0] = source[0];
			target[1] = source[1] - 1;
			
			changePlaces(source, target);
			checkWin();	
		}
	}
	
	private void changePlaces(Integer[] source, Integer[] target) {
		Integer aux = getValueByPostion(target[0], target[1]);
		this.board[source[0]][source[1]] = aux;
		this.board[target[0]][target[1]] = 0;
	}

	private void checkWin() {
		Integer values = 1;
		boolean state = true;
		
		first:
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 2 && j == 2) {
					values = 0;
				}
				
				if (this.board[i][j] != values) {
					state = false;
					break first;
				}
				
				values++;
			}
		}
		
		if (state == true) {
			gameOver = true;
		}
	}
	
	private Integer[] getPositionByValue(Integer value) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.board[i][j] == value) {
					Integer[] pos = new Integer[]{i, j};
					return pos;
				}
			}
		}		
		return null;
	}

	private Integer getValueByPostion(Integer x, Integer y) {
		return this.board[x][y];
	}
		
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.board[i][j] != 0) {
					System.out.print(this.board[i][j] + " ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
