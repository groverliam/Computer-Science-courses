
public class PvAI {
	String p1 = "X";
	String ai2 = "O";
	int whoMoves;
	public PvAI()
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
				g.compPick(ai2);
			}
			turn = g.didWin(turn);
			
		}
		g.showBoard();
		g.draw();
	}
}
