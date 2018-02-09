package Q1;

public class Q1 {

	
	//Perform a bubble sort on an array
	public static void main(String[] args) {
		int arr[]  = {1,0,5,6,3,2,3,7,9,8,4};
		int temp;
		
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 10 - i; j ++) {
				if(arr[j] > arr[j+1]){
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}							
			}
		}
		for(int i = 0; i < 11; i ++) {
			System.out.println(arr[i]);
		}
	}
}
