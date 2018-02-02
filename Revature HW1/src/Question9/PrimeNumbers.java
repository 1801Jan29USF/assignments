package Question9;
import java.util.ArrayList;
public class PrimeNumbers
	{
  public static void main (String[] args)
	   {		
	  ArrayList<Integer> primes = new ArrayList<Integer>();
	    int testNum; 
	    int index; // this is holder for primes

	    for (index = 1; index <= 100; index++) //index counts up to 100 primes
	    {
	        int factors = 0; 
	        for (testNum = index; testNum >= 1; testNum--)
	        {
	            if (index % testNum == 0) 
	            {
	                factors = factors + 1;
	            }
	        }

	        if (factors == 2)
	        {
	            primes.add(index);
	        }
	    }

	    System.out.println("The first 100 prime numbers are:");
	    for (int prime = 0; prime < 25; prime++) 
	    {
	        System.out.println(primes.get(prime));
	   }
	}
	   }
	

