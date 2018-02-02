package Question3;
//ReverseString Question 3
public class ReverseString {

	public static void main(String[] args) {
		
		String input = "Racecar";
		 
        byte [] reverse = input.getBytes(); //getBytes() method makes strings turn into bytes
 
        byte [] result = 
                   new byte [reverse.length]; //counts the length of the bytes created by the String
 
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i<reverse.length; i++)
            result[i] = 
             reverse[reverse.length-i-1];
 
        System.out.println(new String(result));
	}

}
