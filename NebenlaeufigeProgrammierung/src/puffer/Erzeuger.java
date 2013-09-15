package puffer;

public class Erzeuger extends Thread {
	
	Puffer puffer;
	
	public Erzeuger(Puffer puffer) {
		this.puffer = puffer;
	}
	
	public void run() {
		while(true) {
			Object obj = new Object();
			puffer.schreiben(obj);
			System.out.println("Objekt geschrieben. - "+puffer.getLesePos() +";"+puffer.getSchreibPos());
		}
	}

}
