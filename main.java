
public class main {
    public static void main(String[] args) {
        BST<ComparableAssociation<String, String>> bst = new BST<>();
        TxtReader reader = new TxtReader();
        
        String[] diccionario = reader.readFile("diccionario.txt", "\n");
        String[] texto = reader.readFile("texto.txt", " ");
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
            String palabra = texto[i];
            BinaryTree<ComparableAssociation<String, String>> resultado = bst.search(new ComparableAssociation<>((String) palabra.toLowerCase().trim().replace(".", ""), null));
            if (resultado == null) {
                newTexto[i] = "*" + palabra + "*";
            } else if (resultado != null && palabra.endsWith(".")) {
                newTexto[i] = resultado.value().getValue() + ".";
            } else {
                newTexto[i] = resultado.value().getValue();
            }
        }
        
        System.out.println("Texto traducido: " + String.join(" ", newTexto));
    }
}
