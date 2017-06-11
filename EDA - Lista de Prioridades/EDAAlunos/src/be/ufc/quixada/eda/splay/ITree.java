package be.ufc.quixada.eda.splay;

public interface ITree<T> {

	public T getRaiz();
	
	public T buscar(int chave);
	
	public void remove(int chave);

}
