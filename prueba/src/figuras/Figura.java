package figuras;

public abstract class Figura {

	public abstract int cantLados();
	public abstract double area();
	public double pi() {
		return Math.PI;
	}
	@Override
	public String toString(){
		return "Soy un "+this.getClass().getSimpleName();
	}
}
