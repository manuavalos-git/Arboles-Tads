package figuras;

public class PruebaFig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado c=new Cuadrado(4);
		System.out.println(c.ancho);
		System.out.println(c.alto);
		Rectangulo r=new Rectangulo(4, 6);
		System.out.println(r.ancho);
		System.out.println(r.alto);
		System.out.println(r.area());
		System.out.println(r.toString());
	}

}
