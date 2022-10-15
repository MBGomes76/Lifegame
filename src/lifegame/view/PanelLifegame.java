package lifegame.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import lifegame.Controller;
import lifegame.model.Lifegame;

public class PanelLifegame extends JPanel
{
	private JLabel[][] grid;
	
	private Lifegame lifegame;
	private Controller ctrl;
	
	public PanelLifegame( Controller ctrl, Lifegame lifegame )
	{
		this.ctrl     = ctrl;
		this.lifegame = lifegame;

		this.setLayout( new GridLayout( this.lifegame.getWidth(), this.lifegame.getHeight() ));
		
		// JLabel grid initialization
		this.grid = PanelLifegame.initGrid( this.lifegame.getWidth(), this.lifegame.getHeight() );
		this.maj();
	}

	private static JLabel[][] initGrid( int w, int h )
	{
		JLabel[][] grid = new JLabel[h][w];

		for( int i = 0; i < h; i++ )
		{
			for( int j = 0; j < w; j++ )
			{
				grid[i][j] = new JLabel();
				grid[i][j].setPreferredSize( new Dimension( 10, 10 ) );
				grid[i][j].setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
				grid[i][j].setOpaque( true );
			}
		}

		return grid;
	}

	public void maj()
	{
		for( int i = 0; i < this.lifegame.getWidth(); i++ )
		{
			for( int j = 0; j < this.lifegame.getHeight(); j++ )
			{
				this.grid[i][j].setBackground( this.lifegame.getCell( i, j ) ? Color.BLACK : Color.WHITE );

				this.add( this.grid[i][j] );
			}
		}
	}
}
