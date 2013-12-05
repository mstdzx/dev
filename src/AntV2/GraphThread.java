package AntV2;

public class GraphThread implements Runnable {

	Thread t;
	Controll c;

	GraphThread(Controll c) {

		t = new Thread(this, "graph");

		this.c = c;

		t.start();

	}

	public void run() {

		
		
			c.synchUpdateGraphBoard();
			
		
	}

}
