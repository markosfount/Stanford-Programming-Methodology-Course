import stanford.karel.SuperKarel;

public class KarelProtectsDemocracy extends SuperKarel {
	
	public void run(){
		turnLeft();
		move();
		move();
		turnRight();
		
		while (frontIsClear())
		{
			goToBallot();
		
			if (beepersPresent()){
				goBet();
			}
			else{
				pickBall();
			}
		}
	}
	
	//from inbetween ballots goes inside
	private void goToBallot(){
		move();
	}
	
	//moves again to be in position between ballots, to execute gotoBAllot
	private void goBet(){
		move();
	}
	
	//goes both ways picking up any nb of beepers, then returns to between position
	
	private void pickBall(){
		turnLeft();
		move();
		while (beepersPresent())
			pickBeeper();
		turnAround();
		move();
		move();
		while (beepersPresent())
			pickBeeper();
		turnAround();
		move();
		turnRight();
	}
}
