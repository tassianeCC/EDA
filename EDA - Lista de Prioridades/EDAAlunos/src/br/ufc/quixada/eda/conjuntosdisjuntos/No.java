package br.ufc.quixada.eda.conjuntosdisjuntos;

public class No {
	
	private int valor;
	private No proximo;
	private No representante;
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getRepresentante() {
		return representante;
	}

	public void setRepresentante(No representante) {
		this.representante = representante;
	}
}