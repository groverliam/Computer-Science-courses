
public class Data 
{
	public static double average(Measurable[] objects)
	{
		double sum = 0;
		for(Measurable obj : objects)
		{
			sum = sum + obj.getMeasure();
		}
		if (objects.length> 0 )
		{
			return sum/ objects.length;
		}
		else
		{
			return 0;
		}
	}
	public static Measurable max(Measurable[] objects)
	{
		double max= 0;// no grade can be lower than a zero 
		int i= 0;
		int numMax=0;
		for(Measurable obj : objects)
		{
			if (obj.getMeasure() > max)
			{
				max = obj.getMeasure();
				numMax= i;
			}
			i++;
		}
		return objects[numMax];
	}
}