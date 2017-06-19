package br.ufc.quixada.eda.robronegra;

public class No<T>{
	private No<T> esq, dir;
	private int chave;
	private boolean cor;
	
	public static final boolean PRETO = true;
	public static final boolean VERMELHO = false;
	
	public No(int chave) {
		this.chave = chave;
		cor = VERMELHO;
	}
	public No<T> getEsq() {
		return esq;
	}
	public void setEsq(No<T> esq) {
		this.esq = esq;
	}
	public No<T> getDir() {
		return dir;
	}
	public void setDir(No<T> dir) {
		this.dir = dir;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public boolean isCor() {
		return cor;
	}
	public void setCor(boolean cor) {
		this.cor = cor;
	}

}
