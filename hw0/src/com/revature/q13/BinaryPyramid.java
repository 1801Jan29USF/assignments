package com.revature.q13;

public class BinaryPyramid {
	
	private int numRows;
	private boolean lastWasZero = false;

	public BinaryPyramid() {
		super();
	}

	public BinaryPyramid(int numRows) {
		super();
		this.numRows = numRows;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public boolean isLastWasZero() {
		return lastWasZero;
	}

	public void setLastWasZero(boolean lastWasZero) {
		this.lastWasZero = lastWasZero;
	}

	public void printPyramid() {
		for(int i = 0; i <= numRows; i++) {
			for(int j = 0; j < i; j++) {
				if(!lastWasZero) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
				lastWasZero = !lastWasZero;
			}
			System.out.println();
		}
	}
	
}
