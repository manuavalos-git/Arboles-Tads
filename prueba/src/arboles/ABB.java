package arboles;

public class ABB<T extends Comparable <T>> extends AB<T>{
	/*
	 Recordar los siguientes ejemplos para justificar la complejidad, donde n es la cantidad de nodos:
	-Si no pasa por todos los nodos ni quiera una vez, es a lo sumo O(n), siendo log(n) si puedo 
	demostrar que en cada recursión/iteración “descarto” la mitad de los nodos
	-Si paso por todos los nodos exactamente 1 vez, es O(n)
	-Si para cada nodo paso a lo sumo n veces, es O(n2)
	 */
	@Override
	protected boolean pertenece(Nodo<T> raiz, T elem) {
		if(raiz==null) {
			return false;
		}
		else if(raiz.getInfo().equals(elem)) {
			return true;
		}
		else if(elem.compareTo(raiz.getInfo())>0) {
			return pertenece(raiz.getDer(),elem);
		}
		else return pertenece(raiz.getIzq(),elem);
	}
	@Override
	protected void agregar(Nodo<T> raiz, Nodo<T> nuevo) {
		if(nuevo.getInfo().compareTo(raiz.getInfo())<0) {
			if(raiz.getIzq()==null) {
				raiz.setIzq(nuevo);
			}
			else agregar(raiz.getIzq(),nuevo);
		}	
		else if(nuevo.getInfo().compareTo(raiz.getInfo())>0) {
			if(raiz.getDer()==null) {
				raiz.setDer(nuevo);
			}
			else
				agregar(raiz.getDer(),nuevo);
		}	
	}
	@Override
	protected Nodo<T> agregar2(T elem,Nodo<T> raiz){
		if(raiz==null) {
			return new Nodo<T>(elem);
		}
		if(elem.compareTo(raiz.getInfo())<0) {
			raiz.setIzq(agregar2(elem,raiz.getIzq()));
		}
		else if(elem.compareTo(raiz.getInfo())>0) {
			raiz.setDer(agregar2(elem,raiz.getDer()));
		}
		return raiz;
	}
	@Override
	protected T minimo(Nodo <T> raiz) {
		if(raiz.getIzq()==null) {
			return  raiz.getInfo();
		}
		else return minimo(raiz.getIzq());
	}
	@Override
	protected Nodo<T> eliminar(T elem, Nodo<T> raiz) {
		if (raiz==null) {
			return null;
		}
		if(elem.compareTo(raiz.getInfo())<0) {
			raiz.setIzq(eliminar(elem,raiz.getIzq()));
		}
		else if(elem.compareTo(raiz.getInfo())>0) {
			raiz.setDer(eliminar(elem,raiz.getDer()));
		}
		else{//igual
//			if(esHoja(raiz)) {
//				return null;
//			}
			if(raiz.getIzq()==null) {
				return raiz.getDer();
			}
			else if(raiz.getDer()==null) {
				return raiz.getIzq();
			}
			T minDer=minimo(raiz.getDer());
			raiz.setInfo(minDer);
			raiz.setDer(eliminar(minDer, raiz.getDer()));
						
		}
		return raiz;
	}
	@Override
	protected int nivel(Nodo<T> raiz, T elem) {	
		if(raiz.getInfo().equals(elem))
			return 1;
		if(raiz.getInfo().compareTo(elem) > 0)
			return 1 + nivel(raiz.getIzq(), elem);
		else
			return 1 + nivel(raiz.getDer(), elem);		
	}
	@Override
	protected String caminoHasta(Nodo<T> raiz, T elem) {
		String s=raiz.getInfo()+" ";
		if(raiz.getInfo().compareTo(elem)<0) {
			s=s+caminoHasta(raiz.getDer(),elem);
		}
		else if(raiz.getInfo().compareTo(elem)>0) {
			s=s+caminoHasta(raiz.getIzq(),elem);
		}
		return s;
	}
	@Override
	protected int cantMayores(Nodo<T> raiz, T elem) {
		if(raiz==null) {
			return 0;
		}
		if(raiz.getInfo().compareTo(elem)>0) {
			return 1+cantMayores(raiz.getDer(), elem)+cantMayores(raiz.getIzq(), elem);
		}
		else if(raiz.getInfo().compareTo(elem)==0) {
			return cantMayores(raiz.getDer(), elem);
		}
		else return cantMayores(raiz.getDer(),elem);
	}
	@Override
	protected int cantidadPorNivel(Nodo<T> raiz, int nivel) {
		if(raiz==null) {
			return 0;
		}
		else if(nivel(raiz.getInfo())==nivel) {
			return 1;
		}
		return cantidadPorNivel(raiz.getIzq(), nivel)+
				cantidadPorNivel(raiz.getDer(), nivel);
	}
	 
}
