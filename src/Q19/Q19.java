package Q19;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		
		//fill an ArrayList with 1-10
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arr.add(i + 1);
		}
		System.out.println(arr);
		
		//print out the sums of the odd numbers and even numbers
		int even = 0;
		int odd = 0;
		for (Integer integer : arr) {			
			if (integer % 2 == 0){
				even += integer;
			}else {
				odd += integer;
			}
		}
		System.out.println("sum of even " + even);
		System.out.println("sum of odd " + odd);
		
		//remove the prime numbers
		ArrayList<Integer> toRemove = new ArrayList<>();
		toRemove.add(2);
		for(int i = 3; i < arr.size(); i++) {
			boolean flag = true;
			for (int prime : toRemove) {
				if(i%prime == 0) {
					flag = false;
				}
			}
			if(flag) {
				toRemove.add(i);
			}
		}
		arr.removeAll(toRemove);
		System.out.println(arr);
	}
}
