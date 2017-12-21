/**
 * This Person class is used to keep track of the name and year of a person in this project.
 * @author Liam Grover
 * 
 */
public class Person
{
	private String name;
	private String year;

	public Person()
	{
		name = "";	
	}
	/**
	 * Creates a person with a name and year.
	 * @param newName which is used to set the name of the person.
	 * @param newYear which is used to set the year of the person.
	 */
	public Person(String newName, String newYear)
	{
		name= newName;
		year= newYear;
	}
	/**
	 * Changes the name with a new name.
	 * @param newNAme  which is used to change the name of the person
	 */
	public void setName(String newName)
	{
		name= newName;
	}
	/**
	 * @return name of the person
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Changes the birth year with a new year.
	 * @param newNAme  which is used to change the birth year of the person
	 */
	public void setYear(String newYear)
	{
		year= newYear;
	}
	/**
	 * @return year the person was born
	 */
	public String getYear()
	{
		return year;
	}
	/**
	 * @return retString to print the person's name and birth year.
	 */
	public String toString()
	{
		String retString = getClass().getName()+ " [Name = " + name+ "]"
				+ " [Year of birth = " + year+ "]";
		return retString;
	}
}
