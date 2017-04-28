package bartek;

import javax.swing.*;

public class Tiles {
    private JButton button;

    public Tiles(JButton button) {
        this.button = button;
    }

    public void setText(String text) {
        button.setText(text);
    }
}
