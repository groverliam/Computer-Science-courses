/**
 * This Student class is a sub-class of the Person class.
 * It is used to keep track of the name, birth year, and major of a student.
 * @author Liam Grover
 * 
 */
public class Student extends Person
{
	private String major;
	public Student()
	{
	}
	/**
	 * This method creates a student with a name, birth year, and major.
	 * The name and year are sent to the super.
	 * @param newName which is used to set the name of the student.
	 * @param newYear which is used to set the year of the student.
	 * @param newMajor which is used to set the major of the student.
	 */
	public Student(String newName, String newYear, String newMajor)
	{
		super(newName,newYear);// this must be the first executable statement in the constructor
		major= newMajor;
	}
	/**
	 * This method is to change the major of the student.
	 * @param newMajor to change major
	 */
	public void setMajor(String newMajor)
	{
		major= newMajor;
	}
	/**
	 * 
	 * @return major of the student
	 */
	public String getMajor()
	{
		return major;
	}
	/**
	 * @return retString to print the student's name and birth year and major.
	 */
	public String toString()
	{
		String retString = super.toString()+ " [Major = " + major+ "]";
		return retString;
	}
}
