package Morse;

import libs.Root;

import javax.swing.*;
import java.awt.*;

/**
 * Visualizador da árvore Morse usando Swing.
 */
public class SwingTreeViewer extends JPanel {
    private final Root<Character> root;
    private static final int VERTICAL_GAP = 60;
    private static final int NODE_RADIUS = 20;

    public SwingTreeViewer(Root<Character> root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Habilita antialiasing para linhas e texto mais suaves
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        // Desenha a árvore a partir do centro horizontal
        drawTree(g2, root, width / 2, NODE_RADIUS + 10, width / 4);
    }

    /**
     * Desenha recursivamente o nó e seus filhos.
     *
     * @param g2    contexto gráfico
     * @param node  nó atual da árvore
     * @param x     coordenada X deste nó
     * @param y     coordenada Y deste nó
     * @param hGap  distância horizontal até os filhos
     */
    private void drawTree(Graphics2D g2, Root<Character> node, int x, int y, int hGap) {
        if (node == null) return;

        // Desenha conexões para o filho esquerdo ('.')
        if (node.left != null) {
            int childX = x - hGap;
            int childY = y + VERTICAL_GAP;
            g2.drawLine(x, y + NODE_RADIUS, childX, childY - NODE_RADIUS);
            drawTree(g2, node.left, childX, childY, hGap / 2);
        }

        // Desenha conexões para o filho direito ('-')
        if (node.right != null) {
            int childX = x + hGap;
            int childY = y + VERTICAL_GAP;
            g2.drawLine(x, y + NODE_RADIUS, childX, childY - NODE_RADIUS);
            drawTree(g2, node.right, childX, childY, hGap / 2);
        }

        // Desenha o próprio nó (círculo branco com borda preta)
        g2.setColor(Color.WHITE);
        g2.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g2.setColor(Color.BLACK);
        g2.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        // Desenha o texto dentro do círculo (ou '*' se for nó vazio)
        String label = (node.data == null ? "*" : node.data.toString());
        FontMetrics fm = g2.getFontMetrics();
        int labelWidth = fm.stringWidth(label);
        int labelHeight = fm.getAscent();
        g2.drawString(label,
                x - labelWidth / 2,
                y + labelHeight / 2 - 2);
    }


}
