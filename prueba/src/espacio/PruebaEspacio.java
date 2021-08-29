package espacio;

import java.util.ArrayList;

public class PruebaEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		Nave nave1, nave2;
		Asteroide asteroide1, asteroide2, asteroide3;
		// No es posible, si ObjetoGrafico esta declarado como abstract
		// ObjetoGrafico ogr = new ObjetoGrafico();
		//nave :double coord_x, double coord_y, double angulo,int energia
		nave1 = new Nave(50, 50,49,4);
		nave2 = new Nave(50,40,49,6);
		// asteroide:double coord_x, double coord_y, 
		//double velocidad, double angulo,double rotacion
		asteroide1 = new Asteroide(30, 90, 1, 30, 40);
		asteroide2 = new Asteroide(40, 80, 2, 30, 40);
		asteroide3 = new Asteroide(20, 70,3,33, 39);
		CruceroLigero c= new CruceroLigero(50, 57, 34, 3);
		objetos.add(nave1);
		objetos.add(nave2);
		objetos.add(asteroide1);
		objetos.add(asteroide2);
		objetos.add(asteroide3);
		objetos.add(c);
		//hacerQueDisparenTodas(objetos);
		for (ObjetoGrafico og: objetos) {
			og.mover();
			og.dibujar();
			System.out.println(og);
		}
	}
	public static void hacerQueDisparenTodas(ArrayList<ObjetoGrafico> objetos) {
		for(ObjetoGrafico og: objetos) {
			if(og instanceof Nave) {
				System.out.println(og);
				((Nave) og).disparar();
			}
		}
	}

}
