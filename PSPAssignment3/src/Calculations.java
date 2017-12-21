import java.io.*;
import java.lang.Math;
import java.util.Scanner;
/**
 * Title:	Calculations
 * 
 * @author 	Liam Grover
 * @version	3
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
	 * Calculate mean of x-values
	 * @param l set temp equal to l
	 * @return mean
	 */
	public double getXMean(MyLinkedList l)
	{
		MyLinkedList temp = new MyLinkedList();
		temp = l;
		mean = 0;
		double v;
		count = l.getSize();
		for(int i = 0; i < count; i++)
		{
			v = temp.getXValue();
			mean = mean + v;
			temp.removeFirst();
		}
		//System.out.println(mean);
		mean = mean/count;
		//System.out.println(count);
		return mean;
	}
	/**
	 * Calculate mean of y-values
	 * @param l set temp equal to l
	 * @return mean
	 */
	public double getYMean(MyLinkedList l)
	{
		MyLinkedList temp = new MyLinkedList();
		temp = l;
		mean = 0;
		double v;
		count = l.getSize();
		for(int i = 0; i < count; i++)
		{
			v = temp.getYValue();
			mean = mean + v;
			temp.removeFirst();
		}
		//System.out.println(mean);
		mean = mean/count;
		//System.out.println(count);
		return mean;
	}
	/**
	 * Calculates standard deviation of x-values.
	 * @param sd The linked list that will be used for standard deviation.
	 * @param m the linked list that will be use to calculate the mean which 
	 * will be used to in calculating standard deviation.
	 * @return stdDev
	 */
	public double getStdDevX(MyLinkedList sd, MyLinkedList m)
	{
		//double total = 0;
		MyLinkedList temp2 = new MyLinkedList();
		temp2 = sd;
		double topOfFormula = 0;
		double cal = 0;
		double v;
		count = sd.getSize();
		//System.out.println(count);
		mean = getXMean(m);
		for(int i = 0; i < count; i++)
		{
			v = temp2.getXValue();
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
	 * Calculates standard deviation of y-values.
	 * @param sd The linked list that will be used for standard deviation.
	 * @param m the linked list that will be use to calculate the mean which 
	 * will be used to in calculating standard deviation.
	 * @return stdDev
	 */
	public double getStdDevY(MyLinkedList sd, MyLinkedList m)
	{
		//double total = 0;
		MyLinkedList temp2 = new MyLinkedList();
		temp2 = sd;
		double topOfFormula = 0;
		double cal = 0;
		double v;
		count = sd.getSize();
		//System.out.println(count);
		mean = getYMean(m);
		for(int i = 0; i < count; i++)
		{
			v = temp2.getXValue();
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
	public double calcNSum(File f, double xB, double yB)//top for r and for slope
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
		//System.out.println(nSum);

		return nSum;
	}
	/**
	 * Calculates the bottom portion of the correlation formula.
	 * @param f the file with x and y values.
	 * @param xB x bar, which is the mean of the x values.
	 * @param yB y bar, which is the mean of the y values.
	 * @return bottom
	 */
	public double calcBottomforR(File f, double xB, double yB)
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
	/**
	 * Calculates bottom formula for linear regression.
	 * @param l linked list to get data from.
	 * @param xB xBar for the average value of x.
	 * @return bottom formula
	 */
	public double calcBottomforLinReg(MyLinkedList l, double xB)
	{
		MyLinkedList temp = new MyLinkedList();
		
		temp = l;
		int bottom = 0;
		double v;
		count = l.getSize();
		for(int i = 0; i < count; i++)
		{
			v = temp.getXValue();
			temp.removeFirst();
			bottom += ((v - xB)*(v - xB));
		}
		//System.out.println(bottom);

		return bottom;
	}
	/**
	 * Calculates B1.
	 * @param top represents the top of the formula.
	 * @param bottom represents the bottom of the formula.
	 * @return result is top divided by bottom
	 */
	public double calcB1(double top, double bottom)//top is nsum
	{
		result = (top/bottom);
		return result;
	}
	
}
