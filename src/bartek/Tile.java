package bartek;

import javax.swing.*;

public class Tile {
    private JButton button;

    public Tile(JButton button) {
        this.button = button;
    }

    public void setText(String text) {
        button.setText(text);
    }
}
