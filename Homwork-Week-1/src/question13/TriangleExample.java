package question13;

public class TriangleExample {

	public static void main(String[] args) {

		//Used nested for loop to itirate through each line 
		//for each iteration it will print what was printed previous lin
		//plus adding and additional 1 or 0 which over is next
		 int number = 1;
	       for (int i=1;i<=4;i++){
	           for (int j=0;j<i;j++){
	               if (number%2!=0) {
	                   System.out.print("0");
	               }
	               else {
	                   System.out.print("1");
	               }
	               number++;
	           }
	           System.out.print("\n");
		}
	}

}
