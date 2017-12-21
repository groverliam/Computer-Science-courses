import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;



public class Game {

	String[] pos = { "A1", "A2", "A3","B1", "B2", "B3","C1", "C2", "C3"};
	final int ROW = 3;
	final int COL = 3;
	final String DEF = " ";
	String[][] board = new String [ROW][COL];
	public Game()
	{
		for(int i = 0 ; i < ROW ; i++)
		{
			for(int j = 0 ; j < COL ; j++)
			{
				board[i][j] = DEF;
			}
		}	
	}
	public void showBoard()
	{
		System.out.println("    1    2    3");
		System.out.println("A   "+board[0][0]+"  | "+board[0][1]+"  | "+board[0][2]);
		System.out.println("  ---------------");
		System.out.println("B   "+board[1][0]+"  | "+board[1][1]+"  | "+board[1][2]);
		System.out.println("  ---------------");
		System.out.println("C   "+board[2][0]+"  | "+board[2][1]+"  | "+board[2][2]);
	}

	public void spotsToWords()
	{
		System.out.println("Your options are: ");
		for(int i = 0; i< pos.length; i++)
		{
			if(i+1 != pos.length){
				System.out.print(pos[i]+", ");
			}
			else
			{
				System.out.print(pos[i]);
			}
		}
	}

	public void persPick(String letter)
	{
		Scanner in = new Scanner(System.in);
		int pRow;
		int pCol;
		String pick;
		int n = 1;
		while (n == 1)
		{
		System.out.println("Choose a spot not taken.");
		spotsToWords();
		System.out.println();
		pick = in.next();
		pick = pick.toUpperCase();
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
				n--;
			}
			}
		}
	}

	public void compPick(String letter)
	{
		int n = 0;
		while (n == 0)
		{
			int pRow = ThreadLocalRandom.current().nextInt(1, 3 + 1) - 1;
			int pCol = ThreadLocalRandom.current().nextInt(1, 3 + 1) - 1;
			//System.out.println(pRow + "   " + pCol);
			if(board[pRow][pCol] == DEF)
			{
				board[pRow][pCol] = letter;
				n++;
			}

			if(pRow == 0 && pCol == 0)
			{
				pos[0] = "";
			}
			else if(pRow == 0 && pCol == 1)
			{
				pos[1] = "";
			}
			else if(pRow == 0 && pCol == 2)
			{
				pos[2] = "";
			}
			else if(pRow == 1 && pCol == 0)
			{
				pos[3] = "";
			}
			else if(pRow == 1 && pCol == 1)
			{
				pos[4] = "";
			}
			else if(pRow == 1 && pCol == 2)
			{
				pos[5] = "";
			}
			else if(pRow == 2 && pCol == 0)
			{
				pos[6] = "";
			}
			else if(pRow == 2 && pCol == 1)
			{
				pos[7] = "";
			}
			else if(pRow == 2 && pCol == 2)
			{
				pos[8] = "";
			}
			
		}
	}
	

	public void draw()
	{
		if (board[0][0] != " " && board[0][1] != " " && board[0][2] != " " &&
				board[1][0] != " " && board[1][1] != " " && board[1][2] != " " &&
						board[2][0] != " " && board[2][1] != " " && board[2][2] != " ")
		{
			System.out.println("It's a DRAW!");
		}
		else
		{
			//System.out.println("It's a DRAW!");
		}
	}
	public int didWin(int turn)
	{
		if(checkRows() || checkCols() || checkDia())
		{
			turn = 10; //10 will end it
			System.out.println("GAME OVER");
			return turn;
		}
		else
		{
			return turn;
		}
	}
	public boolean checkRows()
	{
		boolean good = false;
		for(int i = 0; i < ROW; i++)
		{
			if (good && board[i][0] == "O" && board[i][1] == "O" && board[i][2] == "O")
			{
				System.out.println("PLAYER TWO WINS!!!!!!!");
				good = true;
			}
			else if (good && board[i][0] == "X" && board[i][1] == "X" && board[i][2] == "X")
			{
				System.out.println("PLAYER ONE WINS!!!!!!!");
				good = true;
			}
		}
		return good;
	}
	public boolean checkCols()
	{
		boolean good = false;
		for(int i = 0; i < COL; i++)
		{
			if (board[0][i] == "O" && board[1][i] == "O" && board[2][i] == "O")
			{
				System.out.println("PLAYER TWO WINS!!!!!!!");
				good = true;
			}
			else if (board[0][i] == "X" && board[1][i] == "X" && board[2][i] == "X")
			{
				System.out.println("PLAYER ONE WINS!!!!!!!");
				good = true;
			}
		}
		return good;
	}
	public boolean checkDia()
	{
		boolean good = false;
			if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O")
			{
				System.out.println("PLAYER TWO WINS!!!!!!!");
				good = true;
			}
			else if (board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X")
			{
				System.out.println("PLAYER ONE WINS!!!!!!!");
				good = true;
			}
			else if (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O")
			{
				System.out.println("PLAYER ONE WINS!!!!!!!");
				good = true;
			}
			else if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X")
			{
				System.out.println("PLAYER TWO WINS!!!!!!!");
				good = true;
			}
			
		return good;
	}

}
