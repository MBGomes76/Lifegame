package lifegame.model;

public class Lifegame
{
	private Cell[][] grid;

	// CONSTRUCTORS
	public Lifegame( int lig, int col )
	{
		this.grid = Lifegame.gridInit( lig, col );

		this.grid[10][10] = new Cell( true );
		this.grid[11][10] = new Cell( true );
		this.grid[12][10] = new Cell( true );
	}

	// GETTERS
	public int getWidth()
	{
		return this.grid[0].length;
	}

	public int getHeight()
	{
		return this.grid.length;
	}

	public boolean getCell( int lig, int col )
	{
		return this.grid[lig][col].getState();
	}

	// METHOD
	public void update()
	{
		this.setNextStates();
		this.commuteCells();
	}
	
	// PRIVATE METHODS
	private void setNextStates()
	{
		int alive;

		for( int i = 0; i < this.grid.length; i++ )
		{
			for( int j = 0; j < this.grid[0].length; j++ )
			{
				alive = 0;
				
				// top left corner
				if( (i - 1 >= 0 && j - 1 >= 0) && this.grid[i - 1][j - 1].getState() ) { alive++; }

				// top middle
				if( i - 1 >= 0 && this.grid[i - 1][j].getState() ) { alive++; }

				// top right corner
				if( (i - 1 >= 0 && j + 1 < this.grid[0].length) && this.grid[i - 1][j + 1].getState() ) { alive++; }

				// left
				if( j - 1 >= 0 && this.grid[i][j - 1].getState() ) { alive++; }

				// right
				if( j + 1 < this.grid[0].length && this.grid[i][j + 1].getState() ) { alive++; }

				// bottom left corner
				if( (i + 1 < this.grid[0].length && j - 1 >= 0) && this.grid[i + 1][j - 1].getState() ) { alive++; }

				// bottom middle
				if( i + 1 < this.grid[0].length && this.grid[i + 1][j].getState() ) { alive++; }

				// bottom right corner
				if( (i + 1 < this.grid[0].length && j + 1 < this.grid[0].length) && this.grid[i + 1][j + 1].getState() ) { alive++; }


				// We set the nextState attribute at true or false for each cell
				this.grid[i][j].setNextState( (!this.grid[i][j].getState() && alive == 3) || (this.grid[i][j].getState() && (alive == 2 || alive == 3 )) );
			}
		}
	}

	private void commuteCells()
	{
		for( int i = 0; i < this.grid.length; i++ )
			for( int j = 0; j < this.grid[0].length; j++ )
				this.grid[i][j].commute();
	}

	// STATIC METHODS
	private static Cell[][] gridInit( int lig, int col )
	{
		Cell[][] grid = new Cell[lig][col];

		for( int i = 0; i < lig; i++ )
			for( int j = 0; j < col; j++ )
				grid[i][j] = new Cell( false );

		return grid;
	}

	public String toString()
	{
		// Border creation
		String border = "+";

		for( int col = 0; col < this.grid[0].length; col++ )
			border += "---+";

		border += "\n";

		// Display grid
		String sRet = border;

		for( int i = 0; i < this.grid.length; i++ )
		{
			for( int j = 0; j < this.grid[0].length; j++ )
			{
				sRet += "| " + this.grid[i][j] + " ";
			}

			sRet += "|\n" + border;
		}

		return sRet;
	}
}
