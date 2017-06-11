package be.ufc.quixada.eda.splay;


public class Splay implements ITree<INo<No>>{
	private No raiz = null;
	
	
	private No splay(No raiz, int chave){
		if(raiz == null)
			return null;
		if(raiz.getChave() == chave)
			return raiz;
		if(chave < raiz.getChave()){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rotacaoDireita(raiz);
			}
		}
		else if(chave > raiz.getChave()){
			if(raiz.getDir() == null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rotacaoEsquerda(raiz);
			}
		}
		
		return raiz;
	}
	
	public No buscar(int chave){
		raiz = splay(raiz, chave);
		if(raiz.getChave() == chave)
			return raiz;
		return null;
	}
	
	public void remove(int chave){
		raiz = remove(this.raiz, chave);
	}
	
	private No remove(No raiz, int chave){
		if(raiz.getEsq() == null && raiz.getDir() == null)
			return null;
		raiz = splay(raiz, chave);
		if(raiz.getChave() == chave){
			if(raiz.getDir() != null){
				No u = raiz.getDir();
				u.setEsq(raiz.getDir().getEsq());
				u.setEsq(raiz);
				return u;
			}
			else if(raiz.getEsq() != null){
				No u = raiz.getEsq();
				u.setDir(raiz.getEsq().getDir());
				u.setDir(raiz);
				return u;
			}
		}
		return raiz;
	}
	
	public void inserir(int chave){
		raiz = inserir(raiz, chave);
	}
	
	private No inserir(No raiz, int chave){
		if(raiz == null)
			return new No(chave);
		else if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave));
		}else if(raiz.getChave() < chave){
			raiz.setDir(inserir(raiz.getDir(), chave));
		}
		raiz = splay(raiz, chave);
		return raiz;
	}
	
	private No rotacaoDireita(No raiz) {
		No u = raiz.getEsq();

		raiz.setEsq(u.getDir());
		u.setDir(raiz);

		return u;
	}
	
	private No rotacaoEsquerda(No raiz) {
		No u = raiz.getDir();
		
		raiz.setDir(u.getEsq());
		u.setEsq(raiz);
		
		return u;
	}

	@Override
	public INo<No> getRaiz() {
		return raiz;
	}
}
