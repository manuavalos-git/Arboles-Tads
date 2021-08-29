package espacio;

public class Nave extends ObjetoGrafico {
	int energia;
	double aceleracion;

	public Nave(double coord_x, double coord_y, double angulo,int energia) {
		super(coord_x, coord_y, angulo);
		// TODO Auto-generated constructor stub
		this.energia=energia;
		this.velocidad=4;
		this.aceleracion=1;
	}

	// sobrescritura de ObjetoGrafico.mover()
	// mismo nombre, cantidad y tipo de parametros que en la superclase
	@Override
	public void mover(){
		this.setCoord_x(this.getCoord_x()+this.aceleracion+this.velocidad);
		System.out.println("Moviendo "+this.getClass().getSimpleName()+" con velocidad de: "+this.velocidad);
	}

	// sobrecarga (mismo nombre de metodo,
	// pero distinta cantidad o tipo de parametros)
	public void mover(double ang){
		this.setCoord_x(this.getCoord_x()+this.aceleracion+this.velocidad);
		System.out.println( "Moviendo "+this.getClass().getSimpleName()+" con velocidad de: "+this.velocidad+" en un angulo de: "+ ang);
	}
	//sobreescribir en clases hijas
	public void disparar(){
		Misil misil=new Misil(30,40,this.angulo,3);
		misil.dibujar();
	}
	public void disparar(double ang){
		Misil misil=new Misil(30,40,ang,3);
		misil.dibujar();
	}

	// sobrescritura obligada, porque en la
	// superclase esta declarado como abstract
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		System.out.println("Dibujando "+ this.getClass().getSimpleName()+" a una velocidad de "+this.velocidad );
	}
	@Override
	public int hashCode() {
		return (int) (41* super.hashCode()+aceleracion+energia);
	}
	@Override
	public boolean equals(Object other) {
		boolean  result=false;
		if(other instanceof Nave ) {
			Nave that=(Nave)other;
			result=(that.canEqual(this)&&
					this.aceleracion==that.aceleracion &&
					this.energia==that.energia &&
					super.equals(that));
		}
		return result;
	}
	@Override
	public boolean canEqual(Object other) {
		return (other instanceof Nave);
	}
}
