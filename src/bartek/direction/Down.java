package bartek.direction;

import bartek.Board;

public class Down extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsDown();
    }
}
