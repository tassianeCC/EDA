package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
 * @author Tassiane, fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for (int i = 0; i < entrada.size(); i++) {
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();	
		quickSort(0, n - 1); //*Porque as posições são de 0 até 1 a menos do tamanho
	}
	
	public int getMaximaPrioridade(){
		if(n <= 0)
			return 0;
		return vetor[0];
	}
	
	public int remove(){
		int rm = vetor[0];
		for (int i = 0; i < n - 1; i++) {
			vetor[i] = vetor[i + 1];
		} 
		n--;
		return rm;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 < nMaximo){			
			vetor[n] = prioridade;
			n++;
		}
		for (int i = 0; i < n - 1; i++) {
			if(vetor[i - 1] > vetor[i]){
				int aux = vetor[i];
				vetor[i] = vetor[i - 1];
				vetor[i - 1] = aux;
			}
		} 
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				quickSort(0, n - 1);
			}
		}
	}
	
	private void quickSort(int ini, int fim){
		if (ini < fim) {
            int posicao = particiona(ini, fim);
            quickSort(ini, posicao - 1);
            quickSort(posicao + 1, fim);
		}
	}
	
	private int particiona(int p, int r){		
		int escolhido = vetor[p];
        int inicio = p + 1; 
        int fim = r;
        while (inicio <= fim) {
               if (vetor[inicio] <= escolhido)
                      inicio++;
               else if (escolhido < vetor[fim])
                      fim--;
               else {
                      int troca = vetor[inicio];
                      vetor[inicio] = vetor[fim];
                      vetor[fim] = troca;
                      inicio++;
                      fim--;
               }
        }
        vetor[p] = vetor[fim];
        vetor[fim] = escolhido;
        return fim;
	}
}
