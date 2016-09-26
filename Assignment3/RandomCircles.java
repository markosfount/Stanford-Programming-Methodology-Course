/*Creates 10 circles with random
**radius and random color and prints 
**them on the canvas
*/

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram{
	
	//minimum radius of circle
	public static final int MIN_RADIUS=1;
	//maximum radius of circle
	public static final int MAX_RADIUS=50;
	
	public void run(){
		
		int winWidth=getWidth();
		int winHeight=getHeight();
		
		for (int i=0; i<10; i++){
			createCircle(winWidth,winHeight);
		}
	}
	
	public void createCircle(int width, int height){
		//get random radius
		int radius=rgen.nextInt(MIN_RADIUS,MAX_RADIUS);
		GOval randomCir=new GOval(radius*2,radius*2);
		
		//get random x position
		int x=rgen.nextInt(0,width-radius*2);
		
		//get random y position
		int y=rgen.nextInt(0,height-radius*2);
		
		//set circle location
		randomCir.setLocation(x, y);
		
		randomCir.setFilled(true);
		
		//set random color
		Color rancol=rgen.nextColor();
		randomCir.setFillColor(rancol);
		randomCir.setColor(rancol);
		
		
		add(randomCir);
	}
	
	//instance variable
	RandomGenerator rgen=new RandomGenerator();
}
