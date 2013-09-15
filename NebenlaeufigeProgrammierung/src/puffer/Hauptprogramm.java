package puffer;

public class Hauptprogramm {

	public static void main(String[] args) {
		Puffer puffer = new Puffer(10);
		
		Erzeuger e = new Erzeuger(puffer);
		e.start();
		
		for(int i=0; i<5; i++) {
			Verbraucher v = new Verbraucher(puffer);
			v.start();
		}

	}

}
