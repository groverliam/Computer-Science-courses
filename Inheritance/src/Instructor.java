public class Instructor extends Person
{
	private double salary;
	public Instructor()
	{
	}
	/**
	 * This method creates an instructor with a name, birth year, and salary.
	 * The name and year are sent to the super.
	 * @param newName which is used to set the name of the student.
	 * @param newYear which is used to set the year of the student.
	 * @param newSalary which is used to set the salary of the student.
	 */
	public Instructor(String newName, String newYear, double newSalary)
	{
		super(newName, newYear);// this must be the first executable statement in the constructor
		salary= newSalary;
	}
	/**
	 * This method is to change the salary of the instructor.
	 * @param newSalary to change salary
	 */
	public void setSalary(double newSalary)
	{
		salary= newSalary;
	}
	/**
	 * 
	 * @return salary of the instructor
	 */
	public double getSalary()
	{
		return salary;
	}
	/**
	 * @return retString to print the instructor's name and birth year and salary.
	 */
	public String toString()
	{
		String retString = super.toString()+ " [Salary = " + salary+ "]";
		return retString;
	}
}