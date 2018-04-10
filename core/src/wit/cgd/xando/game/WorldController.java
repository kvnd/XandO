package wit.cgd.xando.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import wit.cgd.xando.game.Board.GameState;
import wit.cgd.xando.game.ai.FirstSpacePlayer;

public class WorldController extends InputAdapter {
	
	// TODO store screen width, height, and viewportWidth in worldColtroller
	
	private static final String TAG = WorldController.class.getName();
	public float viewportWidth;
	public int width, height;
	public Board board;
	
	public WorldController() {
		init();
	}

	// Initialization code separated from constructor to save on performance
	private void init() {
		Gdx.input.setInputProcessor(this);
		
		board = new Board();
		
		board.firstPlayer = new HumanPlayer(board, board.X);
		
		board.secondPlayer = new FirstSpacePlayer(board, board.O);
		
		board.start();
	}
	
	// TODO Implement method
	public void update (float deltaTime) {
		if (board.gameState == GameState.PLAYING) 
			board.move();
	};
	
	// Maps position of click/touch to a cell on the board
	// TODO Implement method
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (board.gameState == GameState.PLAYING && board.currentPlayer.human == true) {
			// TODO Calculate row coordinate using height and screenY
			int row = 0; // Placeholder value
			// TODO Calculate col coordinate using viewportWidth, screenX and width
			int col = 0; // Placeholder value
			if (board.encode(row, col) >= 0 && board.encode(row, col) <= 8)
				board.move(row,col);
		}
		return true;
	};
	
}
