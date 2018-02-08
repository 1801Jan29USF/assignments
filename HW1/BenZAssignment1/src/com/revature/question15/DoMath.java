package com.revature.question15;

public class DoMath implements BzMathStuff{

	@Override
	public int bzAdd(int one, int two) {
		return one + two;
	}

	@Override
	public int bzSub(int one, int two) {
		return one - two;
	}

	@Override
	public int bzMult(int one, int two) {
		return one * two;
	}

	@Override
	public float bzDiv(int one, int two) {
		return one / two;
	}
	
}
