package br.ufc.quixada.eda.conjuntosdisjuntos;

public class ConjuntoDisjunto {
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;
	
	public ConjuntoDisjunto(int n){
		this.n = n;
		this.pai = new int[n];
		this.ordem = new int[n];
	}
	
	public void make_set(){
		for (int i = 0; i < n; i++) {
			pai[i] = i;
			ordem[i] = 0;
		}	
	}
	
	public int find_set(int x){
		if(x == pai[x])
			return x;
		else
			return find_set(pai[x]);
	}
	
	public void union(int x, int y){
		link(find_set(x), find_set(y));
	}
	
	public void link(int x, int y){
		if(ordem[x] < ordem[y])
			pai[x] = y;
		else{
			if(ordem[x] == ordem[y])
				ordem[x]++;
			pai[y] = x;
		}
			
	}
	
}
