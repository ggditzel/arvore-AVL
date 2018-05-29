package br.ufsc.ine5609;

public class NoAVL {
	private int dado;
	private int nFE;
	private int nFD;
	private int bal;
	private NoAVL fe;
	private NoAVL fd;
	
	/**
	 * @param dado numero inteiro a ser inserido na arvore
	 */
	public NoAVL(int dado) {
		this(dado, null, null);
	}
	
	/**
	 * @param dado numero inteiro a ser inserido na arvore
	 * @param fe endereco do filho a esquerda
	 * @param fd endereco do filho a direita
	 */
	public NoAVL(int dado, NoAVL fe, NoAVL fd) {
		this.dado = dado;
		this.fe = fe;
		this.fd = fd;
		this.nFE = 0;
		this.nFD = 0;
	}

	/**
	 * @return numero inteiro armazenado
	 */
	public int getDado() {
		return dado;
	}

	/**
	 * 
	 * @param dado numero a ser armazenado
	 */
	public void setDado(int dado) {
		this.dado = dado;
	}

	/**
	 * 
	 * @return numero de filhos a esquerda
	 */
	public int getnFE() {
		return nFE;
	}

	/**
	 * 
	 * @param nFE numero de filhos a esquerda
	 */
	public void setnFE(int nFE) {
		this.nFE = nFE;
	}

	/**
	 * 
	 * @return numero de filhos a direita
	 */
	public int getnFD() {
		return nFD;
	}

	/**
	 * 
	 * @param nFD numero de filhos a direita
	 */
	public void setnFD(int nFD) {
		this.nFD = nFD;
	}

	/**
	 * 
	 * @return fator de balanceamento
	 */
	public int getBal() {
		return nFD - nFE;
	}

//	public void setBal(int bal) {
//		this.bal = bal;
//	}

	/**
	 * 
	 * @return endereco do filho a esquerda
	 */
	public NoAVL getFe() {
		return fe;
	}

	/**
	 * 
	 * @param fe endereco do filho a esquerda
	 */
	public void setFe(NoAVL fe) {
		this.fe = fe;
	}

	/**
	 * 
	 * @return endereco do filho a direita
	 */
	public NoAVL getFd() {
		return fd;
	}

	/**
	 * 
	 * @param fd endereco do filho a direita
	 */
	public void setFd(NoAVL fd) {
		this.fd = fd;
	}
	
	
}
