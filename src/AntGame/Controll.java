package AntGame;

import javax.swing.JLabel;

import LiveGame.Model;

public class Controll {

	ViewClass view;
	Board m;

	public Controll(ViewClass v, Board m) {

		view = v;
		this.m = m;
		m.fillBoard();

	}

	public void doLogic() {

		// calibrationTest();
		

			m.makeRound();
			
			// try {
			// Thread.sleep(10);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

		

	}
	
	
	

	private void updateBoard() {

		int ilength = m.X;
		int jlength = m.Y;

		for (int i = 0; i < ilength; i++) {
			for (int j = 0; j < jlength; j++) {

				// System.out.println(i+" "+j);

				if (m.getBoard()[i][j].isAlife())
					view.resurectCell(view.getCell(i, j));
				else
					view.killCell(view.getCell(i, j));

			}
		}

	}

	public synchronized void updateGraphBoard() {
		
		System.out.println(Thread.currentThread());
		if(Board.state)
			try {
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int x = m.getChangedPosition().getxPoz();
		int y = m.getChangedPosition().getyPoz();

		if (view.isAlive(x, y))
			view.killCell(view.getCell(x, y));
		else
			view.resurectCell(view.getCell(x, y));
		
		Board.state = true;

		notify();
		
		
		
	}

	public void calibrationTest() {

		view.resurectCell(view.getCell(0, 0));
		view.resurectCell(view.getCell(0, m.Y - 1));
		view.resurectCell(view.getCell(m.X - 1, 0));
		view.resurectCell(view.getCell(m.X - 1, m.Y - 1));

	}

}
