package bartek.logic.direction;

import bartek.logic.Board;

public class Left implements Move {
    @Override
    public void move(Board board) {
        board.moveFieldsLeft();
    }
}
