package br.com.rrocha.FundamentosJava.aula05;

public class Corrida {
	
	public static void main(String[] args) {
		
		Cavalo c1 = new Cavalo("Pé de Pano");
		Cavalo c2 = new Cavalo("Manga Larga");
		Cavalo c3 = new Cavalo("Ferradura");
		Cavalo c4 = new Cavalo("Cascudo");
		Cavalo c5 = new Cavalo("Trovão");
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
		Thread t5 = new Thread(c5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
}
