package bartek.logic.direction;

import bartek.logic.Board;

public class Right implements Move {
    @Override
    public void move(Board board) {
        board.moveFieldsRight();
    }
}
