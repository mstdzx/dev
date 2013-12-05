package LiveGame;

public class ModelTest {

	static Model m = new Model();
	static ViewClass v = new ViewClass();
	static Controll c = new Controll(v, m);

	public static void main(String[] args) {

		

		new MyThread(c);

		for (int i = 0; i < 500; i++){
		c.start2();
		
		}
		
	}

}
