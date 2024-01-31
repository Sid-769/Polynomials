public class OrderedLinkedList<T extends Comparable<T>> {
	
    private Node<T> head; 
    private int size;     
    
    public OrderedLinkedList() {
        //Initializes an empty ordered linked list
        head = null;  //Node is at the start
        size = 0;     
    }
    
    public void insert(T value) {
        //Inserts a new value into the linked list 

        Node<T> newNode = new Node<>(value, null); //Create a new node
        
        //If the list is empty ie. node is at the start and the value is smaller than the current head's value
        if (head == null || head.getData().compareTo(value) < 0) {
        	
            newNode.setNext(head); 
            
            head = newNode;        //Update the head to the new node
            
        } 
        
        //If the value is greater than or equal to the head's value
        else {
        	
            Node<T> current = head;
            
            // Find the correct position to insert the new node
            while (current.getNext() != null && current.getNext().getData().compareTo(value) > 0) {
            	
                current = current.getNext();
                
            }
            
            newNode.setNext(current.getNext());
            
            current.setNext(newNode);          //Update the current node's next reference
            
        }
        
        size++; 
        
    }
    
    private Node<T> getNodeAtIndex(int index) {
    	
        //Private method to retrieve a node at a specific index in the linked list although never used in the code, I put this before in my code
    	
        Node<T> current = head;
        
        for (int i = 0; i < index && current != null; i++) {
        	
            current = current.getNext();
            
        }
        
        return current;
        
    }
    
    public int getSize() {
    	
        //Public method to get the size of the linked list
        return size;
        
    }
    
    public T get(int index) {
    	
        //Public method to get the data at a specific index in the linked list
    	
        if (index < 0 || index >= size) {
        	
            throw new IndexOutOfBoundsException();
            
        }
        
        Node<T> current = head;
        
        for (int i = 0; i < index; i++) {
        	
            current = current.getNext();
            
        }
        
        return current.getData();
        
    }
    
}