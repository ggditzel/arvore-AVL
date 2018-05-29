package br.ufsc.ine5609;

public class Testes {

	public static void main(String[] args) {

		ArvoreAVL arv = new ArvoreAVL();
		arv.insere(10);
		arv.insere(20);
		arv.insere(30);
		System.out.println(arv.listarPre());
		System.out.println(arv.listarPos());
		System.out.println(arv.listarIn());
	}

}
