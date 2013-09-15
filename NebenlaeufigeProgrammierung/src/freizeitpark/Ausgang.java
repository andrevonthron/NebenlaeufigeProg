package freizeitpark;

public class Ausgang extends Drehkreuz {

	public Ausgang(Fahrgeschäft fahrgeschäft) {
		super(fahrgeschäft);
		
	}
	
	public void passieren() {
		fahrgeschäft.verlassen();
	}

}
