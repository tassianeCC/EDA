package br.ufc.quixada.eda.robronegra;

public class RubroNegra<T> {
	private No<T> raiz;
	
	public boolean isPreto(No<T> no){
		if(no == null) 
			return true;
		else if(no.isCor() == No.PRETO) 
			return true;
		else 
			return false;
	}
	
	public void add(int chave){
		raiz = add(raiz, chave);
		raiz.setCor(No.PRETO);
	}
	
	public No<T> add(No<T> raiz, int chave){
		if(raiz == null){
			No<T> no = new No<T>(chave);
			return no;
		}
		if(chave < raiz.getChave())
			raiz.setEsq(add(raiz.getEsq(),chave));
		else if(chave > raiz.getChave())
			raiz.setDir(add(raiz.getDir(), chave));
		if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq())
				&& !isPreto(raiz.getEsq().getEsq()))
			recolorar(raiz);
		else if(!isPreto(raiz) && !isPreto(raiz.getDir()))
			raiz = rotacaoEsquerda(raiz);
		else if(isPreto(raiz.getDir()) && !isPreto(raiz.getEsq())
				&& !isPreto(raiz.getEsq().getEsq())){
			raiz = rotacaoDireita(raiz);
			raiz.setCor(No.PRETO);
			raiz.getDir().setCor(No.VERMELHO);
		}
		return raiz;
	}
	
	private No<T> rotacaoDireita(No<T> raiz){
		No<T> u = raiz.getEsq();
		raiz.setEsq(raiz.getEsq().getDir());
		u.setDir(raiz);
		return u;
	}
	
	public No<T> rotacaoEsquerda(No<T> raiz){
		No<T> u = raiz.getDir();
		raiz.setDir(raiz.getDir().getEsq());
		u.setEsq(raiz);
		return u;
	}
	
	private void recolorar(No<T> no){
		no.setCor(No.VERMELHO);
		no.getEsq().setCor(No.PRETO);
		no.getDir().setCor(No.PRETO);
	}
	
	public No<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}
	
}
