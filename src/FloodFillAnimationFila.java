import java.awt.image.BufferedImage;

public class FloodFillAnimationFila extends FloodFill {
    private MinhaFila<PixelPosition> container;

    public FloodFillAnimationFila(BufferedImage image, int newColor, int delay, int stepsPerTick) {
        super(image, newColor, delay, stepsPerTick);
    }

    @Override
    protected void initContainer(int startX, int startY) {
        container = new MinhaFila<>();
        container.enQueue(new PixelPosition(startX, startY));
    }

    @Override
    protected boolean isContainerEmpty() {
        return container == null || container.isEmpty();
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
