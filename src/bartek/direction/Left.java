package bartek.direction;

import bartek.Board;

public class Left extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsLeft();
    }
}
