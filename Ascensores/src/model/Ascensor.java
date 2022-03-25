package model;

import java.util.Stack;

public class Ascensor<E> implements IAscensor<E> {
private Stack<E> pila;
private int currentFloor;
private boolean isComingDown;
	@Override
	public void subir() {
		// TODO Auto-generated method stub
	}

	@Override
	public void bajar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salirAscensor() {
		pila.pop();
	}

	@Override
	public void entrarAscensor(E nuevoObjeto) {
		pila.push(nuevoObjeto);
	}

	public boolean isComingDown() {
		return isComingDown;
	}

	public void setComingDown(boolean isComingDown) {
		this.isComingDown = isComingDown;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	
	
}
