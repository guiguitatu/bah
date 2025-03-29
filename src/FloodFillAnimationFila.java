import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloodFillAnimationFila extends JPanel {
    private final BufferedImage image;
    private final MinhaFila<PixelPosition> stack;
    private final int targetColor;
    private final int newColor;
    private final Timer timer;

    public FloodFillAnimationFila(BufferedImage image, int startX, int startY, int newColor) {
        this.image = image;
        this.newColor = newColor;
        targetColor = image.getRGB(startX, startY);
        stack = new MinhaFila<>();
        stack.enQueue(new PixelPosition(startX, startY));

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int steps = 5000;
                for (int i = 0; i < steps && !stack.isEmpty(); i++) {
                    stepFloodFill();
                }
                if (stack.isEmpty()) {
                    timer.stop();
                }
                repaint();
            }
        });
        timer.start();
    }

    private void stepFloodFill() {
        if (stack.isEmpty()) return;
        PixelPosition pos = stack.deQueue();
        int x = pos.x;
        int y = pos.y;
        if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) return;
        if (image.getRGB(x, y) != targetColor) return;
        Duplicado(x, y, image, newColor, stack);
    }

    static void Duplicado(int x, int y, BufferedImage image, int newColor, MinhaFila<PixelPosition> stack) {
        image.setRGB(x, y, newColor);
        stack.enQueue(new PixelPosition(x + 1, y));
        stack.enQueue(new PixelPosition(x - 1, y));
        stack.enQueue(new PixelPosition(x, y + 1));
        stack.enQueue(new PixelPosition(x, y - 1));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }
}
