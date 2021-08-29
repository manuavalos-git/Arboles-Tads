package arboles;

import java.util.LinkedList;

public class AB <T>{
	public Nodo <T> raiz;	
	
	public void agregar(T elem) {
		Nodo<T> nuevo= new Nodo<T>(elem);
		if(raiz==null) {
			raiz=nuevo;//si el arbol esta vacio la raiz es el nodo a agregar
		}
		else
			agregar(raiz,nuevo);
	}
	protected void agregar(Nodo<T> raiz, Nodo<T> nuevo) {
		if(raiz.getIzq()==null) {//si hay lugar a la izquierda,cambia el lugar por el nuevo
			raiz.setIzq(nuevo);
		}
		else if(raiz.getDer()==null) {//si hay lugar a la der,cambia el lugar por el nuevo
			raiz.setDer(nuevo);
		}
		else
			agregar(raiz.getIzq(),nuevo);//si no hay lugar se mueve a la izq y repite
	}
	public void agregar2(T elem) {
		raiz=agregar2(elem,raiz);
	}
    protected Nodo<T> agregar2(T elem, Nodo<T> raiz) {
    	if(raiz==null) {
			return new Nodo<T>(elem);//crea un nuevo nodo para agregar cuando llega a un null
		}if(raiz.getIzq()==null) {
			raiz.setIzq(agregar2(elem,raiz.getIzq()) );//si la iz es null cambia la iz por lo que devuelve el metodo
		}
		else if(raiz.getDer()==null) {
			raiz.setDer(agregar2(elem,raiz.getDer()));//si la der es null cambia la iz por lo que devuelve el metodo
		}
		else
			agregar2(elem, raiz.getIzq());//si ni iz ni der estan vacios se mueve para la iz
			return raiz;// retorna la raiz
	}
	public int cantNodos() {
		return cantNodos(raiz);
	}
	protected int cantNodos(Nodo<T> raiz) {
		if(raiz==null) {
			return 0;
		}
		else
			return 1+cantNodos(raiz.getIzq())+cantNodos(raiz.getDer());//suma 1 a la cantidad de la derecha+cantidad de iz
	}
	public int altura() {
		return altura(raiz);
	}
	private int altura(Nodo <T> raiz) {
		if (raiz == null) {
			return 0;
		}
		else
			return 1+ Math.max(altura(raiz.getIzq()),altura(raiz.getDer()));
	}
	public int cantidadDeHojas() {
		return cantidadDeHojas(raiz);
	}
	private int cantidadDeHojas(Nodo<T> raiz) {
		if(raiz==null) {
			return 0;
		}
		else if(esHoja(raiz)) {
			return 1;
		}
		return cantidadDeHojas(raiz.getIzq())+cantidadDeHojas(raiz.getDer());
	}
	protected boolean esHoja(Nodo<T> nodo) {
		if(nodo.getIzq()==null && nodo.getDer()==null) {
			return true;
		}
		return false;
	}
	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}
	private boolean estaBalanceado(Nodo<T> raiz) {
		if(raiz==null) {
			return true;
		}
		else 
			return Math.abs(altura(raiz.getIzq())-altura(raiz.getDer()))<=1 
			&& estaBalanceado(raiz.getIzq())
			&& estaBalanceado(raiz.getDer());
	}	
	public boolean pertenece(T elem) {
		return pertenece(raiz,elem);
	}
	protected boolean pertenece(Nodo<T> raiz, T elem) {
		if(raiz==null) {
			return false;
		}
		else if(raiz.getInfo().equals(elem)) {
			return true;
		}
		else return pertenece(raiz.getIzq(),elem) || pertenece(raiz.getDer(),elem);
	}
	public void inorder() {
		System.out.print("[");
		inorder(raiz);
		System.out.println("]");
	}
	private void inorder(Nodo <T> raiz) {
		if(raiz==null) {
			return;
		}
		inorder(raiz.getIzq());
		System.out.print(raiz.getInfo()+" ");
		inorder(raiz.getDer());
	}
	public LinkedList<T> inorderList() {
		LinkedList<T> lista= new LinkedList<T>();
		return inorderList(raiz,lista);
	}
	private LinkedList<T> inorderList(Nodo <T> raiz, LinkedList<T> lista) {
		if(raiz==null) {
			return null;
		}
		inorderList(raiz.getIzq(), lista);
		lista.add(raiz.getInfo());
		inorderList(raiz.getDer(),lista);
		return lista;
	}
	public void preorder() {
		System.out.print("[");
		preorder(raiz);
		System.out.println("]");
	}
	private void preorder(Nodo <T> raiz) {
		if(raiz==null) {
			return;
		}
		System.out.print(raiz.getInfo()+" ");
		preorder(raiz.getIzq());
		preorder(raiz.getDer());
	}
	public void postorder() {
		System.out.print("[");
		postorder(raiz);
		System.out.println("]");
	}
	private void postorder(Nodo <T> raiz) {
		if(raiz==null) {
			return;
		}
		postorder(raiz.getIzq());
		postorder(raiz.getDer());
		System.out.print(raiz.getInfo()+" ");
	}
	public T minimo() {
		if(raiz==null) {
			throw new RuntimeException("No se puede saber el minimo de un arbol vacio");
		}
		return minimo(raiz);
	}
	protected T minimo(Nodo<T> raiz) {
		return null;
	}
	public void eliminar(T elem) {
		raiz=eliminar(elem,raiz);
	}
	protected Nodo<T> eliminar(T elem, Nodo<T> raiz) {
		return raiz;
	}
	public T sucesor(T e) {	
		return iesimo(saberIesimo(e)+1);
	}
	public int saberIesimo(T elem) {
		return inorderList().indexOf(elem);
	}
	public T iesimo(int i) {
		if(i<0 || i>=cantNodos(raiz)) {
			return null;
		}
		return iesimo(i,raiz);
	}
	protected T iesimo(int i, Nodo<T> raiz) {
		int cantIzq=cantNodos(raiz.getIzq());
		if(cantIzq==i) {
			return raiz.getInfo();
		}
		else if(cantIzq>i) {
			return iesimo(i,raiz.getIzq());
		}
		return iesimo(i-(cantIzq+1), raiz.getDer());
	}
	public T mediana() {
		if(raiz==null) {
			return null;
		}
		return iesimo(cantNodos(raiz)/2);
	}
	public boolean tieneCiclos() {
		LinkedList<T> recorridos=new LinkedList<T>();
		return tieneCiclos(raiz,recorridos);
	}
	protected boolean tieneCiclos(Nodo<T> raiz,LinkedList<T> recorridos) {
		if(raiz==null) {
			return false;
		}
		if(recorridos.contains(raiz.getInfo())){
			return true;
		}
		else {
			 recorridos.add(raiz.getInfo());
			 return  tieneCiclos(raiz.getIzq(),recorridos)
					 || tieneCiclos(raiz.getDer(), recorridos); 
		}
	}
	// Devuelva el nivel del arbol donde se encuentra un elemento
	// Si no esta, se debe retornar -1
	// El nivel de la raiz es 1
	//solo en ABB ya que sino cuenta la cantidad de nodos
	public int nivel(T elem) {
		if (!pertenece(elem))
			return -1;
		return nivel(raiz, elem);
	}
	protected int nivel(Nodo<T> raiz, T elem) {
		return 0;
	}
	public void niveles() {
		int nivel=1;
		System.out.print("[");
		if(raiz==null){
			System.out.print("");
		}
		else {
			System.out.print(raiz.getInfo()+" ");
				//+"Nivel :"+ nivel+"\n"
			niveles(raiz,nivel);
		}
		System.out.println("]");
	}
	private void niveles(Nodo<T> raiz, int nivel) {
		nivel++;
		if(raiz==null) {
			return;
		}
		else {
			if(raiz.getIzq()!=null){
				System.out.print(raiz.getIzq()+" ");
				//+" "+"nivel"+nivel+"\n"
			}
			if(raiz.getDer()!=null){
				System.out.print(raiz.getDer()+" ");
				//+" "+"nivel"+nivel+"\n"
			}
			niveles(raiz.getIzq(),nivel);
			niveles(raiz.getDer(),nivel);
		}
	}
	//devuelve un string con el camino desde la raiz hasta el elemento
		public String caminoHasta(T elem) {
			if(pertenece(elem)) {
				return "{"+caminoHasta(raiz,elem)+"}";
			}
			return "{}";
		}
	protected String caminoHasta(Nodo<T> raiz, T elem) {
		// TODO Auto-generated method stub
		return null;
	}
	//devuelve la cantidad de nodos mayores al elemento
	public int cantMayores(T elem) {
		if(!pertenece(elem)) {
			return 0;
		}
		else {
			return cantMayores(raiz,elem);
		}
	}
	protected int cantMayores(Nodo<T> raiz, T elem) {
		return 0;
	}
	public int ramaMasCorta() {
		return ramaMasCorta(raiz);
	}
	private int ramaMasCorta(Nodo <T> raiz) {
		if (raiz == null) {
			return 0;
		}
		else
			return 1+ Math.min(ramaMasCorta(raiz.getIzq()),ramaMasCorta(raiz.getDer()));
	}
	//solo ABB porque ab no tiene nivel ya que sino cuenta la cantidad de nodos
	public int cantidadPorNivel(int nivel) {
		if(nivel>0&&nivel<=this.altura()) {
			return cantidadPorNivel(raiz,nivel);
		}
		else return 0;
	}
	protected int cantidadPorNivel(Nodo<T> raiz, int nivel) {
		return 0;
	}
//	public Tripla<Integer,Integer,Integer>  podio(){
//		 if(this.cantNodos()>=3) {
//			 return new Tripla<Integer, Integer, Integer>(iesimo(cantNodos()-1),iesimo(cantNodos()-2), iesimo(cantNodos()-3));
//		 }
//		 else {
//			 return null;
//		 }
//	 }
}
