package bartek.logic.direction;

import bartek.logic.Board;

public class Up implements Move {
    @Override
    public void move(Board board) {
        board.moveFieldsUp();
    }
}
