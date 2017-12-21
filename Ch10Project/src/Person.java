
public class Person implements Measurable
{
	private String name;
	private double height;
	
	public Person(String newName, double newHeight)
	{
		name = newName;
		height= newHeight;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getMeasure()
	{
		return height;
	}
	
	public String toString()
	{
		String retString = " [Name = " + name + "]"
				+ " [Height = " + height+ " inches ]";
		return retString;
	}
	
}
