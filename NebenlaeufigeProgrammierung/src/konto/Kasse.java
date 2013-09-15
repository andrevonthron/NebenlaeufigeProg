package konto;

public class Kasse extends Thread {
	private Konto einKonto;
	
	public Kasse(Konto einKonto) {
		this.einKonto = einKonto;
	}
	
	public void run() {
		einKonto.einzahlen(15000);
	}

}
