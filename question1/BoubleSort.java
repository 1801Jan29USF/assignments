package question1;

public class BoubleSort {
	
	public int[] bouble(int[] array) {
		int temp;
		int[] arr = array;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < (arr.length - i); j++) {
				if(arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;				
				}
			}
		}
		
		return arr;

	}
	
	public void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		BoubleSort bs = new BoubleSort();
		int[] result = new int[10];
		int[] arr = {3,7,15,9,22,4,17,13,33,1};
		bs.printArray(arr);
		result = bs.bouble(arr);
		bs.printArray(result);
	}

}
