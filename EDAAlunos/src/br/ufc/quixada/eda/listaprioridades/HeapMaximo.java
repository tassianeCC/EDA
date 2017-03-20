package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author Tassiane, fabio
 * 
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		n = entrada.size();
		for (int i = 0; i < n; i++){
			vetor[i] = entrada.get(i);
		}
		for (int i = (n / 2); i >= 0; i--)
			descer(i);	
	}
	
	private void subir(int i){
		int j = i / 2;
		if(j >= 1){
			if(vetor[j] < vetor[i]){
				int aux = vetor[j];
				vetor[j] = vetor [i];
				vetor[i] = aux;
				subir(j);
			}
		}
	}
	
	private void descer(int i){
		int j = 2*i;
		if(j <= n && j + 1 <= n){
			if(vetor[j + 1] > vetor[j])
				j++;
			if(vetor[j] > vetor[i]){
				int aux = vetor[j];
				vetor[j] = vetor[i];
				vetor[i] = aux;
				descer(j);
			}
		}
	}
	
	public int getMaximaPrioridade(){
		if(n <= 0)
			return 0;
		return vetor[0];
	}
	
	public int remove(){
		int aux = vetor[0];
		vetor[0] = vetor[n];
		vetor[n] = aux;
		n--;
		descer(0);
		return aux;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 <= nMaximo){
			vetor[n + 1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){	
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				if(prioridade > novaPrioridade){
					descer(i);
				}
				else 
					subir(i);
			}
		}
	}	
}
