package Morse;

import libs.Root;

public class Arvore {
    private final Root<Character> root;

    public Arvore() {
        root = new Root<>(null);

    }

    public Root<Character> getRoot() {
        return root;
    }


    /**
     * Insere cada símbolo de code consumindo um caractere por vez.
     *
     * @param code   sequência de '.' e '-'
     * @param letter letra a armazenar
     */
    public void insert(String code, char letter){
        insert(code, letter, root, 0);
    }


    private void insert(String code, char letter, Root<Character> node, int idx) {
        if (idx == code.length()) {
            node.data = letter;
            return;
        }
        char symbol = code.charAt(idx);
        if (symbol == '.') {
            if (node.left == null) node.left = new Root<>(null);
            insert(code, letter, node.left, idx + 1);
        } else { // '-'
            if (node.right == null) node.right = new Root<>(null);
            insert(code, letter, node.right, idx + 1);
        }
    }

    /** Decodifica uma única letra Morse
     * @return  --. >>> G*/
    public char decodeLetter(String code) {
        return decode(code, 0, root);
    }

    private char decode(String code, int idx, Root<Character> node) {
        if (node == null)
            throw new IllegalArgumentException("Código inválido: " + code);

        if (idx == code.length()) {
            if (node.data == null)
                throw new IllegalArgumentException("Não há letra para: " + code);
            return node.data;
        }

        if (code.charAt(idx) == '.')
            return decode(code, idx + 1, node.left);
        else
            return decode(code, idx + 1, node.right);
    }

    /** Decodifica frase inteira (letras por espaço, palavras por '/') */
    public String decode(String morseMessage) {
        StringBuilder sb = new StringBuilder();
        for (String word : morseMessage.trim().split("\\s*/\\s*")) {
            for (String letter : word.split("\\s+")) {
                sb.append(decodeLetter(letter));
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    /** Codifica uma única letra em Morse */
    public String encodeLetter(char letter) {
        String path = encode(letter, root, "");
        if (path == null)
            throw new IllegalArgumentException("Sem código Morse para: " + letter);
        return path;
    }

    private String encode(char target, Root<Character> node, String path) {
        if (node == null)
            return null;

        if (node.data != null && node.data == target) {
            return path;
        }

        String left = encode(target, node.left, path + ".");
        if (left != null) return left;

        return encode(target, node.right, path + "-");
    }

    /** Codifica frase inteira (letras por espaço, palavras por '/') */
    public String encode(String text) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.trim().toUpperCase().split("\\s+");
        for (int w = 0; w < words.length; w++) {
            String word = words[w];
            for (int i = 0; i < word.length(); i++) {
                sb.append(encodeLetter(word.charAt(i)));
                if (i < word.length() - 1) sb.append(' ');
            }
            if (w < words.length - 1) sb.append(" / ");
        }
        return sb.toString();
    }
}
