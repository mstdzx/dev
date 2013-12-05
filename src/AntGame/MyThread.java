package AntGame;

public class MyThread implements Runnable {

	Thread t;
	Controll c;

	MyThread(Controll c) {

		t = new Thread(this,"mytred");

		this.c = c;

		t.start();

	}

	public void run() {

		for (int i = 0; i < 11000; i++)
			c.updateGraphBoard();

	}

}
