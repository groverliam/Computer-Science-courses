//Create private variable for player
//Create private variable for Answer
//Player is prompted for name
//Put user name in variable
//player is prompted for choice
//Put user choice in variable
//Get the name of the player
//Get the choice of the player
import java.util.Scanner;
public class Players
{
//Create private variable for player
private String player;
//Create private variable for Answer
private String answer;
Scanner in = new Scanner(System.in);
public Players()
{
}
public void setName()
{
//Player is prompted for name
System.out.println("What is your player's name?");
//Put user name in variable
player = in.next(); 
}
public void setChoice()
{
//player is prompted for choice
System.out.println("Rock, Paper, Scissors");
//Put user choice in variable
answer = in.next();
}
public String getName()
{
//Get the name of the player
return player;
}
public String getChoice()
{
//Get the choice of the player
return answer.toLowerCase();
}
}
