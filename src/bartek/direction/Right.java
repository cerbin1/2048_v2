package bartek.direction;

import bartek.Board;

public class Right extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsRight();
    }
}
