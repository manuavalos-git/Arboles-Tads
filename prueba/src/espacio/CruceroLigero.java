package espacio;

public class CruceroLigero extends Nave {

	public CruceroLigero(double coord_x, double coord_y, double angulo, int energia) {
		super(coord_x, coord_y, angulo, energia);
		this.energia=energia;
		this.velocidad=6;
		this.aceleracion=1;
	}
	@Override
	public void disparar(){
		Misil misil=new Misil(30,40,this.angulo,1);
		misil.dibujar();
	}
	@Override
	public void disparar(double ang){
		Misil misil=new Misil(30,40,ang,1);
		misil.dibujar();
	}
	
}
