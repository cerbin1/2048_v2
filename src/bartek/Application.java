package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Application {
    Tile[][] tiles = new Tile[4][4];
    JFrame frame = new JFrame("1024");
    final Board board;
    int[][] fields;

    public Application(Board board) {
        this.board = board;
        fields = board.getFields();
        initializeTiles();
    }

    private void initializeFewFields() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            fields[random.nextInt(4)][random.nextInt(4)] = 2;
        }
    }


    public void displayFrame() {
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 4));
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                move(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        initializeFewFields();

        updateJButtons();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void initializeTiles() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j] = new Tile(createSingleJButton());
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
        System.out.println(keyCode);
        if (keyCode == 40) {
            for (int y = 0; y < 4; y++) {
                board.performMoveOnColumn(y, 1);
            }
        }

        if (keyCode == 38) {
            for (int y = 0; y < 4; y++) {
                board.performMoveOnColumn(y, -1);
            }
        }

        displayFields(fields);
        updateJButtons();
    }

    private void displayFields(int[][] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void updateJButtons() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                tiles[i][j].setText(Integer.toString(fields[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        new Application(new Board()).displayFrame();
    }
}
