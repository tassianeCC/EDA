package br.ufc.quixada.eda.avl;

public class AVL {
	private NoAVL raiz = null;
	
	private int altura(NoAVL raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
	
	public void inserir(int chave){
		this.raiz = inserir(this.raiz, chave);
	}
	
	private NoAVL inserir(NoAVL raiz, int chave) {
		if(raiz == null){
			NoAVL no = new NoAVL(chave);
			return no;
		}else if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave));
			if((altura(raiz.getEsq()) - altura(raiz.getDir())) == 2){
				if(altura(raiz.getEsq().getEsq()) > altura(raiz.getEsq().getDir())){
					raiz = rotacaoDireita(raiz);
				}
				else
					rotacaoDuplaDireita(raiz);
			}
		}
		else if(raiz.getChave() < chave){
			raiz.setDir(inserir(raiz.getDir(), chave));
			if(altura(raiz.getDir()) - altura(raiz.getEsq()) == 2){
				if(altura(raiz.getDir().getDir()) > altura(raiz.getDir().getEsq())){
					raiz = rotacaoEsquerda(raiz);
				}
				else
					raiz = rotacaoDuplaEsquerda(raiz);
			}
		}
		raiz.setAltura(maxAltura(altura(raiz.getDir()), altura(raiz.getEsq())) + 1);
		return raiz;
	}
	
	private int maxAltura(int dir, int esq){
		if(dir > esq)
			return dir;
		return esq;
	}

	private NoAVL rotacaoDireita(NoAVL raiz) {
		NoAVL u = raiz.getEsq();

		raiz.setEsq(u.getDir());
		u.setDir(raiz);
		u.setAltura(maxAltura(altura(u.getDir()), altura(u.getEsq())) + 1);
		raiz.setAltura(maxAltura(altura(raiz.getDir()), altura(raiz.getEsq())) + 1);
		
		return u;
	}
	
	private NoAVL rotacaoDuplaDireita(NoAVL raiz) {
		NoAVL u = raiz.getEsq();

	    u = rotacaoEsquerda(u);
	    raiz.setEsq(u);
	    rotacaoDireita(raiz);
		
		return u;
		
	}

	private NoAVL rotacaoEsquerda(NoAVL raiz) {
		NoAVL u = raiz.getDir();
		
		raiz.setDir(u.getEsq());
		u.setEsq(raiz);
		u.setAltura(maxAltura(altura(u.getDir()), altura(u.getEsq())) + 1);
		raiz.setAltura(maxAltura(altura(raiz.getDir()), altura(raiz.getEsq())) + 1);
		
		return u;
	}

	
	private NoAVL rotacaoDuplaEsquerda(NoAVL raiz) {
		NoAVL u = raiz.getDir();

	    u = rotacaoDireita(u);
	    raiz.setDir(u);
	    rotacaoEsquerda(raiz);
		
		return u;
	}

	@Override
	public String toString() {
		return "RAIZ=" + raiz;
	}

	public NoAVL getRaiz() {
		return raiz;
	}

}
