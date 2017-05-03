package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application {
    private final JFrame frame = new JFrame("1024");
    private final Tile[][] tiles = new Tile[4][4];
    private final Game game;

    public Application() {
        game = new Game();
        initializeTiles();
    }

    public void displayFrame() {
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 4));
        frame.addKeyListener(keyListener());

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
                game.move(e.getKeyCode());
                updateJButtons();
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


    private void updateJButtons() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                setTextField(y, x);
            }
        }
    }

    private void setTextField(int y, int x) {
        tiles[x][y].setText(Integer.toString(getField(x, y)));
    }

    private int getField(int x, int y) {
        return game.getBoard().getFields()[x][y];
    }

    public static void main(String[] args) {
        new Application().displayFrame();
    }
}
