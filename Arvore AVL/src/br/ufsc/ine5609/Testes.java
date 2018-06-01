package br.ufsc.ine5609;

public class Testes {

	public static void main(String[] args) {

		ArvoreAVL arv = new ArvoreAVL();
		arv.insere(7);
		arv.insere(4);
		arv.insere(20);
		arv.insere(14);
		arv.insere(11);
		arv.insere(9);
		arv.insere(16);
		arv.insere(8);
		System.out.println(arv.listarPre());
	}

}
