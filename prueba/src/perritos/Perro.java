package perritos;

public abstract class Perro {
	public abstract String ladrar();
	public int cantidadPatas(){
		return 4;
	}
	final String predicado() {
		return this.getClass().getSimpleName()+" que ladra no muerde";
	}
}
