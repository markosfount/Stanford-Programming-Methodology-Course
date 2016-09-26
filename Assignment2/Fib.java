import acm.program.*;

/*This program calculates the fibonacci sequence 
 * Until MAX
 */

public class Fib extends ConsoleProgram {
	
	private static final int MAX=10000;
	
	public void run(){
		println("This program lists the Fibonacci sequence");
		int first=0;
		println(first);
		int second=1;
		
		while (second<MAX){
			println(second);
			
			int temp=first+second;
			first=second;
			second=temp;
		}
	}
}

