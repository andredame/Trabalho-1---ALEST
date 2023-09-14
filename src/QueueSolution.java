
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;



public class QueueSolution {
    private Stack<String> pilha;

    public QueueSolution() {
        
        pilha = new Stack<>();
    }
    
    public void executar(Queue<String> fila, Hashtable<String, String> dicionario) {
        
        while(!fila.isEmpty()){
            
            if(pilha.isEmpty()){
                pilha.push(fila.poll());
            }else{
                if(pilha.peek().equals(fila.peek())){
                    pilha.push(fila.poll());
                }else{	
                    
                    String ultimaLetra = pilha.peek();
                    String proximaLetra = fila.peek();
                    String chave = ultimaLetra + proximaLetra;
                    if(dicionario.containsKey(chave)){
                        pilha.pop();
                        fila.poll();
                        fila.offer(dicionario.get(chave));
                    }else{
                        pilha.push(fila.poll());
                    }
                }
            }
        } 
        System.out.println(pilha);      
    
    }

}


