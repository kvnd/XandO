package wit.cgd.xando.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board {

	public static final String TAG = Board.class.getName();
	
	public static enum GameState {
		PLAYING, DRAW, X_WON, O_WON
	}
	
	public GameState gameState;
	
	// The actual board and symbols used to represent X and O
	public final int EMPTY = 0;
	public final int X = 1;
	public final int O = 2;
	public int[][] cells = new int[3][3];
	
	public BasePlayer firstPlayer, secondPlayer;
	public BasePlayer currentPlayer;
	
	private void init() {
		start();
	}

	public void start() {
		
		cells = new int[EMPTY][EMPTY];
		
		gameState = GameState.PLAYING;
		
		currentPlayer = firstPlayer;
	}
	
	// Calls main move method with dummy values (for human move)
	public boolean move() {
		return move(-1, -1);
	}

	// Plays the move into (row,col) if valid
	public boolean move(int row, int col) {
		int pos = encode(row, col);
		// TODO: If current player is human then
		if (currentPlayer.human == true) {
			if (row < 0 || row > 2 || col < 0 || col > 2)
				return false;
			else {
				// TODO Get move from _currentPlayer_ using its move() method
				int move = currentPlayer.move();
				// TODO De-encode _pos_ from move() into row,col pair
				row = decodeToRow(move);
				col = decodeToCol(move);
			}
			// TODO Now have a valid move into an empty cell
			
			// TODO Store move
			
			// TODO Check for win using hasWon() and update game state
			
			// TODO If still playing then check for draw using isDraw() and update game state
			if (gameState == GameState.PLAYING) {
				if (isDraw())
					gameState = GameState.DRAW;
			}
			
			if (gameState == GameState.PLAYING) {
				// TODO If still playing then switch player
			}
		}
	}
	
	public boolean isDraw() {
		// TODO Return true if game is a draw, false otherwise
		if (gameState.equals(GameState.DRAW))
				return true;
		else 
			return false;
	}
	
	public boolean hasWon(int symbol, int row, int col) {
		// TODO True if player using symbol _symbol_ wins after placing at pos (row,col)
		// This method simply checks if last move results in a win
	}
	
	public void render(SpriteBatch batch) {
		// TODO Render board so it is centered horizontally on bottom edges of screen
		// Image may be scaled by a factor of four to fill up screen more
		
		// TODO Render contents of cell array, drawing X & O as needed (nested for loop)
		
		// All rendering performed using batch.draw()
	}
	
	public int encode(int row, int col) {
		return row * 3 + col;
	}
	
	public int decodeToRow(int pos) {
		return pos / 3;
	}
	
	public int decodeToCol(int pos) {
		return pos % 3;
	}
	
}
