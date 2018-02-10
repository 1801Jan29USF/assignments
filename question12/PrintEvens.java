package question12;

import java.util.ArrayList;
import java.util.List;

public class PrintEvens {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		for(int n: numbers) {
			if(n % 2 == 0)
				System.out.println(n);
		}
	}

}
