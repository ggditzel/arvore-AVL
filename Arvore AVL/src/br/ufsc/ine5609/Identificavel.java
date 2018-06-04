package br.ufsc.ine5609;

public interface Identificavel<T> extends Comparable<T>{
	
	/**
	 * Retorna um inteiro que permite classificar/identificar o objeto. Utlizado para facilitar os testes.
	 * Auxilia especialmente na busca, onde n�o se sabe, a priori, qual tipo de objeto est� na arvore, logo
	 * ficaria dificil saber o que comparar..
	 * @return
	 */
	public int getID();
}
