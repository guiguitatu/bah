package Morse;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        Arvore tree = new Arvore();
        tree.insert(".-",   'A');
        tree.insert("-...", 'B');
        tree.insert("-.-.", 'C');
        tree.insert("-..",  'D');
        tree.insert(".",    'E');
        tree.insert("..-.", 'F');
        tree.insert("--.",  'G');
        tree.insert("....", 'H');
        tree.insert("..",   'I');
        tree.insert(".---", 'J');
        tree.insert("-.-",  'K');
        tree.insert(".-..", 'L');
        tree.insert("--",   'M');
        tree.insert("-.",   'N');
        tree.insert("---",  'O');
        tree.insert(".--.", 'P');
        tree.insert("--.-", 'Q');
        tree.insert(".-.",  'R');
        tree.insert("...",  'S');
        tree.insert("-",    'T');
        tree.insert("..-",  'U');
        tree.insert("...-", 'V');
        tree.insert(".--",  'W');
        tree.insert("-..-", 'X');
        tree.insert("-.--", 'Y');
        tree.insert("--..", 'Z');

        System.out.println("Gostaria de Imprimir a Árvore Morse? (s/n)");
        String lindonjohnson = scanner.nextLine();
        boolean bah;
        bah = Objects.equals(lindonjohnson, "s");
        if(bah){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Árvore Morse");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new SwingTreeViewer(tree.getRoot()));
            frame.setSize(1000, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });}
        
        while (escolha != 3){
            System.out.println("Gostaria de Codificar ou decodificar um código Morse? (1 - codificar, 2 - decodificar, 3 - sair)");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            if (escolha == 1){
                System.out.println("Digite o texto a ser codificado:");
                String texto = scanner.nextLine();
                texto = tree.encode(texto);
                System.out.println("Texto codificado: " + texto);
            } else if (escolha == 2) {
                System.out.println("Digite o código Morse a ser decodificado:");
                String morse = scanner.nextLine();
                morse = tree.decode(morse);
                System.out.println("Texto decodificado: " + morse);
            } else if (escolha == 3) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
