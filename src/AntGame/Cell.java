package AntGame;

public class Cell {
	
	
	public Cell(boolean live){
		
		this.live = live;
		
	}

	private boolean live;
	
	public boolean isAlife(){
		
		return live;
		
	}
	
	public void changeState(){
		
		this.live = !live;
		
	}
	
	
	public String toString(){
		
		if(isAlife())
			return "x";
		else
			return"-";
		
	}
	
	
	
	
}
