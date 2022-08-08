package brickbreak;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;
public class PongGameplay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = true;
	private Timer timer;
	private int delay = 8;
	private int playerX = 310;
	private int cpuX =310;
	
	private int ballPositionX = 120;
	private int ballPositionY= 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	public PongGameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer =  new Timer (delay, this);
		timer.start();

}
	public void paint (Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(1,1,692,592);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
//		g.setColor(Color.white);
//		g.setFont(new Font("serif",Font.BOLD,25));
//		g.drawString(""+score, 590, 30);
		
		//paddle
		g.setColor(Color.green);	
		g.fillRect(playerX, 550, 100, 8);
		
		//for another player
		g.setColor(Color.blue);
		g.fillRect(cpuX, 20, 100, 8);
		
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ballPositionX, ballPositionY, 20, 20);
		
		g.dispose();
		}
		
		public void actionPerformed(ActionEvent e) {
			timer.start();
			if(play) {
				if(new Rectangle(ballPositionX,ballPositionY,20,20).intersects(new Rectangle(playerX,550,100,8))){
					ballYdir=-ballYdir;
				}
				if(new Rectangle(ballPositionX,ballPositionY,20,20).intersects(new Rectangle(cpuX,20,100,8))){
					ballYdir=-ballYdir;}
				ballPositionX+=ballXdir;
				ballPositionY+=ballYdir;
				if(ballPositionX<0) {
					ballXdir = -ballXdir;
				}
				if(ballPositionY<0) {
					ballYdir = -ballYdir;
				}
				if(ballPositionX>670) {
					ballXdir = -ballXdir;
				}
				
				
			}
			
			repaint();}
		
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(!play) {
					play =true;
					ballPositionX=120;
					ballPositionY=350;
					ballXdir=-1;
					ballYdir=-2;
					cpuX=310;
					playerX=310;
					repaint();
				}
			}
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				if(playerX >=600) {
					playerX= 600;
				}
				else {
					moveRight();
				}
			}
	if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			if(playerX <10) {
				playerX= 10;
			}
			else {
				moveLeft();
		}
			}
	if(e.getKeyCode()== KeyEvent.VK_6) {
		if(cpuX>=600) {
			cpuX=600;
		}
		else {
			moveCPULeft();
		}
	}
	if(e.getKeyCode()== KeyEvent.VK_4) {
		if(cpuX<=10) {
			cpuX=10;
		}
		else {
			moveCPURight();
		}
	}
		
	
		}
		public void moveCPULeft() {
			play=true;
			cpuX+=20;
		}
		public void moveCPURight() {
			play=true;
			cpuX-=20;
		}
		
		public void moveRight() {
			play =true;
			playerX+=20;
		}
		public void moveLeft() {
			play=true;	
			playerX-=20;
		}
}