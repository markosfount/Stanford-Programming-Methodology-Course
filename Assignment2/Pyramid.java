/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		int height=getHeight();
		int width=getWidth();
		
		int startingpoint;
		if (BRICKS_IN_BASE/2==0)
			startingpoint=width/2-BRICK_WIDTH*BRICKS_IN_BASE/2;
		else
			startingpoint=width/2-BRICK_WIDTH*(BRICKS_IN_BASE/2) + BRICK_WIDTH/2;
		
		for (int i=0;i<BRICKS_IN_BASE;i++){
			for (int j=BRICKS_IN_BASE - i;j>0;j--){
				GRect brick=new GRect(0,0,BRICK_WIDTH,BRICK_HEIGHT);
				brick.setLocation(startingpoint+i*(BRICK_WIDTH/2)+(BRICKS_IN_BASE-j-i)*BRICK_WIDTH, height-(i+1)*BRICK_HEIGHT);
				add(brick);
				int a=5;
			}
		}
	}
}

