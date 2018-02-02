package Question13;
//Triangle Pyramid
public class TriangleDisplay {
    public static void main(String[] args) {
    
   int currentNum = 0;

	for (int i = 1; i <= 4; i++) { // this prints out the amount of lines
	  for (int t = 0; t < i; t++) { //this prints out the max amount in a line 
		  System.out.print(currentNum);	
		   if (currentNum == 0) { // if the currentNum is 0 then it will change it otherwise stay at 0
			currentNum = 1; 
   		   } else { 
   			   currentNum = 0;
   		   }
	  }
	  System.out.println();
	}
	
	
}
}