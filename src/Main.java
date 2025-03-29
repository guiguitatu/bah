import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        try {

            BufferedImage image = ImageIO.read(new File("C:/Users/Guilherme/Documents/PUC/5operiodo/bah/img/image.png"));

            //image: 576x497    image2: 212x228    image3: 103x95
            int startX = 10;
            int startY = 10;
            int newColor = 0xFFFF00FF;

            try {
                //FloodFillAnimationPilha panel = new FloodFillAnimationPilha(image, startX, startY, newColor);
                FloodFillAnimationFila panel = new FloodFillAnimationFila(image, startX, startY, newColor);
                JFrame frame = new JFrame("Animação do Flood Fill");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.setSize(image.getWidth() * 2, image.getHeight() * 2);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            } catch (Exception e) {
                System.out.println("Erro ao ler os valores, usando valores padrão");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
