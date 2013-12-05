package LiveGame;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ViewClass {

	private JFrame frame;
	private JPanel panel;
	private JLabel jl;

	private final int X = 25;
	private final int Y = X;
	private final int cellSize = 10;

	private ImageIcon dead = new ImageIcon("dead.jpg");
	private ImageIcon alive = new ImageIcon("alive.jpg");
	private JButton btnNewButton;

	

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewClass window = new ViewClass();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public ViewClass() {
		initialize();
		this.frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 394, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(27, 11, 323, 298);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		

		addCells();
	}
	
	public void addListener(ActionListener l){
		
		btnNewButton.addActionListener(l);
		
	}

	private void addCells() {

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {

				JLabel jl = new JLabel(dead);
				jl.setSize(cellSize, cellSize);
				
				jl.setLocation(10 + i*cellSize, 10 + j*cellSize);

				panel.add(jl);
			}
		}

	}
	
	public JLabel getCell(int y, int x){
		
		jl = (JLabel)panel.getComponentAt(10 + (cellSize/2) + (cellSize*x), 10 + (cellSize/2)+ (cellSize*y));
		
		return jl;
		
	}
	
	
	public void resurectCell(JLabel cell){
		
		
		if (cell.getIcon().equals(dead))

			cell.setIcon(alive);
	
		
	}
	
	public void killCell(JLabel cell){
		
		
		if (cell.getIcon().equals(alive))

			cell.setIcon(dead);
	
		
	}
	
	
	public boolean isAlive(int y , int x){
		
		JLabel jl = (JLabel)panel.getComponentAt(10 + cellSize/2 + cellSize*x, 10 + cellSize/2 + cellSize*y);
		
		if (jl.getIcon().equals(alive))
			return true;
		else 
			return false;
	}
}
