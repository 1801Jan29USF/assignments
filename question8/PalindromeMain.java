package question8;

import java.util.LinkedList;
import java.util.List;

public class PalindromeMain {
	
	public static void main(String[] args) {
		
		Palindromes pd = new Palindromes();
		List<String> OriginalStrings = new LinkedList<>();
		OriginalStrings.add("karan");
		OriginalStrings.add("madam");
		OriginalStrings.add("tom");
		OriginalStrings.add("civic");
		OriginalStrings.add("radar");
		OriginalStrings.add("sexes");
		OriginalStrings.add("jimmy");
		OriginalStrings.add("kayak");
		OriginalStrings.add("john");
		OriginalStrings.add("refer");
		OriginalStrings.add("billy");
		OriginalStrings.add("did");
		
		pd.findPalindromes(OriginalStrings);
		
		pd.printLists();
	}

}
