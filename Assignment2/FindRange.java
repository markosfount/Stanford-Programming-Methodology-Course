/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL=0;
	
	public void run() {
		int min=1000000;
		int max=-1000000;
		
		while (true){
			int a=readInt("Give an integer \n");
			if (a<min) min=a;
			if (a>max) max=a;
			if (a==SENTINEL){ 
				println("The largest number is " + max + " and the smallest is" + min ); 
				break;
			}
		}
	}
}

