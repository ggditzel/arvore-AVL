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
		System.out.println("Inserindo no " + dado);
		insereRec (new NoAVL(dado), raizArvore);
	}
	
	private void insereRec (NoAVL novo, NoAVL raiz) {
		if (raiz != null) {
			// vai para esquerda
			if (novo.getDado() < raiz.getDado()) {
				if (raiz.getFe() != null) {
					insereRec (novo, raiz.getFe());
				}
				else {
					raiz.setFe(novo);
					novo.setPai(raiz);
				}
			}
			else {
				// vai para direita
				if (raiz.getFd() != null) {
					insereRec(novo, raiz.getFd());
				}
				else {
					raiz.setFd(novo);
					novo.setPai(raiz);
				}
			}
			calcBalanceamento(raiz);
			rotaciona(raiz);
			
		}
		
		else {
			// primeiro elemento da arvore
			raizArvore = novo;
		}

	}
	
	/**
	 * @return String com a pre-ordem, ordem de criacao
	 */
	public String listarPre() {
		return listarPreRec(raizArvore);
	}
	
	private String listarPreRec(NoAVL raiz) {
		if (raiz != null) {
			pre += " " + raiz.getDado() + "; altura: " + raiz.getAltura() + "; balanceamento: " + raiz.getBalanceamento() + "; pai: " + (raiz.getPai() != null ? raiz.getPai().getDado() : "null") +"\n";
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
	
	private void rotacaoSD (NoAVL raiz) {
		
		// so pra ficar similar aos slides
		NoAVL Y = raiz;
		NoAVL X = raiz.getFe();
		
		if (Y != raizArvore) {
			if (Y.getPai().getDado() < Y.getDado()) { // Y era filho a esquerda ou filho a direita do pai? (sem cunho religioso)
				Y.getPai().setFd(X);
			}
			else {
				Y.getPai().setFe(X);
			}
		}
		else {
			raizArvore = X; // nova raiz apos a rotacao
		}
		
		X.setPai(Y.getPai());
		Y.setFe(X.getFd());
		
		// na rotacao para a direita, o filho/sub-arvore a direita de X pode nao existir
		if (X.getFd() != null) X.getFd().setPai(Y);
		
		X.setFd(Y);
		Y.setPai(X);
		
		// as chamadas a seguir podem ser desconsideradas, caso nao se precise dos valores atualizados de altura e balanceamento apos a rotacao;
		// as rotacoes recursivas ocorrerao (se propagando para cima, na arvore) independentemente destas atualizacoes, sao mais para mostrar o resultado na tela

		calcBalanceamento(Y);
		calcBalanceamento(X);
	}
		
	private void rotacaoSE (NoAVL raiz) {
		
		// so pra ficar similar aos slides
		NoAVL Y = raiz;
		NoAVL X = raiz.getFd();
		
		if (Y != raizArvore) {
			if (Y.getPai().getDado() < Y.getDado()) { // Y era filho a esquerda ou filho a direita?
				Y.getPai().setFd(X);
			}
			else {
				Y.getPai().setFe(X);
			}
		}
		else {
			raizArvore = X; // nova raiz apos a rotacao
		}

			X.setPai(Y.getPai());
			Y.setFd(X.getFe());
			
			// na rotacao para a esquerda, o filho/sub-arvore a esquerda de X pode nao existir
			if (X.getFe() != null) X.getFe().setPai(Y);
			
			X.setFe(Y);
			Y.setPai(X);

			// as chamadas a seguir podem ser desconsideradas, caso nao se precise dos valores atualizados de altura e balanceamento apos a rotacao;
			// as rotacoes recursivas ocorrerao (se propagando para cima, na arvore) independentemente destas atualizacoes, sao mais para mostrar o resultado na tela

			calcBalanceamento(Y);
			calcBalanceamento(X);
	}
	
	private void calcBalanceamento(NoAVL raiz) {
		if (raiz.getFe() != null && raiz.getFd() != null) {
			raiz.setAltura(1 + Math.max(raiz.getFe().getAltura(), raiz.getFd().getAltura()));
			raiz.setBalanceameto(raiz.getFd().getAltura() - raiz.getFe().getAltura());
		}
		else if (raiz.getFe() == null && raiz.getFd() == null) {
			raiz.setAltura(0);
			raiz.setBalanceameto(0);
		}
		else if (raiz.getFe() != null) {
			raiz.setAltura(1 + raiz.getFe().getAltura());
			raiz.setBalanceameto(0 - raiz.getAltura()); // so pra deixar bem explicito
		}
		else if (raiz.getFd() != null) {
			raiz.setAltura(1 + raiz.getFd().getAltura());
			raiz.setBalanceameto(raiz.getAltura() - 0); // so pra deixar bem explicito
		}
	}
	
	private void rotaciona(NoAVL raiz) {
		if (raiz.getBalanceamento() == 2) {
			if (raiz.getFd().getBalanceamento() == 1) {
				System.out.println("Rota��o simples pra esquerda, no " + raiz.getDado());
				rotacaoSE(raiz);
			}
			else {
				System.out.println("Rota��o dupla para esquerda (direita -> esquerda), n� " + raiz.getDado());
				rotacaoSD(raiz.getFd());
				rotacaoSE(raiz);
			}
		}
		else if (raiz.getBalanceamento() == -2) {
			if (raiz.getFe().getBalanceamento() == -1) {
				System.out.println("Rota��o simples para direita, no " + raiz.getDado());
				rotacaoSD(raiz);
			}
			else {
				System.out.println("Rota��o dupla para direita (esquerda -> direita), no " + raiz.getDado());
				rotacaoSE(raiz.getFe());
				rotacaoSD(raiz);
			}
		}
	}
	
}
