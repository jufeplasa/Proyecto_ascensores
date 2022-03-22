package model;

import java.util.Stack;

public class Ascensor<E> implements IAscensor<E> {
private Stack<E> pila;
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

}
