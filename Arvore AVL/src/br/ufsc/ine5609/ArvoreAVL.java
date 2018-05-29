package br.ufsc.ine5609;

public class ArvoreAVL {
	
	private NoAVL raizArvore;
	private String pre; // listar em pre-ordem
	private String pos; // listar em pos-ordem
	private String in; // listar em ordem
	
	public ArvoreAVL () {
		raizArvore = null;
		pre = "";
		pos = "";
		in = "";
	}
	
//	public void exclui(int ID) {
//		
//	}
//	
//	public NoAVL busca(int ID) {
//		
//		return;
//	}

	public void insere(int dado) {
		insereRec (new NoAVL(dado), raizArvore);
	}
	

	private void insereRec (NoAVL novo, NoAVL raiz) {
		if (raiz != null) {
			if (novo.getDado() < raiz.getDado()) {
				if (raiz.getFe() != null) {
					insereRec (novo, raiz.getFe());
					raiz.setnFE(raiz.getnFE() +1);
				}
				else {
					raiz.setFe(novo);
				}
			}
			else {
				if (raiz.getFd() != null) {
					insereRec(novo, raiz.getFd());
					raiz.setnFD(raiz.getnFD() +1);
				}
				else {
					raiz.setFd(novo);
				}
			}
		}
		else {
			raizArvore = novo;
		}
	}
	
	/**
	 * @return String com a pre-ordem
	 */
	public String listarPre() {
		return listarPreRec(raizArvore);
	}
	
	private String listarPreRec(NoAVL raiz) {
		if (raiz != null) {
			pre += " " + raiz.getDado();
		}
		if (raiz.getFe() != null) {
			listarPreRec(raiz.getFe());
		}
		if (raiz.getFd() != null) {
			listarPreRec(raiz.getFd());
		}
		return pre;
	}
	
	/**
	 * 
	 * @return String com a pos-ordem
	 */
	public String listarPos() {
		return listarPosRec(raizArvore);
	}
	
	private String listarPosRec(NoAVL raiz) {
		if (raiz.getFe() != null) {
			listarPosRec(raiz.getFe());
		}
		if (raiz.getFd() != null) {
			listarPosRec(raiz.getFd());
		}
		if (raiz != null) {
			pos += " " + raiz.getDado();
		}
		return pos;
	}
	
	/**
	 * 
	 * @return String in-order
	 */
	public String listarIn() {
		return listarInRec(raizArvore);
	}
	
	private String listarInRec(NoAVL raiz) {
		if (raiz.getFe() != null) {
			
			listarInRec(raiz.getFe());
		}
		if (raiz != null) {
			in += " " + raiz.getDado();
		}
		if (raiz.getFd() != null) {
			listarInRec(raiz.getFd());
		}
		return in;
	}

}
