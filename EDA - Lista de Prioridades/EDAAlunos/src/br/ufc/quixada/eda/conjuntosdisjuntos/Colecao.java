package br.ufc.quixada.eda.conjuntosdisjuntos;
import java.util.ArrayList;
import java.util.List;

public class Colecao {
	private List<ConjuntoDisjunto> conjuntoDisjuntos = new ArrayList<ConjuntoDisjunto>();

	public ConjuntoDisjunto makeSet(int v){
		No no = new No();
		no.setValor(v);
		no.setProximo(null);

		return new ConjuntoDisjunto(no);
	}
	
	public void addConjunto(ConjuntoDisjunto e){
		conjuntoDisjuntos.add(e);
	}

	public List<ConjuntoDisjunto> getConjuntoDisjuntos() {
		return conjuntoDisjuntos;
	}
	
	public ConjuntoDisjunto union(ConjuntoDisjunto u, ConjuntoDisjunto v) {
		No primeiroNoU = u.getPrimeiro();
		No primeiroNoV = v.getPrimeiro();

		ConjuntoDisjunto c = new ConjuntoDisjunto(primeiroNoU);

		while(primeiroNoU.getProximo() != null){
			primeiroNoU = primeiroNoU.getProximo();
		}

		primeiroNoU.setProximo(primeiroNoV);

		return c;
	}
	
}
