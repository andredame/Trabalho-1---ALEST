import java.util.Hashtable;


public class DoubleLinkedListSolution {

    private Node head;
    private Node tail;

    class Node {

        private String data;
        private Node prev;
        private Node next;
 
        // Constructor to create a new node
        // next and prev is by default initialized as null
        private Node(String d) {
            data = d; 
            this.next = null;
            this.prev = null;
        }
        public String getData() {
            return data;
        }
    }

    public DoubleLinkedListSolution() {
        head = null;
        tail = null;
        
    }

    public void insertion(String data)  {
	Node temp = new Node(data);
	if (tail == null) {
		head = temp;
		tail = temp;
	}
	else {
		tail.next = temp;
		temp.prev = tail;
		tail = temp;
	}
}

    public void printForward() {
        Node current = this.head;
       // System.out.print("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + "");
            current = current.next;
        }
        
    }
    
    
    public void printHead() {
        System.out.println(head.getData());
    }

    public void printTail() {
        System.out.println(tail.getData());
    }

  
    public void executar(Hashtable<String, String> dicionario) {
        Node current = this.head;
        
        while (current != null ) {
            if(current.next == null){
                if(current.prev != null  ){
                    if(!current.prev.data.equals(current.data)){
                        current = current.prev;
                        
                    }else{
                        break;
                    }
                    
                }
            }else{
                if(current.prev != null){
                    if(!current.prev.data.equals(current.data) ){
                        current = current.prev;
                        
                    }
                }
            }
            Node next = current.next;
            String currentBase = current.data;
            String nextBase = (next != null) ? next.data : null; // Verificação para next.data


            String key = currentBase + nextBase;
            
            
    
            if (dicionario.containsKey(key)) {
                String newValue = dicionario.get(key);
                
                insertion(newValue);
                
                if (current == head) {
                    head = next.next;
                    current = head; 
                    if (current != null) {
                        current.prev = null;
                    }
                    
                            
                }else{
                    // Se o nó atual não é a cabeça
                    Node prevNode = current.prev;

                    if (next.next != null) {
                        // Atualize as conexões do nó anterior e próximo
                        prevNode.next = next.next;
                        next.next.prev = prevNode;
                    } else {
                        // Se next.next for nulo, o nó atual é a cauda
                        prevNode.next = null;
                        tail = prevNode;
                    }

                    // Atualize o nó atual para o próximo nó após a inserção
                    current = prevNode.next;
                }
                
                

            } else {
                if (current.prev != null && !current.prev.data.equals(current.data)) {
                    current = current.prev;
                    
                } else {
                    current = current.next;
                }
                
            }
        }
    }
    
    

    public void deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || head == null) {
            return; // Nada a ser feito se o nó for nulo ou a lista estiver vazia
        }
    
        // Se o nó a ser excluído é a cabeça (head) da lista
        if (nodeToDelete == head) {
            head = nodeToDelete.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
    
        // Se o nó a ser excluído é a cauda (tail) da lista
        if (nodeToDelete == tail) {
            tail = nodeToDelete.prev;
            if (tail != null) {
                tail.next = null;
            }
            return;
        }
    
        // O nó a ser excluído não é a cabeça nem a cauda
        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        }
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
    }

}
