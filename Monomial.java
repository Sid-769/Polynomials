public class Monomial implements Comparable<Monomial> { //getter and setter class
	
	private int coefficient;
	
    private int degree;
    
    public Monomial(int coefficient, int degree) {
    	
        this.coefficient = coefficient;
        
        this.degree = degree;
        
    }
    
    public int getCoefficient() {
    	
        return coefficient;
        
    }

    
    public int getDegree() {
    	
        return degree;
        
    }
    
    public int compareTo(Monomial m) {
    	
        return this.degree - m.degree;
        
    }
    

}