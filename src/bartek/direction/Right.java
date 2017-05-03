package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Right extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsRight();
    }
}
