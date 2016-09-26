/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final int LWIDTH=120;
	private static final int LHEIGHT=40;
	private static final int CLENGTH=100;
	
	public void run() {
		
		int width=getWidth();
		int height=getHeight();
		
		// Rectangles
		GRect middle=new GRect((width/2)-LWIDTH/2,(height/2) +CLENGTH/2  ,LWIDTH,LHEIGHT);
		add(middle);
		
		GRect left=new GRect((width/2)-LWIDTH/2 - LWIDTH-20,(height/2)+ CLENGTH/2  ,LWIDTH,LHEIGHT);
		add(left);
		
		GRect right=new GRect((width/2)-LWIDTH/2 + LWIDTH + 20,(height/2)+ CLENGTH/2  ,LWIDTH,LHEIGHT);
		add(right);
		
		GRect upper=new GRect((width/2)-LWIDTH/2 ,(height/2) -CLENGTH/2 - LHEIGHT  ,LWIDTH,LHEIGHT);
		add(upper);
		
		//Lines
		GLine mid=new GLine((width/2),(height/2)+ CLENGTH/2,(width/2),(height/2)- CLENGTH/2);
		add(mid);
		
		GLine lef=new GLine((width/2 - LWIDTH-20),(height/2)+ CLENGTH/2,(width/2),(height/2)- CLENGTH/2);
		add(lef);
		
		GLine rig=new GLine((width/2) + LWIDTH + 20,(height/2)+ CLENGTH/2,(width/2),(height/2)- CLENGTH/2);
		add(rig);
		
		//Labels
		GLabel ll=new GLabel("GraphicsProgram",(width/2)-LWIDTH/2 - LWIDTH-20,(height/2)+ CLENGTH/2  );
		double llw=ll.getWidth();
		double llh=ll.getHeight();
		ll.move((LWIDTH-llw)/2, + LHEIGHT/2+llh/2);
		add(ll);
		
		GLabel lm=new GLabel("ConsoleProgram",(width/2)-LWIDTH/2,(height/2)+ CLENGTH/2);
		double lmw=lm.getWidth();
		double lmh=lm.getHeight();
		lm.move((LWIDTH-lmw)/2, LHEIGHT/2+lmh/2);
		add(lm);
		
		GLabel lr=new GLabel("DialogProgram",(width/2)-LWIDTH/2 + LWIDTH + 20,(height/2)+ CLENGTH/2 );
		double lrw=lr.getWidth();
		double lrh=lr.getHeight();
		lr.move((LWIDTH-lrw)/2, LHEIGHT/2+lrh/2);
		add(lr);
		
		GLabel lu=new GLabel("Program",(width/2)-LWIDTH/2,(height/2) -CLENGTH/2 );
		double luw=lu.getWidth();
		double luh=lu.getHeight();
		lu.move((LWIDTH-luw)/2, -LHEIGHT/2 +luh/2);
		add(lu);
		
		
		/*Center
		GOval cir=new GOval(width/2,height/2, 1,1);
		cir.setFilled(true);
		cir.setFillColor(Color.BLACK);
		cir.setColor(Color.BLACK);
		add(cir);
		*/
		
	}
}

