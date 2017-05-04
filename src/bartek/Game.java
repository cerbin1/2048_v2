package bartek;

import bartek.direction.*;

import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class Game {
    private final Board board;
    private final PointsCounter pointsCounter = new PointsCounter();
    private static final Random random = new Random();

    public Game() {
        board = new Board(pointsCounter);
        setNewField();
        setNewField();
    }

    private void setNewField() {
        if (canAddNewField()) {
            addNewField();
        }
    }

    private boolean canAddNewField() {
        return board.countEmptyFields() != 0;
    }

    private void addNewField() {
        while (true) {
            int x = random.nextInt(4);
            int y = random.nextInt(4);
            if (board.getFields()[x][y] == 0) {
                board.getFields()[x][y] = 2;
                break;
            }
        }
    }

    public void move(int keyCode) {
        Direction direction = setDirection(keyCode);

        if (direction != null) {
            direction.move(board);
            setNewField();
        }
    }

    private Direction setDirection(int keyCode) {
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

    public Board getBoard() {
        return board;
    }

    public int getPoints() {
        return pointsCounter.getPoints();
    }
}
