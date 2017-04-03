package br.ufc.quixada.eda.conjuntosdisjuntos;
import java.util.ArrayList;
import java.util.List;

public class Colecao {
	private List<ConjuntoDisjuntoLE> conjuntoDisjuntos = new ArrayList<ConjuntoDisjuntoLE>();

	public ConjuntoDisjuntoLE makeSet(int v){
		No no = new No();
		no.setValor(v);
		no.setProximo(null);

		return new ConjuntoDisjuntoLE(no);
	}
	
	public void addConjunto(ConjuntoDisjuntoLE e){
		conjuntoDisjuntos.add(e);
	}

	public List<ConjuntoDisjuntoLE> getConjuntoDisjuntos() {
		return conjuntoDisjuntos;
	}
	
	public ConjuntoDisjuntoLE union(ConjuntoDisjuntoLE u, ConjuntoDisjuntoLE v) {
		No primeiroNoU = u.getPrimeiro();
		No primeiroNoV = v.getPrimeiro();

		ConjuntoDisjuntoLE c = new ConjuntoDisjuntoLE(primeiroNoU);

		while(primeiroNoU.getProximo() != null){
			primeiroNoU = primeiroNoU.getProximo();
		}

		primeiroNoU.setProximo(primeiroNoV);

		return c;
	}
	
}
