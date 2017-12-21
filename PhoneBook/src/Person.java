public class Person {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	public Person(String newName, String otherName, String number)
	{
		firstName= newName;
		lastName= otherName;
		phoneNumber= number;
	}
	public Person()
	{
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String newName)
	{
		firstName = newName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String newName)
	{
		lastName = newName;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String newNumber)
	{
		phoneNumber = newNumber;
	}
	public void removePerson(int pos, int currentSize, Person [] persons)
	{
		for(int i = pos; i < currentSize; i++)
		{
			persons[i-1] = persons [i];
		}
		currentSize--;
	}
}