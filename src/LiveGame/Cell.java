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
	}

	public boolean isAlife() {
		return live;
	}

	public void changeState() {
		this.live = !live;
	}

	public String toString() {

		if (isAlife())
			return "x";
		else
			return "-";
	}

}

class Position {

	private int xPoz;
	private int yPoz;

	Position(int x, int y) {
		xPoz = x;
		yPoz = y;
	}

	public int getxPoz() {
		return xPoz;
	}

	public void setxyPoz(int x, int y) {
		xPoz = x;
		yPoz = y;
	}

	public int getyPoz() {
		return yPoz;
	}
}
