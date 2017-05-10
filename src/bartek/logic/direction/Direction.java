package bartek.logic.direction;

import bartek.logic.Board;

import static java.awt.event.KeyEvent.*;

public abstract class Direction {
    public abstract void move(Board board);

    public static Direction setDirection(int keyCode) {
        if (keyCode == VK_DOWN) {
            return new Down();
        }

        if (keyCode == VK_UP) {
            return new Up();
        }

        if (keyCode == VK_LEFT) {
            return new Left();
        }

        if (keyCode == VK_RIGHT) {
            return new Right();
        }
        return null;
    }
}
