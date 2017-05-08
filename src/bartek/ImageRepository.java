package bartek;

import javax.swing.*;

public class ImageRepository {
    public static ImageIcon get(String fileName) {
        return new ImageIcon("res\\images\\" + fileName + ".png");
    }
}
