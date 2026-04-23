public class main {
    public static void main(String[] args) {
        BST<ComparableAssociation<String, String>> bst = new BST<>();
        TxtReader reader = new TxtReader();
        
        String[] diccionario = reader.readFile("diccionario.txt", "\n");
        String[] texto = reader.textoArray("texto.txt");
        String[] newTexto = new String[texto.length];

        // Insertar las palabras del diccionario en el BST
        for (String p : diccionario) {
            String[] palabras = p.split(",");
            if (palabras.length == 2) {
                String ingles = palabras[0].trim().replace("(", "");
                String traduccion = palabras[1].trim().replace(")", "");
                bst.insert(new ComparableAssociation<>(ingles.toLowerCase().trim(), traduccion));
            }
        }

        System.out.println("Diccionario INORDER de BST:");
        bst.inorder();

        System.out.println("Texto a traducir: " + String.join(" ", texto));

        // Traducir el texto utilizando el BST
        for (int i = 0; i < texto.length; i++) {
            String original = texto[i];
            String palabra = original.toLowerCase().trim().replaceAll("[^a-z]", "");;
            BinaryTree<ComparableAssociation<String, String>> resultado = bst.search(new ComparableAssociation<>(palabra, null));
            if (resultado == null) {
                newTexto[i] = "*" + original + "*";
            } else if (original.endsWith(".")) {
                newTexto[i] = resultado.value().getValue() + ".";
            } else if (original.endsWith(",")) {
                newTexto[i] = resultado.value().getValue() + ","; 
            } else if (original.endsWith("!")) {
                newTexto[i] = resultado.value().getValue() + "!"; 
            } else if (original.endsWith("?")) {
                newTexto[i] = resultado.value().getValue() + "?"; 
            }else {
                newTexto[i] = resultado.value().getValue();
            }
        }
        System.out.println("Texto traducido: " + String.join(" ", newTexto));
    }
}
