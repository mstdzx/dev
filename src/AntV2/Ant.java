package AntV2;

public class Ant {

	enum Direction {
		left, right, up, down
	};

	private Direction dir;
	private Position position;

	

	public Ant(int xpoz, int ypoz, Direction dir) {

		position = new Position(xpoz,ypoz);
		this.dir = dir;

	}

	public Position getPosition() {

		return position;

	}
	
	public int getPozX(){
		
		return this.position.getxPoz();
		
	}
	
	public int getPozY(){
		
		return this.position.getyPoz();
		
	}
	
	public void set(int xpoz, int ypoz){
		
		position.setxyPoz(xpoz, ypoz);
		
	}
	
	
	public Direction getDir() {
		return dir;
	}

	public void leftTurn() {

		switch (dir) {

		case left:
			this.dir = Direction.down;
			break;
		case right:
			this.dir = Direction.up;
			break;
		case up:
			this.dir = Direction.left;
			break;
		case down:
			this.dir = Direction.right;
			break;

		}

	}

	public void rightTurn() {

		switch (dir) {

		case left:
			this.dir = Direction.up;
			break;
		case right:
			this.dir = Direction.down;
			break;
		case up:
			this.dir = Direction.right;
			break;
		case down:
			this.dir = Direction.left;
			break;

		}

	}

}

class Position {

	private int xPoz;
	private int yPoz;

	Position(int x, int y){
		
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
