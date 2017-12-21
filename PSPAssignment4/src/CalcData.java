import java.util.Scanner;
/**
 * @author Liam Grover
 */
/*
+----------------------------------------------------------------------------+
|            Monmouth University Spring 2017 SE 403-01		         	     |
+----------------------------------------------------------------------------+
| Program Name:  PROGU4                                         		  	 |
| Author:  Liam Grover      	                                      	     |
| Version:        4.0                                                        |
| Date:  3/8/17         		                                     		 |
| Synopsis:                                                                  |
|                This program will demonstrate how to calculate relative 	 |
|					size.|													 |
|    																		 |
| References:  M. T. Goodrich, R. Tamassia and M. H. Goldwasser, Data 		 |
| Structures and Algorithms in Java, vol. 6th edition, Hoboken, NJ: John 	 |
| Wiley & Sons, Inc., 2010.                                                  |
+----------------------------------------------------------------------------+
*/
import java.io.*;
public class CalcData {
	public static void main(String[] args) {
		MyLinkedList xlist1 = new MyLinkedList();
		String nameX = "";
		double dataY;
		double dataZ;
		int n = 0;
		String[] data = new String[3];
		String str;

		Calculations calc = new Calculations();

		
		Scanner in = new Scanner(System.in);
		Scanner scan;
		File file1 = new File("/Users/admin/Desktop/CS/PSPAssignment4/src/test1InputFile");
		//File file2 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test2InputFile");
		//File file3 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test3InputFile");
		//File file4 = new File("/Users/admin/Desktop/CS/PSPAssignment3/src/test4InputFile");


		System.out.println("\nThe data inputed for LOC/METHOD DATA is: ");
		System.out.println("-------------------------------------------------------------------------");

		try {
			scan = new Scanner(file1);
			System.out.println("\tClass Name          |\tClass LOC\t|\t# of Methods\t|");
			System.out.println("-------------------------------------------------------------------------");
			while(scan.hasNext())
			{
				str = (scan.next());
				data = str.split(",");
				nameX = data[0];
				dataY = (int) Double.parseDouble(data[1]);
				dataZ = (int)Double.parseDouble(data[2]);
				System.out.printf("\t%-20s|\t%-10f\t|\t%-10f\t|\n",nameX, dataY, dataZ);
				System.out.println("-------------------------------------------------------------------------");
				
				xlist1.add3(nameX, dataY, dataZ);
				n++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("");
		calc.LOCMETH(file1);
		calc.findln();
		calc.findAvg();
		calc.findVar();
		calc.findStd();
		calc.findLRange();
		calc.convertLRange();
	
	}

}
