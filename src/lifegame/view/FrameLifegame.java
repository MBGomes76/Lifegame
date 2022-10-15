package lifegame.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import lifegame.Controller;
import lifegame.model.Lifegame;

public class FrameLifegame extends JFrame
{	
	private PanelLifegame panelLifegame;
	
	public FrameLifegame( Controller ctrl, Lifegame lifegame )
	{
		this.setTitle( "Lifegame" );
		
		// Frame component initialization
		this.panelLifegame = new PanelLifegame( ctrl, lifegame );

		// Adding components
		this.add( this.panelLifegame );

		this.setVisible( true );
		this.pack();
		this.setLocationRelativeTo( null );
		// this.setResizable( false );
		this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
	}

	public void maj()
	{
		this.panelLifegame.maj();
	}
}
