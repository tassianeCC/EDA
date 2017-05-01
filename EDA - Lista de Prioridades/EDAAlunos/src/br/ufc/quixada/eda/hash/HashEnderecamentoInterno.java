package br.ufc.quixada.eda.hash;

import java.util.ArrayList;
import java.util.List;

public class HashEnderecamentoInterno {
	private int n;
	private int tm;
	private List<Integer> tabelaHash;
		
	public HashEnderecamentoInterno(int n){
		this.n = n;
		this.tm =(int) ((int) n * 0.7);
		tabelaHash = new ArrayList<>();
	}
	
	private int calculaHash(int valor){
		return valor % this.tm;
	}
	
	public void inserir(int valor){
		int indice = calculaHash(valor);
		
		if(tabelaHash.get(indice) == null){
			tabelaHash.add(indice, valor);
		} else {
			for (int i = this.tm+1; i < this.n; i++) {
				if(tabelaHash.get(i) == null) {
					tabelaHash.add(i, valor);
				}
			}
		}
	}
	
	public void remove(int valor){
		int indice = calculaHash(valor);

		if(tabelaHash.get(indice).equals(valor)){
			tabelaHash.add(indice, null);
		}
	}
	
	public int selecionar(int valor){
		int indice = calculaHash(valor);

		if(tabelaHash.get(indice).equals(valor)){
			return indice;
		}

		return -1;
	}
	
	
}
