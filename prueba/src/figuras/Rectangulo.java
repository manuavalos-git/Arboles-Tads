package figuras;

public class Rectangulo extends Figura{
	public double ancho;
	public double alto;
	
	public Rectangulo(double ancho, double alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.alto*this.ancho;
	}

	@Override
	public int cantLados() {
		// TODO Auto-generated method stub
		return 4;
	}
	@Override
	public int hashCode() {
		return (int) (41*(41+ancho+alto));
	}
	@Override
	public boolean equals(Object other) {
		boolean  result=false;
		if(other instanceof Rectangulo ) {
			Rectangulo that=(Rectangulo)other;
			result=(that.canEqual(this)&&
					this.alto==that.ancho&&
					this.alto==that.alto);
		}
		return result;
	}
	public boolean canEqual(Object other) {
		return (other instanceof Rectangulo);
	}

}
