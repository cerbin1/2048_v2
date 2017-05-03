package bartek;

import bartek.direction.Down;
import bartek.direction.Left;
import bartek.direction.Right;
import bartek.direction.Up;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Application {
    private Tile[][] tiles = new Tile[4][4];
    private JFrame frame = new JFrame("1024");
    private final Board board;

    public Application(Board board) {
        this.board = board;
        initializeTiles();
    }

    private void setNewField() {
        Random random = new Random();
        if (board.getEmptyFields() != 0) {
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

    public void displayFrame() {
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 4));
        frame.addKeyListener(keyListener());
        setNewField();
        setNewField();

        updateJButtons();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    private KeyListener keyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                move(e.getKeyCode());
                setNewField();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    public void initializeTiles() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                tiles[x][y] = new Tile(createSingleJButton());
            }
        }
    }

    private JButton createSingleJButton() {
        JButton jButton = new JButton("");
        jButton.setPreferredSize(new Dimension(50, 50));
        jButton.setEnabled(false);
        frame.add(jButton);
        return jButton;
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
        }

        updateJButtons();
    }

    private void updateJButtons() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                tiles[x][y].setText(Integer.toString(board.getFields()[x][y]));
            }
        }
    }

    public static void main(String[] args) {
        new Application(new Board()).displayFrame();
    }
}
