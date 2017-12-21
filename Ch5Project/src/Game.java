//Create name1
//Create answer 1
//Create name2
//Create answer 2
//Create a game class
//Create a startGame class
//Create player one
//Create player two
//Set player one's name and choice
//Set playertwo's name and choice
//Get player one's name and answer
//Get player Two's name and answer
//Create an if statement determining player ones options
//Create a nested if statement determining player ones options
//Compare the two choices
//Allow for errors
public class Game
{
//Create name1
	private String nameOne;
//Create answer 1
	private String answerOne;
	
//Create name2
	private String nameTwo;
//Create answer 2
	private String answerTwo;
//Create a game class
	public void game()
	{
		
	}
//Create a startGame class
public void startGame()
	{
//Create player one
	Players playerOne = new Players();
//Create player two
	Players playerTwo = new Players();
//Set player one's name and choice
	playerOne.setName();
	playerOne.setChoice();
//Set playertwo's name and choice
	playerTwo.setName();
	playerTwo.setChoice();
//Get player one's name and answer
	nameOne= playerOne.getName();
	answerOne = playerOne.getChoice();
//Get player Two's name and answer
	nameTwo= playerTwo.getName();
	answerTwo = playerTwo.getChoice();
	
//Create an if statement determining player ones options
	//player one is rock
	if (answerOne.equals("rock"))
	{
//Create a nested if statement determining player ones options
		//Player two is rock
		if(answerTwo.equals("rock"))
		{
//Compare the two choices
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Both rock then should be a tie
			System.out.println("It is a TIE!");
		}
		//Player two paper
		else if(answerTwo.equals("paper"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has rock and player two has paper
			//Player two wins
			System.out.println(nameTwo+ " WINS!");
		}
		else if(answerTwo.equals("scissors"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has rock and player two has scissors
			//Player one wins
			System.out.println(nameOne+ " Wins!");
		}
		else
		{
//Allow for errors
			//if not a correct answer then it shows error
			System.out.println("ERROR: anwser wrong");
		}
	}
	else if (answerOne.equals("paper"))
	{
		if(answerTwo.equals("rock"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has paper and player two has rock
			//Player one wins
			System.out.println(nameOne+ " Wins!");
		}
		else if(answerTwo.equals("paper"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has paper and player two has paper
			//It is a tie
			System.out.println("It is a TIE!");
		}
		else if(answerTwo.equals("scissors"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has paper and player two has scissors
			//player two wins
			System.out.println(nameTwo+ " Wins!");
		}
		else
		{
			//if not a correct answer then it shows error
			System.out.println("ERROR: anwser wrong");
		}
	}
	else if (answerOne.equals("scissors"))
	{
		if(answerTwo.equals("rock"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has scissors and player two has rock
			//player two wins
			System.out.println(nameTwo+ " Wins");
		}
		else if(answerTwo.equals("paper"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has scissors and player two has paper
			//Player one wins
			System.out.println(nameOne+ " WINS!");
		}
		else if(answerTwo.equals("scissors"))
		{
			//State player one's choice
			System.out.println(nameOne+ " uses " +answerOne+ "!");
			//State player two's choice
			System.out.println(nameTwo+ " uses " +answerTwo+ "!");
			//Player one has scissors and player two has scissors
			//should be a tie
			System.out.println("It is a TIE!");
		}
		else
		{
			//if not a correct answer then it shows error
			System.out.println("ERROR: anwser wrong");
		}
	}
	else
	{
		//if not a correct answer then it shows error
		System.out.println("ERROR: anwser wrong");
	}
	}
}