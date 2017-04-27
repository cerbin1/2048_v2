package bartek;

import javax.swing.*;

public class Application {
    public void displayFrame() {
        JFrame frame = new JFrame("1024");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Application().displayFrame();
    }
}
