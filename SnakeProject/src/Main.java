import javax.swing.JFrame;

public class Main {

	public Main() {
		
		JFrame frame = new JFrame();
		GamePanel gamepanel = new GamePanel();
		
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SNAKE");
		
		frame.pack();
		frame.setVisible(true); 
		frame.setLocationRelativeTo(null);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main();
	}

}
