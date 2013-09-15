package puffer;

public class Verbraucher extends Thread {
	Puffer puffer;
	
	public Verbraucher(Puffer puffer) {
		this.puffer = puffer;
	}
	
	public void run() {
		while(true) {
			Object obj = puffer.lesen();
			System.out.println("Objekt gelesen. - lesePos: "+puffer.getLesePos() +"; schreibPos: "+puffer.getSchreibPos());
		}
	}

}
