package bartek.direction;

import bartek.Board;

public class Up extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsUp();
    }
}
