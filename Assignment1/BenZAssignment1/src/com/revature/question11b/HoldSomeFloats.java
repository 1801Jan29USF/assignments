package com.revature.question11b;

public class HoldSomeFloats {
	public float holdMyFloat;
	public float aDistantFloat;
	
	
	public HoldSomeFloats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoldSomeFloats(float holdMyFloat, float aDistantFloat) {
		super();
		this.holdMyFloat = holdMyFloat;
		this.aDistantFloat = aDistantFloat;
	}
	public float getHoldMyFloat() {
		return holdMyFloat;
	}
	public void setHoldMyFloat(float holdMyFloat) {
		this.holdMyFloat = holdMyFloat;
	}
	public float getaDistantFloat() {
		return aDistantFloat;
	}
	public void setaDistantFloat(float aDistantFloat) {
		this.aDistantFloat = aDistantFloat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(aDistantFloat);
		result = prime * result + Float.floatToIntBits(holdMyFloat);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoldSomeFloats other = (HoldSomeFloats) obj;
		if (Float.floatToIntBits(aDistantFloat) != Float.floatToIntBits(other.aDistantFloat))
			return false;
		if (Float.floatToIntBits(holdMyFloat) != Float.floatToIntBits(other.holdMyFloat))
			return false;
		return true;
	}
	
	
}
