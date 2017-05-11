package bartek.logic.direction;

import bartek.logic.Board;

public class Down implements Move {
    @Override
    public void move(Board board) {
        board.moveFieldsDown();
    }
}
