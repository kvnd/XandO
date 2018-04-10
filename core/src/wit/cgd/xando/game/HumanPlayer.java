package wit.cgd.xando.game;

public class HumanPlayer extends BasePlayer {

	public HumanPlayer(Board board, int symbol) {
		super(board, symbol);
		human = true;
	}

	@Override
	public int move() {
		// TODO To be processed by worldController (human move done via user input)
		return 0;
	}

}
