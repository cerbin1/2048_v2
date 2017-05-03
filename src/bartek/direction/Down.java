package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Down extends Direction {
    @Override
    public void move(Board board) {
        board.down();
    }
}
