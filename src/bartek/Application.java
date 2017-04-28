package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Application {
    Field[][] fields = new Field[4][4];
    JFrame frame = new JFrame("1024");
    Fields dd = new Fields();
    int[][] dupa = dd.getFields();

    void kek() {
        dupa[0][0] = 2;
        dupa[1][0] = 2;
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
                move(e.getKeyCode(), dupa);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        initializeFields();
        kek();
        System.out.println(Arrays.deepToString(dupa));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void initializeFields() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fields[i][j] = new Field(createSingleJButton());
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
        for (int i = 3; i > 0; i--) {
            for (int j = 2; j < i; j++) {
                System.out.println(i + " " + j);
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(dupa));
        /*if (array[0][0] == array[1][0] && array[2][0] == array[3][0]) {
            array[3][0] = array[2][0] + array[3][0];
            array[2][0] = array[0][0] + array[1][0];
            array[0][0] = 0;
            array[1][0] = 0;
        }
        else if (array[2][0] == array[3][0]) {
            array[3][0] += array[3][0];
            array[2][0] = 0;
        } else if (array[1][0] == array[2][0]) {
            array[2][0] += array[1][0];
            array[1][0] = 0;
        } else if (array[0][0] == array[1][0]) {
            array[1][0] += array[0][0];
            array[0][0] = 0;
        } else if (array[1][0] == array[3][0] && array[2][0] == 0) {
            array[3][0] += array[1][0];
            array[1][0] = 0;
        } else if (array[0][0] == array[2][0] && array[1][0] == 0) {
            array[2][0] += array[0][0];
            array[0][0] = 0;
        } else if (array[0][0] == array[3][0] && array[1][0] == 0 && array[2][0] == 0) {
            array[3][0] += array[0][0];
            array[0][0] = 0;
        }*/
    }

    private boolean canMove(int i) {
        if (i >= 3) {
            return false;
        }
        return dupa[i][0] == dupa[i + 1][0] || dupa[i + 1][0] == 0;
    }
}
