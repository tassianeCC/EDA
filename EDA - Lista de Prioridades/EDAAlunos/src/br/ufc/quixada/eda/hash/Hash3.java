package br.ufc.quixada.eda.hash;

import java.util.ArrayList;
import java.util.List;

public class Hash3 {
	private int n;
	private List<Elemento> tabelaHash;
		
	public Hash3(int n){
		this.n = n;
		tabelaHash = new ArrayList<Elemento>();
	}
	
	private int calculaHash(int valor){
		return valor % this.n;
	}
	
	public boolean inserir(int valor){

		if(tabelaHash.contains(valor)) {
			return false;
		}
			
		int indice = calculaHash(valor);
		
		if(tabelaHash.get(indice) == null){
			tabelaHash.add(new Elemento(valor));
			return true;
		}
		else {
			int indiceAtual = getElementoPosicaoLivre(indice);
			int indiceNovo = getProximaNull(indiceAtual);
			
			if(indiceNovo != -1){
				tabelaHash.add(indiceNovo, new Elemento(valor));
				tabelaHash.get(indiceAtual).setIndiceProximo(indiceNovo);
				return true;
			}
		}
		
		return false;

	}
	
	public void remove(int valor){
		if(tabelaHash.contains(valor)){
			int indice = calculaHash(valor);
	
			if(tabelaHash.get(indice).getIndiceProximo() == -1){
				tabelaHash.add(indice, null);
			}
			
			int i;
			for (i = 0; i < indice; i++) {
				if(tabelaHash.get(i).getIndiceProximo() == indice){
					tabelaHash.get(i).setIndiceProximo(-1);
				}
			}
		}
	}
	
	public int selecionar(int valor){
		if(!tabelaHash.contains(valor)){
			return -1;
		}

		int indice = calculaHash(valor);
		while (tabelaHash.get(indice).getValor() != valor) {
			indice = tabelaHash.get(indice).getIndiceProximo();
		}

		return indice;
	}
	
	private int getElementoPosicaoLivre(int index) {
		while (true) {
			if(tabelaHash.get(index).getIndiceProximo() == -1){
				return index;
			}

			index = tabelaHash.get(index).getIndiceProximo();
		}	
	}

	private int getProximaNull(int index) {
		for (int i = index; i < tabelaHash.size(); i++) {
			if(tabelaHash.get(i) == null) {
				return i;
			}
		}

		for (int i = 0; i < index; i++) {
			if(tabelaHash.get(i) == null) {
				return i;
			}
		}

		return -1;
	}
}
