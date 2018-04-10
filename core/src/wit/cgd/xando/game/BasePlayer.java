package wit.cgd.xando.game;

// Base class for all players
public abstract class BasePlayer {

	public boolean human;
	public int mySymbol, opponentSymbol;
	public String name;
	public Board board;
	
	public BasePlayer(Board board, int symbol) {
		
		this.board = board;
		
		human = false;
		setSymbol(symbol);
	}

	public void setSymbol(int symbol) {
		// TODO Set mySymbol and opponentSymbol using board.O and board.X constants
		if (symbol == 1) {
		mySymbol = board.X;
		opponentSymbol = board.O;
		} else {
			mySymbol = board.O;
			opponentSymbol = board.X;
		}
	}
	
	public abstract int move();
	
}
