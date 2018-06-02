package br.ufsc.ine5609;

public class Musica implements Identificavel<Musica> {
	
	private int posicao;
	private String titulo;
	private String artista;
	
	public Musica() {
		posicao = 0;
		titulo = "";
		artista = "";
	}
	
	public Musica(int posicao, String titulo, String artista) {
		this.posicao = posicao;
		this.titulo = titulo;
		this.artista = artista;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * retorna -1 se 
	 */
	public int compareTo(Musica musica) {
		int i = 0;
		if (musica.getPosicao() < this.getPosicao()) i = 1;
		if (musica.getPosicao() == this.getPosicao()) i = 0;
		if (musica.getPosicao() > this.getPosicao()) i = -1;
		return i;
	}

	public int getID() {
		return posicao;
	}
	
}
