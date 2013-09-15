package freizeitpark;

public class Testklasse {

	public static void main(String[] args) {
		Fahrgeschäft fg = new Fahrgeschäft();
		Eingang e = new Eingang(fg);
		Ausgang a = new Ausgang(fg);
		for (int i=0; i<100; i++) {
			Besucher bs = new Besucher(e, a);
			bs.start();
		}

	}

}
