package bartek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.BoxLayout.Y_AXIS;
import static javax.swing.SwingConstants.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Application {
    private final JFrame frame = new JFrame("1024");
    private final JLabel labelPoints = new JLabel("", CENTER);
    private final JButton newGame = new JButton();
    private final Tile[][] tiles = new Tile[4][4];

    private Game game;

    private Application() {
        game = new Game();
        addComponentsToContainer(frame.getContentPane());
    }

    private void addComponentsToContainer(Container container) {
        container.setLayout(new BoxLayout(container, Y_AXIS));

        createUserInterface(container);
        createGameBoard(container);
    }

    private void createUserInterface(Container container) {
        JPanel userInterface = new JPanel(new GridLayout(1, 2));
        userInterface.setSize(200, 300);

        setNewGameButton();
        setLabelPoints();

        userInterface.add(newGame);
        userInterface.add(labelPoints);

        container.add(userInterface);
    }

    private void setLabelPoints() {
        labelPoints.setSize(400, 300);
        labelPoints.setHorizontalTextPosition(RIGHT);
        updatePoints(game.getPoints());
    }

    private void setNewGameButton() {
        newGame.setText("Nowa gra");
        newGame.setHorizontalAlignment(LEFT);
        newGame.setHorizontalAlignment(CENTER);
        newGame.setSize(200, 300);
        newGame.addKeyListener(keyListener());
        newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startNewGame();
            }
        });
    }

    private void startNewGame() {
        game = new Game();
        updatePoints(game.getPoints());
        updateJButtons();
    }


    private void createGameBoard(Container container) {
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
        JButton jButton = new JButton();
        jButton.setPreferredSize(new Dimension(100, 100));
        jButton.setEnabled(false);
        panel.add(jButton);
        return jButton;
    }

    private void displayFrame() {
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addKeyListener(keyListener());
        updateJButtons();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                if (game.isGameDone()) {
                    displayEndGameMessage();
                } else {
                    game.move(e.getKeyCode());
                    updatePoints(game.getPoints());
                    updateJButtons();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    private void displayEndGameMessage() {
        labelPoints.setText("Koniec gry. Twoj wynik: " + game.getPoints());
    }

    private void updatePoints(int points) {
        this.labelPoints.setText("Wynik : " + Integer.toString(points));
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
