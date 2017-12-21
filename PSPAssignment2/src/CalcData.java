import java.util.Scanner;
/**
 * @author Liam Grover
 */
import java.io.*;
public class CalcData {
	public static void main(String[] args) {
		MyLinkedList xMlist = new MyLinkedList();
		MyLinkedList xSDlist = new MyLinkedList();
		MyLinkedList yMlist = new MyLinkedList();
		MyLinkedList ySDlist = new MyLinkedList();
		MyLinkedList xVals = new MyLinkedList();
		MyLinkedList yVals = new MyLinkedList();
		double xBar;
		double yBar;
		double data;
		double nSum;
		double result;
		double resultS;
		double bottom;
		int n = 0;
		
		Calculations calc = new Calculations();
		Scanner in = new Scanner(System.in);
		Scanner scan;
	    File file = new File("/Users/admin/Desktop/CS/PSPAssignment2/src/inputFile");
	    System.out.println("The data inputed from the file is: ");
	    try {
	        scan = new Scanner(file);
	        System.out.println("  X      Y");
	        while(scan.hasNextDouble())
	        {
	            data = (scan.nextDouble() );
	            if(n%2 == 0)
	            {
	            	System.out.print("("+data+ ", ");
	            }
	            else
	            {
	            	System.out.println(data+")");
	            }
	            if(n % 2 == 0)
	            {
	            	xVals.add(data);
	            	xMlist.add(data);
	            	xSDlist.add(data);
	            }
	            else
	            {
	            	yVals.add(data);
	            	yMlist.add(data);
	            	ySDlist.add(data);
	            }
	            n++;
	        }

	    } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	    }
		

		System.out.println("Pick your choice.");
		System.out.println("1) Calculate xBar and yBar");
		System.out.println("2) Get r");
		System.out.println("3) Get r squared");


		int choice = in.nextInt();
		if(choice == 1)
		{
			
			xBar= calc.getMean(xMlist);
			System.out.println("xBar: "+xBar);
			yBar= calc.getMean(yMlist);
			System.out.println("yBar: "+yBar);
			
		}
		else if(choice == 2)
		{
			xBar= calc.getMean(xVals);
			yBar= calc.getMean(yVals);
			nSum= calc.calcNSum(file, xBar, yBar);
			bottom = calc.calcBottom(file, xBar, yBar);
			result = calc.getR(nSum, bottom);
			System.out.println("r: "+result);
		}
		
		else if(choice == 3)
		{
			xBar= calc.getMean(xVals);
			yBar= calc.getMean(yVals);
			nSum= calc.calcNSum(file, xBar, yBar);
			bottom = calc.calcBottom(file, xBar, yBar);
			result = calc.getR(nSum, bottom);
			resultS= calc.getRSqrd(result);
			System.out.println("r squared: "+resultS);
		}
		else
		{
			System.out.println("INVALID SELECTION");

		}
		
	}

}
