//Q15
package com.revature.interfaces;

import com.revature.interfaces.Methods.Operations;

public class ImplementOps implements Operations {
	
	@Override
	public  void  addition(int a, int b) {
		 System.out.println( a + b);
		 	
	}
	@Override
	public void sub(int as, int bs) {
		System.out.println(as - bs);
	
		
	}
	
	@Override
	public void multiplication(int ac,int bc) {
		System.out.println(ac * bc);
		
	}
	@Override
	public void division(int am, int bm) {
		System.out.println(am/bm);
	}
	

}
