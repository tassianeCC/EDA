package br.ufc.quixada.eda.hash;

import java.util.ArrayList;
import java.util.List;

public class HashEnderecamentoInterno extends Hash<Integer>{
	private int n;
	private int tamanhaMaior;
	private int tamanhaMenor;
	private List<Integer> tabelaHash;
	private int contadorMaior;
	private int contadorMenor;
		
	public HashEnderecamentoInterno(int tamanho){
		this.tamanhaMaior =(int) ((int) n * 0.7);
		this.tamanhaMenor =  tamanho - tamanhaMaior;
		tabelaHash = new ArrayList<>();
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
		if(valor != null) {
			return valor % this.tamanhaMaior;
		}
		return null;
	}

	@Override
	public void inserir(Integer valor) {
		
		if((contadorMaior + contadorMenor) > (tamanhaMaior)){
			throw new TamanhoInsuficienteException("Exceção de Tamanho Insuficiente");
		}
		
		int indice = calcularHash(valor);
		
		if(tabelaHash.get(indice) == null){
			tabelaHash.add(indice, valor);
			contadorMaior++;
		} else {
			if(contadorMenor > tamanhaMenor){
				throw new TamanhoInsuficienteException("Exceção de Tamanho Insuficiente");
			}

			tabelaHash.add(tamanhaMaior+contadorMenor, valor);
			contadorMenor++;
		}
	}

	@Override
	public void remove(Integer valor) {
		int indice = calcularHash(valor);

		if(tabelaHash.get(indice).equals(valor)){
			tabelaHash.add(indice, null);
		}
	}

	@Override
	public Integer selecionar(Integer valor) {
		int indice = calcularHash(valor);

		if(tabelaHash.get(indice).equals(valor)){
			return indice;
		}

		return -1;
	}
	
	
}
