package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Left extends Direction {
    @Override
    public void move(Board board) {
        for (int y = 0; y < 4; y++) {
            board.left(y);
        }
    }
}
