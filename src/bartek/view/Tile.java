package bartek.view;

import javax.swing.*;

public class Tile {
    private JLabel tile;

    public Tile(JLabel tile) {
        this.tile = tile;
    }

    public void setText(String text) {
        tile.setText(text);
    }

    public JLabel getTile() {
        return tile;
    }
}
