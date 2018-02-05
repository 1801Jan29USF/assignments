package com.revature.q11.beans;

public class IStoreFloats {

	public IStoreFloats() {
		super();
	}
	
	private static float float0 = 3.14159f;
	private static float float1 = 2.71828f;
	
	public static float getFloat0() {
		return float0;
	}
	public static void setFloat0(float float0) {
		IStoreFloats.float0 = float0;
	}
	public static float getFloat1() {
		return float1;
	}
	public static void setFloat1(float float1) {
		IStoreFloats.float1 = float1;
	}

}
