
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.nio.file.Files;
import java.io.BufferedReader;

import java.nio.charset.Charset;



public class App {


    private DoubleLinkedList lista;
    private String resposta;
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
    public void leitura(String pasta,String arquivo) {
        lista = new DoubleLinkedList();
        Path path1 = Paths.get(pasta, arquivo);
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
        
        String pasta="testePrincipal";
        long startTime, endTime, elapsedTime;
        int[] casos = {1, 10, 20, 50, 100, 200, 500, 2000};
        String casoPrefix = "caso";
        String casoSuffix = ".txt";

        System.out.println("---------------------------------------------------------------------------");

        for (int caso : casos) {
            String casoNumero = String.format("%04d", caso);
            String casoArquivo = casoPrefix + casoNumero + casoSuffix;

            leitura(pasta, casoArquivo);
            startTime = System.currentTimeMillis();
            lista.executar(dicionario);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.print( casoArquivo + " Tempo gasto: " + elapsedTime + " ms ");
            System.out.print("Resposta : ");
            lista.printForward();
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("                              Teste 2: ");

        pasta = "testeOutros";
        int[] outrosCasos = {10, 100, 1000, 10000, 100000, 30000000};
        String[] outrosCasoArquivos = {"caso10.txt", "caso100.txt", "caso1000.txt", "caso10k.txt", "caso100k.txt", "caso30000k.txt"};

        for (int i = 0; i < outrosCasos.length; i++) {
            int caso = outrosCasos[i];
            String casoArquivo = outrosCasoArquivos[i];
        
            leitura(pasta, casoArquivo);
            startTime = System.currentTimeMillis();
            lista.executar(dicionario);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.print(casoArquivo + " Tempo gasto: " + elapsedTime + " ms ");
            System.out.print("Resposta : ");
            lista.printForward();
        }
        System.out.println("---------------------------------------------------------------------------");








    }	

}
