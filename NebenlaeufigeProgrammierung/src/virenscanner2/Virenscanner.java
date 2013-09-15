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
		//File file = new File(pfad);
		ArrayList<String> file = new ArrayList(); 
		file.add("v1");
		file.add("v2");
		file.add("t1");
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
