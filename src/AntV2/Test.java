package AntV2;

public class Test {


	public static void main(String[] args) {
		
		ViewClass v = new ViewClass();
		Board m = new Board();
		Controll c = new Controll(v, m);
		
		//v.addListener(new ButtonListener());
		double start = System.currentTimeMillis();
		
//		LogicThread lt = new LogicThread(c);
//		GraphThread gt = new GraphThread(c);
//		
//		
//		try {
//			lt.t.join();
//			gt.t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		System.out.println("skonczylem watek glowny");
		
		
		for (int i = 0; i < 2000; i++) {
			
			m.makeRound();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.updateGraphBoard();
		
			
			
		}
		 
		System.out.println(System.currentTimeMillis() - start);
		

		
		

	}

}
