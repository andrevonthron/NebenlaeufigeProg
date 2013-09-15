package virenscanner;

public class Virenscanner implements Runnable {
	
	private String pfad;
	private Hauptprogramm applikation;
	private static int virus=0;
	
	public Virenscanner(String pfad, Hauptprogramm applikation) {
		this.applikation = applikation;
		this.pfad = pfad;
		
	}

	@Override
	public void run() {
		System.out.println("Scanne jetzt: "+pfad);
		
		try {
			Thread.sleep(1000);
			if(virus==1)
				applikation.handleVirus(pfad);
			virus++;
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pfad wurde gescannt: "+pfad);
		
	}

}
