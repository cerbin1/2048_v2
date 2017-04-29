package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application {
    Tiles[][] tiles = new Tiles[4][4];
    JFrame frame = new JFrame("1024");
    int[][] fields = new Fields().getFields();

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
                move(e.getKeyCode(), fields);
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

    public void move(int keyCode, int[][] array) {
        System.out.println(keyCode);
        joinFieldsIfPossible();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i; j++) {
                if (canMove(j)) {
                    fields[j + 1][0] = fields[j][0];
                    fields[j][0] = 0;
                }
            }
        }
        displayFields();
        updateJButtons();
    }

    private void displayFields() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void joinFieldsIfPossible() {
        for (int i = 3; i > 0; i--) {
            if (fields[i][0] != 0) {
                if (fields[i][0] == fields[i - 1][0]) {
                    fields[i][0] += fields[i - 1][0];
                    fields[i - 1][0] = 0;
                    return;
                }
            }
            if (fields[i - 1][0] == 0) {
                System.out.println("jest puste");
            }
        }
    }

    private void updateJButtons() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                tiles[i][j].setText(Integer.toString(fields[i][j]));
            }
        }
    }

    private boolean canMove(int i) {
        return i <= 2 && fields[i + 1][0] == 0;
    }

    public static void main(String[] args) {
        new Application().displayFrame();
    }
}
