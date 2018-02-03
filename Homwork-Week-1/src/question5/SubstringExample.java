package question5;

public class SubstringExample {
	
	static String substring(String str, int idx) {
		
		if(idx > str.length()) {
			return str + idx;
		}
		
		String x = "";
		for(int i=0; i<idx;i++) {
			x+=str.charAt(i);
		}
		return x;			
	}

	public static void main(String[] args) {
		
		String st= "I am learning Java";
		System.out.println(st);
		System.out.println("substring(string,4): "+substring(st, 4));
		System.out.println("substring(string,10): "+substring(st, 10));
		
	}

}
