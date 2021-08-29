package arboles;

public class PruebaArb {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		ABB<Integer> arbol=new ABB<Integer>();
		arbol.agregar(6);
		arbol.agregar(4);
		arbol.agregar(2);
		arbol.agregar(1);
		arbol.agregar(3);
		arbol.agregar(8);
//		arbol.inorder();
//		arbol.preorder();
//		arbol.postorder();
//		
		//System.out.print(arbol.sucesor(2));
		arbol.niveles();
		System.out.println(arbol.ramaMasCorta());
		System.out.println(arbol.cantidadPorNivel(4));
		System.out.println(arbol.minimo());
		System.out.println("#####################");
		AB<Integer> arbol2=new AB<Integer>();
		arbol2.agregar(6);
		arbol2.agregar(4);
		arbol2.agregar(2);
		arbol2.agregar(1);
		arbol2.agregar(3);
		arbol2.agregar(8);
		arbol2.inorder();
		
//		
		//System.out.print(arbol.sucesor(2));
		arbol2.niveles();
		System.out.println(arbol2.ramaMasCorta());
		System.out.println(arbol2.altura());
		System.out.println(arbol2.cantidadPorNivel(4));
		System.out.println(arbol2.minimo()+"hola");
		System.out.println(arbol2.nivel(3)+" aca");
	}
	public boolean igualEstructural(ABB abb1, ABB abb2) {
		return igualEstructural(abb1.raiz.getIzq(),abb2.raiz.getIzq())&&
				igualEstructural(abb1.raiz.getDer(),abb2.raiz.getDer());
	}
	private boolean igualEstructural(Nodo izq, Nodo izq2) {
		if(izq==null&&izq2==null) {
			return true;
		}
		else if(izq.getInfo()!=izq.getInfo()) {
			return false;
		}
		return igualEstructural(izq.getIzq(),izq2.getIzq())&&
				igualEstructural(izq.getDer(),izq2.getDer());
	}

}
