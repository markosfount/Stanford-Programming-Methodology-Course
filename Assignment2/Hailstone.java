/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int step=0;
		int n=readInt("Give a number \n");
		while (true){
			if (n%2==0){
				int temp=n/2;
				println(n + " is even, so I take half: " +temp +"\n");
				n=temp;
			}
			else{
				int temp=3*n+1;
				println(n + " is odd so I multiply by three and add one: " +temp+ "\n");
				n=temp;
			}
			step++;
			if (n==1) break;
			
		}
		println("This process took " + step + " steps to complete \n"); 
	}
}

