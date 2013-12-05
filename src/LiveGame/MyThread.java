package LiveGame;

public class MyThread implements Runnable{

	private Thread t ;
	private Controll c;
	
	MyThread(Controll c){
		
		t = new Thread(this);
		
		this.c= c;
		
		t.start();
		
	}
	
	
	
	
	public void run() {
		
		for (int i = 0; i < 500; i++) 
		c.start1();
		
	}

	

}
