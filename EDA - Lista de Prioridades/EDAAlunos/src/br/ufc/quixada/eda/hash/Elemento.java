package br.ufc.quixada.eda.hash;

public class Elemento {
	
	private int valor;
	private int indiceProximo;
	
	public Elemento(){
		indiceProximo = -1;
	}
	
	public Elemento(int valor){
		this.valor = valor;
		indiceProximo = -1;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getIndiceProximo() {
		return indiceProximo;
	}
	public void setIndiceProximo(int indiceProximo) {
		this.indiceProximo = indiceProximo;
	}

}
