package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.algoritmos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteArvoreGeradoraMinima {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				for (int i = 0; i < 4; i++) {
					
					String arquivoOperacao = "tb8ch" + tamanho + "_" + i;
					String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
					List<Operacao> operacoes = EDAUtil.getOperacoes(path);
					
					long tempoInicial = System.currentTimeMillis();				
					Grafo g = new Grafo(operacoes.get(0).getX());
					operacoes.remove(0);
			
					for (Operacao operacao : operacoes) {
						Aresta aux = new Aresta(operacao.getX(), operacao.getY(), operacao.getPeso());
						g.AdicionarAresta(aux);
					}
					ArvoreGeradoraMinima a = new ArvoreGeradoraMinima();
					ArrayList<Aresta> arestas = a.Kruskal(g);
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					System.out.println(arquivoOperacao + " - " + a.custo(arestas) +" - " + tempo);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
