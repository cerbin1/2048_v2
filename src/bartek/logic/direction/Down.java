package bartek.logic.direction;

import bartek.logic.Board;

public class Down extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsDown();
    }
}
