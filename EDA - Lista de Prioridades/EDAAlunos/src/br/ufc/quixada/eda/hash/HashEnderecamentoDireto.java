package br.ufc.quixada.eda.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashEnderecamentoDireto extends Hash<Integer>{
	private int n;
	private List<LinkedList<Integer>> tabelaHash;
		
	public HashEnderecamentoDireto(int n){
		this.n = n;
		tabelaHash = new ArrayList<LinkedList<Integer>>();
		
		for(int i = 0; i < n; i++){
			tabelaHash.add(new LinkedList<Integer>());
		}
	}
	
//	private int calculaHash(int valor){
//	}
//	
//	public void inserir(int valor){
//	}
//	
//	public void remove(int valor){
//	}
//	
//	public int selecionar(int valor){
//	}

	@Override
	public Integer calcularHash(Integer valor) {
		if(valor != null){
			return valor % this.n;
		}
		return null;
	}

	@Override
	public void inserir(Integer valor) {
		int indice = calcularHash(valor);

		if(!tabelaHash.get(indice).contains(valor)){
			tabelaHash.get(indice).add(valor);
		}
	}

	@Override
	public void remove(Integer valor) {
		int indice = calcularHash(valor);

		if(tabelaHash.get(indice).contains(valor)){
			tabelaHash.get(indice).remove(valor);
		}
	}

	@Override
	public Integer selecionar(Integer valor) {
		int indice = calcularHash(valor);

		if(tabelaHash.get(indice).contains(valor)){
			return indice;
		}

		return -1;
	}
	
	
}
