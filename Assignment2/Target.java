/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	
	private static final double EXRADIUS=72;				//radiuses of 3 circles
	private static final double MIDRADIUS=0.65*EXRADIUS;
	private static final double LOWRADIUS=0.3*EXRADIUS;
	
	public void run() {
		int height=getHeight();
		int width=getWidth();
		
		GOval outcir=new GOval(width/2-EXRADIUS,height/2-EXRADIUS, EXRADIUS*2,EXRADIUS*2);
		outcir.setFilled(true);
		outcir.setFillColor(Color.RED);
		outcir.setColor(Color.RED);
		add(outcir);
		
		GOval midcir=new GOval(width/2-MIDRADIUS,height/2-MIDRADIUS, MIDRADIUS*2,MIDRADIUS*2);
		midcir.setFilled(true);
		midcir.setFillColor(Color.WHITE);
		midcir.setColor(Color.WHITE);
		add(midcir);
		
		GOval lowcir=new GOval(width/2-LOWRADIUS,height/2-LOWRADIUS, LOWRADIUS*2,LOWRADIUS*2);
		lowcir.setFilled(true);
		lowcir.setFillColor(Color.RED);
		lowcir.setColor(Color.RED);
		add(lowcir);
		
	
	}
}
