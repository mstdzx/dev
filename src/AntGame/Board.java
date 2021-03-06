package AntGame;

import java.util.Random;

import AntGame.Ant.Direction;
import LiveGame.Cell;

public class Board {
	
	public static boolean state = true;

	static final int X = 25;
	static final int Y = X;
	private Position changedPosition = new Position(0, 0);



	public Cell[][] board = new Cell[X][Y];

	public Cell[][] getBoard() {
		return board;
	}

	private Ant ant = new Ant(X / 2, Y / 2, Direction.left);
	private Ant ant2 = new Ant(X / 2 + 2, Y / 2, Direction.right);

	private void updateCell(Ant a) {

		int x, y;

		x = a.getPosition().getxPoz();
		y = a.getPosition().getyPoz();

		board[x][y].changeState();
		
		changedPosition.setxyPoz(x, y);
	}
	
	public Position getChangedPosition() {
		return changedPosition;
	}
	
	

	public void moveAnt(Ant a) {

		switch (a.getDir()) {

		case left:
			a.getPosition().setxyPoz(a.getPosition().getxPoz(),
					a.getPosition().getyPoz() - 1);
			break;
		case right:
			a.getPosition().setxyPoz(a.getPosition().getxPoz(),
					a.getPosition().getyPoz() + 1);
			break;
		case up:
			a.getPosition().setxyPoz(a.getPosition().getxPoz() - 1,
					a.getPosition().getyPoz());
			break;
		case down:
			a.getPosition().setxyPoz(a.getPosition().getxPoz() + 1,
					a.getPosition().getyPoz());
			break;

		}

	}

	public synchronized void makeRound() {

		System.out.println(Thread.currentThread());
		print(board);		
		
		if(!state)
			try {
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		moveAnt(ant);
		updateCell(ant);
		updateDir(ant);
		
		state = false;
		notify();
		
	

	}

	private void updateDir(Ant a) {

		int x, y;

		x = a.getPosition().getxPoz();
		y = a.getPosition().getyPoz();

		if (board[x][y].isAlife())
			a.rightTurn();
		else
			a.leftTurn();

	}

	public void fillBoard() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				board[i][j] = new Cell(false);

			}

		}

	}

	public <T> void print(T[][] tab) {

		for (int i = 0; i < tab.length; i++) {

			for (int j = 0; j < tab[i].length; j++) {

				if (i == ant.getPosition().getxPoz()
						&& j == ant.getPosition().getyPoz()) {
					System.out.print("@ ");
					continue;
				}
				System.out.print(tab[i][j] + " ");

			}

			System.out.println();

		}
		System.out.println();

	}



}
