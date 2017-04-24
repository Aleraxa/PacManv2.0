package pacman;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Klasa z okienkiem startu
 */
public class Start {

    public static void main(String[] args) {
        final SwingFrame sw = new SwingFrame("Tytuł");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sw.setVisible(true);
            }
        });
    }
}

@SuppressWarnings("serial")
class SwingFrame extends JFrame {

    SwingFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 350);
    }
}