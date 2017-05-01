package br.ufc.quixada.eda.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashEnderecamentoDireto {
	private int n;
	private List<LinkedList<Integer>> tabelaHash;
		
	public HashEnderecamentoDireto(int n){
		this.n = n;
		tabelaHash = new ArrayList<LinkedList<Integer>>();
		
		for(int i = 0; i < n; i++){
			tabelaHash.add(new LinkedList<Integer>());
		}
	}
	
	private int calculaHash(int valor){
		return valor % this.n;
	}
	
	public void inserir(int valor){
		int indice = calculaHash(valor);

		if(!tabelaHash.get(indice).contains(valor)){
			tabelaHash.get(indice).add(valor);
		}
	}
	
	public void remove(int valor){
		int indice = calculaHash(valor);

		if(tabelaHash.get(indice).contains(valor)){
			tabelaHash.get(indice).remove(valor);
		}
	}
	
	public int selecionar(int valor){
		int indice = calculaHash(valor);

		if(tabelaHash.get(indice).contains(valor)){
			return indice;
		}

		return -1;
	}
	
	
}
