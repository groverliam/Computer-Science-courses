import java.util.Scanner;
/**
 * @author Liam Grover
 */
import java.io.*;
public class CalcData {
	public static void main(String[] args) {
		MyLinkedList xMlist = new MyLinkedList();
		MyLinkedList xSDlist = new MyLinkedList();
		MyLinkedList xVals = new MyLinkedList();
		MyLinkedList yMlist = new MyLinkedList();
		MyLinkedList ySDlist = new MyLinkedList();
		MyLinkedList yVals = new MyLinkedList();
		double xBar;
		double yBar;
		double dataX;
		double dataY;
		double nSum;
		double result;
		double resultS;
		double bottom;
		double B1;
		double B0; // = yBar - B1(xBar)
		double yHat;
		int n = 0;
		final double XJ = 386;

		Calculations calc = new Calculations();
		Scanner in = new Scanner(System.in);
		Scanner scan;
		File file1 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test1InputFile");
		File file2 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test2InputFile");
		File file3 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test3InputFile");
		File file4 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test4InputFile");


		for(int choice = 1; choice <= 4; choice++)
		{


			if(choice == 1)
			{
				n=0;
				System.out.println("\nThe data inputed for test "+choice+" is: ");
				System.out.println("--------------");

				try {
					scan = new Scanner(file1);
					System.out.println("  X      Y");
					while(scan.hasNextDouble())
					{
						dataX = (scan.nextDouble() );
						dataY = (scan.nextDouble() );
						System.out.println("("+dataX+ ", "+dataY+")");


						xVals.add(dataX,dataY);
						xMlist.add(dataX,dataY);
						xSDlist.add(dataX,dataY);
						yVals.add(dataX,dataY);
						yMlist.add(dataX,dataY);
						ySDlist.add(dataX,dataY);

						n++;
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				System.out.println("--------------");

				xBar= calc.getXMean(xMlist);
				//System.out.println("xBar: "+xBar);
				yBar= calc.getYMean(yMlist);
				//System.out.println("yBar: "+yBar);
				nSum= calc.calcNSum(file1, xBar, yBar);
				bottom = calc.calcBottomforR(file1, xBar, yBar);
				result = calc.getR(nSum, bottom);
				//System.out.println("r: "+result);
				nSum= calc.calcNSum(file1, xBar, yBar);
				bottom = calc.calcBottomforR(file1, xBar, yBar);
				result = calc.getR(nSum, bottom);
				resultS= calc.getRSqrd(result);
				//System.out.println("r squared: "+resultS);
				nSum= calc.calcNSum(file1, xBar, yBar);
				bottom = calc.calcBottomforLinReg(xVals, xBar);
				B1 = calc.calcB1(nSum, bottom);
				B0 = yBar - (B1*(xBar));
				//have to find Result next. (yHat = B1x + B0)
				yHat = (B1*XJ) + B0;
				//System.out.println("y hat= "+yHat);
				System.out.println("\nTest #\t|\t\tB0\t\t|\t\tB1\t\t|\t\tR\t\t|\t\tR^2\t\t|\t\tY\t\t|");
				System.out.print("------------------------------------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Test "+choice+"\t|\t"+B0+"\t|\t"+B1+"\t|\t"+result+"\t|\t"+resultS+"\t|\t"+yHat+"\t|");
				System.out.println("n = "+ n);
			}

			else if(choice == 2)
			{
				n=0;
				System.out.println("\nThe data inputed for test "+choice+" is: ");
				System.out.println("--------------");

				try {
					scan = new Scanner(file2);
					System.out.println("  X      Y");
					while(scan.hasNextDouble())
					{
						dataX = (scan.nextDouble() );
						dataY = (scan.nextDouble() );
						System.out.println("("+dataX+ ", "+dataY+")");


						xVals.add(dataX,dataY);
						xMlist.add(dataX,dataY);
						xSDlist.add(dataX,dataY);
						yVals.add(dataX,dataY);
						yMlist.add(dataX,dataY);
						ySDlist.add(dataX,dataY);

						n++;
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				System.out.println("--------------");

				xBar= calc.getXMean(xMlist);
				//System.out.println("xBar: "+xBar);
				yBar= calc.getYMean(yMlist);
				//System.out.println("yBar: "+yBar);
				nSum= calc.calcNSum(file2, xBar, yBar);
				bottom = calc.calcBottomforR(file2, xBar, yBar);
				result = calc.getR(nSum, bottom);
				//System.out.println("r: "+result);
				nSum= calc.calcNSum(file2, xBar, yBar);
				bottom = calc.calcBottomforR(file2, xBar, yBar);
				result = calc.getR(nSum, bottom);
				resultS= calc.getRSqrd(result);
				//System.out.println("r squared: "+resultS);
				nSum= calc.calcNSum(file2, xBar, yBar);
				bottom = calc.calcBottomforLinReg(xVals, xBar);
				B1 = calc.calcB1(nSum, bottom);
				B0 = yBar - (B1*(xBar));
				//have to find Result next. (yHat = B1x + B0)
				yHat = (B1*XJ) + B0;
				//System.out.println("y hat= "+yHat);
				System.out.println("\nTest #\t|\t\tB0\t\t|\t\tB1\t\t|\t\tR\t\t|\t\tR^2\t\t|\t\tY\t\t|");
				System.out.print("------------------------------------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Test "+choice+"\t|\t"+B0+"\t|\t"+B1+"\t|\t"+result+"\t|\t"+resultS+"\t|\t"+yHat+"\t|");
				System.out.println("n = "+ n);
			}

			else if(choice == 3)
			{
				n=0;
				System.out.println("\nThe data inputed for test "+choice+" is: ");
				System.out.println("--------------");

				try {
					scan = new Scanner(file3);
					System.out.println("  X      Y");
					while(scan.hasNextDouble())
					{
						dataX = (scan.nextDouble() );
						dataY = (scan.nextDouble() );
						System.out.println("("+dataX+ ", "+dataY+")");


						xVals.add(dataX,dataY);
						xMlist.add(dataX,dataY);
						xSDlist.add(dataX,dataY);
						yVals.add(dataX,dataY);
						yMlist.add(dataX,dataY);
						ySDlist.add(dataX,dataY);

						n++;
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				System.out.println("--------------");

				xBar= calc.getXMean(xMlist);
				//System.out.println("xBar: "+xBar);
				yBar= calc.getYMean(yMlist);
				//System.out.println("yBar: "+yBar);
				nSum= calc.calcNSum(file3, xBar, yBar);
				bottom = calc.calcBottomforR(file3, xBar, yBar);
				result = calc.getR(nSum, bottom);
				//System.out.println("r: "+result);
				nSum= calc.calcNSum(file3, xBar, yBar);
				bottom = calc.calcBottomforR(file3, xBar, yBar);
				result = calc.getR(nSum, bottom);
				resultS= calc.getRSqrd(result);
				//System.out.println("r squared: "+resultS);
				nSum= calc.calcNSum(file3, xBar, yBar);
				bottom = calc.calcBottomforLinReg(xVals, xBar);
				B1 = calc.calcB1(nSum, bottom);
				B0 = yBar - (B1*(xBar));
				//have to find Result next. (yHat = B1x + B0)
				yHat = (B1*XJ) + B0;
				//System.out.println("y hat= "+yHat);
				System.out.println("\nTest #\t|\t\tB0\t\t|\t\tB1\t\t|\t\tR\t\t|\t\tR^2\t\t|\t\tY\t\t|");
				System.out.print("------------------------------------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Test "+choice+"\t|\t"+B0+"\t|\t"+B1+"\t|\t"+result+"\t|\t"+resultS+"\t|\t"+yHat+"\t|");
				System.out.println("n = "+ n);
			}

			else if(choice == 4)
			{
				n=0;
				System.out.println("\nThe data inputed for test "+choice+" is: ");
				System.out.println("--------------");

				try {
					scan = new Scanner(file4);
					System.out.println("  X      Y");
					while(scan.hasNextDouble())
					{
						dataX = (scan.nextDouble() );
						dataY = (scan.nextDouble() );
						System.out.println("("+dataX+ ", "+dataY+")");


						xVals.add(dataX,dataY);
						xMlist.add(dataX,dataY);
						xSDlist.add(dataX,dataY);
						yVals.add(dataX,dataY);
						yMlist.add(dataX,dataY);
						ySDlist.add(dataX,dataY);

						n++;
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				System.out.println("--------------");
				xBar= calc.getXMean(xMlist);
				//System.out.println("xBar: "+xBar);
				yBar= calc.getYMean(yMlist);
				//System.out.println("yBar: "+yBar);
				nSum= calc.calcNSum(file4, xBar, yBar);
				bottom = calc.calcBottomforR(file4, xBar, yBar);
				result = calc.getR(nSum, bottom);
				//System.out.println("r: "+result);
				nSum= calc.calcNSum(file4, xBar, yBar);
				bottom = calc.calcBottomforR(file4, xBar, yBar);
				result = calc.getR(nSum, bottom);
				resultS= calc.getRSqrd(result);
				//System.out.println("r squared: "+resultS);
				nSum= calc.calcNSum(file4, xBar, yBar);
				bottom = calc.calcBottomforLinReg(xVals, xBar);
				B1 = calc.calcB1(nSum, bottom);
				B0 = yBar - (B1*(xBar));
				//have to find Result next. (yHat = B1x + B0)
				yHat = (B1*XJ) + B0;
				//System.out.println("y hat= "+yHat);
				System.out.println("\nTest #\t|\t\tB0\t\t|\t\tB1\t\t|\t\tR\t\t|\t\tR^2\t\t|\t\tY\t\t|");
				System.out.print("------------------------------------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Test "+choice+"\t|\t"+B0+"\t|\t"+B1+"\t|\t"+result+"\t|\t"+resultS+"\t|\t"+yHat+"\t|");
				System.out.println("n = "+ n);
			}
			
			else
			{
				System.out.println("INVALID SELECTION");

			}
			

		}
	}

}
