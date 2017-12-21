import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Title: Agile U6 - Statistical Package
 * 
 * Description: This program will input values from three test files and then will output their:
 * mean, variance, standard deviation, correlation, z scores, normal distribution values, 
 * regression parameters, and t distribution values. 
 *
 * @author Robert Thompson, Alexander Kaczynski, Liam Grover
 * April 5, 2017
 */

public class TestStatisticalPackage
{
	static SELinkedList test = new SELinkedList();
	static SELinkedList u5List = new SELinkedList();
	static SELinkedList u6List1 = new SELinkedList();
	static SELinkedList u6List2 = new SELinkedList();
	
	double num1, num2, num3;
	
	File file1 = new File("Test File #1");
	File file2 = new File("Test File #2");
	File file3 = new File("Test File #3");
	
	Scanner testNum1 = new Scanner(System.in);
	Scanner testNum2 = new Scanner(System.in);
	Scanner testNum3 = new Scanner(System.in);
	
	public void inputNum()
	{
		try
		{
			testNum1 = new Scanner(file1);
			testNum2 = new Scanner(file2);
			testNum3 = new Scanner(file3);
			
			while (testNum1.hasNextLine() || testNum2.hasNextLine() || testNum3.hasNextLine())
			{
				num1 = testNum1.nextDouble();
				num2 = testNum2.nextDouble();
				num3 = testNum3.nextDouble();
				u5List.add(num1);
				u6List1.add(num2);
				u6List2.add(num3);
			}
			testNum1.close();
			testNum2.close();
			testNum3.close();
			
			System.out.println("List 1:");
			u5List.print();
			System.out.println();
			
			System.out.println("List 2:");
			u6List1.print();
			System.out.println();
			
			System.out.println("List 3:");
			u6List2.print();
			System.out.println();
		}
			
		catch (FileNotFoundException check)
		{
			check.printStackTrace();
			System.out.println("File Not Found");
		}
	}

	public static void main(String[] args)
	{
		TestStatisticalPackage se403 = new TestStatisticalPackage();
		se403.inputNum();
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("Statistical Information for List 1:");
		System.out.println("Mean: " + u5List.getMean(u5List));
		System.out.println("Variance: " + u5List.getVariance(u5List));
		System.out.println("Standard Deviation: " + u5List.getStandardDeviation(u5List));
		System.out.println();
		System.out.println("Correlation Values:");
		System.out.println("R(x, y): " + u5List.getCorrelation(u5List, u6List1));
		System.out.println("R^2: " + u5List.correlationSquared(u5List, u6List1));
		System.out.println();
		System.out.println("Z Scores:");
		u5List.getZScores(u5List).print();
		System.out.println();
		System.out.println("Probability:");
		u5List.getProbability(u5List).print();
		System.out.println();
		System.out.println("Regression Parameters: ");
		System.out.println("Beta 1: " + u5List.getBeta1(u5List, u6List1));
		System.out.println("Beta 0: " + u5List.getBeta0(u5List, u6List1));
		System.out.println("------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.println("Statistical Information for List 2:");
		System.out.println("Mean: " + u6List1.getMean(u6List1));
		System.out.println("Variance: " + u6List1.getVariance(u6List1));
		System.out.println("Standard Deviation: " + u6List1.getStandardDeviation(u6List1));
		System.out.println();
		System.out.println("Correlation Values:");
		System.out.println("R(x, y): " + u6List1.getCorrelation(u6List1, u6List2));
		System.out.println("R^2: " + u5List.correlationSquared(u6List1, u6List2));
		System.out.println();
		System.out.println("Z Scores:");
		u6List1.getZScores(u6List1).print();
		System.out.println();
		System.out.println("Probability:");
		u6List1.getProbability(u6List1).print();
		System.out.println();
		System.out.println("Regression Parameters: ");
		System.out.println("Beta 1: " + u6List1.getBeta1(u6List1, u6List2));
		System.out.println("Beta 0: " + u6List1.getBeta0(u6List1, u6List2));
		System.out.println("------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.println("Statistical Information for List 3:");
		System.out.println("Mean: " + u6List2.getMean(u6List2));
		System.out.println("Variance: " + u6List2.getVariance(u6List2));
		System.out.println("Standard Deviation: " + u6List2.getStandardDeviation(u6List2));
		System.out.println();
		System.out.println("Correlation Values:");
		System.out.println("R(x, y): " + u6List2.getCorrelation(u6List1, u6List2));
		System.out.println("R^2: " + u6List2.correlationSquared(u6List1, u6List2));
		System.out.println();
		System.out.println("Z Scores:");
		u6List2.getZScores(u6List2).print();
		System.out.println();
		System.out.println("Probability:");
		u6List2.getProbability(u6List2).print();
		System.out.println();
		System.out.println("Regression Parameters: ");
		System.out.println("Beta 1: " + u6List2.getBeta1(u6List1, u6List2));
		System.out.println("Beta 0: " + u6List2.getBeta0(u6List1, u6List2));
		System.out.println("------------------------------------------------------------------");
		

	}

}
