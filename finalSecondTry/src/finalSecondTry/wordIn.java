package finalSecondTry;
import java.util.Stack;
public class wordIn {
	protected char[] x;
	protected Stack inStack = new Stack();
	public wordIn(String word)
	{
		System.out.println("The word entered is :"+ word);
		x= word.toCharArray();
		/*
		 * check to see if you can convert the char array to a string and then print it. 
		 * call the method in the test class to test.
		 */
	}
}
