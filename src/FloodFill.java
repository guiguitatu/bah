import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class FloodFill extends JPanel {
    protected final BufferedImage image;
    protected int targetColor;
    protected final int newColor;
    protected Timer timer;
    protected final int delay;
    protected final int stepsPerTick;
    protected boolean floodFillStarted = false;

    public FloodFill(BufferedImage image, int newColor, int delay, int stepsPerTick) {
        this.image = image;
        this.newColor = newColor;
        this.delay = delay;
        this.stepsPerTick = stepsPerTick;
    }

    protected void startFloodFill(int startX, int startY) {
        if (floodFillStarted) return;
        floodFillStarted = true;
        targetColor = image.getRGB(startX, startY);
        initContainer(startX, startY);
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < stepsPerTick && !isContainerEmpty(); i++) {
                    stepFloodFill();
                }
                if (isContainerEmpty()) {
                    timer.stop();
                }
                repaint();
            }
        });
        timer.start();
    }

    protected void stepFloodFill() {
        if (isContainerEmpty()) return;
        PixelPosition pos = removeNext();
        int x = pos.x;
        int y = pos.y;
        if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) return;
        if (image.getRGB(x, y) != targetColor) return;
        image.setRGB(x, y, newColor);
        addNeighbors(x, y);
    }

    protected abstract void initContainer(int startX, int startY);
    protected abstract boolean isContainerEmpty();
    protected abstract PixelPosition removeNext();
    protected abstract void addNeighbors(int x, int y);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }
}
