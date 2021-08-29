package espacio;

public class CruceroPesado extends Nave {

	public CruceroPesado(double coord_x, double coord_y, double angulo, int energia) {
		super(coord_x, coord_y, angulo, energia);
		// TODO Auto-generated constructor stub
		this.energia=energia;
		this.velocidad=2;
		this.aceleracion=1;
	}
	@Override
	public void disparar(){
		Misil misil=new Misil(30,40,this.angulo,5);
		misil.dibujar();
	}
	@Override
	public void disparar(double ang){
		Misil misil=new Misil(30,40,ang,5);
		misil.dibujar();
	}

}
