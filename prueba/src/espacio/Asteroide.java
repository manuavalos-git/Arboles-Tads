package espacio;

public class Asteroide extends ObjetoGrafico {
	double rotacion;
	
	public Asteroide(double coord_x, double coord_y, double velocidad, double angulo,double rotacion) {
		super(coord_x, coord_y, angulo);
		// TODO Auto-generated constructor stub
		this.velocidad=velocidad;
		this.rotacion=rotacion;
	}

	// sobrescritura
//	@Override
//	public void mover(){}

	// sobrescritura obligada, porque en la
	// superclase esta declarado como abstract
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		System.out.println("Dibujando Asteroide ");
	}
}
