import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Robot extends GraphicsProgram {
	
	private static final double HEAD_WIDTH=200;
	private static final double HEAD_HEIGHT=300;
	private static final double EYE_RADIUS=20;
	private static final double MOUTH_WIDTH=100;
	private static final double MOUTH_HEIGHT=40;
	
	public void run(){
		double width=getWidth();
		double height=getHeight();
		//HEAD
		GRect head=new GRect(width/2-HEAD_WIDTH/2,height/2-HEAD_HEIGHT/2,HEAD_WIDTH,HEAD_HEIGHT);
		head.setFilled(true);
		head.setColor(Color.BLACK);
		head.setFillColor(Color.GRAY);
		add(head);
		
		//EYES
		GOval eye=new GOval(width/2-HEAD_WIDTH/2 + HEAD_WIDTH/4 -EYE_RADIUS ,height/2-HEAD_HEIGHT/2 + HEAD_HEIGHT/4 - EYE_RADIUS ,EYE_RADIUS*2,EYE_RADIUS*2);
		eye.setFilled(true);
		eye.setColor(Color.YELLOW);
		eye.setFillColor(Color.YELLOW);
		add(eye);
		
		GOval eye2=new GOval(width/2-HEAD_WIDTH/2 + 3*HEAD_WIDTH/4 -EYE_RADIUS ,height/2-HEAD_HEIGHT/2 + HEAD_HEIGHT/4 - EYE_RADIUS ,EYE_RADIUS*2,EYE_RADIUS*2);
		eye2.setFilled(true);
		eye2.setColor(Color.YELLOW);
		eye2.setFillColor(Color.YELLOW);
		add(eye2);
		
		//MOUTH
		GRect mouth=new GRect(width/2-HEAD_WIDTH/2 +HEAD_WIDTH/2 - MOUTH_WIDTH/2 ,height/2-HEAD_HEIGHT/2 + HEAD_HEIGHT -HEAD_HEIGHT/4 -MOUTH_HEIGHT/2,MOUTH_WIDTH,MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		mouth.setFillColor(Color.WHITE);
		add(mouth);
		
	}

}
