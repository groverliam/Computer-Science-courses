public class PersonTester
{

	public static void main(String[] args)
	{
		// create an instance of the Person class using a constructor with parameters for the name and year of birth
		Person person= new Person("Jim", "1995");
		
		// use the Accessor methods of the class to get the instance variables of the object
		person.setName("Ron");
		System.out.println("The name is " + person.getName());
		person.setYear("1996");
		System.out.println("The birth year is " + person.getYear());
		
		// print the instance variables of the object
		System.out.println(person+ "\n");
		
		// create an instance of the Student class using a constructor with parameters for the name, year of birth, and major
		Student student= new Student("Becky", "1995", "Computer Science");
		
		// use the accessor methods of the class to get the instance variables of the object, including those that are inherited
		student.setName("Jesse");
		System.out.println("The name is " + student.getName());
		student.setYear("1994");
		System.out.println("The birth year is " + student.getYear());
		student.setMajor("History");
		System.out.println("The major is " + student.getMajor());
		
		// print the instance variables of the object
		System.out.println(student+ "\n");
		
		// create an instance of the Instructor class using a constructor with parameters for the name, year of birth, and salary
		Instructor instructor= new Instructor("Joe", "1976", 50000);
		
		// use the accessor methods of the class to get the instance variables of the object, including those that are inherited
		instructor.setName("George");
		System.out.println("The name is " + instructor.getName());
		instructor.setYear("1964");
		System.out.println("The salary is " + instructor.getYear());
		instructor.setSalary(80000);
		System.out.println("The major is " + instructor.getSalary());
		
		// print the instance variables of the object
		System.out.println(instructor+ "\n");
		
		// create an array of type Person
		final int LENGTH= 3;
		Person[] persons= new Person[LENGTH];
		
		// add the person object to the array
		persons[0]= person;
		
		// add the Student object to the array
		persons[1]= student;
		
		// add the Instructor object to the array
		persons[2]= instructor;
		
		// use a for loop to process each element of the array
		// for each element of the array, use the toString method to print the instance variables of the object
		for (int i = 0; i<LENGTH; i++)
		{
			System.out.println((i+1)+") "+persons[i]);
		}



	}

}

