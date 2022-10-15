package lifegame;

import lifegame.model.Lifegame;
import lifegame.view.FrameLifegame;

public class Controller
{
	private Lifegame lifegame;
	private FrameLifegame ihm;
	
	// CONSTRUCTORS
	public Controller( int lig, int col )
	{
		this.lifegame = new Lifegame( lig, col );
		this.ihm      = new FrameLifegame( this, this.lifegame );

		while( true )
		{
			try
			{
				System.out.println( this.lifegame );
				this.lifegame.update();
				this.ihm.maj();
				
				Thread.sleep( 1000 );
			}
			catch (Exception e) { e.printStackTrace(); }
		}
	}

	public static void main(String[] args)
	{
		new Controller( 50, 50 );
	}
}