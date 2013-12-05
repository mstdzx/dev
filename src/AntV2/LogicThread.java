package AntV2;

public class LogicThread implements Runnable {

	Thread t;
	Controll c;

	LogicThread(Controll c) {

		t = new Thread(this, "logic");

		this.c = c;

		t.start();

	}

	public void run() {

		
			c.doLogic();
		

	}

}
