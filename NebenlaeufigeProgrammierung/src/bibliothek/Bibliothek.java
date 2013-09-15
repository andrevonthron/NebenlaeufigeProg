package bibliothek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bibliothek {

	private List<Buch> buecherliste = new ArrayList<Buch>();

	public void setBuecherliste(List<Buch> buecherliste) {
		this.buecherliste = buecherliste;
	}

	void sortierenNachTitel() {
		final Comparator<Buch> c = new Comparator<Buch>() {
			@Override
			public int compare(Buch o1, Buch o2) {
				return o1.getTitel().compareTo(o2.getTitel());
			}
			public boolean equals(Buch o1, Buch o2) {
				return o1.getTitel().equals(o2);
			}
		};
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Reihenfolge vor dem Sortieren: \n"+buecherliste.toString());
				sortieren(buecherliste, c);
				System.out.println("Reihenfolge nach dem Sortieren: \n"+buecherliste.toString());
			}
		});
		t.start();
	}

	private void sortieren(List<Buch> elemente, Comparator<Buch> c) {
		Collections.sort(elemente, c);
	}

	public static void main(String[] args) {
		Bibliothek bib = new Bibliothek();
		Buch b1 = new Buch("Titel mit C");
		Buch b2 = new Buch("Titel mit B");
		Buch b3 = new Buch("Titel mit A");
		Buch b4 = new Buch("Titel mit D");
		
		List<Buch> l = new ArrayList<Buch>();
		
		l.add(b1);
		l.add(b2);
		l.add(b3);
		l.add(b4);
		
		bib.setBuecherliste(l);
		
		bib.sortierenNachTitel();
		
		
		
	}

}
