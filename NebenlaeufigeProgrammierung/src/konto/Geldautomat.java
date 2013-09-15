package konto;

public class Geldautomat extends Thread {
	
	private Konto einKonto;
	public Geldautomat(Konto einKonto) {
		this.einKonto = einKonto;
	}
	
	public void run() {
		einKonto.auszahlen(10000);
	}

}
