package figuras;

public class Cuadrado extends Rectangulo{

	public Cuadrado(double ancho) {
		super(ancho, ancho);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return (int) (41*super.hashCode());
	}
	@Override
	public boolean equals(Object other) {
		boolean  result=false;
		if(other instanceof Cuadrado ) {
			Cuadrado that=(Cuadrado)other;
			result=(that.canEqual(this)&&
					super.equals(that));
		}
		return result;
	}
	public boolean canEqual(Object other) {
		return (other instanceof Cuadrado);
	}

}
