package figuras;

public class Elipse extends Circulo {
	public double radio2;
	
	public Elipse(double radio,double radio2) {
		super(radio);
		// TODO Auto-generated constructor stub
		this.radio2=radio2;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.radio*this.radio2*this.pi();
	}
}
