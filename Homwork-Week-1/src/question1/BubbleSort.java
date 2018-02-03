package question1;

public class BubbleSort {

	//bubbleSort algorethim in which array is traversed from first element to last element.
	static void bubbleSort(int[] array) {

		int temp = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				//if current elemnt is greater than the next element then it swamps elements
				if (array[j - 1] > array[j]) {					
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}

		}
	}
	
	public static void main(String[] args) {
		int[] array = {0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(array);// used bubbleSort to sort array elements. 
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}

}
