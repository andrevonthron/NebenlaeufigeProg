package konto;

public class BankBeispiel {

	public static void main(String[] args) {
		Konto einKonto = new Konto();
		Kasse eineKasse = new Kasse(einKonto);
		Geldautomat ga1 = new Geldautomat(einKonto);
		Geldautomat ga2 = new Geldautomat(einKonto);
		
		eineKasse.start();
		ga1.start();
		ga2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			
		}
		
		System.out.println("Kontostand: "+ einKonto.getSaldo());

	}

}
