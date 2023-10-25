
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.nio.charset.Charset;



public class App {


    private DoubleLinkedListSolution listaDoubleLinked;
    private Hashtable<String, String> dicionario;
    private QueueSolution fila;
    //private Queue<String> fila;


    public App() {
        fila = new QueueSolution();
        dicionario = new Hashtable<String, String>();
        listaDoubleLinked = new DoubleLinkedListSolution();
        dicionario.put("ND", "A");
        dicionario.put("DN", "A");
        dicionario.put("DA", "N");
        dicionario.put("AD", "N");
        dicionario.put("AN", "D");
        dicionario.put("NA", "D");
    }

    public Queue<String> leituraSolution2(String pasta, String arquivo) {
        Queue<String> fila = new LinkedList<>();
        Path path = Paths.get(pasta, arquivo);
    
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            int charCode;
            while ((charCode = reader.read()) != -1) {
                char character = (char) charCode;
                String letra = String.valueOf(character).trim(); // Converte o caractere em string e remove espaços em branco
                if (!letra.isEmpty()) { // Verifica se a string não está vazia
                    fila.offer(letra); // Adiciona a string à fila
                    System.out.println(letra);
                }
            }
        } catch (Exception e) {
            System.err.format(e.getMessage());
        }
        return fila;
    }

    public void leituraSolution1(String pasta,String arquivo) {
        listaDoubleLinked = new DoubleLinkedListSolution();
        Path path1 = Paths.get(pasta, arquivo);
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String linha = null;
            while ((linha = reader.readLine()) != null) {
                // Defina o padrão de separação desejado, por exemplo, separar por caractere
                String[] partes = linha.split(""); // Isso dividirá a linha em caracteres individuais
                for (String parte : partes) {
                    listaDoubleLinked.insertion(parte);
                }
            }
        } catch (Exception e) {
            System.err.format(e.getMessage());
        }
    }

    public void executaFila(){
        long startTime, endTime, elapsedTime;
        int[] casos = {1, 10, 20, 50, 100, 200, 500, 2000};
        String casoPrefix = "caso";
        String casoSuffix = ".txt";

        System.out.println("---------------------------------------------------------------------------");

        for (int caso : casos) {
            String casoNumero = String.format("%04d", caso);
            String casoArquivo = casoPrefix + casoNumero + casoSuffix;

            Queue<String> dados= leituraSolution2("src", casoArquivo);
            startTime = System.currentTimeMillis();
            fila.executar(dados, dicionario);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.print( casoArquivo + " Tempo gasto: " + elapsedTime + " ms ");
            System.out.print("Resposta : [");
            listaDoubleLinked.printForward();
            System.out.println("]");
        }
    }
    
    public void executaDoubleLinkedList() {
        
        long startTime, endTime, elapsedTime;
        int[] casos = {1, 10, 20, 50, 100, 200, 500, 2000};
        String casoPrefix = "caso";
        String casoSuffix = ".txt";

        System.out.println("---------------------------------------------------------------------------");

        for (int caso : casos) {
            String casoNumero = String.format("%04d", caso);
            String casoArquivo = casoPrefix + casoNumero + casoSuffix;

            leituraSolution1("src", casoArquivo);
            startTime = System.currentTimeMillis();
            listaDoubleLinked.executar(dicionario);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.print( casoArquivo + " Tempo gasto: " + elapsedTime + " ms ");
            System.out.print("Resposta : [");
            listaDoubleLinked.printForward();
            System.out.println("]");
        }
    }	

}
