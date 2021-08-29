package arboles;

public class Tripla<T1, T2, T3> implements Comparable<T1>{

	private T1 x;
	private T2 y;
	private T3 z;
	
	public Tripla(T1 t, T2 t2,T3 t3) {
		x=t;
		y=t2;
		z=t3;
	}
	public T1 getX() {
		return x;
	}
	public T2 getY() {
		return y;
	}
	public T3 getZ() {
		return z;
	}
	public void setX(T1 t1) {
		 x=t1;
	}
	public void setY(T2 t2) {
		 y=t2;
	}
	public int compareTo(Tripla<T1,T2,T3> tripla) {
		return this.compareTo(tripla.x);
	}
	@Override
	public int compareTo(T1 o) {
		return ((Integer)this.x)-(Integer)o;
	}
	@Override
	public String toString() {
		return  x+""+ y+""+ z ; 
	}
	
	
}
