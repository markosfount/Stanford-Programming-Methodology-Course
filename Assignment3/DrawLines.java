
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram {
	
	public void run(){
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e){
		xclick=e.getX();
		yclick=e.getY();
		line=new GLine(xclick,yclick,xclick,yclick);
		add(line);
	}
	
	public void mouseDragged(MouseEvent e){
		//GLine line=new GLine(xclick,yclick,e.getX(),e.getY());
		//add(line);
		line.setEndPoint(e.getX(),e.getY());
	}
	
	
	//instance variables to store coordinates of click
	private GLine line;
	int xclick;
	int yclick;
}
