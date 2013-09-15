package virenscanner2;

import java.awt.List;
import java.util.ArrayList;

public class Virenscanner extends Thread {

	private String pfad;
	private VirenVerwaltung verwaltung;
	
	public Virenscanner(String pfad, VirenVerwaltung verwaltung) {
		this.pfad = pfad;
		this.verwaltung = verwaltung;
	}
	
	@Override
	public void run() {
		
		//Test-Liste mit Pseudo-Dateinamen
		ArrayList<String> file = new ArrayList(); 
		file.add(pfad);
		for (String f : file) {
			if (f.contains("v"))
				verwaltung.registriereInfizierteDatei(f);
			try {
				Thread.currentThread().sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
