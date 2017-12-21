
public class PvP {
	String p1 = "X";
	String p2 = "O";
	int whoMoves;
	public PvP()
	{
		Game g = new Game();
		for(int turn = 1; turn < 10; turn++)
		{
			whoMoves = turn % 2;
			if(whoMoves == 1)
			{
				System.out.println("\n PLAYER ONE GOES! \n");
				g.showBoard();
				g.persPick(p1);
			}
			else
			{
				System.out.println("\n PLAYER TWO GOES! \n");
				g.showBoard();
				g.persPick(p2);
			}
			turn = g.didWin(turn);
			
		}
		g.showBoard();
		g.draw();

		
	}
}
