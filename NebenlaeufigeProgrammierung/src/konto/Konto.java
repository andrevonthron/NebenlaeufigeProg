package konto;

public class Konto {
	private int Saldo;
	
	public synchronized int getSaldo() {
		return Saldo;
	}
	
	public void einzahlen(int Betrag) {
		synchronized (this) {
			this.Saldo = this.Saldo+Betrag;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			
		}
	}
	
	public void auszahlen(int Betrag) {
		synchronized (this) {
		if (Saldo >= Betrag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
				System.out.println("Auszahlung von "+Betrag+"Geld findet statt. Neuer Kontostand: "+(Saldo-Betrag)+"Geld");
				this.Saldo = this.Saldo-Betrag;
		}
		else
			System.out.println("Auszahlung nicht möglich. Konto nicht ausreichend gedeckt.");
		}
		}

}
