import acm.program.*;

/*This program receives numbers and inserts commas
 * every 3 digits.
 */

public class Commas extends ConsoleProgram{
	public void run(){
		//read a multidigit string from user
		String str=readLine("Enter a number: \n");
		println(insertCommas(str));
	}
	
	//gets an integer in string format and inserts commas
	//every three digits
	public String insertCommas(String str){
		int length=str.length();
		// i counts digits without including commas
		int i=1; 
		// used to count how many commas have already been inserted
		//in order to find the proper index to check
		int commas=0;
		
		//we check string starting from the end
		while (true){
			//if we have checked all digits, end program
			if (i==length)
				break;
			//if we are at a digit which is dividable by three, insert a comma
			if (i%3==0){
				int j=length-i;
				str=str.substring(0, j) + "," + str.substring(j, length +commas);
				commas++;
			}
		
			i++;
		}
		return str;
	}
}
