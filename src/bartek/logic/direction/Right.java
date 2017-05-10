package bartek.logic.direction;

import bartek.logic.Board;

public class Right extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsRight();
    }
}
