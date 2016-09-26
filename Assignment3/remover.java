import acm.program.*;

/*This program receives a character ch and
 * removes all its occurences from a given
 * string
 */

public class remover extends ConsoleProgram{
	public void run(){
		//read a line from user
		
		String str1=readLine("Enter a line: \n");
		String str2="";
		while (str2.length()!=1)
			str2=readLine("Enter a character: \n");
		char ch=str2.charAt(0);
		println(charemover(str1,ch));
		
	}
	
	//gets an integer in string format and inserts commas
	//every three digits
	public String charemover(String str, char ch){
		int length=str.length();
		// i counts position of character in string (first character is i=1 not i=0 !)
		int i=1; 
		
		//counts characters removed by string
	
		
		while (true){
			/*if current character is the one we are looking for,
			 *concatenate string from beginning with the one right before
			 *and string to the one next to the end
			 */
			if (str.charAt(i-1)==ch){
				str=str.substring(0, i-1) + str.substring(i, length);
				/*we are adding one to "removed"
				 * for every character we have removed
				 * in order to calculate the current 
				 * length of the string
				 */
				length--;
				i--;
			}
			
			if (i==length)
				break;
			i++;
		}
		return str;
	}
}