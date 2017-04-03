package br.ufc.quixada.eda.conjuntosdisjuntos;
public class ConjuntoDisjunto {
	private No primeiro;

	public ConjuntoDisjunto(){
	}
	
	public ConjuntoDisjunto(No primeiro) {
		this.primeiro = primeiro;
		this.primeiro.setRepresentante(primeiro);
		this.primeiro.setProximo(null);
	}

	public No find(int x) {
		No atual = primeiro;

		while(atual != null) {
			if(atual.getValor() == x){
				return atual.getRepresentante();
			}
			atual = atual.getProximo();
		}
		return null;
	}
	
	public void adicionarElemento(int x){
		No no = new No();
		no.setValor(x);
		no.setRepresentante(primeiro);
		no.setProximo(null);

		No atual = this.primeiro;

		while(atual.getRepresentante() != null) {
			atual = atual.getProximo();
		}

		atual.setProximo(no);
	}

	public No getPrimeiro() {
		return primeiro;
	}
}
