import java.awt.image.BufferedImage;

public class FloodFillAnimationPilha extends FloodFill {
    private MinhaPilha<PixelPosition> container;

    public FloodFillAnimationPilha(BufferedImage image, int startX, int startY, int newColor) {
        // Delay de 500 ms e processa 5000 passos por tick
        super(image, startX, startY, newColor, 500, 5000);
    }

    @Override
    protected void initContainer(int startX, int startY) {
        container = new MinhaPilha<>();
        container.push(new PixelPosition(startX, startY));
    }

    @Override
    protected boolean isContainerEmpty() {
        return container.isEmpty();
    }

    @Override
    protected PixelPosition removeNext() {
        return container.pop();
    }

    @Override
    protected void addNeighbors(int x, int y) {
        container.push(new PixelPosition(x + 1, y));
        container.push(new PixelPosition(x - 1, y));
        container.push(new PixelPosition(x, y + 1));
        container.push(new PixelPosition(x, y - 1));
    }
}
