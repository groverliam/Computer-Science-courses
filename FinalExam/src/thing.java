
import java.util.Stack;
import java.util.Scanner;
import java.util.Arrays;
public class thing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What word?");
		String input= in.next();
		
		Stack s = new Stack();
		
		for(int i = 0 ; i < input.length() ; i++)
		{
			s.push(input.charAt(i));
		}
		
		System.out.println("You entered: "+ input);

		String rvr = "";
		
		while(!s.isEmpty())
		{
			rvr = rvr+s.pop();
		}
		
		System.out.println("The reversed word is: "+ rvr);
		
		if(input.equals(rvr))
		{
			System.out.println("This is a palindrome.");
		}
		else
		{
			System.out.println("This is not a palindrome.");
		}

	}

}
