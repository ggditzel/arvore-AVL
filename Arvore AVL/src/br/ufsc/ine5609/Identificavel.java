package br.ufsc.ine5609;

public interface Identificavel<T> extends Comparable<T>{
	
	/**
	 * Retorna um inteiro que permite classificar/identificar o objeto. Utlizado para facilitar os testes, poderia usar apenas a
	 * interface Comparable<T> em uma aplicação real. Usando apenas o Comparable<T>, a arvore poderia armazenar Integer, por exemplo.
	 * @return
	 */
	public int getID();
}
