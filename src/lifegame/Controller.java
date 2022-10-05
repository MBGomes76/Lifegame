package lifegame;

import lifegame.metier.Lifegame;

public class Controller
{
	private Lifegame lifegame;
	
	// CONSTRUCTORS
	public Controller( int lig, int col )
	{
		this.lifegame = new Lifegame( lig, col );

		while( true )
		{
			try
			{
				System.out.println( this.lifegame );
				this.lifegame.update();
				
				Thread.sleep( 1000 );
			}
			catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	public static void main(String[] args)
	{
		new Controller( 5, 5 );
	}
}