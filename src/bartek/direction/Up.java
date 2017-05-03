package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Up extends Direction {
    @Override
    public void move(Board board) {
        for (int x = 0; x < 4; x++) {
            board.up(x);
        }
    }
}
