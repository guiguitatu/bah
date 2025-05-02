package FloodFill;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FloodMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {

                BufferedImage image = ImageIO.read(new File("C:/Users/Guilherme/Documents/PUC/5operiodo/bah/img/image.png"));

                int newColor = 0xFF000000 | (new java.util.Random().nextInt(0xFFFFFF));

                FloodFill panel;
                // Para aumentar a velocidade de preenchimento trocar o quarto parâmetro, quanto maior mais rápido;
                panel = new FloodFillAnimationPilha(image, newColor, 500, 10000);
                //panel = new FloodFill.FloodFill.FloodFillAnimationFila(image, newColor, 500, 10000);

                panel.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        panel.startFloodFill(e.getX(), e.getY());
                    }
                });

                // Cria e configura a janela para exibir o painel
                JFrame frame = new JFrame("Flood Fill Animation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.setSize(image.getWidth(), image.getHeight());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
