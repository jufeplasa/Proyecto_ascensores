package model;

public interface IAscensor<T> {
	public void subir();
	public void bajar();
	public T salirAscensor();
	public T entrarAscensor();
}
