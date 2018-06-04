package br.ufsc.ine5609;

public class Testes {

	public static void main(String[] args) {
		
		// As 7 Melhores da Jovem Pan
		Musica m1 = new Musica(1, "Meant to Be", "Bebe Rexha feat. Florida Georgia Line");
		Musica m2 = new Musica(11, "What About Us", "Pink");
		Musica m3 = new Musica(27, "Together", "TW3LV feat. Jack Wilby");
		Musica m4 = new Musica(22, "Too Good at Goodbyes", "Sam Smith");
		Musica m5 = new Musica(3, "Echame la Culpa", "Luis Fonzi & Demi Lovato");
		Musica m6 = new Musica(13, "New Rules", "Dua Lipa");
		Musica m7 = new Musica(25, "No Tears Left to Cry", "Ariana Grande");
		
		ArvoreAVL<Musica> arv = new ArvoreAVL<Musica>();
		
		arv.insere(m3);
		arv.insere(m1);
		arv.insere(m7);
		arv.insere(m5);
		arv.insere(m4);
		arv.insere(m6);
		arv.insere(m2);
		System.out.println("\n===== RESULTADO =====");
		System.out.println(arv.listarPre());
		
		Musica buscada = arv.busca(100);
		if (buscada != null) {
			System.out.printf("\nElemento buscado -> posicao: %d; titulo: \"%s\"; artista: \"%s\"", buscada.getID(), buscada.getTitulo(), buscada.getArtista());
		} else {
			System.out.println("Elemento nao encontrado");
		}
		
	}
}
