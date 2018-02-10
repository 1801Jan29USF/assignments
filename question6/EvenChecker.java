package question6;

public class EvenChecker {
	
	int half;

	public EvenChecker() {
		super();
	}

	public void checkIt(int n) {
		
		half = n/2;
		if((half * 2) == n) {
			System.out.println(n + " is an even number.");
		} else {
			System.out.println(n + " is an odd number.");
		}		
	}
}
