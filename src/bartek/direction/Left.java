package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Left extends Direction {
    @Override
    public void move(Board board) {
        board.left();
    }
}
