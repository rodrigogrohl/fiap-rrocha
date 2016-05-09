package br.com.rrocha.FundamentosJava.aula05;

public class Cavalo implements Runnable {

	private String nome;
	
	public Cavalo(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("Cavalo %s na volta #%d.\n", nome,i);
			try {
				Thread.sleep((int)(Math.random() * 5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("\n> %s chegou!\n", nome);

	}

}
