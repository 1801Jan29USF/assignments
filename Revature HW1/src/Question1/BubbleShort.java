package Question1;
//sorting an arrayList
public class BubbleShort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,0,5,6,3,2,3,7,9,8,4}; 
		int temp = 0;
	
		for (int i = 0; i < arr.length; i++) {
		  for (int j = 1; j < ( arr.length - i); j++) {
			  if (arr[j-1] > arr[j]) {
				  temp = arr[j - 1];
				  arr[j - 1] = arr[j];
				  arr[j] = temp;
			  }
		  }
		}		
		System.out.println(java.util.Arrays.toString(arr));

	}

}
