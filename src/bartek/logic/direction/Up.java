package bartek.logic.direction;

import bartek.logic.Board;

public class Up extends Direction {
    @Override
    public void move(Board board) {
        board.moveFieldsUp();
    }
}
