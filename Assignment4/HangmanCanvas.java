/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		width=300;
		height=600;
		
		drawScaffold();
		drawHanged();
		/*sets the wrongly guessed letter string
		 * that appears on the canvas as vacant
		 */
		wrong="";
		
		/*creates the label of the word that will
		 * be displayed, without initializing it
		 * the GLabel will be updated every time 
		 * with the displayWord method
		 */
		this.word=new GLabel("",50,height-50);
		this.word.setFont("Times-24");
		add(this.word);
		
		/*creates an empty label for the incorrect
		 * guesses. The label will be updated
		 * with the string "wrong" in the 
		 * noteUncorrectGuesses method
		 */
		wrongGuesses=new GLabel("",50,height-25);
		add(wrongGuesses);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		this.word.setLabel(word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		//if (wrong.indexOf(letter)<0)
		wrong+= letter;
		wrongGuesses.setLabel(wrong);
		int i=wrong.length();
		
		switch (i){
		case 1:
			add(head);
			break;
		case 2:
			add(body);
			break;
		case 3:
			add(leftarm1);
			add(leftarm2);
			break;
		case 4:
			add(rightarm1);
			add(rightarm2);
			break;
		case 5:
			add(leftleg1);
			add(leftleg2);
			break;
		case 6:
			add(rightleg1);
			add(rightleg2);
			break;
		case 7:
			add(leftfoot);
			break;
		case 8:
			add(rightfoot);
			break;
		}
	}
	
	private void drawScaffold(){
		
		rope=new GLine(width/2,height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS - ROPE_LENGTH,width/2,height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS);
		add(rope);
		beam=new GLine(width/2-BEAM_LENGTH,height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS - ROPE_LENGTH,width/2,height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS - ROPE_LENGTH);
		add(beam);
		scaffold=new GLine(width/2-BEAM_LENGTH,height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS - ROPE_LENGTH,width/2-BEAM_LENGTH,height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS - ROPE_LENGTH +SCAFFOLD_HEIGHT);
		add(scaffold);
	}
	
	private void drawHanged(){
		//head
		head=new GOval(width/2 - HEAD_RADIUS, height/2 - BODY_LENGTH/2 - 2*HEAD_RADIUS, 2*HEAD_RADIUS,2*HEAD_RADIUS);
		
		//body
		body=new GLine(width/2,height/2 - BODY_LENGTH/2,width/2,height/2 + BODY_LENGTH/2);
		
		//arms
		leftarm1=new GLine(width/2 - UPPER_ARM_LENGTH,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD,width/2,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD);
		
		leftarm2=new GLine(width/2 - UPPER_ARM_LENGTH,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD,width/2 - UPPER_ARM_LENGTH,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		
		rightarm1=new GLine(width/2,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD,width/2 + UPPER_ARM_LENGTH,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD);
		
		rightarm2=new GLine(width/2 + UPPER_ARM_LENGTH,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD,width/2 + UPPER_ARM_LENGTH,height/2 - BODY_LENGTH/2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
	
		//legs
		leftleg1=new GLine(width/2 - HIP_WIDTH,height/2 + BODY_LENGTH/2,width/2,height/2 + BODY_LENGTH/2);
		
		leftleg2=new GLine(width/2 - HIP_WIDTH,height/2 + BODY_LENGTH/2,width/2 - HIP_WIDTH,height/2 + BODY_LENGTH/2 + LEG_LENGTH);
	
		rightleg1=new GLine(width/2,height/2 + BODY_LENGTH/2,width/2 + HIP_WIDTH,height/2 + BODY_LENGTH/2);
	
		rightleg2=new GLine(width/2 + HIP_WIDTH,height/2 + BODY_LENGTH/2,width/2 + HIP_WIDTH,height/2 + BODY_LENGTH/2 + LEG_LENGTH);
		
		//feet
		leftfoot=new GLine(width/2 - HIP_WIDTH-FOOT_LENGTH,height/2 + BODY_LENGTH/2 + LEG_LENGTH,width/2 - HIP_WIDTH,height/2 + BODY_LENGTH/2 + LEG_LENGTH);
		
		rightfoot=new GLine(width/2 + HIP_WIDTH,height/2 + BODY_LENGTH/2 + LEG_LENGTH,width/2 + HIP_WIDTH+FOOT_LENGTH,height/2 + BODY_LENGTH/2 + LEG_LENGTH);
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	private int width,height;
	
	private GLine body;
	private GOval head;
	private GLine leftarm1;
	private GLine leftarm2;
	private GLine rightarm1;
	private GLine rightarm2;
	private GLine leftleg1;
	private GLine leftleg2;
	private GLine rightleg1;
	private GLine rightleg2;
	private GLine leftfoot;
	private GLine rightfoot;
	
	private GLine scaffold;
	private GLine beam;
	private GLine rope;

	private GLabel word;
	private GLabel wrongGuesses;
	
	private String wrong;
}
