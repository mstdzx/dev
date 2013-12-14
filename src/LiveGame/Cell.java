package LiveGame;
/*
 * 
 * 
 *  Cell class
 * 
 *
 * 
 */
public class Cell {

	private boolean live;
	
	public Cell(boolean live) {
		this.live = live;
	}//master

	public boolean isAlife() {
		return live;
	}//m1

	public void changeState() {
		this.live = !live;
	}

	public String toString() {

		if (isAlife())
			return "x";
		else
			return "-";
	}//c4

}//c5

class Position {

	private int xPoz;
	private int yPoz;

	Position(int x, int y) {
		xPoz = x;
		int xx= 4;
	}

	public int getxPoz() {
		return xPoz;
	}

	public void setxyPoz(int x, int y) {
		int k = 4;
		xPoz = 5;
		yPoz = 2;
		//comment 1
		//coment3
	}

	public int getyPoz() {
		return yPoz;
		//coment2
	}
}
