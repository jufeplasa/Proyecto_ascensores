package model;

import java.util.Stack;

public interface IAscensor<T> {
	public void subir(int destinyFloor);
	public void bajar(int destinyFloor);
	public boolean isEmpty();
	public void salirAscensor();
	public void entrarAscensor(T nuevoObjeto);
	public void setCurrentFloor(int currentFloor);
	public int getCurrentFloor();
	public void setComingDown(boolean isComingDown);
	public boolean isComingDown();
	public boolean isInElevator(T objeto) ;
	public Stack<T> getPila();
}
