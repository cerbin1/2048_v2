package bartek.logic.direction;

import bartek.logic.Board;

public class Left extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsLeft();
    }
}
