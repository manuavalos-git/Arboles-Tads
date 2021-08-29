package perritos;

import java.util.ArrayList;

public class PruebaPerros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Perro> perros = new ArrayList<Perro>();
		perros.add(new Cocker());
		perros.add(new Caniche());
		for (Perro p: perros) {
			System.out.println(p.predicado());
			System.out.println(p.ladrar());
			System.out.println(p.cantidadPatas());
		}

	}

}
