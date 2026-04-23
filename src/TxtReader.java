import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TxtReader {
    
    public String[] readFile(String filePath, String delimiter) {
        String[] lista = new String[0];
        try {
            lista = Files.readString(Path.of(filePath)).trim().split(delimiter);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }

    public String[] textoArray(String filePath) {
        String [] lista = new String[0];
        try {
            String content = Files.readString(Path.of(filePath)).trim();
            lista = content.split("\\s+"); 
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        return lista;
    }
}
