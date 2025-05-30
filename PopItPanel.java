/*
 * Visualizes the Game
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PopItPanel extends JPanel {
    int gridSize;
    Bubble[][] bubbles;

    public PopItPanel(int gridSize) {
        super();

        this.gridSize = gridSize;

        bubbles = new Bubble[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                bubbles[i][j] = new Bubble();
            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int tileWidth = getWidth() / gridSize;
                int tileHeight = getHeight() / gridSize;

                int col = e.getX() / tileWidth;
                int row = e.getY() / tileHeight;

                if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) {
                    Bubble bubble = bubbles[row][col];
                    bubble.setPopped(!bubble.getPopped()); // toggle
                    repaint();
                }
            }
        });
    }

    public void drawGrid(Graphics g) {
        int tileWidth = (int) (getWidth() / gridSize);
        int tileHeight = (int) (getHeight() / gridSize);

        // Draws vertical lines
        for (int i = 0; i <= gridSize; i++) {
            int x = (int) (i * tileWidth);
            g.drawLine(x, 0, x, getHeight());
        }

        // Draws horizontal lines
        for (int i = 0; i <= gridSize; i++) {
            int y = (int) (i * tileHeight);
            g.drawLine(0, y, getWidth(), y);
        }
    }

    public void drawBubbles(Graphics g) {
        int tileWidth = (int) (getWidth() / gridSize);
        int tileHeight = (int) (getHeight() / gridSize);

        for (int i = 0; i < bubbles.length; i++) {
            for (int j = 0; j < bubbles.length; j++) {
                if (bubbles[i][j].getPopped()) {
                    g.setColor(Color.GRAY);
                    g.fillOval(j * tileWidth + 5, i * tileHeight + 5, tileWidth - 10, tileHeight - 10);
                } else {
                    g.setColor(Color.BLUE);
                    g.fillOval(j * tileWidth + 5, i * tileHeight + 5, tileWidth - 10, tileHeight - 10);
                    g.setColor(Color.CYAN);
                    g.fillOval(j * tileWidth + 10, i * tileHeight + 10, tileWidth - 20, tileHeight - 20);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws the Grid
        // drawGrid(g);

        // Draws the remaining Tiles
        drawBubbles(g);
    }
}
