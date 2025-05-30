/*
 * Displays the Game
 */

import javax.swing.JFrame;
import java.awt.Dimension;

public class PopItFrame extends JFrame {
    final static String TITLE = "Pop It!";
    final int GRID_SIZE = 5;
    final Dimension SIZE = new Dimension(800, 800);

    public PopItFrame() {
        super(TITLE);
        
        setPreferredSize(SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(new PopItPanel(GRID_SIZE));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
