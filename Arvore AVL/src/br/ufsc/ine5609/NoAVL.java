package br.ufsc.ine5609;

public class NoAVL <T> {
	private T item; 
	private int altura;
	private int balanceamento;
	private NoAVL<T> fe;
	private NoAVL<T> fd;
	private NoAVL<T> pai;
	
	/**
	 * @param item numero inteiro a ser inserido na arvore
	 */
	public NoAVL(T item) {
		this(item, null, null);
	}
	
	/**
	 * @param dado numero inteiro a ser inserido na arvore
	 * @param fe endereco do filho a esquerda
	 * @param fd endereco do filho a direita
	 */
	public NoAVL (T item, NoAVL<T> fe, NoAVL<T> fd) {
		this.item = item;
		this.fe = fe;
		this.fd = fd;
		this.setPai(null);
		this.altura = 0;
		this.balanceamento = 0;
	}
 
	/**
	 * @return numero inteiro armazenado
	 */
	public T getItem() {
		return item;
	}

	/**
	 * 
	 * @param dado numero a ser armazenado
	 */
	public void setItem(T item) {
		this.item = item;
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
	public NoAVL<T> getFe() {
		return fe;
	}

	/**
	 * 
	 * @param fe endereco do filho a esquerda
	 */
	public void setFe(NoAVL<T> fe) {
		this.fe = fe;
	}

	/**
	 * 
	 * @return endereco do filho a direita
	 */
	public NoAVL<T> getFd() {
		return fd;
	}

	/**
	 * 
	 * @param fd endereco do filho a direita
	 */
	public void setFd(NoAVL<T> fd) {
		this.fd = fd;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceameto(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public NoAVL<T> getPai() {
		return pai;
	}

	public void setPai(NoAVL<T> pai) {
		this.pai = pai;
	}
}
