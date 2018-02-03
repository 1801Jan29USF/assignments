package question15;


public class MathInterfaceExample implements MathInterface{
	//Implemented the MathiInterface with all its mehtods 
	
	private double a;
	private double b;
	private double c;
	
	

	public MathInterfaceExample() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public MathInterfaceExample(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	



	public double getA() {
		return a;
	}



	public void setA(double a) {
		this.a = a;
	}



	public double getB() {
		return b;
	}



	public void setB(double b) {
		this.b = b;
	}



	public double getC() {
		return c;
	}



	public void setC(double c) {
		this.c = c;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MathInterfaceExample other = (MathInterfaceExample) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "MathInterfaceExample [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	

	
	@Override
	public double add() {
		
		a = b+c;
		return a;
	}
	

	//implemented divide method from Interface
	@Override
	public double divide() {
		a = b/c;
		return a;
		
	}

	//implemented multiply method from Interface
	@Override
	public double multiply() {
		a = b * c;
		return a;
	}

	//implemented subtract method from Interface
	@Override
	public double subtract() {
		a = b-c; 
		return a;
	}
	
	

}
