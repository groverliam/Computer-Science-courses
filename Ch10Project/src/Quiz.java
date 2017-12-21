
public class Quiz implements Measurable
{
	private double grade;
	private String letter;
	
	public Quiz(double newGrade, String newLetter)
	{
		grade = newGrade;
		letter = newLetter;
		
	}
	
	public String getLetter()
	{
		return letter;
	}
	

	public double getMeasure()
	{
		return grade;
	}
	
	public String toString()
	{
		String retString = getClass().getName()+ ": [Letter Grade = " + letter+ "]"
				+ " [Number Grade = " + grade+ "]";
		return retString;
	}
}
