package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Up extends Direction {
    @Override
    public void move(Board board) {
        board.up();
    }
}
