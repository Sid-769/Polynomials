public class Polynomial {
	
    private OrderedLinkedList<Monomial> polynomial; //The polynomial represented as an ordered linked list of monomials

    public Polynomial() {
    	
        //Initializes an empty polynomial
    	
        this.polynomial = new OrderedLinkedList<>();
        
    }

    public void add(int coefficient, int degree) {
    	
        //Adds a monomial to the polynomial
    	
        Monomial monomial = new Monomial(coefficient, degree);
        
        this.polynomial.insert(monomial);
        
    }

    public Polynomial derivative() {
    	
    	int i = 0;
    	
        //calculates and returns the derivative
    	
        Polynomial derivedPolynomial = new Polynomial();

        for (i = 0; i < this.polynomial.getSize(); i++) {
        	
            Monomial monomial = this.polynomial.get(i);

            //Calculate the derivative of each monomial and adds it to the derived polynomial
            
            if (monomial.getDegree() != 0) {
            	
                derivedPolynomial.add(monomial.getCoefficient() * monomial.getDegree(),
                                      monomial.getDegree() - 1);
                
            }
            
        }

        return derivedPolynomial;
        
    }

    public double eval(double x) {
    	
    	int i = 0;
    	
        //Evaluates the polynomial
        double result = 0.0;

        for (i = 0; i < this.polynomial.getSize(); i++) {
        	
            Monomial monomial = this.polynomial.get(i);

            //Evaluate each monomial and accumulate the result
            
            result += monomial.getCoefficient() * Math.pow(x, monomial.getDegree());
            
        }

        return result;
        
    }

    public String toString() {
    	
    	int i = 0;
    	
        //Converts the polynomial to a string
    	
        if (this.polynomial.getSize() == 0) {
        	
            return "";
            
        }

        StringBuilder sb = new StringBuilder();

        for (i = 0; i < this.polynomial.getSize(); i++) {
        	
            Monomial monomial = this.polynomial.get(i);

            if (i != 0) {
            	
                if (monomial.getCoefficient() >= 0) {
                	
                    sb.append(" + ");
                    
                } 
                
                else {
                	
                    sb.append(" ");
                    
                }
                
            }

            int updNeg;

            if(monomial.getCoefficient() < 0) {
            	
                updNeg = monomial.getCoefficient() * -1;
                
                sb.append("- ");
                
                sb.append(updNeg);
                
            } 
            
            else {
            	
                sb.append(monomial.getCoefficient());
                
            }

            sb.append("*x");

            if (monomial.getDegree() != 1) {
            	
                sb.append("^").append(monomial.getDegree());
                
            }

            if (monomial.getDegree() == 1) {
            	
                sb.append("^").append(monomial.getDegree());
                
            }
            
        }

        return sb.toString();
        
    }
    
    public double solve(double x0, double tolerance, int maxIterations) throws SolutionNotFound {
    	
        //Solves for a root of the polynomial using Newton's method
    	
        double previous = x0;
        
        int iteration = 0;

        while (iteration < maxIterations) {
        	
            double fValue = eval(previous);
            
            Polynomial derivative = derivative();
            
            double fPrimeValue = derivative.eval(previous);

            // If derivative is zero then exception is thrown
            
            if (Math.abs(fPrimeValue) < 1e-10) {
            	
                throw new SolutionNotFound("divide by zero error");
                
            }

            double current = previous - (fValue / fPrimeValue);

            //If the difference between two successive approximations is less than tolerance, return current value
            if (Math.abs(current - previous) < tolerance) {
            	
                return current;
                
            }

            //If f(x) is zero then solution is found
            
            if (Math.abs(fValue) < 1e-10) {
            	
                return previous;
                
            }

            previous = current;
            
            iteration++;
            
        }

        throw new SolutionNotFound("maximum iteration exceeded");
        
    }
    
}