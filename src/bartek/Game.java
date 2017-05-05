package bartek;

import bartek.direction.*;

import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class Game {
    private static final Random random = new Random();

    private final Board board;
    private final PointsCounter pointsCounter = new PointsCounter();

    private boolean done = false;

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
            if (isFieldEmpty(x, y)) {
                setFieldWithDefaultValue(x, y);
                break;
            }
        }
    }

    private boolean isFieldEmpty(int x, int y) {
        return board.getFields()[x][y] == 0;
    }

    private void setFieldWithDefaultValue(int x, int y) {
        board.getFields()[x][y] = 2;
    }

    public void move(int keyCode) {
        Direction direction = setDirection(keyCode);

        if (direction != null) {
            if (board.canMove()) {
                direction.move(board);
                setNewField();
            } else {
                done = true;
            }
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

    public boolean isGameDone() {
        return done;
    }
}
