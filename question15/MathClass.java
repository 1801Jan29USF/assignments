package question15;

public class MathClass implements MathInterface {

	@Override
	public double addition(double num1, double num2) {
		
		return num1 + num2;
	}

	@Override
	public double subtraction(double num1, double num2) {
		
		return num1 - num2;
	}

	@Override
	public double multiplication(double num1, double num2) {
		
		return num1 * num2;
	}

	@Override
	public double division(double num1, double num2) {
		
		return num1 / num2;
	}
	
	
}
