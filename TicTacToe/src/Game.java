import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//use modular to make odd turns player one and even player two.
public class Game {
	String[] pos = { "topleft", "topmiddle", "topright",
			"middleleft", "middle", "middleright",
			"bottomleft", "bottommiddle", "bottomright"
	};
	protected int row = 3;
	protected int col = 3;
	char[][] board = new char [row][col];
	protected String gameType;
	protected String type;
	protected char p1 = 'X';
	protected char p2 = 'O';
	int turn = 1;
	int who;

	public Game ()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to play or watch?");
		type = in.next();
		type.toLowerCase();
		if (type.equals("play"))
		{
			System.out.println("Would you like to play a friend or computer?");
			gameType = in.next();
			gameType.toLowerCase();
			if (gameType.equals("friend")) //Person vs Person
			{

				System.out.println("Player 1 goes first as X!");
				gameBoard();
				while(turn != 10)
				{
					showBoard();
					who = turn % 2;
					if(who == 1)
					{
						//player 1
						System.out.println("Player 1!");
						playerChoice(p1);
						
					}
					else
					{
						//player2
						System.out.println("Player 2!");
						playerChoice(p2);
					}
					draw();
					winOnBoard();
					/*if(fullBoard())
					{
						turn = 10;
					}
					else if(winOnBoard())
					{
						turn = 10;
					}*/
					turn++;
				}
			}
			else //Person vs AI
			{
				System.out.println("Player 1 goes first as X!");
				gameBoard();
				while(turn != 10)
				{
					showBoard();
					who = turn % 2;
					if(who == 1)
					{
						//player 1
						System.out.println("Player 1!");
						playerChoice(p1);
						
					}
					else
					{
						//computer
						System.out.println("Computer!");
						compChoice(p2);
					}
					//draw();
					//winOnBoard();
					/*if(fullBoard())
					{
						turn = 10;
					}
					else if(winOnBoard())
					{
						turn = 10;
					}*/
					turn++;
				}
				
			}
		}
		else//AI vs AI
		{
			System.out.println("Player 1 goes first as X!");
			gameBoard();
			while(turn != 10)
			{
				showBoard();
				who = turn % 2;
				if(who == 1)
				{
					//player 1
					System.out.println("Player 1!");
					compChoice(p1);
					
				}
				else
				{
					//player2
					System.out.println("Player 2!");
					compChoice(p2);
				}
				draw();
				winOnBoard();
				/*if(fullBoard())
				{
					turn = 10;
				}
				else if(winOnBoard())
				{
					turn = 10;
				}*/
				turn++;
			}

		}
		/*System.out.println("You have chosen to play with a computer!");
		System.out.println("You are X");
		gameBoard();
		showBoard();
		toWords(pos);*/


	}
	/*public Game (String p1Choice) //verse player
	{
		System.out.println("You have chosen to play with a friend!");
		System.out.println("Player 1 is "+p1Choice+"!");
		gameBoard();
		showBoard();
		toWords(pos);
	}*/
	public void gameBoard()
	{
		for(int i = 0 ; i < 0 ; i++)
		{
			for(int j = 0 ; j < 0 ; j++)
			{
				board[i][j] = ' ';
			}
		}	
	}
	public void showBoard()
	{
		System.out.println("  "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
		System.out.println("----------");
		System.out.println("  "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
		System.out.println("----------");
		System.out.println("  "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
	}
	public void toWords(String[] a)
	{
		System.out.println("Your options are: ");
		for(int i = 0; i< a.length; i++)
		{
			if(i+1 != a.length){
				System.out.print(pos[i]+", ");
			}
			else
			{
				System.out.print(pos[i]);
			}
		}
	}
	public void compChoice(char letter)
	{
		int n = 0;
		/*int rRow = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		int rCol = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		while (n != 1)
			if(board[rRow][rCol] == ' ')
			{
				board[rRow][rCol] = letter;
				n= 1;
			}
			else
			{
				rRow = ThreadLocalRandom.current().nextInt(0, 2 + 1);
				rCol = ThreadLocalRandom.current().nextInt(0, 2 + 1);
			}*/
		while(n != 1)
		{
			int cPick = ThreadLocalRandom.current().nextInt(0, 8 + 1);
			if (cPick<3)
			{
				if(board[0][cPick] == ' ')
				{
					board[0][cPick] = letter;
					n = 1;
				}
			}
			else if (3<= cPick && cPick < 6)
			{
				if(board[1][cPick-3] == ' ')
				{
					board[1][cPick-3] = letter;
					n = 1;
				}
			}
			else
			{
				if(board[2][cPick-6] == ' ')
				{
					board[2][cPick-6] = letter;
					n = 1;
				}
			}
		}

	}
	public void playerChoice(char letter)
	{
		Scanner in = new Scanner(System.in);
		int pRow;
		int pCol;
		String pick;
		//while (n != 1)
		System.out.println("Where would you like to go?");
		toWords(pos);
		System.out.println();
		pick = in.next();
		pick.toLowerCase();
		for (int p = 0 ; p < 9 ; p++)
		{
			if (pos[p].equals(pick))
			{
				pos[p] = "";
				//pos[p].
				if (p<3)
				{
					board[0][p] = letter;
				}
				else if (3<= p && p < 6)
				{
					board[1][p-3] = letter;
				}
				else
				{
					board[2][p-6] = letter;
				}
			}
		}
		/*if (pick == pos[0] || pick == pos[1] || pick == pos[2] || 
				pick == pos[3] || pick == pos[4] || pick == pos[5] || 
				pick == pos[] || pick == pos[0] || pick == pos[0])
		{
			
		}*/
	}
	public boolean draw()//tie
	{
		/*if (board[0][0] == ' ' || board[0][2] == ' ' || board[0][2] == ' ' 
				|| board[1][0] == ' ' || board[1][1] == ' ' || board[1][2] == ' ' ||
				board[2][0] == ' ' || board[2][1] == ' ' || board[2][2] == ' ')
		{
			System.out.println("It's a DRAW!");
			return false;
		}
		else
		{
			//System.out.println("It's a DRAW!");
			return true;
		}*/
		for(int e = 0; e < 3; e++)
		{
			for(int f = 0; f < 3; f++)
			{
				if(board[e][f] == ' ')
				{
					return false;
				}
			}
		}
		System.out.println("It's a DRAW!");
		return true; //draw
	}
	public boolean winOnBoard() {//win
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == 'X' || board[0][0] == 'O')) 
		{
			return true;
		} 
		else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O')) 
		{
			return true;
		} 
		else if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == 'X' || board[0][0] == 'O')) 
		{
			return true;
		} 
		else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == 'X' || board[0][1] == 'O')) 
		{
			return true;
		} 
		else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == 'X' || board[0][2] == 'O')) 
		{
			return true;
		} 
		else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == 'X' || board[1][0] == 'O')) 
		{
			return true;
		} 
		else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == 'X' || board[2][0] == 'O')) 
		{
			return true;
		} 
		else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[2][0] == 'X' || board[2][0] == 'O')) 
		{
			System.out.println("GAME OVER!");
			return true;
		} 
		else 
		{
			return false;
		}
	}
	/*public void turnPicker()
	{
		if(turn % 2)
		{
			
		}
	}*/

}
