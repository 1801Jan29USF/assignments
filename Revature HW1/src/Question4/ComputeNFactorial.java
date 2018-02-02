package Question4;
//N Factorial Question 4
public class ComputeNFactorial {

	public static void main(String[] args) {
		
	int T,X=1;  //this sets the variable
	int number=5;//It is the number to calculate factorial    
    for(T=1;T<=number;T++){    
	X=X*T;    
	 }    
	 System.out.println("Factorial of "+number+" is: "+X);    
	}  
}  