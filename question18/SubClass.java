package question18;

public class SubClass extends Abstract {

	@Override
	public boolean uppercaseChecker(String s) {
		//check each character in string for uppercases
		StringBuilder sb = new StringBuilder(s);
		boolean isUpper = false;
		for(int i = 0; i < sb.length(); i++) {
			if(Character.isUpperCase(sb.charAt(i)))
				isUpper = true;
		}		
		return isUpper;
	}

	@Override
	public String uppercaseConverter(String s) {
		//capitalizes lowercase characters
		StringBuilder sb = new StringBuilder(s);
		StringBuilder newString = new StringBuilder();
		char ch = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(Character.isLowerCase(sb.charAt(i))) {
				ch = Character.toUpperCase(sb.charAt(i));			
			}
			newString.append(ch);
		}
		
		return newString.toString();
	}

	@Override
	public void addTen(String s) {
		//converts input string to int then adds 10
		try {
			int integer = Integer.parseInt(s);
			integer = integer + 10;
			System.out.println(integer);
		} catch (Exception e) {
			System.out.println("You cannot add a number to a string.");
		}		
	}

}
