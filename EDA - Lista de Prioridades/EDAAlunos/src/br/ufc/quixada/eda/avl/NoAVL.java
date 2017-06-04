package br.ufc.quixada.eda.avl;

public class NoAVL {
	private NoAVL esq, dir;
	
	private int altura, chave;
	
	public NoAVL(int chave){
		esq = null;
		dir = null;
		altura = 1;
		this.chave = chave;
	}

	public NoAVL() {
		esq = null;
		dir = null;
		altura = 1;
	}

	public NoAVL getEsq() {
		return esq;
	}
	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}
	public NoAVL getDir() {
		return dir;
	}
	public void setDir(NoAVL dir) {
		this.dir = dir;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	@Override
	public String toString() {
		return "ESQ =" + esq ;//+ ", dir=" + dir  + ", altura=" + altura + ", chave=" + chave + "]\n";
	}
	
	
}
