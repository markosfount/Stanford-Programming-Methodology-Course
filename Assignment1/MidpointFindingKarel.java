/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.SuperKarel;

public class MidpointFindingKarel extends SuperKarel {

	public void run(){
		if (frontIsBlocked()){
			putBeeper();
		}
		else{
			fillFirstRow();

			for (;0<1;){
				passRow();
				turn2Beep();
				
				if (beepersPresent())
					pickRoll();
				else{
					putBeeper();
					break;
				}
				
			}
		}
	}
	
	//fills 1st row except for 1st and last corner, ends with Karel at end -1 of 1st row facing west
	private void fillFirstRow(){		
		while (frontIsClear()){
			move();
			putBeeper();
		}
		turnAround();
		pickBeeper();
		move();
		
	}
	
	//goes through row to remove beeper at end
	//Karel is standing in far east or west corner with last beeper facing opposite
	//ends with Karel one corner away form last beeper
	private void passRow(){
		while (beepersPresent()&& frontIsClear()){
				move();
		}
	}
	
	private void turn2Beep(){
		turnAround();
		move();
	}
	
	private void pickRoll(){
		pickBeeper();
		move();
	}
	
	
}
