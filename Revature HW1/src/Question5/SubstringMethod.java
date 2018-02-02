package Question5;
//Substring Method Question 5
public class SubstringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String testing = "Winning";
        System.out.println(random(testing,3));
	
		
		
	
	}
		
//showing certain characters
private static String random(String str, int idx) {
	
		String answer = "";
		for(int i = 0; i < idx; i++) {
			answer += Character.toString(str.charAt(i));
		}
		
	return answer;	
}
}

