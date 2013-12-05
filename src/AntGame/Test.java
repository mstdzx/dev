package AntGame;

public class Test {


	public static void main(String[] args) {
		
		ViewClass v = new ViewClass();
		Board m = new Board();
		Controll c = new Controll(v, m);
		
		//v.addListener(new ButtonListener());
		
		double start = System.currentTimeMillis();
		
		new MyThread(c);
		
		for (int i = 0; i < 11000; i++)
		c.doLogic();
		
		 
		System.out.println(System.currentTimeMillis() - start);
		

		
		

	}

}
