package question9;

public class PrimeCheck {
	
	public boolean isPrime(int n) {
		if(n == 1)
			return false;
	    for (int i = 2; i < n; ++i) {
	      if (n % i == 0) {
	        // If the number has a divisor other
	        // than 1 or itself, we return immediately.
	        return false;
	      }
	    }
	    return true;
	  }

}
