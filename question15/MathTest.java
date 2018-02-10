package question15;

import org.junit.Test;

public class MathTest {
	
	MathClass mc = new MathClass();

	@Test
	public void testAddition() {
		equals(mc.addition(15, 20));
	}
	
	@Test
	public void testSubtraction() {
		equals(mc.subtraction(360, 90));
	}
	
	@Test
	public void testMultiplication() {
		equals(mc.multiplication(5, 25));
	}
	
	@Test
	public void testDivision() {
		equals(mc.division(100, 3));
	}

}
