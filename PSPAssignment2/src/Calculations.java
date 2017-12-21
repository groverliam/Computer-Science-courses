import java.io.*;
import java.lang.Math;
import java.util.Scanner;
/**
 * Title:	Calculations
 * 
 * @author 	Liam Grover
 * @version	2
 * 
 */
public class Calculations {
	private double stdDev;
	private double mean;
	private int count;
	private double data;
	private double result;
	MyLinkedList apples = new MyLinkedList();
	/**
	 * Constructor
	 */
	public Calculations()
	{
		
	}
	/**
	 * Calculate mean
	 * @param l set temp equal to l
	 * @return mean
	 */
	public double getMean(MyLinkedList l)
	{
		MyLinkedList temp = new MyLinkedList();
		temp = l;
		mean = 0;
		double v;
		count = l.getSize();
		for(int i = 0; i < count; i++)
		{
			v = temp.getValue();
			mean = mean + v;
			temp.removeFirst();
		}
		//System.out.println(mean);
		mean = mean/count;
		//System.out.println(count);
		return mean;
	}
	/**
	 * Calculates standard deviation.
	 * @param sd The linked list that will be used for standard deviation.
	 * @param m the linked list that will be use to calculate the mean which 
	 * will be used to in calculating standard deviation.
	 * @return stdDev
	 */
	public double getStdDev(MyLinkedList sd, MyLinkedList m)
	{
		//double total = 0;
		MyLinkedList temp2 = new MyLinkedList();
		temp2 = sd;
		double topOfFormula = 0;
		double cal = 0;
		double v;
		count = sd.getSize();
		//System.out.println(count);
		mean = getMean(m);
		for(int i = 0; i < count; i++)
		{
			v = temp2.getValue();
			//System.out.println(v);

			cal = (( v - mean)*(v - mean));
			topOfFormula = topOfFormula + cal;

			temp2.removeFirst();
		}

		//System.out.println("Mean:"+mean);
		
		
		
		stdDev = Math.sqrt((topOfFormula / (count-1)));
		System.out.println("Standard Deviation: "+ stdDev);
		return stdDev;
	}
	/**
	 * Calculates the top of the correlation formula.
	 * @param f the file with x and y values.
	 * @param xB x bar, which is the mean of the x values.
	 * @param yB y bar, which is the mean of the y values.
	 * @return nSum
	 */
	public double calcNSum(File f, double xB, double yB)
	{
		double nSum=0;
		double bottom=0;
		double xTemp=0;
		double yTemp=0;
		int n = 0;
		Scanner scan;
		try {
	        scan = new Scanner(f);

	        while(scan.hasNextDouble())
	        {
	            data = (scan.nextDouble() );
	            if(n%2 == 0)
	            {
	            	xTemp = data;
	            }
	            else
	            {
	            	yTemp = data;
	            }
	            if(n%2 == 1)
	            {
	            	nSum += ((xTemp - xB)*(yTemp - yB));
	            }
	            n++;
	        }

	    } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	    }
		return nSum;
	}
	/**
	 * Calculates the bottom portion of the correlation formula.
	 * @param f the file with x and y values.
	 * @param xB x bar, which is the mean of the x values.
	 * @param yB y bar, which is the mean of the y values.
	 * @return bottom
	 */
	public double calcBottom(File f, double xB, double yB)
	{
		
		double bottom=0;
		double bottomX=0;
		double bottomY=0;
		double xTemp=0;
		double yTemp=0;
		int n = 0;
		Scanner scan;
		try {
	        scan = new Scanner(f);

	        while(scan.hasNextDouble())
	        {
	            data = (scan.nextDouble() );
	            if(n%2 == 0)
	            {
	            	xTemp = data;
	            }
	            else
	            {
	            	yTemp = data;
	            }
	            if(n%2 == 1)
	            {
	            	bottomX += ((xTemp - xB)*(xTemp - xB));
	            	bottomY += ((yTemp - yB)*(yTemp - yB));
	            }
	            n++;
	        }

	    } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	    }
		bottom = Math.sqrt((bottomX*bottomY));
		return bottom;
	}
	/**
	 * Calculates correlation.
	 * @param top represents the top of the formula.
	 * @param bottom represents the bottom of the formula.
	 * @return result
	 */
	public double getR (double top, double bottom)
	{
		//System.out.println(top);
		//System.out.println(bottom);
		result = ((top/bottom));
		return result;
	}
	/**
	 * Calculates r squared.
	 * @param r is the r-value used with correlation
	 * @return result
	 */
	public double getRSqrd (double r)
	{
		result = (r*r);
		return result;
	}
}
