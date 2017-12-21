import java.util.Scanner;
/*
 * Liam Grover
 * Algorithm:
 * Prompt user for the first number.
 * Read the first number.
 * Prompt user for the second number.
 * Read the second number.
 * Get the sum of the two numbers.
 * Print the two numbers and show the sum.
 */
public class Sum2 
{
	public static void main (String args[])
	{
		double num1;
		double num2;
		double sum;
		
		Scanner in = new Scanner (System.in);
		
		//Prompt user for the first number.
		System.out.println ("What is your first number?");
		//Read the first number.
		num1= in.nextDouble();
		
		//Prompt user for the second number.
		System.out.println ("What is your second number?");
		//Read the second number.
		num2= in.nextDouble();

		//Get the sum of the two numbers.
		sum= num1 + num2;
		
		//Print the two numbers and show the sum.
		System.out.println ("Your two numbers you would like summed are "+num1+" and "+num2+".");
		System.out.println ("Your sum is "+sum+".");
	}

}
