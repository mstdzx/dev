package AntV2;

import javax.swing.JLabel;

import LiveGame.Model;

public class Controll {

	ViewClass view;
	Board m;
	double repetitions = 1000000;

	private boolean state = true;
	//287469.
	public Controll(ViewClass v, Board m) {

		view = v;
		this.m = m;
		m.fillBoard();

	}

	public synchronized void doLogic() {

		// calibrationTest();
		for (int i = 0; i < repetitions; i++) {
	

			if (i % 11000 == 0) {
				m.fillBoard();
				m.ant.set(50, 50);

			}
			m.makeRound();

		}
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

	public  void synchUpdateGraphBoard() {

		// System.out.println(Thread.currentThread());

		for (int i = 0; i < repetitions; i++) {
	
			int x = m.getChangedPosition().getxPoz();
			int y = m.getChangedPosition().getyPoz();

			if (view.isAlive(x, y))
				view.killCell(view.getCell(x, y));
			else
				view.resurectCell(view.getCell(x, y));

		}

	}

	public void updateGraphBoard() {

		int x = m.getChangedPosition().getxPoz();
		int y = m.getChangedPosition().getyPoz();

		if (view.isAlive(x, y))
			view.killCell(view.getCell(x, y));
		else
			view.resurectCell(view.getCell(x, y));

	}

	public void calibrationTest() {

		view.resurectCell(view.getCell(0, 0));
		view.resurectCell(view.getCell(0, m.Y - 1));
		view.resurectCell(view.getCell(m.X - 1, 0));
		view.resurectCell(view.getCell(m.X - 1, m.Y - 1));

	}

}
