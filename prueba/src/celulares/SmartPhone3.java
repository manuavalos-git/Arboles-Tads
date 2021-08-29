package celulares;

public class SmartPhone3 extends SmartPhone2 {
	@Override
	public int precio() {
		// TODO Auto-generated method stub
		return super.precio()+100;
	}
	public int precio(int descuento) {
		// TODO Auto-generated method stub
		return super.precio()+100-descuento;
	}

	@Override
	public int cantMegasPorSegundo() {
		// TODO Auto-generated method stub
		return super.cantMegasPorSegundo()+1;
	}

}
