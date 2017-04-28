package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Application {
    Tiles[][] tiles = new Tiles[4][4];
    JFrame frame = new JFrame("1024");
    int[][] fields = new Fields().getFields();

    private void initializeFewFields() {
        fields[0][0] = 2;
        fields[1][0] = 2;
    }


    public void displayFrame() throws InterruptedException {
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
        initializeFields();
        initializeFewFields();
        System.out.println(Arrays.deepToString(fields));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void initializeFields() {
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

    public static void main(String[] args) throws InterruptedException {
        new Application().displayFrame();

    }

    public void move(int keyCode, int[][] array) {
        System.out.println(keyCode);
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (canMove(i)) {
                    fields[i + 1][0] += fields[i][0];
                    fields[i][0] = 0;
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }

        updateJButtons();
    }

    private void updateJButtons() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                tiles[i][j].setText(Integer.toString(fields[i][j]));
            }
        }
    }

    private boolean canMove(int i) {
        if (i >= 3) {
            return false;
        }
        return fields[i][0] == fields[i + 1][0] || fields[i + 1][0] == 0;
    }
}
