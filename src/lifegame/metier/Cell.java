package lifegame.metier;

public class Cell
{
	private boolean state;
	private boolean nextState;

	// CONSTRUCTORS
	public Cell( boolean state )
	{
		this.state     = state;
		this.nextState = state;
	}

	// GETTERS
	public boolean getState()
	{
		return this.state;
	}

	// SETTERS
	public void setNextState( boolean nextState )
	{
		this.nextState = nextState;
	}

	// METHODS
	public void commute()
	{
		this.state = this.nextState;
	}

	public String toString()
	{
		return this.state?"T":"F";
	}
}
