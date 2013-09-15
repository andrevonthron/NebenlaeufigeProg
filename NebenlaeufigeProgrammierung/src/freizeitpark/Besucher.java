package freizeitpark;

import java.util.Random;

import com.sun.tools.javac.resources.javac;

public class Besucher extends Thread {
	
	private Eingang eingang;
	private Ausgang ausgang;
	
	public Besucher(Eingang eingang, Ausgang ausgang) {
		this.eingang = eingang;
		this.ausgang = ausgang;
	}
	
	public void run() {
		java.util.Random rnd = new java.util.Random();
		
			eingang.passieren();
			try {
				int pause = rnd.nextInt(10000) + 1000;
				sleep(pause);
			} catch (InterruptedException ie) {
				
			}
			ausgang.passieren();
		
	}

}
