package br.ufsc.ine5609;

public class NoAVL {
	private int dado; 
	private int altura;
	private int balanceamento;
	private NoAVL fe;
	private NoAVL fd;
	private NoAVL pai;
	
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
		this.setPai(null);
		this.altura = 0;
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
	 * @return altura do no
	 */
	public int getAltura() {
		return this.altura;
	}

	/**
	 * 
	 * @param altura do no
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

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

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceameto(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public NoAVL getPai() {
		return pai;
	}

	public void setPai(NoAVL pai) {
		this.pai = pai;
	}
}
