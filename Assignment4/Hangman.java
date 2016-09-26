/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	public void init(){
    	canvas=new HangmanCanvas();
    	
    	add(canvas);
    	int a=canvas.getWidth();
    	canvas.reset();
    }
	
    public void run() {
		
    	/*Returns a random word after checking how
		 * many words are available by calling getWord and
		 * getWordCount methods of Hangman instance variable
		 * of HangmanLexicon Class defined in other file
		 */
    	word=Lexicon.getWord(rgen.nextInt(1, Lexicon.getWordCount()));
    	
		println("Welcome to Hangman!\n");
		/*guessed: string that contains correct letters
		 * given by user
		 * dashWord: string with the word where correct
		 * letters are visible
		 * wrong:incorrect guesses
		 */
		guessed="";
		dashWord="";
		
		//Create dashed word
		for (int i=0; i<word.length(); i++)
			dashWord+="-";
		int i=8;
		canvas.displayWord(dashWord);
		
		//run 8 times
		while (i>0){
			println("The word now looks like this: " + dashWord + "\n" + "You have " + i + " guesses left"); 
			canvas.displayWord(dashWord); 
			char nextChar=readLetter();
			int pos=0;
			boolean found=false;
			/*searches for the letter given by user in word
			 * if found, continues until whole word is searched
			 * and finLetter function returns -1
			 */
			while (pos!=-1){
				pos=findLetter(nextChar,pos);
				showLetter(nextChar,pos);
				if (pos>-1){
					pos++;
					found=true;
				}
			}
			canvas.displayWord(dashWord);
			if (found)
				println("Your guess is correct!");
			else{
				println("There are no " + nextChar + "'s in this word.");
				canvas.noteIncorrectGuess(nextChar);
				i--;
			}
			
			/*check if the word has been guessed
			 * print winning message and break loop
			 */
			if (checkFinish()<0){
				println("You guessed the word: " + word + "\nYou win");
				break;
			}
		}
		/*If all 8 guesses have been exhausted
		 * print message to end game
		 */
		if (i==0){
			println("You are completely hung. \n" + "The word was: " + word + "\nYou lose. ");
		}
	}
    /* Asks user for next letter. If input string is longer
     * than one character or is one character but not a
     * letter, user is prompted again for the next letter
     */
    public char readLetter(){
    	
    	String input="0";
    	while (!Character.isLetter(input.charAt(0)) || input.length()!=1) 
    		input=readLine("Your guess: ");
    	return Character.toUpperCase(input.charAt(0));
 
    }
    
    /* returns index of letter found in word
     * or -1 if it doesn't exist
     */
    public int findLetter(char ch,int start){
    	return word.indexOf(ch,start);
    }
    
    /*replaces all dashes in positions
     * where the letter is present
     */
    public void showLetter(char ch,int pos){
    	if (pos!=-1)
    		dashWord=dashWord.substring(0,pos) + ch + dashWord.substring(pos+1,dashWord.length());
    }
    
    public int checkFinish(){
    	return dashWord.indexOf("-");
    }

    public String word;
    public String dashWord;
    public String guessed;
    
    private RandomGenerator rgen=new RandomGenerator();
    private HangmanLexicon Lexicon=new HangmanLexicon();
    private HangmanCanvas canvas;
}
