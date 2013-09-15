package virenscanner2;

import java.io.File;

public class DateiEntferner extends Thread {
	
	private VirenVerwaltung verwaltung;
	
	public DateiEntferner(VirenVerwaltung verwaltung) {
		this.verwaltung = verwaltung;
	}
	
	public void run() {
		while(true) {
			String datei = verwaltung.holeZuLoeschendeDatei();
			File f = new File(datei);
			f.delete();
		}
	}

}
