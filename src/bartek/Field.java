package bartek;

import javax.swing.*;

public class Field {
    private JButton button;

    public Field(JButton button) {
        this.button = button;
    }

    public void setText(String text) {
        button.setText(text);
    }
}
