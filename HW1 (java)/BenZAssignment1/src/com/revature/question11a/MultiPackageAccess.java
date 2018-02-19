package com.revature.question11a;

import com.revature.question11b.HoldSomeFloats;

public class MultiPackageAccess {
	public static void main(String[] args) {
		// 10/10 Naming convention. Not confusing at all. Don't hate me.
		HoldSomeFloats someFloats = new HoldSomeFloats(4.20f, 7.77f);
		
		float usingMyFloats = someFloats.getaDistantFloat() + someFloats.getHoldMyFloat();
		System.out.println(usingMyFloats);
}
}
