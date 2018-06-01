package br.ufsc.ine5609;

public class Testes {

	public static void main(String[] args) {

		ArvoreAVL arv = new ArvoreAVL();
		
//		for (int i = 1; i < 16; i++) {
//			arv.insere(i);
//		}
		
		arv.insere(67);
		arv.insere(94);
		arv.insere(51);
		arv.insere(23);
		arv.insere(39);
		arv.insere(67);
		System.out.println("\n===== RESULTADO =====");
		System.out.println(arv.listarPre());
	}

}
