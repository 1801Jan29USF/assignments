package question4;

public class ComputeNFactorial {
	
	private int fact;
	
	public ComputeNFactorial() {
		fact = 1;
	}

	public void computeFactorial(int n) {
		
		for(int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println(n + "! = " + fact);
	}

}
