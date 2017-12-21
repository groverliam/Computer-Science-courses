import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Title:	Calculations
 * 
 * @author 	Liam Grover
 * @version	3
 * 
 */
public class Calculations {
	static MyLinkedList space1 = new MyLinkedList();
	private ArrayList<RelativeST> rst = new ArrayList<RelativeST>();

	private double std;
	private int n = 0;
	private double ln;
	private double lnt;
	String name;
	private double h;
	private double avg;
	private double var = 0;
	public double lnvs;
	public double lns;
	public double lnm;
	public double lnl;
	public double lnvl;
	

	MyLinkedList apples = new MyLinkedList();
	
	/**
	 * Constructor
	 */
	public Calculations()
	{
		
	}
/**
 * Converts the natural log range to the relative range.
 */
	public void convertLRange()
	{
		lnvs = Math.exp(lnvs);
		lns = Math.exp(lns);
		lnm = Math.exp(lnm);
		lnl = Math.exp(lnl);
		lnvl = Math.exp(lnvl);
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Converted Relative Size:");
		System.out.println("VS = "+lnvs);
		System.out.println("S = "+lns);
		System.out.println("M = "+lnm);
		System.out.println("L = "+lnl);
		System.out.println("VL = "+lnvl);
		System.out.println("---------------------------------------------------------------------------------------");
	}
	/**
	 * Finds the natural log of the range.
	 */
	public void findLRange()
	{
	lnvs = (avg - (2*std));
	lns = (avg - (std));
	lnm = (avg);
	lnl = (avg + (std));
	lnvl = (avg + (2*std));
	System.out.println("---------------------------------------------------------------------------------------");
	System.out.println("Natural Log of Relative Size:");
	System.out.println("ln(VS) = "+lnvs);
	System.out.println("ln(S) = "+lns);
	System.out.println("ln(M) = "+lnm);
	System.out.println("ln(L) = "+lnl);
	System.out.println("ln(VL) = "+lnvl);
	System.out.println("---------------------------------------------------------------------------------------");
	
	}
	/**
	 * finds the standard deviation.
	 */
	public void findStd()
	{
		std = Math.sqrt(var);
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("STANDARD DEVIATION = "+std);
		System.out.println("---------------------------------------------------------------------------------------");
	}
	/**
	 * Finds the variance.
	 */
	public void findVar()
	{
		
		for(int i = 0; i < rst.size(); i++)
		{
			var += ((rst.get(i).getln()-avg)*(rst.get(i).getln()-avg));
		}
		
		var = (var/(n-1));
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("VARIANCE = "+var);
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	/**
	 * Finds the average.
	 */
	public void findAvg()
	{
		avg = lnt/n;
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("AVERAGE = "+avg);
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	/**
	 * Finds the natural log 
	 */
	public void findln()
	{
		System.out.println("---------------------------------------------------------------------------------------");

		while (!space1.isEmpty())
		{
			name = space1.getName();
			h = space1.getYValue();
			ln = Math.log(h);
			lnt += ln;
			rst.add(new RelativeST(h, ln, lnt));
			System.out.printf("%-20s|", name);
			System.out.println(" Xj = "+h+"\t ln(Xj) = "+ln);
			System.out.println("---------------------------------------------------------------------------------------");

			space1.removeFirst();
		}
		System.out.println("ln total = "+lnt);
		System.out.println("");
	}
	
	/**
	 * Finds the LOC/Method.
	 * @param f file that is used to extract the data and is then placed into a linked list.
	 */
	public void LOCMETH(File f)
	{
	try {
		Scanner scan = new Scanner(f);
		String[] stuff = new String[3];
		String str;
		String nameX;
		double y;
		double z;
		
		double LOCpMeth;
		System.out.println("------------------------------------------------------");

		while(scan.hasNext())
		{
			
			str = (scan.next());
			stuff = str.split(",");
			nameX = stuff[0];
			y = (int) Double.parseDouble(stuff[1]);
			z = (int)Double.parseDouble(stuff[2]);

			LOCpMeth = (y/z);
			space1.addnd(nameX,LOCpMeth);
			System.out.println(nameX+"'s LOC/Method = "+LOCpMeth);
			System.out.println("-----------------------------------------------------");

			n++;
			
		}

	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	System.out.println("");
	}
	
	
}
