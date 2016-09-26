import acm.program.*;
import acm.util.ErrorException;
import java.io.*;

public class wordCount extends ConsoleProgram{
	
	public void run(){
		String filename=readLine("Enter filename:\n");
		readFile(filename);
		
		lines=0;
		words=0;
		chars=0;
		
		count();
		println("Lines: " + lines + "\n" + "Words: " + words + "\n" + "Characters: " + chars);
	}
	
	private void readFile(String string){
		try{
			rd=new BufferedReader(new FileReader(string));
		}
		catch(IOException ex){
			throw new ErrorException(ex);
		}
		println("File: " + string);
	}
	
	private void count(){
		try{
			while (true){
				String newLine=rd.readLine();
				if (newLine==null)
					break;
				lines++;
				chars+=newLine.length();
				for (int i=0; i<newLine.length(); i++){
					//if (Character.isLetterOrDigit(newLine.charAt(i)))
					//else
					 if (newLine.charAt(i)==' ')
						words++;
				}
			}
		}
		catch(IOException ex){
			throw new ErrorException(ex);
		}
	}
	
	private BufferedReader rd;
	private int lines,words,chars;
}


