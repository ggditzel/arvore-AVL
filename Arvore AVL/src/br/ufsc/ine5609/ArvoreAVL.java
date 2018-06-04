package br.ufsc.ine5609;

public class ArvoreAVL<T extends Identificavel<T>> {

	private NoAVL<T> raizArvore;
	private NoAVL<T> buscado;
	private String pre; // listar em pre-ordem
	private String pos; // listar em pos-ordem
	private String in; // listar em ordem

	public ArvoreAVL () {
		raizArvore = null;
		buscado = null;
		pre = "";
		pos = "";
		in = "";
	}

	//	public void exclui(int ID) {
	//		NoAVL<T> no = buscaRec(ID, raizArvore);
	//		if (no == null) {
	//			System.out.println("Este item nao esta cadastrado no sistema.");
	//		}
	//		else {
	//
	//		}
	//	}



	public T busca(int ID) {
		buscado = buscaRec(ID, raizArvore);
		if (buscado == null) return null;
		return buscado.getItem();
	}

	/**
	 * Busca o no que possui o item com o ID buscado; nao utilza o "compareTo" porque nao se sabe,
	 * a priori, qual o tipo de item esta armazenado na lista.
	 * @param ID identificador do item buscado
	 * @param raiz raiz da arvore
	 * @return o no que possui o item buscado
	 */
	private NoAVL<T> buscaRec(int ID, NoAVL<T> raiz) {
		if (raiz.getItem().getID() == ID) {
			buscado = raiz;
		}
		else if (ID < raiz.getItem().getID()) {
			if (raiz.getFe() != null) {
				buscaRec(ID, raiz.getFe());
			}
		}
		else {
			if (raiz.getFd() != null) {
				buscaRec(ID, raiz.getFd());
			}
		}

		return buscado;

	}


	public void insere(T item) {
		System.out.println("Inserindo no " + item.getID());
		insereRec (new NoAVL<T>(item), raizArvore);
	}

	private void insereRec (NoAVL<T> novo, NoAVL<T> raiz) {
		if (raiz != null) {
			// vai para esquerda
			if (novo.getItem().compareTo(raiz.getItem()) == -1) {
				if (raiz.getFe() != null) {
					insereRec (novo, raiz.getFe());
				}
				else {
					raiz.setFe(novo);
					novo.setPai(raiz);
				}
			}
			else if (novo.getItem().compareTo(raiz.getItem()) == 1) { 
				// vai para direita
				if (raiz.getFd() != null) {
					insereRec(novo, raiz.getFd());
				}
				else {
					raiz.setFd(novo);
					novo.setPai(raiz);
				}
			}
			else
				System.out.println("Tentativa de inserir elemento ja presente na arvore (poderia gerar exceção)");
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

	private String listarPreRec(NoAVL<T> raiz) {
		if (raiz != null) {
			pre += " " + raiz.getItem().getID() + "; altura: " + raiz.getAltura() + "; balanceamento: " + raiz.getBalanceamento() + "; pai: " + (raiz.getPai() != null ? raiz.getPai().getItem().getID() : "null") +"\n";
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

	private String listarPosRec(NoAVL<T> raiz) {
		if (raiz.getFe() != null) {
			listarPosRec(raiz.getFe());
		}
		if (raiz.getFd() != null) {
			listarPosRec(raiz.getFd());
		}
		if (raiz != null) {
			pos += " " + raiz.getItem().getID();
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

	private String listarInRec(NoAVL<T> raiz) {
		if (raiz.getFe() != null) {
			listarInRec(raiz.getFe());
		}
		if (raiz != null) {
			in += " " + raiz.getItem().getID();
		}
		if (raiz.getFd() != null) {
			listarInRec(raiz.getFd());
		}
		return in;
	}

	private void rotacaoSD (NoAVL<T> raiz) {

		// so pra ficar similar aos slides
		NoAVL<T> Y = raiz;
		NoAVL<T> X = raiz.getFe();

		if (Y != raizArvore) {
			if (Y.getPai().getItem().compareTo(Y.getItem()) == -1) { // Y era filho a esquerda ou filho a direita do pai? (sem cunho religioso)
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

		// as chamadas a seguir podem ser desconsideradas, caso nao se precise dos valores atualizados de altura e
		// balanceamento apos a rotacao;
		// as rotacoes recursivas ocorrerao (se propagando para cima, na arvore) independentemente destas atualizacoes,
		// sao mais para mostrar o resultado na tela

		calcBalanceamento(Y);
		calcBalanceamento(X);
	}

	private void rotacaoSE (NoAVL<T> raiz) {

		// so pra ficar similar aos slides
		NoAVL<T> Y = raiz;
		NoAVL<T> X = raiz.getFd();

		if (Y != raizArvore) {
			if (Y.getPai().getItem().compareTo(Y.getItem()) == -1) { // Y era filho a esquerda ou filho a direita?
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

		// as chamadas a seguir podem ser desconsideradas, caso nao se precise dos valores atualizados de altura e
		// balanceamento apos a rotacao;
		// as rotacoes recursivas ocorrerao (se propagando para cima, na arvore) independentemente destas atualizacoes,
		// sao mais para mostrar o resultado na tela

		calcBalanceamento(Y);
		calcBalanceamento(X);
	}

	private void calcBalanceamento(NoAVL<T> raiz) {
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

	private void rotaciona(NoAVL<T> raiz) {
		if (raiz.getBalanceamento() == 2) {
			if (raiz.getFd().getBalanceamento() == 1) {
				System.out.println("Rotação simples pra esquerda, no " + raiz.getItem().getID());
				rotacaoSE(raiz);
			}
			else {
				System.out.println("Rotação dupla para esquerda (direita -> esquerda), nó " + raiz.getItem().getID());
				rotacaoSD(raiz.getFd());
				rotacaoSE(raiz);
			}
		}
		else if (raiz.getBalanceamento() == -2) {
			if (raiz.getFe().getBalanceamento() == -1) {
				System.out.println("Rotação simples para direita, no " + raiz.getItem().getID());
				rotacaoSD(raiz);
			}
			else {
				System.out.println("Rotação dupla para direita (esquerda -> direita), no " + raiz.getItem().getID());
				rotacaoSE(raiz.getFe());
				rotacaoSD(raiz);
			}
		}
	}

}
