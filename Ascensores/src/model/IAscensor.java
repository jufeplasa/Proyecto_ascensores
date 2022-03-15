package model;

public interface IAscensor<T> {
	public void subir();
	public void bajar();
	public void salirAscensor();
	public void entrarAscensor(T nuevoObjeto);
}
