package br.ufc.quixada.eda.hash;

public abstract class Hash <T>{
	
	public abstract Object calcularHash(T valor);
	public abstract void inserir(T valor);
	public abstract void remove(T valor);
	public abstract T selecionar(T valor);
}
