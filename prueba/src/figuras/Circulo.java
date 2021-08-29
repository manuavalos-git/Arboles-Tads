package figuras;

public class Circulo extends Figura {
	public double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public int cantLados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.radio*this.radio*this.pi();
	}
	@Override
	public int hashCode() {
		return (int) (41*(41+radio));
	}
	@Override
	public boolean equals(Object other) {
		boolean  result=false;
		if(other instanceof Circulo ) {
			Circulo that=(Circulo)other;
			result=(that.canEqual(this)&&
					this.radio==that.radio);
		}
		return result;
	}
	public boolean canEqual(Object other) {
		return (other instanceof Circulo);
	}


}
