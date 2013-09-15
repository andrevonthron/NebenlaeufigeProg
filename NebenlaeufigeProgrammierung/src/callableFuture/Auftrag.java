package callableFuture;

import java.util.concurrent.Callable;

public class Auftrag implements Callable<Ergebnis> {

	@Override
	public Ergebnis call() throws Exception {
		
		return new Ergebnis();
	}

}
