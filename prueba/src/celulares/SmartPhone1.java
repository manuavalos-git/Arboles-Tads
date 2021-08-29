package celulares;

public class SmartPhone1 extends Celular {

	@Override
	public int precio() {
		// TODO Auto-generated method stub
		return 500;
	}
	public int precio(int descuento) {
		// TODO Auto-generated method stub
		return 500-descuento;
	}

	@Override
	public int cantMegasPorSegundo() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int cantMaxSMSenMemoria() {
		// TODO Auto-generated method stub
		return 1000;
	}

}
