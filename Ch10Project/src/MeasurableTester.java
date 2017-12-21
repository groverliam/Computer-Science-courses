
public class MeasurableTester
{

	public static void main(String[] args) 
	{
		final int LENGTH= 3;
		Measurable[] quizzes = new Measurable[LENGTH];
		Measurable[] persons = new Measurable[LENGTH];
		
		quizzes[0] = new Quiz (88.8, "B+");
		quizzes[1] = new Quiz (70.3, "C-");
		quizzes[2] = new Quiz (90, "A");
		
		double averageScore = Data.average(quizzes);
		Measurable maxScore = Data.max(quizzes);
		
		System.out.println("1) " + quizzes[0]);
		System.out.println("2) " + quizzes[1]);
		System.out.println("3) " + quizzes[2]);
		System.out.println("Max "+ maxScore);
		System.out.println("The quiz average is : "+averageScore +"\n");
		
		persons[0] = new Person ("Henry", 66);
		persons[1] = new Person ("Bobby", 72);
		persons[2] = new Person ("Jack", 60);
		
		double averageHeight = Data.average(persons);
		Measurable maxHeight = Data.max(persons);
		
		System.out.println("1) " + persons[0]);
		System.out.println("2) " + persons[1]);
		System.out.println("3) " + persons[2]);
		System.out.println("Max height is : "+ maxHeight);
		System.out.println("The average height is : "+averageHeight+ " inches");
		

	}

}
