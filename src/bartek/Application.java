package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class Application {
    private final JFrame frame = new JFrame("1024");
    private final Tile[][] tiles = new Tile[4][4];
    private final JLabel points = new JLabel();
    private final Game game;

    private Application() {
        addComponentsToContainer(frame.getContentPane());
        game = new Game();
    }

    private void addComponentsToContainer(Container container) {
        container.setLayout(new BoxLayout(container, Y_AXIS));

        createGraphicInterface(container);
        initializeTiles(container);
    }

    private void createGraphicInterface(Container container) {
        JPanel panel = new JPanel();
        panel.setSize(400, 300);
        points.setSize(400, 300);
        points.setText("Start New Game");
        panel.add(points);
        container.add(panel);
    }


    private void displayFrame() {
        frame.setLocationRelativeTo(null);
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
                updatePoints(game.getPoints());
                updateJButtons();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    private void updatePoints(int points) {
        this.points.setText(Integer.toString(points));
    }

    private void initializeTiles(Container container) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setSize(400, 100);

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                tiles[x][y] = new Tile(createSingleJButton(panel));
            }
        }
        container.add(panel);
    }

    private JButton createSingleJButton(JPanel panel) {
        JButton jButton = new JButton("");
        jButton.setPreferredSize(new Dimension(100, 100));
        jButton.setEnabled(false);
        panel.add(jButton);
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
