package bartek.direction;

import bartek.Board;
import bartek.Direction;

public class Down extends Direction {
    @Override
    public void move(Board board) {
        for (int x = 0; x < 4; x++) {
            board.down(x);
        }
    }
}
