package espacio;

public class Misil extends ObjetoGrafico {


	public Misil(double coord_x, double coord_y, double angulo,double velocidad) {
		super(coord_x, coord_y, angulo);
		// TODO Auto-generated constructor stub
		this.velocidad=velocidad;
	}

	// sobrescritura obligada, porque en la
	// superclase esta declarado como abstract
	@Override
	public void dibujar() {
		System.out.println("Misil enviado a una velocidad de :"+this.velocidad);
	}

}
