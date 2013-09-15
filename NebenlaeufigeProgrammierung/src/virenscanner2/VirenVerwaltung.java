package virenscanner2;

public class VirenVerwaltung {
	
	private String[] dateien = new String[5];
	
	int zaehler = 0;
	
	private Object warteAufFreienPufferPlatz = new Object();
	private Object warteAufNeuesElement = new Object();
	
	
	public void registriereInfizierteDatei(String datei) {
		while (zaehler+1 == dateien.length) {
			try {
				synchronized (warteAufFreienPufferPlatz) {
					warteAufFreienPufferPlatz.wait();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		dateien[zaehler] = datei;
		zaehler++;
		System.out.println("+++> "+datei);
		synchronized (warteAufNeuesElement) {
			warteAufNeuesElement.notifyAll();
		}
	}
	

	public synchronized String holeZuLoeschendeDatei() {

		while (zaehler == 0) {
			try {
				synchronized (warteAufNeuesElement) {
					warteAufNeuesElement.wait();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		zaehler--;
		String result = dateien[zaehler];
		synchronized (warteAufFreienPufferPlatz) {
			warteAufFreienPufferPlatz.notifyAll();
		}
		System.out.println("---> "+result);
		return result;
	}

}
