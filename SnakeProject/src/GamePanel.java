import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 500, HEIGHT = 500;

	private Thread thread;
	
	private boolean running;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	private int xColor = 10, yColor = 10, size = 5;
	private int ticks = 0;
	
	public GamePanel() {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		snake = new ArrayList<BodyPart>();
	}
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tick() {
		if(snake.size() == 0) {
			b = new BodyPart(xColor, yColor, 10);
			snake.add(b);
		}
		ticks++;
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, HEIGHT, WIDTH);	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, HEIGHT, WIDTH);
		
		for(int i = 0; i<WIDTH/10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		for(int i = 0; i<HEIGHT/10; i++) {
			g.drawLine( 0, i * 10, HEIGHT, i * 10 );
		}
		for(int i = 0; i< snake.size(); i++) {
			snake.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		
		while(running) {
			tick();
			repaint();
		}
	}
}
