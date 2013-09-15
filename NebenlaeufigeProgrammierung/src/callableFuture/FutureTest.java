package callableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class FutureTest {

	public static void main(String[] args) {
		
		// Callable
		Callable<Ergebnis> test = new Auftrag();
		try {
			Ergebnis e = test.call();
			System.out.println(e.getErgebnis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Future
		Ergebnis e = new Ergebnis();
		try {
			System.out.println(e.get().getErgebnis());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
