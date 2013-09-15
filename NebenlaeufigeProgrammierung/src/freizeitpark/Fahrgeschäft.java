package freizeitpark;

public class Fahrgeschäft {
	private int anzahlBesucher = 0;
	
	public void betreten() {
		anzahlBesucher++;
		System.out.println(anzahlBesucher);
	}
	
	public void verlassen() {
		anzahlBesucher--;
		System.out.println(anzahlBesucher);
	}
}
