package model;

import java.util.Stack;

public class Ascensor<E> implements IAscensor<E> {
private Stack<E> pila;
private int currentFloor;
private boolean isComingDown;
	@Override
	public void subir() {
		setComingDown(false);
		currentFloor++;
	}

	@Override
	public void bajar() {
		setComingDown(true);
		currentFloor--;
		
	}
	
	@Override
	public Stack<E> getPila(){
		return pila;
	}
	
	@Override
	public boolean isEmpty() {
		return pila.isEmpty();
	}

	@Override
	public void salirAscensor() {
		pila.pop();
	}

	@Override
	public void entrarAscensor(E nuevoObjeto) {
		if(!isInElevator(nuevoObjeto)) {
			pila.push(nuevoObjeto);
		}
	}

	@Override
	public boolean isComingDown() {
		return isComingDown;
	}

	@Override
	public void setComingDown(boolean isComingDown) {
		this.isComingDown = isComingDown;
	}

	@Override
	public int getCurrentFloor() {
		return currentFloor;
	}

	@Override
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	@Override
	public boolean isInElevator(E objeto) {
		if(pila.contains(objeto)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
