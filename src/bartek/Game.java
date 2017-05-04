package bartek;

import bartek.direction.Down;
import bartek.direction.Left;
import bartek.direction.Right;
import bartek.direction.Up;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Game {
    private final Board board;
    private final PointsCounter pointsCounter = new PointsCounter();

    public Game() {
        board = new Board(pointsCounter);
        setNewField();
        setNewField();
    }

    private void setNewField() {
        Random random = new Random();
        if (board.getEmptyFieldsCount() != 0) {
            while (true) {
                int randomX = random.nextInt(4);
                int randomY = random.nextInt(4);
                if (board.getFields()[randomX][randomY] == 0) {
                    board.getFields()[randomX][randomY] = 2;
                    break;
                }
            }
        }
    }

    public void move(int keyCode) {
        Direction direction = null;
        if (keyCode == KeyEvent.VK_DOWN) {
            direction = new Down();
        }

        if (keyCode == KeyEvent.VK_UP) {
            direction = new Up();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            direction = new Left();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            direction = new Right();
        }

        if (direction != null) {
            direction.move(board);
            setNewField();
        }
    }

    public Board getBoard() {
        return board;
    }

    public int getPoints() {
        return pointsCounter.getPoints();
    }
}
