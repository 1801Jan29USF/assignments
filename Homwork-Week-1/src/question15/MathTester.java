package question15;

public class MathTester {
	
	public static void main(String[] args) {
		MathInterfaceExample ex = new MathInterfaceExample();
		 
	
		//used setter to invoke b and c variables to hard code numbers to be calculated
		ex.setA(0);
		ex.setB(200);
		ex.setC(2);
		
		
		
		System.out.println("The two mulitplied numbers = "+ex.multiply());;
		System.out.println("The two divided numbers = "+ex.divide());;
		System.out.println("The two added numbers = "+ex.add());;
		System.out.println("The two subtracted numbers = "+ex.subtract());;
	}

}
