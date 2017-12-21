import java.lang.Math;
public class Calculations {
	private double value;
	private double stdDev;
	private double mean;
	private int count;
	MyLinkedList apples = new MyLinkedList();
	
	public Calculations()
	{
		
	}
	
	public double getMean(MyLinkedList l)
	{
		MyLinkedList temp = new MyLinkedList();
		temp = l;
		double v;
		count = l.getSize();
		for(int i = 0; i < count; i++)
		{
			v = temp.getValue();
			mean = mean + v;
			temp.removeFirst();
		}
		mean = mean/count;
		//System.out.println(count);
		System.out.println("Mean: "+mean);
		return mean;
	}
	
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
		
		System.out.println("Standard Deviation:");
		
		stdDev = Math.sqrt((topOfFormula / (count-1)));
		return stdDev;
	}
}
