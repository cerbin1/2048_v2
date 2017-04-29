package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application {
    Tiles[][] tiles = new Tiles[4][4];
    JFrame frame = new JFrame("1024");
    final Board board;
    int[][] fields;

    public Application(Board board) {
        this.board = board;
        fields = board.getFields();
    }

    private void initializeFewFields() {
        fields[0][0] = 2;
        fields[1][0] = 2;
        fields[2][0] = 2;
        fields[3][0] = 2;
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
        initializeTiles();
        initializeFewFields();

        updateJButtons();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void initializeTiles() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j] = new Tiles(createSingleJButton());
            }
        }
    }

    private JButton createSingleJButton() {
        JButton jButton = new JButton("0");
        jButton.setPreferredSize(new Dimension(50, 50));
        jButton.setEnabled(false);
        frame.add(jButton);
        return jButton;
    }

    public void move(int keyCode) {
        System.out.println(keyCode);
        for (int k = 0; k < 4; k++) {
            board.joinFieldsIfPossible(k);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3 - i; j++) {
                    board.moveIfPossible(j, k);
                }
            }
        }
        displayFields(fields);
//        updateJButtons();
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
