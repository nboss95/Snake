import java.awt.*;				//import java.awt.Graphics
import java.awt.event.*;  		//import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;																			//How big the Objects in this game
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/ UNIT_SIZE;										//How many Objects can fit on the screen
	static final int DELAY = 75;																				// The higher the number, the slower the game
	final int x[] = new int[GAME_UNITS];																		//the Coordinates for all bodyparts of the snake including his head. Snake isnt going to be bigger then the game itself(thats why:[GAME_UNITS])
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;																							// begin with 6 bodyparts of the snake 
	int applesEaten;
	int appleX;																									// x Coordinate of where the apple is going to appear
	int appleY;
	char direction = 'R'; 																						//R for right, L for left ..
	boolean running = false;
	Timer timer;
	Random random;
	
	
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
		
	}
		
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	public void draw(Graphics g) {
		
		for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		}
		g.setColor(Color.red);
		g.fillOval(appleX, appleX, UNIT_SIZE, UNIT_SIZE);
		
		for (int i = 0; i < bodyParts; i++) {
			if(i == 0) {
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			else {
				g.setColor(new Color(45,180,0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

			}
		}
	}
	
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		
	}
	
	public void move() {
		for(int i = bodyParts; i>0;i--)
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':												//U for Up
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':												// D for Down
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':												// L for Left
			x[0] = x[0] - UNIT_SIZE;
		case 'R':												//R for Right
			x[0] = x[0] + UNIT_SIZE;
			
		}
		}
	
	public void checkApple() {
		
	}
	
	public void checkCollisions() {
		
	}
	
	public void gameOver(Graphics g) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			
		}
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}
}
