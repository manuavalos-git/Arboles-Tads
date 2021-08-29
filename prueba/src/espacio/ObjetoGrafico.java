package espacio;

public abstract class ObjetoGrafico {
	private double coord_x;
	private double coord_y;
	double velocidad;
	double angulo;
	
	
	public ObjetoGrafico(double coord_x, double coord_y, double angulo) {
		super();
		this.coord_x = coord_x;
		this.coord_y = coord_y;
		this.angulo = angulo;
	}
	public double getCoord_x(){
		return coord_x;
	}
	public double getCoord_y(){
		return coord_y;
	}
	public void mover() {
		this.coord_x+=this.velocidad;
		System.out.println("Moviendo "+this.getClass().getSimpleName()+
				" a una velocidad de: "+this.velocidad);
	}
	public void setCoord_x(double coord_x) {
		this.coord_x = coord_x;
	}
	public void chocarCon(ObjetoGrafico g) {};
	public abstract void dibujar();
	
	@Override
	public String toString(){
		return "Soy un "+this.getClass().getSimpleName();
	}
	@Override
	public int hashCode() {
		return (int) (41*(41+angulo+coord_x+coord_y+velocidad));
	}
	@Override
	public boolean equals(Object other) {
		boolean  result=false;
		if(other instanceof ObjetoGrafico ) {
			ObjetoGrafico that=(ObjetoGrafico)other;
			result=(that.canEqual(this)&&
					this.angulo==that.angulo &&
					this.coord_x==that.coord_x &&
					this.coord_y==that.coord_y &&
					this.velocidad==that.velocidad);
		}
		return result;
	}
	public boolean canEqual(Object other) {
		return (other instanceof ObjetoGrafico);
	}

}
