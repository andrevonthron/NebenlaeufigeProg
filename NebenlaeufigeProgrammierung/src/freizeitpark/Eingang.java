package freizeitpark;

public class Eingang extends Drehkreuz {

	public Eingang(Fahrgeschäft fahrgeschäft) {
		super(fahrgeschäft);
		
	}
	
	public void passieren() {
		fahrgeschäft.betreten();
	}

}
