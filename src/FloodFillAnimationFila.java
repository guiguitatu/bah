import java.awt.image.BufferedImage;

public class FloodFillAnimationFila extends FloodFill {
    private MinhaFila<PixelPosition> container;

    public FloodFillAnimationFila(BufferedImage image, int startX, int startY, int newColor) {
        // Delay de 500 ms e processa 5000 passos por tick (valores que você pode ajustar)
        super(image, startX, startY, newColor, 500, 5000);
    }

    @Override
    protected void initContainer(int startX, int startY) {
        container = new MinhaFila<>();
        container.enQueue(new PixelPosition(startX, startY));
    }

    @Override
    protected boolean isContainerEmpty() {
        return container.isEmpty();
    }

    @Override
    protected PixelPosition removeNext() {
        return container.deQueue();
    }

    @Override
    protected void addNeighbors(int x, int y) {
        container.enQueue(new PixelPosition(x + 1, y));
        container.enQueue(new PixelPosition(x - 1, y));
        container.enQueue(new PixelPosition(x, y + 1));
        container.enQueue(new PixelPosition(x, y - 1));
    }
}
