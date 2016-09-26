/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW+1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	
	public void run() {
	
		setup();
		addMouseListeners();
		//run ball bouncing
		while (remTurns>0 && brickCount<NBRICKS_PER_ROW*NBRICK_ROWS){
			moveBall();
			checkBoundaries();
			checkCollision();
			pause(10);
		}
		
		GLabel endMess;
		if (remTurns>0){
			remove(ball);
			endMess=new GLabel("Congratulation! You finished the game!");
		}
		else
			endMess=new GLabel("We are sorry, game over");
		
		endMess.setFont(new Font("Sans Serif",Font.BOLD , 18));
		endMess.setLocation(width/2 - endMess.getWidth()/2,height/2 - endMess.getAscent()/2);
		add(endMess);
	}
	
	//Sets up the bricks and paddle
	private void setup(){
		//get window dimensions
		width=getWidth();
		height=getHeight();
		
		remTurns=NTURNS;
		setBricks();
		writeTurns();
		createPaddle();
		createBall();
		setBallSpeed();
	}
	
	//Creates bricks
	private void setBricks(){
		for (int i=0; i<NBRICK_ROWS; i++){
			Color color;
			if (i==0 || i==1)
				color=Color.RED;
			else if (i==2 || i==3)
				color=Color.ORANGE;
			else if (i==4 || i==5)
				color=Color.YELLOW;
			else if (i==6 || i==7)
				color=Color.GREEN;
			else 
				color=Color.CYAN;
				
			createRow(i,color);	
		}
	}
	
	//Creates a row of bricks
	private void createRow(int numrow,Color color){
		for (int i=0; i<NBRICKS_PER_ROW; i++){
			
			int x=(i+1)*BRICK_SEP + i*BRICK_WIDTH;
			if (i>=5)
				x+=6;
			int y=(numrow+1)*BRICK_SEP + numrow*BRICK_HEIGHT;
			
			GRect brick=new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
			brick.setFilled(true);
			brick.setColor(color);
			brick.setFillColor(color);
			add(brick);
		}
	}
	
	private void writeTurns(){
		turnLabel=new GLabel("Turns Left: " + remTurns);
		turnLabel.setLocation(0,height - turnLabel.getAscent());
		add(turnLabel);
	}
	
	//Creates the paddle at the bottom of the screen
	private void createPaddle(){
		paddle=new GRect(width/2-PADDLE_WIDTH/2,height-PADDLE_HEIGHT,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}
	
	//Defines movement of paddle along with mouse
	public void mouseMoved(MouseEvent e){
		int mousex=e.getX();

		if (mousex>width-PADDLE_WIDTH/2)
			mousex=(int)width-PADDLE_WIDTH/2;
		else if (mousex<PADDLE_WIDTH/2)
			mousex=PADDLE_WIDTH/2;
		paddle.setLocation(mousex-PADDLE_WIDTH/2, height-PADDLE_HEIGHT);
		
	}
	
	//Creates bouncing ball
	public void createBall(){
		ball= new GOval(width/2 - BALL_RADIUS, height/2 - BALL_RADIUS,BALL_RADIUS,BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
	}
	
	public void setBallSpeed(){
		yvel=3.0;
		xvel=rgen.nextDouble(1.0,3.0);
		if (rgen.nextBoolean())
			xvel=-xvel;
	}
	
	public void moveBall(){
		ball.move(xvel,yvel);
	}
	
	public void checkBoundaries(){
		double x=ball.getX();
		double y=ball.getY();
		
		//left and right
		if (x>=width-BALL_RADIUS*2 || x<=0)
			xvel=-xvel;
		
		//up 
		if ( y<=0)
			yvel=-yvel;
		
		//bottom
		if (y> height - BALL_RADIUS * 2){
			remove(ball);
			remTurns--;
			turnLabel.setLabel("Turns Left: " + remTurns);
			if (remTurns>0){
				pause(1000);
				createBall();
				setBallSpeed();
			}
		}
	}
	
	public void checkCollision(){
		GObject collider=checkAllCorners();
		
		if (collider!=null && collider!=turnLabel){
			if (collider==paddle)
				yvel=-yvel;
			else {
				remove(collider);
				brickCount++;
				yvel=-yvel;
			}
		}
	}
	
	public GObject checkAllCorners(){
		//check all corners of square of ball to see if they collide
		double x;
		double y;
		
		//upper left
		x=ball.getX(); 
		y=ball.getY();
		obj=getElementAt(x,y);
		if (obj!=null)
			return obj;
		//upper right
		x=ball.getX() + 2*BALL_RADIUS;
		y=ball.getY();
		obj=getElementAt(x,y);
		if (obj!=null)
			return obj;
		//bottom left
		x=ball.getX();
		y=ball.getY() + 2*BALL_RADIUS;
		obj=getElementAt(x,y);
		if (obj!=null)
			return obj;
		//bottom left
		x=ball.getX() + 2 * BALL_RADIUS;
		y=ball.getY() + 2* BALL_RADIUS;
		return(getElementAt(x,y));
	}
	
	
	
	//private GRect brick;
	private GRect paddle;
	private GOval ball;
	private GObject obj;
	private GLabel turnLabel;
	
	private double width;
	private double height;
	
	private double xvel;
	private double yvel;
	
	private int remTurns;
	private int brickCount;
	
	private RandomGenerator rgen=new RandomGenerator();
}
