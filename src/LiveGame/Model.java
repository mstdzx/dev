package LiveGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

	private static final int X = 25;
	private static final int Y = X;

	private Cell[][] board = new Cell[X][Y];
	private Integer neighbours[][] = new Integer[X][Y];
	private List<Position> changed = new ArrayList<>();

	public int[][] startTab = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
			{ 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 } };

	public int[][] gilder = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 } };

	public List<Position> getChanged() {
		return changed;
	}

	public Cell[][] getBoard() {
		return board;
	}



	public void fillBoard() {

		Random r = new Random();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				board[i][j] = new Cell(r.nextBoolean());

			}

		}

	}


	public void fillBoard(int[][] startTab) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (startTab[i][j] == 0)
					board[i][j] = new Cell(false);
				else
					board[i][j] = new Cell(true);

			}

		}

	}

	public <T> void print(T[][] tab) {

		for (int i = 0; i < tab.length; i++) {

			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j] + " ");
			}

			System.out.println();

		}

	}



	boolean value = false;

	public synchronized void updateColofCells() {

		if (!value)

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		changed.removeAll(changed);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i].isAlife()) {
					if (neighbours[j][i] > 3 || neighbours[j][i] < 2) {
						board[j][i].changeState();
						changed.add(new Position(j, i));
					}
				} else if (!board[j][i].isAlife()) {
					if (neighbours[j][i] == 3) {
						board[j][i].changeState();
						changed.add(new Position(j, i));
					}
				}
				notify();
			}

		}
		value = false;
		//print(board);

	}

	public synchronized void chceckStates() {

		if (value)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				neighbours[j][i] = checkNeighbours(j, i);
				if (i + j > 1)
					notify();
			}

		}

		value = true;

	}

	public void countNeighbours(int from, int to) {

		for (int i = from; i < to; i++)
			chceckState(i);

		print(neighbours);
	}

	public void chceckState(int col) { 

		for (int i = 0; i < board.length; i++) {

			neighbours[i][col] = checkNeighbours(i, col);

		}

	}

	private int checkNeighbours(int x, int y) {

		int neighbourCount = 0;

		for (int i = x - 1; i < x + 2; i++) {
			for (int j = y - 1; j < y + 2; j++) {

				if (i < 0)
					i = 0;
				if (j < 0)
					j = 0;
				if (i == board.length)
					break;
				if (j == board[i].length)
					break;
				if (i == x && j == y)
					continue;
				if (board[i][j].isAlife())

					neighbourCount += 1;

			}

		}
		return neighbourCount;
	}



}
