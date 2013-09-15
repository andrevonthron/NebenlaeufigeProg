package puffer;

public class Puffer {
	Object[] array;
	private int schreibPosition;
	private int lesePosition;
	
	public Puffer(int größe) {
		array = new Object[größe];
		schreibPosition = 0;
		lesePosition = 0;
	}
	
	//Getter für sysouts in Erzeuger und Verbraucher hinzugefügt
	public synchronized int getLesePos() {
		return lesePosition;
	}
	public synchronized int getSchreibPos() {
		return schreibPosition;
	}
	
	public synchronized void schreiben(Object element) {
		while (lesePosition == schreibPosition && array[lesePosition] != null) {
			try {
				wait();
			} catch (InterruptedException ie) {
				
			}
			array[schreibPosition] = element;
			schreibPosition = (schreibPosition +1) % array.length;
			
			notifyAll();
			
		}
	}
	
	public synchronized Object lesen() {
		while(lesePosition == schreibPosition && array[lesePosition] == null) {
			try {
				wait();
			} catch (InterruptedException ie) {
				
			}
		}
			Object ergebnis = array[lesePosition];
			lesePosition = (lesePosition + 1) % array.length;
			notifyAll();
			return ergebnis;
		
	}

}
