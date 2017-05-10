package bartek.view;

import javax.swing.*;
import java.io.File;

public class ImageRepository {
    public static ImageIcon get(String name) {
        String fileName = "res\\images\\" + name + ".png";
        File imageIcon = new File(fileName);
        if (imageIcon.exists()) {
            return new ImageIcon(fileName);
        }

        throw new ImageIconNotFoundException();
    }
}
