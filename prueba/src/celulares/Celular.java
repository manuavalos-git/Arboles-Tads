package celulares;

import java.util.LinkedList;

public abstract class Celular {
	LinkedList<Celular> listaCel=new LinkedList<Celular>();
	
	public abstract int precio();

	public int cantMegasPorSegundo() {
		return 0;
	}
	public abstract int cantMaxSMSenMemoria();

	public void agregarCelular(Celular c) {
		if(!listaCel.contains(c)) {
			listaCel.add(c);
		}
	}
}
