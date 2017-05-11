package bartek.logic.direction;

import bartek.logic.Board;

import static java.awt.event.KeyEvent.*;

public interface Move {
    void move(Board board);

    static Move getDirection(int keyCode) {
        switch (keyCode) {
            case VK_DOWN:
                return new Down();
            case VK_UP:
                return new Up();
            case VK_LEFT:
                return new Left();
            case VK_RIGHT:
                return new Right();
            default:
                return null;
        }
    }
}
