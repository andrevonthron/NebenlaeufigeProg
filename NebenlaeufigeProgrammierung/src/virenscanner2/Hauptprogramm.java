package virenscanner2;

import java.io.File;
import java.util.ArrayList;

public class Hauptprogramm {

	public static void main(String[] args) {
		VirenVerwaltung verwaltung = new VirenVerwaltung();
		
		Thread entfernerThread1 = new DateiEntferner(verwaltung);
		Thread entfernerThread2 = new DateiEntferner(verwaltung);
		
		entfernerThread1.start();
		entfernerThread2.start();
		
		//File f = new File("/Users/henk/vtest");
		
		//Test-Liste mit Pseudo-Dateinamen
		ArrayList<String> file = new ArrayList(); 
		file.add("v1");
		file.add("v2");
		file.add("t1");
		file.add("v3");
		for (String dir : file) {
			Thread scan = new Virenscanner(dir, verwaltung);
			scan.start();
		}

	}

}
