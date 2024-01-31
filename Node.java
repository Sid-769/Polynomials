public class Node<T> {
	
    private T data;
    
    private Node<T> next;

    
    public Node(T data, Node<T> next) { //when the constructor is called, the inputted values of data and next will be set as the data and next variables in this class
    	
        this.data = data;
        
        this.next = next;
        
    }

    
    public T getData() { //returns the value of data
    	
        return data;
        
    }

    public Node<T> getNext() { //returns the value of next
    	
        return next;
        
    }

    
    public void setNext(Node<T> next) {
    	
        this.next = next;
        
    }
}