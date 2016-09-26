/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.SuperKarel;

public class CheckerboardKarel extends SuperKarel {

	public void run(){
		fillEvenRow();
		while (leftIsClear()){
				get2OddPos();
				fillOddRow();
			if (rightIsClear()){
				get2EvenPos();
				fillEvenRow();
			}
			else
				break;
		}
	}	
	
	// Karel is at corner of even row facing east without necessarily having space in front
	private void fillEvenRow(){
		putBeeper();
		while (frontIsClear()){
			if (beepersPresent())
				move();
			else{
				move();
				putBeeper();
			}
		}
	}
	
	//Karel is at the end corner of even row
	private void get2OddPos(){
		turnLeft();
		if (beepersPresent()){
			move();
			turnLeft();
		}
		else{
			move();
			turnLeft();
			putBeeper();
		}
	}
	
	//Karel is at the rar east corner of odd row
	private void fillOddRow(){
		while (frontIsClear()){
			if (beepersPresent())
				move();
			else{
				move();
				putBeeper();
			}
		}
	}
	
	private void get2EvenPos(){
			turnRight();
			move();
			turnRight();
	}
}
