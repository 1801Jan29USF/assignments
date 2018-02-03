package question18;

public class Subclass extends InheritanceExample{
	
    //check if all the char in the stirng are upper case, if not 
	//it will return false.
	@Override
	public boolean checkUpperCase(String str) {
		for(int i = 0; i<str.length(); i++) {
			char x = str.charAt(i);
					if(Character.isUpperCase(x) == true) {
						return true;
					}
		}
		return false;
	}

	//converst the input to upperCase uset isUpperCase method 
	@Override
	public String convertToUpperCase(String str) {
		return str.toUpperCase();
		
	}

	//uses Integer parsInt to convert the input string to an integer.
	@Override
	public void convertToString(String str) {
		System.out.println(Integer.parseInt(str)); ;
		
	}
	
	public static void main(String[] args) {
		String s = "reveture";
		String st = "56";	
		
		Subclass in = new Subclass();
		
		//Check if the string is upper case
		System.out.println(in.checkUpperCase(st));
		//converts the string to upper case 
		System.out.println(in.convertToUpperCase(s));
		//converts input string to integer
		System.out.println(in.convertToUpperCase(st));
	

	}


	
	

	
	
	



}
