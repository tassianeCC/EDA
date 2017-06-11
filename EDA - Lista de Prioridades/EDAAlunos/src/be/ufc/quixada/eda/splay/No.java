package be.ufc.quixada.eda.splay;


public class No implements INo<No> {
	private No esq, dir;
	
	private int chave;
	
	public No(int chave){
		esq = null;
		dir = null;
		this.chave = chave;
	}

	public No() {
		esq = null;
		dir = null;
	}

	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	public No getDir() {
		return dir;
	}
	public void setDir(No dir) {
		this.dir = dir;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return "NoSplay [esq=" + esq + ", dir=" + dir + ", chave=" + chave + "]";
	}
	
}
