package com.revature.question18;

public class StringManipulator extends AbstractSuper{
// Capitals 65-90 inclusive. Lowercase 97-122 inclusive
	
	@Override
	boolean checkUpper(String str) {
		// Only need one capital before we return in order to meet the requirements
		for(int i = 0; i <= str.length(); i++) {
			if((str.charAt(i) > 64) && (str.charAt(i) < 91))
				return true;
		}
		return false;
	}

	@Override
	String toUpper(String str) {	
		return str.toUpperCase();
		
		// Well look at that, turns out there's a "toUpper" function already. Awkward
		// Got an exception when I tried to run it so guess I'll get to use it anyways. 
		// Leaving this because RIP C
		
//		// I convert to char array so that I can change values. Quite a bother so far that strings are immutable.
//		char[] c = new char[str.length()];
//		str.getChars(0, str.length(), c, 0);
//		for(int i = 0; i <= str.length(); i++) {
//			// -32 should bring it from a lowercase letter to the capital equivalent
//			if((c[i] > 96) && (c[i] < 123))
//				c[i] -= 32;	
//		}
//		return c.toString();
	}

	@Override
	int atoiPlusTen(String str) {
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
			e.printStackTrace();
		}
		return result + 10;
	}

}
