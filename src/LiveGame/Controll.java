package LiveGame;

import javax.swing.JLabel;

import LiveGame.Model;

public class Controll {

	private ViewClass view;
	private Model m;

	public Controll(ViewClass v, Model m) {

		this.view = v;
		this.m = m;
		m.fillBoard();
		makeBoard();

	}

	private void makeBoard() {

		for (int i = 0; i < m.getBoard().length; i++) {
			for (int j = 0; j< m.getBoard()[i].length; j++) {

				if(m.getBoard()[i][j].isAlife())
					view.resurectCell(view.getCell(i, j));
				else
					view.killCell(view.getCell(i, j));
					
			}

		}

	}


	
	public void start1(){
		
		m.chceckStates();
		
	}
	
	public void start2(){
		
		m.updateColofCells();
		updateBoard();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	public void updateBoard() {

		int x, y;
		JLabel jl;

		for (Position z : m.getChanged()) {

			x = z.getxPoz();
			y = z.getyPoz();

			jl = view.getCell(x, y);

			if (view.isAlive(x, y))
				view.killCell(jl);
			else
				view.resurectCell(jl);

		}

	}

}
