package virenscanner;

import sun.awt.windows.ThemeReader;

public class Hauptprogramm {

	public static void main(String[] args) {
		Hauptprogramm h = new Hauptprogramm();
		Virenscanner v1 = new Virenscanner("/User/henk", h);
		Virenscanner v2 = new Virenscanner("/User/henk", h);
		Virenscanner v3 = new Virenscanner("/User/henk", h);
		
		Thread t1 = new Thread(v1);
		Thread t2 = new Thread(v2);
		Thread t3 = new Thread(v3);
		
		t1.start();
		t2.start();
		t3.start();

	}
	
	public void handleVirus(String path) {
		System.out.println("Virus gefunden in: "+path);
		
		try {
			Thread.currentThread();
			Thread.sleep(1000);	
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Virus entfernt.");
	}

}
