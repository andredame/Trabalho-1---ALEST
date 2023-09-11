
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedReader;

import java.nio.charset.Charset;



public class App {


    private DoubleLinkedList lista;
    
    public App() {
        lista = new DoubleLinkedList();
        leitura();
        lista.printForward();
        System.out.print("LEITURA DO HEAD: ");
        lista.printHead();
        System.out.print("LEITURA DO TAIL: ");
        lista.printTail();

    }
    // leitura de arquivo
    public void leitura() {
        Path path1 = Paths.get("caso0100.txt");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String linha = null;
            while ((linha = reader.readLine()) != null) {
                // Defina o padrão de separação desejado, por exemplo, separar por caractere
                String[] partes = linha.split(""); // Isso dividirá a linha em caracteres individuais
                for (String parte : partes) {
                    lista.insertion(parte);
                }
            }
        } catch (Exception e) {
            System.err.format(e.getMessage());
        }
    }
    

    public void criacao() {
        
    }
}
