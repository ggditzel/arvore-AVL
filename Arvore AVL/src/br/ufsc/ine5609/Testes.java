package br.ufsc.ine5609;

public class Testes {

	public static void main(String[] args) {

		ArvoreAVL arv = new ArvoreAVL();
		arv.insere(42);
		arv.insere(15);
		arv.insere(88);
		arv.insere(67);
		arv.insere(94);
		arv.insere(90);
//		arv.insere(2);
//		arv.insere(8);
		System.out.println(arv.listarPre());
	}

}
