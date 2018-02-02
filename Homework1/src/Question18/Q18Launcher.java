package Question18;

public class Q18Launcher {

	public static void main(String[] args) {
		StringSnuffer snuff = new StringSnuffer();
		// Creates two sample strings to play with
		String caps = "Caps";
		String noCaps = "nocaps";
		String anInt = "11";
		// Checks the string "Caps" for caps. Should be true.
		System.out.println(snuff.hasCaps(caps));
		// Checks the string "nocaps" for caps. Should be false.
		System.out.println(snuff.hasCaps(noCaps));
		// Converts the string "nocaps" to upper case.
		System.out.println(snuff.toUppercase(noCaps));
		// Converts anInt to its numberical value (11) and adds 10
		snuff.add10(anInt);
	}

}
