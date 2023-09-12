
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.nio.file.Files;
import java.io.BufferedReader;

import java.nio.charset.Charset;



public class App {


    private DoubleLinkedList lista;
    private Hashtable<String, String> dicionario;


    public App() {
        dicionario = new Hashtable<String, String>();
        lista = new DoubleLinkedList();

        dicionario.put("ND", "A");
        dicionario.put("DN", "A");
        dicionario.put("DA", "N");
        dicionario.put("AD", "N");
        dicionario.put("AN", "D");
        dicionario.put("NA", "D");
    }
    // leitura de arquivo
    public void leitura() {
        Path path1 = Paths.get("caso0010.txt");
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
    public void executa() {
        leitura();
        
        lista.executar(dicionario);
        System.out.print("LEITURA DA LISTA: ");
        lista.printForward();
       
    }	
}
