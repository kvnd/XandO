package wit.cgd.xando.game.ai;

import wit.cgd.xando.game.BasePlayer;
import wit.cgd.xando.game.Board;

public class FirstSpacePlayer extends BasePlayer {

	public FirstSpacePlayer(Board board, int symbol) {
		super(board, symbol);
		human = false;
	}

	@Override
	public int move() {
		// TODO Find coordinates of first free space and return using encoding
		// Otherwise return -1
		return -1;
	}

}
