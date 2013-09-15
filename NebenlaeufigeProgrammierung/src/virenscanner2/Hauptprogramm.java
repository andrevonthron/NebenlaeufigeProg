package virenscanner2;

import java.io.File;

public class Hauptprogramm {

	public static void main(String[] args) {
		VirenVerwaltung verwaltung = new VirenVerwaltung();
		
		Thread entfernerThread1 = new DateiEntferner(verwaltung);
		Thread entfernerThread2 = new DateiEntferner(verwaltung);
		
		entfernerThread1.start();
		entfernerThread2.start();
		
		File f = new File("/Users/henk/vtest");
		for (File dir : f.listFiles()) {
			Thread scan = new Virenscanner(dir.getAbsolutePath(), verwaltung);
			scan.start();
		}

	}

}
